package com.tomslab.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativize
{
  public static void main(String[] args)
  {
    Path pathA = Paths.get(".\\temp\\zonki\\zonk12\\2019\\feb");
    Path rootDir = Paths.get(".\\temp\\zonki");
    System.out.println(rootDir.relativize(pathA));
  }
}
