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
import model.Murid;
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
        String query = "SELECT * FROM orang_tua WHERE nip = " + id + " AND password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
		user.setId(rs.getInt("id_ortu"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
		user.setNIP(rs.getString("nip"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setTipe(TipeUser.PARENT);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public Murid getAnak(int id_ortu) {
        Murid anak = new Murid();
        conn.connect();
        String query = "SELECT * FROM murid WHERE nip ='" + id_ortu + "'";
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
