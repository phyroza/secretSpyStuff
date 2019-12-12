package com.tomslab.net.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class RMIRegistry
{
  public static void main(String[] args)
  {
    System.out.println("java.class.path " + System.getProperty("java.class.path"));
    System.out.println("java.rmi.server.codebase: " + System.getProperty("java.rmi.server.codebase"));
    System.out.println("java.rmi.server.useCodebaseOnly: " + System.getProperty("java.rmi.server.useCodebaseOnly"));

    Registry registry;
    int port = 1099;

    System.setSecurityManager(new RMISecurityManager());

    try
    {
      System.out.println("Creating registry at port: " + port);
      registry = java.rmi.registry.LocateRegistry.createRegistry(port);
    } catch (Throwable e)
    {
      System.out.println("\n\nRegistry not created.");
      registry = null;
    }


    while (true)
    {
      try
      {
        listObjects(registry);
        Thread.sleep(7500);

      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  private static void listObjects(Registry registry) throws RemoteException
  {
    String[] list = registry.list();
    for (String s : list)
    {
      System.out.println(s);
    }
  }
}
