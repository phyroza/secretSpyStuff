package com.tomslab.TDD;

public class Money
{
  protected int amount;

  @Override
  public boolean equals(Object moneyObj)
  {
    if (moneyObj == null) return false;
    if (this.getClass().equals(moneyObj.getClass()))
//    if (Money.class.isAssignableFrom(moneyObj.getClass()))
      return this.amount == ((Money) moneyObj).amount;
    else
      return false;
  }
}
