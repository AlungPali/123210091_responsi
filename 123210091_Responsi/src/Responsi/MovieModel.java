/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Responsi;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class MovieModel {
    private static Connection connection;
    private static Statement statement;
    
    public MovieModel(){
        connectToDatabase();
    }
    private void connectToDatabase(){
               
        try {
            String url = "jdbc:mysql://localhost/movie_db";
            String username = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection  = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private final DefaultTableModel model;
    
    public void tampilData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        String query = "SELECT * FROM movie";
        try {
            ResultSet resultSet = statement.executeUpdate(query);
            while(resultSet.next()){
            Object[] o = new Object [5];
            o[0] = resultSet.getString("judul");
            o[1] = resultSet.getString("alur");
            o[2] = resultSet.getString("penokohan");
            o[3] = resultSet.getString("akting");
            o[4] = resultSet.getString("nilai");
            
            model.addRow(o);
            }
            
        } catch (Exception e) {
        }
    }

    
    public void tambahData (String judul, double alur, double penokohan, double akting){
        double nilai = alur + penokohan + akting / 3;
        
        String query = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES ('" + judul + "', " + alur + ", " + penokohan + ", " + akting + ", " + nilai + ")";
        System.out.println(judul);
        
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
}
