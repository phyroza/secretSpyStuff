package com.tomslab.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public static void main(String[] args) throws IOException
  {
    while (1 == 1)
    {
      tryEcho(args[0]);
    }
  }

  private static void tryEcho(String arg) throws IOException
  {

    try (
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(arg));
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    )
    {
      {
        System.out.println("Start convo with: " + clientSocket.getInetAddress() + " connected : "
                + clientSocket.isConnected() + " waiting for text!");
        out.println("wat up, your server here - can repeat and shit");

        String line = in.readLine();
        while (line != null)
        {
          System.out.println("Sending back: " + line.toUpperCase());
          out.println(line.toUpperCase());
          line = in.readLine();
        }
      }
    }
    System.out.println("Bye!");
  }
}
