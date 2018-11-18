package com.tomslab;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainTest {
  Main m;
  String a = new String();
  String b = new String();


  public MainTest() throws IOException
  {
  }

  @Test
  public void getZonk() {
     m.getZonk();
     assertEquals("Zonk", m.getZonk());
     assertEquals(15, SecretStuffProvider.provideInt());
  }

  @Test
  public void getZonksTest()
  {
    assertEquals("zonkzonk", m.getZonks(2));
  }

  @Test
  public void foka()
  {
    assertEquals(1, (int)1);
  }

  @Test
  public void main()
  {
    assertEquals(1,(int)1);
  }

  @Test
  public void getNara()
  {
    assertEquals("Nara", m.getNara());
  }

  @Before
  public void setUp() throws Exception
  {
  }


}