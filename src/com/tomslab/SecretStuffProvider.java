package com.tomslab;

public class SecretStuffProvider
{
  private Main m;
  public SecretStuffProvider()
  {
    m = new Main();
  }
  public static int provideInt()
  {
    return 15;
  }
}
