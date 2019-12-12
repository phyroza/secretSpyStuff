package com.tomslab.net.rmi;

import java.io.Serializable;

public class Msg implements Serializable
{
  String from;
  String to;
  String title;
  String content;

  public Msg(String from, String to, String title, String content)
  {
    this.from = from;
    this.to = to;
    this.title = title;
    this.content = content;
  }

  @Override
  public String toString()
  {
    return  "From: " + from + "\r\n" +
            "To: " + to + "\r\n" +
            "Title:  " + title + "\r\n" +
            "Content: " + content + "\r\n";
  }


}
