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
import model.Murid;
import model.OrangTua;
import model.TipeUser;
import model.User;
import model.UserManager;

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
    public Murid getAnak() {
        Murid anak = new Murid();
        OrangTua ortu = (OrangTua) UserManager.getInstance().getUser();
        conn.connect();
        String query = "SELECT * FROM murid WHERE nip ='" + ortu.getNIP();
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                anak.setId(rs.getInt("id_murid"));
                anak.setNama(rs.getString("nama"));
                anak.setPassword(rs.getString("password"));
                anak.setNoTlp(rs.getString("no_tlp"));
                anak.setSPP(rs.getDouble("uang_sekolah"));
                anak.setTipe(TipeUser.STUDENT);
            }
        } catch(SQLException ex) {
            
        }
        return anak;
    }
}
