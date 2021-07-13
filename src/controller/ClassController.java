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
                Kelas kls = new Kelas();
                kls.setKode(rs.getString("kode"));
                kls.setNama(rs.getString("nama"));
                kls.setJadwal(rs.getString("jadwal"));
//                kls.setHomeRoomTeacher((Guru)tc.getUser(null, null, rs.getInt("id_guru")));
//                kls.setArrAbsensiMurid();
//                kls.setArrPost(dc.getPosts(rs.getInt("id_kelas")));
                kls.setArrMurid(studentsInClass(rs.getInt("id_kelas")));
                arrKelas.add(kls);
            }
        } catch(Exception e) {
            
        }
        return arrKelas;
    }
    
    public Kelas getKelas(int idKelas, boolean makingArray){
//        if(makingArray == false){
            conn.connect();
//        }
        Kelas kls = new Kelas();
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                DatabaseController dc = new DatabaseController();
                TeacherController tc = new TeacherController();
                kls.setKode(rs.getString("kode"));
                kls.setNama(rs.getString("nama"));
                kls.setJadwal(rs.getString("jadwal"));
//                kls.setHomeRoomTeacher((Guru)tc.getUser(null, null, rs.getInt("id_guru")));
//                kls.setArrAbsensiMurid();
//                kls.setArrPost(dc.getPosts(rs.getInt("id_kelas")));
                kls.setArrMurid(studentsInClass(rs.getInt("id_kelas")));
            }
        } catch(SQLException ex) {
            
        }
        return kls;
    }
    
    private ArrayList<Murid> studentsInClass(int idKelas){
        ArrayList<Murid> arrMurid = new ArrayList();
        String query = "SELECT * FROM murid_kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                MuridController mc = new MuridController();
                arrMurid.add((Murid)mc.getUser(null, null, rs.getInt("id_murid")));
            }
        } catch(SQLException ex) {
            
        }
        return arrMurid;
    }
    
    public void createClass(){
        
    }
    
}
