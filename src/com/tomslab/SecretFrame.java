package com.tomslab;

import javax.swing.*;
import java.awt.*;

public class SecretFrame extends JFrame
{
  public SecretFrame(){
    super("secretFrame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    setSize(320,180);
    setLocation(50,50);

    add(new JButton("Fuck you"));
    add(new JButton("You too!"));
    setVisible(true);
  }
}
