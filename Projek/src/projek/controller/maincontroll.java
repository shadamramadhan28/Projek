/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projek.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import projek.helper.helper;
import projek.model.mainmodel;
import projek.query.mainquery;
import java.sql.*;

/**
 *
 * @author Shadam Ramadhan
 */
public class maincontroll extends basecontroll {
    
   helper helper = new helper();
   mainquery query = new mainquery();
   
   public boolean create(mainmodel model) throws ParseException, SQLException {
       String date = helper.parseDateToString(model.getExpired());
            
       Map<Integer, Object> map = new HashMap<>();
       map.put(1, model.getName());
       map.put(2, model.getType());
       map.put(3, model.getStock());
       map.put(4, model.getPrice());
       map.put(5, date);
       
       
       String sql = this.query.create;
       
       return this.preparedStatement(map, sql);
   }
}
