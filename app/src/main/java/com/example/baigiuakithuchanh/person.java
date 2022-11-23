package com.example.baigiuakithuchanh;

public class person {
    private String name;
    private String capbac, vitri;
    private int hinh ,vn,danhgia;

    public person(String name, String capbac, String vitri, int hinh, int vn, int danhgia) {
        this.name = name;
        this.capbac = capbac;
        this.vitri = vitri;
        this.hinh = hinh;
        this.vn = vn;
        this.danhgia = danhgia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapbac() {
        return capbac;
    }

    public void setCapbac(String capbac) {
        this.capbac = capbac;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public int getVn() {
        return vn;
    }

    public void setVn(int vn) {
        this.vn = vn;
    }

    public int getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(int danhgia) {
        this.danhgia = danhgia;
    }
}
