package controller;

import java.sql.Date;
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
import model.Posting;
import model.TipeUser;
import model.Tugas;
import model.User;
import model.UserManager;

/**
 *
 * @author BRCS
 */
public class MuridController {

    DatabaseHandler conn = new DatabaseHandler();

    public Murid getUser(String nip, String password) {
        conn.connect();
        Murid user = new Murid();
        user = getNonArrayDataType(user, nip, password);
        user.setListKelas(getFollowedClass(user.getId()));
        conn.disconnect();
        return user;
    }

    public Murid getUserById(int idMurid) {
        conn.connect();
        Murid murid = new Murid();
        String query = "SELECT * FROM murid WHERE id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                murid.setNama(rs.getString("nama"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return murid;
    }

    private String loginQuery(String nip, String password) {
        return "SELECT * FROM murid WHERE nip = " + nip + " AND password = '" + password + "'";
    }

    public Murid getNonArrayDataType(Murid user, String id, String password) {
        String query = loginQuery(id, password);
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.setId(rs.getInt("id_murid"));
                user.setNIP(rs.getString("nip"));
                user.setNama(rs.getString("nama"));
                user.setPassword(rs.getString("password"));
                user.setNoTlp(rs.getString("no_telepon"));
                user.setSPP(rs.getInt("uang_sekolah"));
                user.setTipe(TipeUser.STUDENT);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    private ArrayList<Kelas> getFollowedClass(int idMurid) {
        ArrayList<Kelas> arrClasses = new ArrayList();
        String query = "SELECT * FROM murid_kelas WHERE id_murid = " + idMurid;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kelas followClass = getClass(rs.getInt("id_kelas"), idMurid);
                arrClasses.add(followClass);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrClasses;
    }

    private Kelas getClass(int idKelas, int idMurid) {
        Kelas kelas = new Kelas();
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                kelas.setId(rs.getInt("id_kelas"));
                kelas.setKode(rs.getString("kode"));
                kelas.setNama(rs.getString("nama"));
                kelas.setJadwal(rs.getString("jadwal"));
                kelas.setArrPost(getPosts(rs.getInt("id_kelas"), idMurid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kelas;
    }

    private ArrayList<Posting> getPosts(int idKelas, int idMurid) {
        ArrayList<Posting> arrPosts = new ArrayList();
        try {
            String queryPost = "SELECT * FROM post WHERE id_kelas = " + idKelas;
            Statement st = conn.con.createStatement();
            ResultSet rPost = st.executeQuery(queryPost);
            while (rPost.next()) {
                Posting post = new Posting();
                post.setJudul(rPost.getString("judul"));
                post.setDeskripsi(rPost.getString("deskripsi"));
                arrPosts.add(post);
            }
            String queryTugas = "SELECT * FROM tugas WHERE id_kelas = " + idKelas + " && id_murid = " + idMurid;
            ResultSet rTugas = st.executeQuery(queryTugas);
            while (rTugas.next()) {
                Tugas tgs = new Tugas();
                tgs.setJudul(rTugas.getString("judul"));
                tgs.setDeskripsi(rTugas.getString("deskripsi"));
                tgs.setTanggalPengumpulan(rTugas.getDate("tanggal_pengumpulan"));
                tgs.setTanggalDikumpulkan(rTugas.getDate("tanggal_dikumpulkan"));
                tgs.setTerkumpulkan(rTugas.getInt("terkumpulkan") == 1 ? true : false);
                tgs.setNilai(rTugas.getInt("nilai"));
                arrPosts.add(tgs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPosts;
    }

    private void printError() {

    }

    private boolean isMurid(User pengguna) {
        if (pengguna instanceof Murid) {
            return true;
        }
        return false;
    }

    private void updateListKelas(Murid pengguna) {
        pengguna.setListKelas(getFollowedClass(UserManager.getInstance().getUser().getId()));
        UserManager.getInstance().setUser(pengguna);
    }

    public void searchKelas(Murid pengguna, int idKelas) {
        conn.connect();
        String query = "SELECT * FROM kelas WHERE id_kelas = " + idKelas;
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            gabungKelas(rs.getInt("id_kelas"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        updateListKelas(pengguna);
    }

    private void gabungKelas(int idKelas) {
        String query = "INSERT INTO murid_kelas (`id_murid`, `id_kelas`) VALUES (?,?)";
        try {
            PreparedStatement st = conn.con.prepareStatement(query);
            st.setInt(1, UserManager.getInstance().getUser().getId());
            st.setInt(2, idKelas);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void keluarKelas(Murid pengguna, int idKelas) {
        conn.connect();
        String query = "DELETE FROM murid_kelas WHERE id_kelas = " + idKelas + " && id_murid = " + UserManager.getInstance().getUser().getId();
        try {
            Statement st = conn.con.createStatement();
            ResultSet rs = st.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        updateListKelas(pengguna);
    }

    public void submitTugas(int idMurid, Tugas tugas) {
        conn.connect();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String query = "UPDATE `tugas` SET `terkumpulkan` = 1, `tanggal_dikumpulkan` = '" + date + "' WHERE id_murid = " + UserManager.getInstance().getUser().getId();
        //UPDATE `admin` SET `nik` = '1122333' WHERE `admin`.`id_admin` = 1; 
        try {
            PreparedStatement st = conn.con.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        conn.disconnect();
        updateListKelas((Murid) UserManager.getInstance().getUser());
    }

    public void addMurid(String nama, String Nik, String pw, String tlp) {
        conn.connect();
        String query = "INSERT INTO `murid` "
                + "(`nama`, `nip`, `password`, `no_telepon`) "
                + "VALUES "
                + "('" + nama + "', '" + Nik + "', '" + pw + "', '" + tlp + "')";
        try {
            PreparedStatement preparedStmt = conn.con.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
