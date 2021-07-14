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
    public Admin getUser(String id, String password){
        conn.connect();
        Admin user = new Admin();
        String query = "SELECT * FROM admin WHERE nik = " + id + " AND password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id_admin"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("noTelp"));
                user.setNik(rs.getString("nik"));
                user.setTipe(TipeUser.ADMIN);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
}
