/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    
    public static int difficulty = 1;
    
    
    
    public Database()
    {
        resetDB();
    }
    
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\ugure\\OneDrive\\Belgeler\\NetBeansProjects\\KelimeOyunu\\DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void resetDB(){
        String sql = "UPDATE questions SET status=0";
        difficulty = 1;
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Object> queryQuestion(String zorluk){
        
        ArrayList<Object> array = new ArrayList();
        String sql = "SELECT * FROM questions WHERE status = 0 and difficulty ="+zorluk+" ORDER BY RANDOM() LIMIT 1";       
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             
             int id = rs.getInt("id");
             String soru = rs.getString("question");
             String cevap = rs.getString("answer");
             int durum = rs.getInt("status");
             int zor = rs.getInt("difficulty");
             
             array.add(id);
             array.add(soru);
             array.add(cevap);
             array.add(durum);
             array.add(zor);
             
             
             
             
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return array;
    }
    
    
    
   
}
