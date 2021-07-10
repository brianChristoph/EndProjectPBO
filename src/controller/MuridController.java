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
import model.Kelas;
import model.Murid;
import model.OrangTua;
import model.TipeUser;
import model.User;

/**
 *
 * @author BRCS
 */
public class MuridController {
    
    ArrayList<Kelas> arrKelas = new ArrayList();
    DatabaseHandler conn = new DatabaseHandler();
    
    public User getUser(String id, String password){
        Murid user = new Murid();
        String query = "SELECT * FROM murid WHERE nip = '" + id + "' && password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
//                    user.setId(rs.getInt("ID/"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setSPP(rs.getInt("uang_sekolah"));
                user.setTipe(TipeUser.STUDENT);
            }
        } catch(SQLException ex) {
            
        }
        return user;
    }
    
    private boolean isMurid(User pengguna){
        if(pengguna instanceof Murid){
            return true;
        }
        return false;
    }
    private int indexKelas(int idKelas){
        for (int i = 0; i < arrKelas.size(); i++) {
            if(arrKelas.get(i) != null){
                // if id arrKelas dri database == idKelas
                // return i
            }
        }
        return -1;
    }
    private void printError(){
        // show Error Message
    }
    
    public void gabungKelas(User pengguna, int idKelas){
        if(isMurid(pengguna) == true){
            int idxKelas = indexKelas(idKelas);
            if(idxKelas != -1){
                // add pengguna ke arrayList student yang ada di model Kelas
            } else {
                printError();
            }
        }
    }
    
    public void keluarKelas(User pengguna, int idKelas){
        if(isMurid(pengguna) == true){
            int idxKelas = indexKelas(idKelas);
            if(idxKelas != -1){
                // remove pengguna dari arrayList student yang ada di model kelas
            } else {
                printError();
            }
        }
    }
    
    public void kumpulkanTugas(User pengguna){
        if(isMurid(pengguna) == true){
            // mengganti status tugas menjadi submited
        }
    }
    
}
