package com.tomslab;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
  Main m;
  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    m = new Main();
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
  }

  @org.junit.jupiter.api.Test
  void getZonk() {
     m.getZonk();
     assertEquals(m.getZonk(), "Zonk");
     assertEquals(SecretStuffProvider.provideInt(),15);
  }
}