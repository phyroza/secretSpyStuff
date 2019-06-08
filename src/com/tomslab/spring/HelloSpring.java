package com.tomslab.spring;

import java.sql.*;

public class HelloSpring
{
  public static void main(String[] args) throws SQLException, ClassNotFoundException
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection connection = null;
    String dbURL = "jdbc:oracle:thin:@//192.168.1.6:1539/TomTest";
    try(Connection connection1 = DriverManager.getConnection(dbURL,"Tom","tomslab"))
    {
      Statement statement = connection.createStatement();
      boolean result = statement.execute("SELECT * FROM DUAL");
      ResultSet resultSet = statement.getResultSet();
      if (result)
      {
        resultSet = statement.getResultSet();
        String val = resultSet.getString("DUMMY");
        System.out.println(val);
      }

      while (resultSet.next())
      {
        String val = resultSet.getString(0);
        System.out.println(val);
      }
    }


  }
}
