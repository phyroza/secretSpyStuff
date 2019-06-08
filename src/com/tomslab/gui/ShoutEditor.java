package com.tomslab.gui;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Locale;

public class ShoutEditor
{
  public static final int BUTTON_WITH = 50;
  public static final int BUTTON_HEIGHT = 50;
  public static final int BIG_BUTTON_WIDTH = 500;
  public static final int BIG_BUTTON_HEIGHT = 50;
  public static final int SHOUT_ROWS = 20;
  public static final int SHOUT_COLS = 80;
  public static final int TOOLBAR_WIDTH = 1000;
  public static final int TOOLBAR_HEIGHT = 50;

  private JFrame frame;
  private JPanel contentPane;
  private JTextArea shoutArea;

  ShoutEditor()
  {
    frame = new JFrame("Shout Editor");
    contentPane = new JPanel(new BorderLayout());
    frame.setContentPane(contentPane);
  }

  public static void main(String[] args)
  {
    ShoutEditor se = new ShoutEditor();
    se.init();
    se.run();
  }

  private void run()
  {
    frame.setVisible(true);
  }

  private void init()
  {
    addToolbar(contentPane);
    addComponents(contentPane);

    frame.pack();
  }

  private static void addToolbar(JPanel contentPane)
  {
    JToolBar toolBar = new JToolBar("Tools");
    toolBar.setPreferredSize(new Dimension(TOOLBAR_WIDTH, TOOLBAR_HEIGHT));
    addFuckOffButton(toolBar);

    contentPane.add(toolBar, BorderLayout.NORTH);
  }

  private static void addFuckOffButton(JToolBar toolBar)
  {
    JButton closeButton = new JButton("Fuck off");
    AbstractAction a = new AbstractAction()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        Runtime.getRuntime().exit(0);
      }
    };
    closeButton.addActionListener(a);
    closeButton.setSize(BUTTON_WITH, BUTTON_HEIGHT);
    toolBar.add(closeButton);
  }

  private void addComponents(JPanel contentPane)
  {
    addShoutButton(contentPane);
    addClearButton(contentPane);
  }

  private void addClearButton(JPanel contentPane)
  {
    JButton clearButton = new JButton("C");
    clearButton.setPreferredSize(new Dimension(BIG_BUTTON_WIDTH, BIG_BUTTON_HEIGHT));
    clearButton.addActionListener(new AbstractAction()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        shoutArea.setText(null);
      }
    });
    contentPane.add(clearButton, BorderLayout.EAST);

    shoutArea = new JTextArea(SHOUT_ROWS, SHOUT_COLS);
    contentPane.add(shoutArea, BorderLayout.SOUTH);
  }

  private void addShoutButton(JPanel contentPane)
  {
    JButton shoutButton = new JButton("Shout!");
    shoutButton.setPreferredSize(new Dimension(BIG_BUTTON_WIDTH, BIG_BUTTON_HEIGHT));
    shoutButton.addActionListener(new AbstractAction()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        shoutArea.setText(shoutArea.getText().toUpperCase(Locale.ENGLISH));
      }
    });
    contentPane.add(shoutButton, BorderLayout.WEST);
  }
}
