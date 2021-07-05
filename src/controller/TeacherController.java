/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
import model.Guru;
import model.Murid;
import model.Kelas;

/**
 *
 * @author BRCS
 */
public class TeacherController {

    ArrayList<Kelas> arrKelas = new ArrayList();
    DatabaseHandler conn = new DatabaseHandler();

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

    public void createNewPost(User pengguna, int idKelas, String post) {

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

                } else {
                    try {
                        String query = "DELETE FROM `murid_kelas` WHERE id_murid = ?";
                        PreparedStatement st = conn.con.prepareStatement(query);
                        st.setInt(1, result);
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
