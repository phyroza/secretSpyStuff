package com.tomslab;

public class SecretStuffProvider
{
  private static Main ms;
  private Main m;
  public SecretStuffProvider()
  {
    m = new Main();
  }
  public static int provideInt()
  {
    return 15;
  }

  public static void main(String[] args)
  {
    System.out.println(ms.getZonks(15));
  }
}
