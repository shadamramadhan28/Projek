/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.controller;

import java.util.Map;
import projek.connection.dbconnection;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
/**
 *
 * @author Shadam Ramadhan
 */
public class basecontroll {
   dbconnection koneksi = new dbconnection();
   
   public boolean preparedStatement(Map<Integer, Object> map, String sql) throws SQLException{
     try{
         Connection con = koneksi.open();
         PreparedStatement ps = con.prepareStatement(sql);
         
         for(Map.Entry<Integer, Object> entry : map.entrySet()){
             ps.setString(entry.getKey(), entry.getValue().toString());
         }
         
         int rows = ps.executeUpdate();
         con.close();
         return rows != 0;
     }  
     catch(SQLException e){
         System.err.println(e.getMessage());
         return false;
     }
   }
}
