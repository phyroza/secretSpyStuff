package com.tomslab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp
{
  public static void main(String[] args)
  {
    Pattern pattern = Pattern.compile("(\\s[ab]{2}\\sOK)()");
    System.out.println(pattern.pattern());

    String input = " aa OK TRALRALLALA" + System.lineSeparator() + " bb OK######\r ab OK.......\n bb OK";
    System.out.println(input);

    Matcher matcher = pattern.matcher(input);
    while (matcher.find())
    {
      System.out.println(matcher.groupCount());
      System.out.println(matcher.group());
    }
    System.out.println((System.lineSeparator().toCharArray()));
  }
}
