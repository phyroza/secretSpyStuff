package com.tomslab.TDD;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrancTest
{
  @Test
  public void testMultiplication()
  {
    Franc Franc = new Franc(5);
    assertEquals(new Franc(10), Franc.times(2));
    assertEquals(new Franc(15), Franc.times(3));
  }

  @Test
  public void testEquals()
  {
    assertTrue(new Franc(5).equals(new Franc(5)));
    assertFalse(new Franc(5).equals(new Franc(6)));
    assertFalse(new Franc(5).equals(new String("LOL")));
    assertFalse(new Franc(5).equals(null));
  }
}