package com.tomslab.net.rmi;

import java.rmi.RemoteException;

public class RemoteStuffImpl implements RemoteStuff
{
  String stationName;

  int msgId;

  public RemoteStuffImpl(String stationName)
  {
    this.stationName = stationName;
  }

  @Override
  public Msg sendMeALetter(String to)
  {
    int currMsgId = this.msgId;
    this.msgId++;
    String title = "Hello" + to + " this is" + stationName + "! [#" + currMsgId + "]";
    String content = "What's up";
    Msg newLetter = new NiceMsg(stationName, to, title, content);
    System.out.println(newLetter);

    return newLetter;
  }

  @Override
  public Msg sendReply(Msg orig) throws RemoteException
  {
    return new Msg(orig.to, orig.from, "RE: " + orig.title, "Fuck you dolan");
  }
}
