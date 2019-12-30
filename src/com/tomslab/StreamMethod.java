package com.tomslab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMethod
{
  static class CheatingComparator implements Comparator<String>
  {
    @Override
    public int compare(String o1, String o2)
    {
      if (o1.toLowerCase().startsWith("c") || o2.toLowerCase().startsWith("c"))
      {
        if (!o2.toLowerCase().startsWith("c"))
        {
          return -1;
        }else{
          if (o1.startsWith("c"))
            return o1.compareTo(o2);
          else
            return 1;
        }
      }else{
        return o1.compareTo(o2);
      }

    }
  }

  public static class FuckingHeller implements Function<String,String>
  {
    @Override
    public String apply(String s)
    {
      return "Fucking hell! " + s;
    }
  }

  public static void main(String[] args)
  {
    String[] words = {"lol", "wat", "omg", "kolo", "cheater", "ala"};
    FuckingHeller heller = new FuckingHeller();
    CheatingComparator comp = new CheatingComparator();

    Arrays.asList(words).stream().sorted(comp).map(heller::apply).forEach((s) -> { System.out.println(s); } );
    System.out.println("No cheats:");
    Arrays.asList(words).stream().sorted().map(heller::apply).forEach((s) -> { System.out.println(s); } );
  }
}
