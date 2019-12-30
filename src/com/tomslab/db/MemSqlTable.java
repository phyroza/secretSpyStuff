package com.tomslab.db;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MemSqlTable
{
  private static final String PASSWORD = System.getProperty("password");
  private static final String USERNAME = System.getProperty("username");
  private static final String URL = "jdbc:h2:mem:test";
  private static Connection conn;

  public static void main(String[] args)
  {
    try
    {
      init();
      List<String> columnsDefs = new ArrayList<>();
      columnsDefs.add("omg INTEGER");
      columnsDefs.add("lol VARCHAR(200)");
      columnsDefs.add("butt VARCHAR(200)");

      String tableName = "ROTFL";
      makeSomeNiceStuff(columnsDefs, tableName);
      ArrayList<String[]> strings = new ArrayList<>();

      strings.add(new String[]{"1", "wat", "zomg"});
      strings.add(new String[]{"2", "deska", "rolki"});
      strings.add(new String[]{"3", "dupa", "czarek"});

      populateWithValues(strings, tableName);
      selectEVERYTHING("SELECT * FROM " + tableName);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

  private static boolean selectEVERYTHING(String selectSql)
  {
    boolean status = false;

    try (Statement statement = conn.createStatement())
    {
      try (ResultSet resultSet = statement.executeQuery(selectSql))
      {
        printOutResultSet(resultSet);
      }
    } catch (SQLException e)
    {
      e.printStackTrace();
    }

    return status;
  }

  private static void printOutResultSet(ResultSet resultSet) throws SQLException
  {
    ResultSetMetaData metaData = resultSet.getMetaData();
    int columnCount = metaData.getColumnCount();
    for (int i = 1; i < (columnCount + 1); i++)
    {
      String columnClassName = metaData.getColumnClassName(i);
      System.out.print(i + " " + columnClassName + "\t");
    }

    System.out.println();

    while (resultSet.next())
    {
      for (int i = 1; i < columnCount + 1; i++)
      {
        String columnClassName = metaData.getColumnClassName(i);

        if (columnClassName.toUpperCase(Locale.ENGLISH).contains("STRING"))
        {
          System.out.print(resultSet.getString(i) + " \t");
        }

        if (columnClassName.toUpperCase(Locale.ENGLISH).contains("INT"))
        {
          System.out.print(resultSet.getInt(i) + " \t");
        }
      }
      System.out.println();
    }
  }

  private static boolean populateWithValues(List<String[]> valuesTab, String tableName)
  {
    boolean status = false;

    StringBuilder insertSql = buildInsertSQL(valuesTab, tableName);

    try (PreparedStatement preStmt = conn.prepareStatement(insertSql.toString()))
    {
      for (String[] row : valuesTab)
      {
        for (int j = 0; j < row.length; j++)
        {
          String value = row[j];
          preStmt.setString(j+1, value);
        }

        status = preStmt.execute();
      }

    } catch (SQLException e)
    {
      e.printStackTrace();
    }

    return status;
  }

  @NotNull
  private static StringBuilder buildInsertSQL(List<String[]> values, String tableName)
  {
    StringBuilder insertSql = new StringBuilder("INSERT INTO ").append(tableName).append(" VALUES (");
    for (int i = 0; i < values.size(); i++)
    {
      insertSql.append("?");
      if ((i+1) < values.size())
        insertSql.append(", ");
    }
    insertSql.append(");");
    return insertSql;
  }

  private static boolean makeSomeNiceStuff(List<String> columns, String tabName) throws SQLException
  {
    if (columns == null)
      return false;

    boolean status = false;
    StringBuilder niceDefinitionSql = new StringBuilder("CREATE TABLE ").append(tabName).append(" (");

    for (int i = 0; i < columns.size(); i++)
    {
      niceDefinitionSql.append(columns.get(i));
      if ( (i+1) < columns.size())
      {
        niceDefinitionSql.append(", ");
      }
    }
    niceDefinitionSql.append(");");

    System.out.println(niceDefinitionSql);

    try (PreparedStatement preStmt = conn.prepareStatement(niceDefinitionSql.toString()))
    {
      status = preStmt.execute();
      status = true;
    }

    return status;
  }

  private static void init()
  {
    try
    {
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}
