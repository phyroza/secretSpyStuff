package com.tomslab.aspect;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LogicClassTest
{

  @org.junit.jupiter.api.BeforeEach
  void setUp()
  {
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown()
  {
  }

  @org.junit.jupiter.api.Test
  void curseDude()
  {
    LogicClass lc =  new LogicClass();
    Mockery mockery = new Mockery();
    mockery.setImposteriser(ClassImposteriser.INSTANCE);
    final PrintStream mockStream = mockery.mock(PrintStream.class);
    mockery.checking(new Expectations(){{
      one(mockStream).println(with(equal("Fuck you John")));
    }});

    String curse = lc.curseDude("John", mockStream);
    assertEquals("Fuck you John", curse);

    curse = lc.curseDude("Johnny", System.out);
  }
}