package com.tomslab;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
  private static final Logger LOGGER = Logger.getLogger("root");

  public static void main(String[] args)
  {
    LOGGER.log(Level.INFO,"LOL?");
    LOGGER.log(Level.INFO,"LULZ");
    SecretStuffProvider.foka();
    int a = SecretStuffProvider.SHAWNS_CONST;
    int b = SecretStuffProvider.DAN_CONST;
    LOGGER.log(Level.INFO,"Main.maina.AHHUMZHHH.stupidfucks");
    int c = a + b;
    LOGGER.log(Level.INFO, "{0}", c);
  }

}
