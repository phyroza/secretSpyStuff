package com.tomslab.TDD;

public class Dollar extends Money
{
  Dollar(int amount)
  {
    this.amount = amount;
  }

  public Dollar times(int multiplier)
  {
    return new Dollar(this.amount * multiplier);
  }

  public int getAmount()
  {
    return amount;
  }
}
