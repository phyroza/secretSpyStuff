package com.tomslab.util;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EnumTest
{
  public static void main(String[] args)
  {
    TomsState state1 = TomsState.EXHAUSTED;
    TomsState state2 = TomsState.NORMAL;
    TomsState state3 = TomsState.TIRED;
    TomsState state4 = TomsState.RESTED;

    Map<String, TomsState> tomsRegister = new HashMap<>();

    tomsRegister.put("Tomasz Karolak", TomsState.EXHAUSTED);
    tomsRegister.put("Tomasz Strasburger", TomsState.NORMAL);
    tomsRegister.put("Tomasz Kot", TomsState.RESTED);

    Iterator<String> iterator = tomsRegister.keySet().iterator();
    while (iterator.hasNext())
    {
      String currentTom = iterator.next();
      System.out.println(currentTom + " " + tomsRegister.get(currentTom));
    }

    System.out.println();
    System.out.println(Arrays.toString(TomsState.values()));

    System.out.println();
    for (TomsState ts : TomsState.values())
    {
      System.out.println(ts);
    }

    System.out.println();
    Iterator<TomsState> iterator2 = Arrays.asList(TomsState.values()).iterator();
    while (iterator2.hasNext())
    {
      TomsState el = iterator2.next();
      System.out.println(el);
    }

    System.out.println();
    System.out.println(state1);
    System.out.println(state1.energyLevel);
    System.out.println(state1.willWork);
  }

  public enum TomsState
  {
    EXHAUSTED(0, false), TIRED(1, true), NORMAL(2, true), RESTED(3, true), CRAZY(4, false);

    private int energyLevel;
    private boolean willWork;

    TomsState(int energyLevel, boolean willWork)
    {
      this.energyLevel = energyLevel;
      this.willWork = willWork;
    }
  }
}
