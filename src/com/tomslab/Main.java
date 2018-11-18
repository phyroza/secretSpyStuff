package com.tomslab;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
  private static final Logger LOGGER = Logger.getLogger("root");
  public static final int SHAWNS_CONST = 2;
  public static final int DAN_CONST = 4;
  public static final String GOODBYE_MESSAGE = "Nara";
  public static final String ZONK = "Zonk";

  public static void foka()
  {
    LOGGER.log(Level.INFO,"KWKWI");
  }

  public static void main(String[] args)
  {
    LOGGER.log(Level.INFO,"LOL?");
    LOGGER.log(Level.INFO,"LULZ");
    foka();
    int a = SHAWNS_CONST;
    int b = DAN_CONST;
    LOGGER.log(Level.INFO,"Main.maina.AHHUMZHHH.stupidfucks");
    int c = a + b;
    LOGGER.log(Level.INFO, "{0}", c);
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
