package com.tomslab.util;

public class LongestStringsSubsequence
{
  static long counter = 0;

  public static String longestSubSequence(String s1, String s2)
  {
    String cand1 = trySubSeq(s1, s2);
    String cand2 = trySubSeq(s2, s1);
    return cand1.length() > cand2.length() ? cand1 : cand2;
  }

  private static String trySubSeq(String longest, String shortest)
  {
    char[] longestChars = longest.toCharArray();
    char[] shortestChars = shortest.toCharArray();
    int lastShortest = 0;
    String subseq = "";
    for (char c : longestChars)
    {
      for (int i = lastShortest; i < shortestChars.length; i++)
        if (c == shortestChars[lastShortest])
        {
          subseq += (shortestChars[lastShortest]);
          lastShortest++;
        }
    }
    System.out.println(longest + " " + shortest + " " + subseq.length() + ":" + subseq);

    return subseq;
  }

  static boolean isSubsequence(String target, String pattern)
  {
    int lastTargetChar = 0;
    char[] patternChars = pattern.toCharArray();
    boolean[] patternCharsMatched = new boolean[pattern.length()];
    for (boolean b : patternCharsMatched) b = false;

    for (int i = 0; i < patternChars.length; i++)
    {
      for (int j = lastTargetChar; j < target.length(); j++)
      {
        if (patternChars[i] == target.charAt(j))
        {
          lastTargetChar = j;
          patternCharsMatched[i] = true;
          break;
        }
      }
    }

    boolean isSubSequence = true;
    for (boolean matched : patternCharsMatched)
    {
      if (!matched) isSubSequence = false;
    }

    return isSubSequence;
  }

  public static String longestSubSequence2(String s1, String s2)
  {
    counter++;
    String longest = "";
    if (isSubsequence(s1, s2))
    {
      longest = s1;
      return s2;
    }
    if (isSubsequence(s2, s1))
    {
      longest = s2;
      return s1;
    }
    if (s1.length() == 1 || s2.length() == 1) return "";

    String cand1 = checkLeftSubstring(s1, s2, longest);
    String cand2 = checkLeftSubstring(s2, s1, longest);
    longest = cand1.length() > cand2.length() ? cand1 : cand2;

    return longest;
  }

  private static String checkLeftSubstring(String left, String right, String longest)
  {
    char[] leftCharArray = left.toCharArray();

    for (int i = 0; i < leftCharArray.length; i++)
    {
      String sc = longestSubSequence2(left.substring(0, i) + left.substring(i + 1, left.length()), right);
      int iii = 0;
//      System.out.println(sc);
      if (sc.length() > longest.length())
        longest = sc;
    }
    return longest;
  }

  //43080529
//31518565
  public static void main(String[] args)
  {
    System.out.println(isSubsequence("BACBAD", "BAZDC"));
    System.out.println(longestSubSequence2("ABAZDC", "BACBAD"));
    System.out.println(counter);
  }
}
