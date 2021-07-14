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
import java.util.ArrayList;
import model.Guru;
import model.Kelas;
import model.Murid;
import model.TipeUser;
import model.User;

/**
 *
 * @author BRCS
 */
public class ClassController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    // Database related
    
    public ArrayList<Kelas> getAllClass(){
        conn.connect();
        ArrayList<Kelas> arrKelas = new ArrayList();
        String query = "SELECT * FROM kelas";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Kelas kelas = new Kelas();
                kelas.setKode(rs.getString("kode"));
                kelas.setNama(rs.getString("nama"));
                kelas.setJadwal(rs.getString("jadwal"));
                kelas.setHomeRoomTeacher(getGuru(rs.getInt("id_guru")));
                arrKelas.add(kelas);
            }
        } catch(Exception e) {
            
        }
        return arrKelas;
    }
    
    public Guru getGuru(int idGuru){
        conn.connect();
        Guru user = new Guru();
        String query = "SELECT * FROM guru WHERE id_guru = " + idGuru;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id_guru"));
                user.setNik(rs.getString("nik"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setTipe(TipeUser.TEACHER);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        return user;
    }
    
}
