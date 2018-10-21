package com.tomslab;

import org.junit.Before;
import org.junit.Test;
import com.tomslab.Main;

import static org.junit.Assert.assertEquals;

public class MainTest {
  Main m;

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

  @Before
  public void setUp() throws Exception {
  }


}