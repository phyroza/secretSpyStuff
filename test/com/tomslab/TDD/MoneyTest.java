package com.tomslab.TDD;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoneyTest
{
  @Test
  public void testEquality()
  {
    assertEquals(new Dollar(5), new Dollar(5));
    assertNotEquals(new Dollar(5), new Dollar(6));
    assertEquals(new Franc(5), new Franc(5));
    assertNotEquals(new Franc(5), new Franc(6));
    assertNotEquals(new Dollar(5), new Franc(5));
    assertNotEquals(new Franc(5), new Dollar(5));
  }
}