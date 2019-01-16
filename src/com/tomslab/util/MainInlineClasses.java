package com.tomslab.util;

public class MainInlineClasses
{
  public static void main(String[] args)
  {
    System.out.println("lol");

    class InlineZonk
    {
      int zonkGrade;

      public int getZonkGrade()
      {
        return zonkGrade;
      }

      public int increaseZonkGrade()
      {
        return ++zonkGrade;
      }

      public int decreaseZonkgrade()
      {
        return --zonkGrade;
      }
    }

    InlineZonk z1 = new InlineZonk();
    z1.increaseZonkGrade();
    System.out.println(z1.getZonkGrade());
  }
}
