/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author BRCS
 */
public class Kelas {
    
    private ArrayList<Murid> arrMurid = new ArrayList();
    private Guru homeRoomTeacher = new Guru();
    private ArrayList<Posting> arrPost = new ArrayList();
    private ArrayList<Absensi> arrAbsensiMurid = new ArrayList();

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

    public ArrayList<Absensi> getArrAbsensiMurid() {
        return arrAbsensiMurid;
    }

    public void setArrAbsensiMurid(ArrayList<Absensi> arrAbsensiMurid) {
        this.arrAbsensiMurid = arrAbsensiMurid;
    }
    
    public Kelas(){
        
    }
            
}