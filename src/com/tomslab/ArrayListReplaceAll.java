package com.tomslab;

import java.util.ArrayList;
import java.util.List;

public class ArrayListReplaceAll
{
  public static void main(String[] args)
  {
    List<String> list = new ArrayList<>();
    list.add("xxXxxXXxXxxXxX");
    list.add("aAbBcCsD");
    list.add("zomg");
    System.out.println(list);
    list.replaceAll(s -> s.toUpperCase());
    list.replaceAll(String::toUpperCase);
    System.out.println(list);
  }
}
