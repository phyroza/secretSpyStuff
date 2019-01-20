package com.tomslab.net;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

import static junit.framework.TestCase.assertTrue;

public class EchoClientTest
{
  private final Object lock = new Lock();

  @Test
  public void testEchoStuff() throws Exception
  {
    String[] clientArgs = {"lol", "wut", "nah", "bye"};
    InputStream oriIn = System.in;
    OutputStream oriOut = System.out;

    ByteArrayOutputStream boas = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(boas);

    System.setOut(out);
    ByteArrayInputStream argStream = new ByteArrayInputStream(String.join("\n", clientArgs).getBytes());

    Runnable runServer = () ->
    {
      try
      {
        EchoServer.main(new String[]{"4444"});
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    };

    Thread serverThread = new Thread(runServer);
    serverThread.start();

    Runnable runClient = () ->
    {
      try
      {
        System.setIn(argStream);
        EchoClient.main(new String[]{"localhost", "4444"});
      } catch (IOException e)
      {
        e.printStackTrace();
      }
    };

    Thread clientThread = new Thread(runClient);
    clientThread.start();
    System.setIn(oriIn);

    synchronized (lock)
    {
      lock.wait(1500);
    }

    String s = new String(boas.toByteArray(), Charset.defaultCharset());

    assertTrue(s.contains("wat up, your server here - can repeat and shit"));
    assertTrue(s.contains("bye"));
  }

  private static final class Lock
  {
  }
}