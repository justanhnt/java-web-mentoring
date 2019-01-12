package com.mentoring.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DatabaseExample {
    private static final String H2_JDBC_DRIVER = "org.h2.Driver";
    private static final String H2_DB_URL = "jdbc:h2:~/test";

    private static final String ADDING_STUDENT_SQL_QUERY = "INSERT INTO STUDENT_TABLE VALUES (?, ?)";
    private static final String DELETING_STUDENT_SQL_QUERY = "DELETE FROM STUDENT_TABLE WHERE NAME = ?";
    private static final String LIST_STUDENT_SQL_QUERY = "SELECT * FROM STUDENT_TABLE";
    private static final String COUNT_STUDENT_SQL_QUERY = "SELECT COUNT(NAME) AS TOTAL FROM STUDENT_TABLE";

    private static void addingSomeData() {
        Connection conn = null;
        try {
            // Register JDBC driver
            Class.forName(H2_JDBC_DRIVER);

            // Open connection
            conn = DriverManager.getConnection(H2_DB_URL);

            // Execute a query
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO student_tables VALUES (?, ?)");
            pstmt.setString(1, "Alpha");
            pstmt.setInt(2, 10);
            pstmt.executeUpdate();

            pstmt.setString(1, "Beta");
            pstmt.setInt(2, 12);
            pstmt.executeUpdate();

            pstmt.setString(1, "Gamma");
            pstmt.setInt(2, 11);
            pstmt.executeUpdate();
        } catch (Exception se){
            se.printStackTrace();
        } finally {
            // Clean-up environment
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // before running create table student_table in test.db first!.
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 1) {
            if ("1".equalsIgnoreCase(args[1])) {
                addingSomeData();
            }
        }

        Connection conn = null;

        // Get the queries
        File queryFile = new File("meta/db_query");
        Scanner sc = new Scanner(queryFile);

        try {
            Class.forName(H2_JDBC_DRIVER);
            conn = DriverManager.getConnection(H2_DB_URL);

            // Execute queries
            int numberOfQuery = sc.nextInt();
            PreparedStatement addingStmt = conn.prepareStatement(ADDING_STUDENT_SQL_QUERY);
            PreparedStatement removeStmt = conn.prepareStatement(DELETING_STUDENT_SQL_QUERY);
            PreparedStatement listAllStmt = conn.prepareStatement(LIST_STUDENT_SQL_QUERY);
            PreparedStatement count = conn.prepareStatement(COUNT_STUDENT_SQL_QUERY);

            for (int i = 1; i < numberOfQuery+1; i++) {
                String rawQuery = sc.nextLine();
                String[] query = rawQuery.split(" ");

                assert query.length > 0;
                assert query[0] != null;

                switch (query[0]) {
                    case "ADD":
                        addingStmt.setString(1, query[1]);
                        addingStmt.setInt(2, Integer.parseInt(query[2]));
                        addingStmt.executeUpdate();
                        break;
                    case "REMOVE":
                        removeStmt.setString(1, query[1]);
                        removeStmt.executeUpdate();
                        break;
                    case "LIST_ALL": {
                        ResultSet rs = listAllStmt.executeQuery();
                        System.out.println("Name" + "\t\t\t" + "Age");
                        while (rs.next()) {
                            String name = rs.getString("NAME");
                            int age = rs.getInt("AGE");
                            System.out.println(name + "\t\t\t" + age);
                        }
                        rs.close();
                        break;
                    }
                    case "COUNT": {
                        ResultSet rs = count.executeQuery();
                        while (rs.next()) {
                            // sure that length of rs is 1;
                            System.out.println("Total " + rs.getInt(1) + " students");
                        }
                        break;
                    }
                    case "COUNT_CONDITION": {
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("SELECT COUNT(NAME) AS TOTAL FROM STUDENTLIST WHERE AGE" + query[1] + query[2]);
                        int c = 0;
                        while (rs.next()) {
                            c = rs.getInt(1);
                            System.out.println("Total " + c + " students whose age" + query[1] + query[2]);
                        }
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
