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
    
    String guru;
    String namaMapel;
    String jadwal;
    LinkedList<Posting> classPosting = new LinkedList<Posting>();
    ArrayList<Murid> students = new ArrayList<Murid>();
    HashMap<String, Integer> nilaiAkhirMurid = new HashMap<String, Integer>();
    HashMap<String, Boolean> absensiMurid = new HashMap<String, Boolean>();
            
}
