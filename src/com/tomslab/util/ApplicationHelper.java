/*
 * @(#)ApplicationHelper.java
 *
 * Copyright (c) 2018 Sabre Airline Solutions, Inc. All rights reserved.
 */
package com.tomslab.util;

import com.tomslab.SecretStuffProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Contains methods to help build simple applications.
 */
public class ApplicationHelper
{
  public static final String ICON_URL = "https://www.google.pl/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiOnfGcufreAhWMqIsKHccQDigQjRx6BAgBEAU&url=https%3A%2F%2Fpngtree.com%2Ffree-icon%2Ficon-exit_1205759&psig=AOvVaw3r3h2kS083D0JfLGIP6Nfx&ust=1543609927562968";
  /**
   * Applications root frame
   */
  JFrame frame;

  /**
   * Applications root desktop pane
   */
  JDesktopPane desktop;

  /**
   * Applications menu bar
   */
  private JMenuBar menuBar;

  private double frameWidthRatio = 0.60;
  private double frameHeightRatio = 0.60;
  private JToolBar toolbar;

  public static void runApp()
  {
    ApplicationHelper app = new ApplicationHelper();
    app.createApplication("test");
    ExitAction exitAction = new ApplicationHelper.ExitAction("Exit", new ImageIcon(ICON_URL), "Exit no",
            new Integer(KeyEvent.VK_X));

    SecretStuffProvider stp = new SecretStuffProvider();
    ApplicationAction zonkAction = null;
    try
    {
      zonkAction = new ApplicationAction(stp, "getZonks",
              "do Zonks", "does zonks", ICON_URL, KeyStroke.getKeyStroke('Z'));
    } catch (@NotNull MalformedURLException | IllegalAccessException | InstantiationException e)
    {
      e.printStackTrace();
    }


    app.addToFrame(new JButton("LOL"));
    app.addToMenu(new JButton("zonk"));
    app.addToMenu(new JMenuItem(exitAction));
    app.addToMenu(new JMenuItem(zonkAction));
  }

  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        runApp();
      }
    });
  }

  /**
   * Builds application graphical interface with specified title, default components (Frame, menu, desktop, tool bar)
   * and look and feel.
   *
   * @param title for the frame, displayed at title bar
   */
  public void createApplication(String title)
  {
    initializeFrame(title);
    initializeDesktop();
    initializeMenu();
    initializeToolbar();
    frame.setVisible(true);
  }

  /**
   * Initializes given frame with title and sensible defaults.
   *
   * @param title for the frame, displayed at titlebar
   */
  public void initializeFrame(String title)
  {
    frame = new JFrame();
    frame.setTitle(title);
    initializeFrameDimensions();
    initializeFrameLayout();
    JOptionPane.setRootFrame(frame);
  }

  /**
   * Creates and adds desktop pane (allows to create windows within window) to application's frame.
   */
  public void initializeDesktop()
  {
    desktop = new JDesktopPane();
    frame.getContentPane().add(desktop);
  }

  /**
   * Creates and adds menu to application's frame. Includes default File menu.
   */
  public void initializeMenu()
  {
    menuBar = new JMenuBar();
    menuBar.setOpaque(true);
    frame.setJMenuBar(menuBar);

    JMenu menu = addMenu(menuBar, "File", 'F');
  }

  /**
   * Creates and adds empty toolbar to applications's frame.
   */
  public void initializeToolbar()
  {
    toolbar = getToolBar();
    if (toolbar == null)
    {
      toolbar = new JToolBar();
      frame.getContentPane().add(toolbar, BorderLayout.NORTH);
    }
    toolbar.setRollover(true);
  }

  public void addToFrame(JComponent componentToAdd)
  {
    frame.getContentPane().add(componentToAdd);
  }

  public void addToMenu(JComponent componentToAdd)
  {
    menuBar.add(componentToAdd);
  }

  public void startWaitCursor()
  {

  }

  public void stopWaitCursor()
  {

  }

  public double getFrameWidthRatio()
  {
    return frameWidthRatio;
  }

  public void setFrameWidthRatio(double frameWidthRatio)
  {
    this.frameWidthRatio = frameWidthRatio;
  }

  public double getFrameHeightRatio()
  {
    return frameHeightRatio;
  }

  public void setFrameHeightRatio(double frameHeightRatio)
  {
    this.frameHeightRatio = frameHeightRatio;
  }

  @NotNull
  private JToolBar getToolBar()
  {
    return (JToolBar) ((BorderLayout) frame.getContentPane().getLayout()).getLayoutComponent(BorderLayout.NORTH);
  }

  @NotNull
  private JMenu addMenu(JMenuBar menuBar, String menuText, char mnemonic)
  {
    JMenu menu = new JMenu(menuText);
    menu.setMnemonic(mnemonic);

    menuBar.add(menu);
    return menu;
  }

  private void initializeFrameLayout()
  {
    BorderLayout layout = new BorderLayout();
    frame.getContentPane().setLayout(layout);
  }

  private void initializeFrameDimensions()
  {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int width = (int) (screenSize.width * frameWidthRatio);
    int height = (int) (screenSize.height * frameHeightRatio);
    int xPos = (screenSize.width - width) / 2;
    int yPos = 75;

    frame.setBounds(xPos, yPos, width, height);
  }

  // todo: maybe move to top level class?
  @Nullable
  public ApplicationAction createAction(Object target, String methodName, String text, String toolTip,
                                        String iconFileName, KeyStroke accelerator)
  {
    return null;
  }

  public static class ApplicationAction extends AbstractAction
  {

    private Object target;
    private Method method;
    private String methodName;
    private Class[] parameterTypes;
    private Object[] invocationArgs;

    public ApplicationAction(Object target, String methodName, String text, String toolTip,
                             @NotNull String iconFileName, KeyStroke accelerator) throws MalformedURLException, IllegalAccessException, InstantiationException
    {
      super(text, new ImageIcon(new URL(iconFileName)));
      putValue(SHORT_DESCRIPTION, toolTip);
      putValue(ACCELERATOR_KEY, accelerator);
      this.target = target;
      this.methodName = methodName;

      Method[] declaredMethods = target.getClass().getDeclaredMethods();
      long methodCount = Stream.of(declaredMethods).filter(m -> m.getName() == methodName).count();
      if (methodCount == 1)
      {
        Optional<Method> methodCand = Stream.of(declaredMethods).filter(m -> m.getName() == methodName).findFirst();
        method = methodCand.get();
      }
      parameterTypes = method.getParameterTypes();
      invocationArgs = new Object[parameterTypes.length];
      for (int i = 0; i < parameterTypes.length; i++)
      {
        if (parameterTypes[i].getTypeName().equals("int"))
        {
          invocationArgs[i] = new Integer(0);
        } else
        {
          invocationArgs[i] = parameterTypes[i].newInstance();
        }
      }
    }

    public void actionPerformed(ActionEvent event)
    {
      try
      {
        method.invoke(target, invocationArgs);

      } catch (IllegalAccessException e)
      {
        e.printStackTrace();
      } catch (InvocationTargetException e)
      {
        e.printStackTrace();
      }
    }
  }

  public static class ExitAction extends AbstractAction
  {
    public ExitAction(String text, ImageIcon icon,
                      String desc, Integer mnemonic)
    {
      super(text, icon);
      putValue(SHORT_DESCRIPTION, desc);
      putValue(MNEMONIC_KEY, mnemonic);
    }

    public void actionPerformed(ActionEvent e)
    {
      System.exit(0);
    }
  }
}
