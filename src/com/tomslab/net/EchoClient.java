package com.tomslab.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient
{
  public static void main(String[] args) throws IOException
  {
    System.out.println("Trying " + args[0] + ":" + args[1]);
    try (
            Socket echoSocket = new Socket(args[0], new Integer(args[1]));
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    )
    {
      String greetings = in.readLine();
      System.out.println(greetings);
      System.out.println("Ready, type stuff!");
      String stuff = userInput.readLine();

      while (stuff != null && stuff != "bye")
      {
        System.out.println("Sending: " + stuff);

        out.println(stuff);

        System.out.println("Got smth: \n" + in.readLine());
        System.out.println("Type next line..");
        stuff = userInput.readLine();
      }
    }
  }
}
