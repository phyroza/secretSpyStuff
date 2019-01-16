package com.tomslab;

import java.util.HashSet;
import java.util.Set;

public class SetOperations
{
  public static void main(String[] args)
  {
    Set<String> a = new HashSet<>();
    Set<String> b = new HashSet<>();

    a.add("ala");
    a.add("adam");
    a.add("abazur");

    b.add("bob");
    b.add("abazur");
    b.add("bottle");

    System.out.println(a);
    System.out.println(b);
    System.out.println();

//    a.addAll(b);
//    a.removeAll(b);
    a.retainAll(b);
    System.out.println(a);
  }
}
