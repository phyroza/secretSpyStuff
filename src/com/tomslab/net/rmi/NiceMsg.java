package com.tomslab.net.rmi;

import java.io.Serializable;

class NiceMsg extends Msg implements Serializable
{
  public NiceMsg(String from, String to, String title, String content)
  {
    super(from, to, title, content);
  }

  @Override
  public String toString()
  {
    return "FUCKING NICE INNIT? " + super.toString();
  }
}
