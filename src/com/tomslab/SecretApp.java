package com.tomslab;

import java.awt.*;

public class SecretApp
{
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable(){
      @Override
      public void run()
      {
        SecretFrame sf = new SecretFrame();
      }
    });
  }
}
