package com.tomslab.aspect;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LogicClass
{

  public String curseDude(String name, PrintStream channel)
  {
    String curse = "Fuck you " + name;
    channel.println(curse);

    return curse;
  }

  public static void main(String[] args)
  {
    LogicClass lc = new LogicClass();
    List<String> names = new ArrayList<String>(){{
      add("Zonk");
      add("Zygmunt");
      add("Jan");
      add("Andrei");
    }};

    for (String name : names)
    {
      lc.curseDude(name, System.out);
    }
  }
}
