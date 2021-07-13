/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author BRCS
 */
public class Kelas {

    private String nama;
    private String kode;
    private String jadwal;
    private double na;
    private ArrayList<Murid> arrMurid = new ArrayList();
    private Guru homeRoomTeacher = new Guru();
    private ArrayList<Posting> arrPost = new ArrayList();
    private HashMap<Murid, Absensi> listAbsensiMurid = new HashMap<>();
    private ArrayList<HashMap> absensi = new ArrayList<>();

    public Kelas() {
    }

    public HashMap<Murid, Absensi> getListAbsensiMurid() {
	return listAbsensiMurid;
    }

    public void setListAbsensiMurid(HashMap<Murid, Absensi> listAbsensiMurid) {
	this.listAbsensiMurid = listAbsensiMurid;
    }

    public ArrayList<HashMap> getAbsensi() {
	return absensi;
    }

    public void setAbsensi(ArrayList<HashMap> absensi) {
	this.absensi = absensi;
    }

    public Kelas(String nama, String kode, String jadwal) {
	this.nama = nama;
	this.kode = kode;
	this.jadwal = jadwal;
    }

    public double getNa() {
	return na;
    }

    public void setNa(double na) {
	this.na = na;
    }

    public ArrayList<Murid> getArrMurid() {
	return arrMurid;
    }

    public void setArrMurid(ArrayList<Murid> arrMurid) {
	this.arrMurid = arrMurid;
    }

    public Guru getHomeRoomTeacher() {
	return homeRoomTeacher;
    }

    public void setHomeRoomTeacher(Guru homeRoomTeacher) {
	this.homeRoomTeacher = homeRoomTeacher;
    }

    public ArrayList<Posting> getArrPost() {
	return arrPost;
    }

    public void setArrPost(ArrayList<Posting> arrPost) {
	this.arrPost = arrPost;
    }

    public void addMurid(Murid student) {
	this.arrMurid.add(student);
    }

    public String getNama() {
	return nama;
    }

    public void setNama(String nama) {
	this.nama = nama;
    }

    public String getKode() {
	return kode;
    }

    public void setKode(String kode) {
	this.kode = kode;
    }

    public String getJadwal() {
	return jadwal;
    }

    public void setJadwal(String jadwal) {
	this.jadwal = jadwal;
    }

}
