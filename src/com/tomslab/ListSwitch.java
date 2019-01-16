package com.tomslab;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

public class ListSwitch
{
  public static void zamien(List<?> list, int i, int j)
  {
    boolean randomAccess = false;
    for (AnnotatedType type : list.getClass().getAnnotatedInterfaces())
    {
      if ("interface java.util.RandomAccess".equals(type.getType().toString()))
      {
        randomAccess = true;
      }
    }

    if (randomAccess)
    {
      zamienPomocnik(list, i, j);
      System.out.println("RandomAccess!");
    } else
    {

    }
  }

  public static <T> void zamienPomocnik(List<T> list, int i, int j)
  {
    T temp = list.get(j);
    list.set(j, list.get(i));
    list.set(i, temp);
  }

  public static void main(String[] args)
  {
    List<String> list = new ArrayList<>();
    list.add("lol");
    list.add("trol");
    list.add("gnom");
    System.out.println(list);
//    zamien(list,1 ,0 );
    zamienPomocnik(list, 1, 0);
    System.out.println(list);
  }
}
