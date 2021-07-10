/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import model.Admin;
import model.TipeUser;
import model.User;

/**
 *
 * @author BRCS
 */
public class AdminController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    // Take User From dBase
    public User getUser(String id, String password){
        Admin user = new Admin();
        String query = "SELECT * FROM admin WHERE nik = '" + id + "' && password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
//                    user.setId(rs.getInt("ID"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("noTelp"));
                user.setNik(rs.getString("nik"));
                user.setTipe(TipeUser.ADMIN);
            }
        } catch(SQLException ex) {
            
        }
        return user;
    }
    
}
