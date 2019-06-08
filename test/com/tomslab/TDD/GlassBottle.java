package com.tomslab.TDD;

public class GlassBottle extends Bottle
{
  GlassBottle(int ml)
  {
    super(ml);
  }

  public static void main(String[] args)
  {
    GlassBottle gb = new GlassBottle(222);
    Bottle b = new GlassBottle(222);
    System.out.println(b instanceof Bottle);
    System.out.println(gb instanceof Bottle);
    System.out.println(b instanceof GlassBottle);
    System.out.println(gb instanceof GlassBottle);
  }
}
