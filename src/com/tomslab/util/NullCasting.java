package com.tomslab.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullCasting
{

  public static final int INT = 4400;

  public static void main(String[] args)
  {
    char c = 'a';
    NullCasting nullCasting = new NullCasting();
    nullCasting.doNullifStuff(c);
    nullCasting.doNullifStuff(null);

    Boxland boxland = new Boxland();
    Boxland.Box bl = boxland.getLetterBox("fu");
    Boxland.Box b1 = boxland.getEmptyBox();
    Boxland.Box b2 = boxland.getEmptyBox();
    Boxland.Box b3 = boxland.getEmptyBox();
    Boxland.Box b4 = boxland.getEmptyBox();

    System.out.println(bl);
    System.out.println(b1);
    System.out.println(b2);
    System.out.println(b3);
    System.out.println(b4);

    System.out.println("_______________");
    char c0 = '\u004a';
    System.out.println(c0);
    char c1 = '\u0000';
    System.out.println(c1);
    System.out.println((int) c1);
    System.out.println("_______________");


    // MORE

//    ArrayList<Boxland.Box> xmasPacks = new ArrayList<>();
//
//    for (int i = 0; i< INT; i++)
//    {
//      xmasPacks.add(boxland.getEmptyBox());
//    }
//
//    for (Boxland.Box b : xmasPacks) System.out.println(b);
  }

  void doNullifStuff() // primitive no un-init pass
  {
    doNullifStuff('c');
  }

  private void doNullifStuff(char c) // primitive no un-init pass
  {
    int i = (int) c;
    System.out.println(i);
  }

  private void doNullifStuff(Character c) // primitive no un-init pass
  {
    if (c == null)
      return;
    int i = (int) c;
    System.out.println(i);
  }

  static class Boxland
  {

    static int idSeq = 0;

    public static int getIdSeq()
    {
      return idSeq++;
    }

    @NotNull
    public Box getEmptyBox()
    {
      return new Box();
    }

    @NotNull
    public Box getLetterBox(@NotNull String letter)
    {
      return new Box(letter);
    }

    class Box
    {
      int id;
      @Nullable Object payload;

      Box()
      {
        id = Boxland.getIdSeq();
        payload = null;
      }

      Box(@NotNull String letter)
      {
        id = Boxland.getIdSeq();
        payload = new String(letter);
      }


      @NotNull
      public String toString()
      {
        return Integer.toString(id);
      }
    }


  }

}
