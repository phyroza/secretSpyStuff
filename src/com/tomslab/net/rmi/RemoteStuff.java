package com.tomslab.net.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteStuff extends Remote
{
  Msg sendMeALetter(String to) throws RemoteException;
  Msg sendReply(Msg orig) throws RemoteException;
}
