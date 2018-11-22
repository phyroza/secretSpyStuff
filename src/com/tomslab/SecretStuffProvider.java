package com.tomslab;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SecretStuffProvider
{
  public static final int SHAWNS_CONST = 2;
  public static final int DAN_CONST = 4;
  public static final String GOODBYE_MESSAGE = "Nara";
  public static final String ZONK = "Zonk";
  public static final int ZONK_COUNT = 15;
  private static final Logger LOGGER =  Logger.getGlobal();
  private Main m;
  public SecretStuffProvider()
  {
    m.hashCode();
  }
  public static int provideInt()
  {
    return ZONK_COUNT;
  }

  public static void main(String[] args)
  {
    LOGGER.log(Level.INFO, getZonks(ZONK_COUNT));
  }

  public static void foka()
  {
    LOGGER.log(Level.INFO,"KWKWI");
  }

  /**
   *
   * @return String zonk
   */
  public static String getZonk()
  {
    return ZONK;
  }

  public static String getZonks(int count)
  {
    StringBuilder zonk = new StringBuilder();
    for (int i=0;i<count;i++)
    {
      zonk.append("zonk");
    }
    String s;
    s = zonk.toString();
    return s;
  }

  public static String getNara()
  {
    return GOODBYE_MESSAGE;
  }
}
