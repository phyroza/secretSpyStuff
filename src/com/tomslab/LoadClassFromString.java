package com.tomslab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoadClassFromString
{
  public static void main(String[] args)
  {
    try
    {
      Class c = Class.forName("com.tomslab.StreamMethod");
      Method main = c.getMethod("main", new Class[]{});
      main.invoke(null, new String[]{});
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
