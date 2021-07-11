/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BRCS
 */
public class Admin extends User implements ClassAdministrator {

    private String nik;

    public Admin(String nik, int id, String nama, String password, String noTlp, TipeUser tipe) {
        super(id, nama, password, noTlp, tipe);
        this.nik = nik;
    }

    public Admin() {
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void registerUser() {

    }

    public void removeUser() {

    }

    @Override
    public void createKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postPengumuman() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mengubahJadwalKelas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
