package com.tomslab;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ErastotenesSieve
{
  Set<Integer> set = new HashSet<>();
  int originalSize;

  public ErastotenesSieve(int n)
  {
    originalSize = n;
    for (int i = 2; i < n; i++)
    {
      set.add(i);
    }
  }

  public static void main(String[] args)
  {
    ErastotenesSieve sieve = new ErastotenesSieve(1000);
    sieve.doSieve();
    System.out.println(sieve.getReadableValueList());
  }

  public int getMinVal(Set<Integer> s, int t)
  {
    Integer min = null;
    Iterator<Integer> iterator = s.iterator();

    if (iterator.hasNext())
    {
      int temp = iterator.next();
      while (temp < t && iterator.hasNext())
      {
        temp = iterator.next();
      }
      min = temp;
    }

    while (iterator.hasNext())
    {
      Integer next = iterator.next();
      if (next < min && next > t)
        min = next;
    }

    return min;
  }

  public void doSieve()
  {
    int s = getMinVal(set, 0);
    while (s * s < originalSize)
    {
      int i = 0;
      while (s * (s + i) < originalSize)
      {
        set.remove(s * (s + i));
        i++;
      }
      s = getMinVal(set, s + 1);
    }
  }

  public String getReadableValueList()
  {
    StringBuffer buffer = new StringBuffer();
    for (Integer i : set)
    {
      buffer.append(i + ", ");
    }
    return buffer.substring(0, buffer.length() - 2);
  }
}
