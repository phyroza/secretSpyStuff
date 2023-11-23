package com.tomslabs.exercises.chapter1;

public class Exercise16
{
    public static void main(String[] args)
    {
        String l = """
                "public class Exercise16",
                "{",
                "  public static void main(String[] args)",
                "  {",
                "    String l = \"\"\" fuckthis
                \"\"\"
                "    ",
                "    };",
                "   System.out.println(l);
                "  }",
                "}",
                """;
        System.out.println(l);
    }
}
