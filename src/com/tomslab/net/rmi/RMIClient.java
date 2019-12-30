package com.tomslab.net.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient
{
  public static final String NATO_LETTER_BASE_1 = "WAT";

  Registry registry;
  private int port = 1099;
  private String className = "LUL";

  public RMIClient(String clientName) throws RemoteException
  {
    this.clientName = clientName;
    init();
  }

  private String clientName;


  void init() throws RemoteException
  {
    registry = LocateRegistry.getRegistry(port);
    System.out.println("Registry inited: " + port);
  }

  void readMeSome(int howMany) throws RemoteException, NotBoundException
  {
    String objName = NATO_LETTER_BASE_1 + className;
    RemoteStuff stub = (RemoteStuff) registry.lookup(objName);

    for (int i = 0; i < howMany; i++)
    {
      Msg newMsg = stub.sendMeALetter(clientName);
      System.out.println(newMsg);
      Msg reply = stub.sendReply(newMsg);
      System.out.println(reply);
    }
  }

  public static void main(String[] args)
  {
    try
    {
      RMIClient client = new RMIClient("whinyBitch");
      client.readMeSome(5);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    } catch (NotBoundException e)
    {
      e.printStackTrace();
    }
  }

}
