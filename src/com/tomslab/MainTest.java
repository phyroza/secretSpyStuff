package com.tomslab;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
  Main m;

  public void setUp() {
    m = new Main();
  }


  void tearDown() {
  }

  @Test
  public void getZonk() {
     m.getZonk();
     assertEquals("Zonk", m.getZonk());
     assertEquals(15, SecretStuffProvider.provideInt());
  }

  @Test
  public void foka() {
    assertEquals(1, (int)1);
  }

  @Test
  public void main() {
    assertEquals(1,(int)1);
  }

  @Test
  public void getNara() {
    assertEquals("Nara", m.getNara());
  }
}