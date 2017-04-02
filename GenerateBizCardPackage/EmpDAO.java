/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateBizCardPackage;

import loginPackage.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import employeebusinesscardgenerator.Emp;

/**
 *
 * @author Admin
 */
public class EmpDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public EmpDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public Emp getEmp(String empName) throws SQLException {
        Emp emp = null;
        String sql = "SELECT * FROM Employees WHERE name = ? ";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, empName);
         
        ResultSet resultSet = statement.executeQuery();
         
        //only comes here is found matching user 
        //if not, user is null
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String title = resultSet.getString("title");
            String division = resultSet.getString("division");
            String phone = resultSet.getString("phone");
             
            emp = new Emp(name, title, division,phone);
        }
         
        resultSet.close();
        statement.close();
         
        return emp;
    }
}
