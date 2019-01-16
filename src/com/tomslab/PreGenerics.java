package com.tomslab;

import java.util.ArrayList;
import java.util.List;

public class PreGenerics
{
  public static void main(String[] args)
  {
    List list = new ArrayList();
    list.add("hello");
    list.add(new Integer(2));
    list.add(new Lol("wut"));
    String s = (String) list.get(0);//typecasting
    Integer i = (Integer) list.get(1);//typecasting
    Lol l = (Lol) list.get(2);
    System.out.println(s);
    System.out.println(i);
    System.out.println(l.getText());
    System.out.println(list.iterator().next());
  }
}
