package com.tomslab.db;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

// H2 In-Memory Database Example shows about storing the database contents into memory.

public class Storage
{

  private static final String DB_DRIVER = "org.h2.Driver";
  private static final String DB_CONNECTION = "jdbc:h2:mem:test";
  private static final String DB_USER = "";
  private static final String DB_PASSWORD = "";
  private static Connection connection = getDBConnection();
  private static List<String[]> existingData = Arrays.asList(new String[][]{{"data1","data2","data3"},{"2data1","2data2","2data3"}});

  public static void main(String[] args){
    try {
//      insertWithStatement();
//      insertWithPreparedStatement();
      loadAndSelectFromExistingData(existingData);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void loadAndSelectFromExistingData(List<String[]> data) throws SQLException
  {
    connection = getConnection();
    connection.setAutoCommit(true);
    String name = "TEST_TAB";

    String createSql = createCreateTabStmt(data, name);
    executeStmt(createSql);

    for (int i = 0; i < data.size(); i++)
    {
      String[] row = data.get(i);
      String insertSql = "INSERT INTO " + name + " VALUES (";
      for (int j = 0; j < row.length; j++)
      {
        String cell = row[j];
        insertSql += "'" + cell + "'";
        if (!(j + 1 == row.length))
          insertSql += ", ";
        else
          insertSql += "); ";
      }

      executeStmt(insertSql);
    }

    String selectStmt = getSelectStmt(name);
    executeSelectStmt(selectStmt);
  }

  private static String getSelectStmt(String tabName)
  {
     return "SELECT * FROM " + tabName;
  }

  @NotNull
  private static String createCreateTabStmt(List<String[]> data, String name)
  {
    String createSql = "CREATE TABLE " + name + " ( ";

    {
      String[] row = data.get(0);
      for (int i = 0; i < row.length; i++)
      {
        String cell = row[i];
        createSql = createSql + "col" + i + " VARCHAR2(200)";
        if (!(i + 1 == row.length))
          createSql += ", ";
      }
    }
    createSql += "); ";
    return createSql;
  }

  private static void executeStmt(String sql) throws SQLException
  {
    System.out.println( sql);
    PreparedStatement stmt = null;
    try
    {
      stmt = connection.prepareStatement(sql);
      stmt.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    } finally
    {
      stmt.close();
    }
  }

  private static void executeSelectStmt(String sql) throws SQLException
  {
    System.out.println( sql);
    try (
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
    )
    {

      while (resultSet.next())
      {
        for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++)
        {
          System.out.print(resultSet.getString(i));
        }
        System.out.println();
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private static void insertWithPreparedStatement() throws SQLException {
    PreparedStatement createPreparedStatement = null;
    PreparedStatement insertPreparedStatement = null;
    PreparedStatement selectPreparedStatement = null;

    String CreateQuery = "CREATE TABLE PERSON(id int primary key, name varchar(255))";
    String InsertQuery = "INSERT INTO PERSON" + "(id, name) values" + "(?,?)";
    String SelectQuery = "getSelectStmt * from PERSON";

    try {
      Connection connection = getConnection();
      connection.setAutoCommit(false);

      createPreparedStatement = connection.prepareStatement(CreateQuery);
      createPreparedStatement.executeUpdate();
      createPreparedStatement.close();

      insertPreparedStatement = connection.prepareStatement(InsertQuery);
      insertPreparedStatement.setInt(1, 1);
      insertPreparedStatement.setString(2, "Jose");
      insertPreparedStatement.executeUpdate();

      selectPreparedStatement = connection.prepareStatement(SelectQuery);
      ResultSet rs = selectPreparedStatement.executeQuery();
      System.out.println("H2 In-Memory Database inserted through PreparedStatement");
      while (rs.next()) {
        System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
      }
      selectPreparedStatement.close();

      connection.commit();
    } catch (SQLException e) {
      System.out.println("Exception Message " + e.getLocalizedMessage());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      createPreparedStatement.close();
      insertPreparedStatement.close();
      connection.close();
    }
  }

  private static Connection getConnection()
  {
    return getDBConnection();
  }

  private static void insertWithStatement() throws SQLException {
    try (Statement stmt = connection.createStatement())
    {
      connection.setAutoCommit(false);
      stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
      stmt.execute("INSERT INTO PERSON(id, name) VALUES(1, 'Anju')");
      stmt.execute("INSERT INTO PERSON(id, name) VALUES(2, 'Sonia')");
      stmt.execute("INSERT INTO PERSON(id, name) VALUES(3, 'Asha')");

      try (ResultSet rs = stmt.executeQuery("getSelectStmt * from PERSON"))
      {
        System.out.println("H2 In-Memory Database inserted through Statement");
        while (rs.next())
        {
          System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
        }
      }

//      stmt.execute("DROP TABLE PERSON");
      connection.commit();

    } catch (SQLException e)
    {
      System.out.println("Exception Message " + e.getLocalizedMessage());
    } catch (Exception e)
    {
      e.printStackTrace();
    } finally
    {
      connection.close();
    }
  }

  private static Connection getDBConnection() {
    Connection dbConnection = null;
    try {
      Class.forName(DB_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try {
      dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
      return dbConnection;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return dbConnection;
  }
}
