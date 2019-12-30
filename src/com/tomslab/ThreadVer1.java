package com.tomslab;

public class ThreadVer1 implements Runnable
{

  Thread t;
  static int i = 0;

  public ThreadVer1()
  {
    t = new Thread(this, "ThreadVer1_" + i++);
  }

  @Override
  public void run()
  {
    for (int i = 0; i < 5; i++)
    {
      try
      {
        System.out.println(i);
        Thread.sleep(500);
      } catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    System.out.println("Ending thread");
  }

  public static void main(String[] args)
  {
    try
    {
      ThreadVer1 t1 = new ThreadVer1();
      t1.t.start();
      t1.t.join();
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    System.out.println("Ending main");
  }
}
