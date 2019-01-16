package com.tomslab.TDD;

public class Franc extends Money
{
  Franc(int amount)
  {
    this.amount = amount;
  }

  public Franc times(int multiplier)
  {
    return new Franc(this.amount * multiplier);
  }

  public int getAmount()
  {
    return amount;
  }
}
