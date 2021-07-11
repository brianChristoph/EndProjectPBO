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
import model.OrangTua;
import model.TipeUser;
import model.User;

/**
 *
 * @author BRCS
 */
public class ParentController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    // Take User From dBase
    public OrangTua getUser(String id, String password){
        conn.connect();
        OrangTua user = new OrangTua();
        String query = "SELECT * FROM orang_tua WHERE nip = '" + id + "' && password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp("no_tlp");
                user.setTipe(TipeUser.PARENT);
            }
        } catch(SQLException ex) {
            
        }
        return user;
    }
    
}
