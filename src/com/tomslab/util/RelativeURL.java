package com.tomslab.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RelativeURL
{
  public static void main(String[] args)
  {
    String relativeFilePath = "/a/b/c/d/e/f/g";
    try
    {
      URI relativeURI = new URI("a/b/").relativize(new URI(relativeFilePath));
      System.out.println(relativeURI.toString());

      URL rel = new URL("file", "a", relativeFilePath);
      System.out.println(rel);
    } catch (URISyntaxException | MalformedURLException e)
    {
      e.printStackTrace();
    }
  }
}
