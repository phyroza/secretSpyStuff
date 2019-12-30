package com.tomslab.net.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer
{

  public static final String NATO_LETTER_BASE_1 = "WAT";
  public static final String className = "LUL";
  private Registry registry;
  private int port = 1099;

  void run() throws RemoteException, AlreadyBoundException
  {
    init();
    System.out.println("java.rmi.server.codebase: " + System.getProperty("java.rmi.server.codebase"));
    System.out.println("java.rmi.server.useCodebaseOnly: " + System.getProperty("java.rmi.server.useCodebaseOnly"));

    String objName = NATO_LETTER_BASE_1 + className;
    RemoteStuffImpl skeleton = new RemoteStuffImpl(objName);
    RemoteStuff stub = (RemoteStuff) UnicastRemoteObject.exportObject(skeleton, 0);

    registry.rebind(objName, stub);
    System.out.println("Bound obj: " + objName);
    System.out.println("Server ready.");
  }

  private void init() throws RemoteException
  {
    System.setSecurityManager(new RMISecurityManager());
    registry = LocateRegistry.getRegistry(port);
    System.out.println("Registry inited: " + port);

  }

  public static void main(String[] args)
  {
    RMIServer serv = new RMIServer();


    try
    {
      serv.run();
    } catch (RemoteException e)
    {
      e.printStackTrace();
    } catch (AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }
}
