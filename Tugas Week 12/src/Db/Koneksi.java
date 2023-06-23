/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Db;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class Koneksi {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/penjualan";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs; 
    
   public void koneksidb(){
       try{
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
           JOptionPane.showMessageDialog(null,"Terkoneksi");
       }
       catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args)
   {
//       koneksidb();
   }
}
