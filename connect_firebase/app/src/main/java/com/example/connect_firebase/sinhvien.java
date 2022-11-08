package com.example.connect_firebase;

import java.util.HashMap;
import java.util.Map;

public class sinhvien {
    private int masv, tuoi;
    private String tensv, lop;

    public sinhvien(){

    }

    public sinhvien(int masv, int tuoi, String tensv, String lop) {
        this.masv = masv;
        this.tuoi = tuoi;
        this.tensv = tensv;
        this.lop = lop;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("masv", masv);
        result.put("tensv", tensv);
        result.put("tuoi", tuoi);
        result.put("lop", lop);

        return result;
    }
}
