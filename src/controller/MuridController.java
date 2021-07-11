package controller;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kelas;
import model.User;
import model.Guru;
import model.Murid;
import model.OrangTua;
import model.Kelas;
import model.TipeUser;
import model.User;

/**
 *
 * @author BRCS
 */
public class MuridController {
    
    ArrayList<Kelas> arrKelas = new ArrayList();
    DatabaseHandler conn = new DatabaseHandler();
    
    public Murid getUser(String id, String password, int idMurid){
        Murid user = new Murid();
        String query = "";
        if(idMurid != 0)
            query = "SELECT * FROM murid WHERE id_murid = " + idMurid;
        else
            conn.connect();
            query = "SELECT * FROM murid WHERE nip = '" + id + "' && password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setId(rs.getInt("id_murid"));
                user.setNIP(rs.getString("nip"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setSPP(rs.getInt("uang_sekolah"));
//                user.setAjarKelas(getTaughtClasses(rs.getInt("id_guru")));
                user.setTipe(TipeUser.STUDENT);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        return user;
    }
    
    private ArrayList<Kelas> getTaughtClasses(int idGuru){
        ArrayList<Kelas> arrClasses = new ArrayList();
        String query = "SELECT * FROM kelas WHERE id_guru = " + idGuru;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ClassController cc = new ClassController();
                Kelas taughtClass = cc.getKelas(rs.getInt("id_kelas"), true);
                arrClasses.add(taughtClass);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return arrClasses;
    }
    
    private void printError(){
        
    }
    
    private boolean isMurid(User pengguna){
        if(pengguna instanceof Murid){
            return true;
        }
        return false;
    }
    
    private int indexKelas(int idKelas) {
        for (int i = 0; i < arrKelas.size(); i++) {
            if (arrKelas.get(i) != null) {
                /**
                 * if idKelas == id kelas yang ada di database return i;
                 */
            }
        }
        return -1;
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
            
        }
    }

}