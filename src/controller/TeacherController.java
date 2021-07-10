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
import model.User;
import model.Guru;
import model.Murid;
import model.Kelas;
import model.TipeUser;

/**
 *
 * @author BRCS
 */
public class TeacherController {

    ArrayList<Kelas> arrKelas = new ArrayList();
    DatabaseHandler conn = new DatabaseHandler();
    
    // Database related
    public User getUser(String id, String password, int idGuru){
        Guru user = new Guru();
        String query = "";
        if(idGuru != 0)
            query = "SELECT * FROM guru WHERE id_guru = " + idGuru;
        else
            query = "SELECT * FROM guru WHERE nik = '" + id + "' && password = '" + password + "'";
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp("no_tlp");
                user.setTipe(TipeUser.TEACHER);
                user.setAjarKelas(getTaughtClasses(rs.getInt("id_guru")));
            }
        } catch(SQLException ex) {
            
        }
        return user;
    }
    private ArrayList<Kelas> getTaughtClasses(int idGuru){
        ArrayList<Kelas> arrClasses = new ArrayList();
        conn.connect();
        String query = "SELECT * FROM kelas WHERE id_guru = " + idGuru;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ClassController cc = new ClassController();
                Kelas taughtClass = cc.getKelas(rs.getInt("id_kelas"));
                arrClasses.add(taughtClass);
            }
        } catch(SQLException ex) {
            
        }
        return arrClasses;
    }

    private boolean isTeacher(User pengguna) {
        if (pengguna instanceof Guru) {
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

    private void printError() {

    }

    public void createNewPost(User pengguna, int idKelas, String judul, String post) {
        if (pengguna.getTipe().TEACHER == TipeUser.TEACHER) {
            try {
                String query = "INSERT INTO `post`(`judul`, `deskripsi`) VALUES (?,?)";
                PreparedStatement st = conn.con.prepareStatement(query);
                st.setString(1, judul);
                st.setString(2, post);
                st.executeUpdate();
            } catch (SQLException e) {

            }
        }
    }

    public void deletePost(User pengguna, int idKelas, int idPost) {

    }

    public void studentAttendance(User pengguna, int idKelas) {

    }

    public void inputGrade(User pengguna, int idKelas, int idMurid, int nilai) {

    }

    public void kickStudent(User pengguna, int idKelas, int idMurid, ArrayList<Murid> murids) {
        if (isTeacher(pengguna) == true) {
            int idxKelas = indexKelas(idKelas);
            if (idxKelas != -1) {
                /**
                 * get arrMurid yg ada di model kelas delete murid where idMurid
                 * == arrMurid().get(i).getId()
                 */
                int result = getMuridById(murids, idMurid);
                if (result == -1) {
                    System.out.println("No murid with id " + idMurid + " found");
                } else {
                    try {
                        String query = "DELETE FROM `murid_kelas` WHERE id_murid = ? AND id_kelas = ?";
                        PreparedStatement st = conn.con.prepareStatement(query);
                        st.setInt(1, result);
                        st.setInt(2, idKelas);
                        st.executeUpdate();
                        System.out.println("Murid with id " + idMurid + " deleted from kelas with id " + idKelas);
                    } catch (SQLException e) {
                        printError();
                    }
                }
            } else {
                printError();
            }
        }
    }

    private int getMuridById(ArrayList<Murid> murids, int search) {
        for (int i = 0; i < murids.size(); i++) {
            if (murids.get(i).getId() == search) {
                return murids.get(i).getId();
            }
        }
        return -1;
    }

}
