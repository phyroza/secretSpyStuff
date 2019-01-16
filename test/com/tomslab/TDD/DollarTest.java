package com.tomslab.TDD;

import org.junit.Test;

import static org.junit.Assert.*;

public class DollarTest
{
  @Test
  public void testMultiplication()
  {
    Dollar dollar = new Dollar(5);
    assertEquals(new Dollar(10), dollar.times(2));
    assertEquals(new Dollar(15), dollar.times(3));
  }

  @Test
  public void testEquals()
  {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
    assertFalse(new Dollar(5).equals(new String("LOL")));
    assertFalse(new Dollar(5).equals(null));
  }
}