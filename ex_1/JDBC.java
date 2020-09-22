package com.company;

import java.sql.*;

public class JDBC {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/TEST";
    static final String USER = "username";
    static final String PASS = "password";

    public static void updateDB(ManipulationDetails details){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            String query = " insert into table (input_text_file, output_text_file, action)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, details.getInputTextFile());
            preparedStmt.setString (2, details.getOutputTextFile());
            preparedStmt.setString (3, details.getAction());

            preparedStmt.execute();

        }catch(SQLException se){
            System.out.println(se.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
                System.out.println(se.getMessage());
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                System.out.println(se.getMessage());
            }
        }
    }
}

