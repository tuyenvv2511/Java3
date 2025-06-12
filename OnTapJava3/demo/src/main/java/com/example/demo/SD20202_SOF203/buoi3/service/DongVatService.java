package com.example.demo.SD20202_SOF203.buoi3.service;

import com.example.demo.SD20202_SOF203.buoi3.model.DongVat;

import java.util.ArrayList;
import java.util.List;

public class DongVatService {
    List<DongVat> danhSach = new ArrayList<>();
    public DongVatService(){
        danhSach.add(new DongVat(1,"Cho",true,123f));
        danhSach.add(new DongVat(2,"Meo",false,234f));
        danhSach.add(new DongVat(3,"Vit",true,345f));
    }

    public List<DongVat> getAll(){
        return danhSach;
    }

    public void them(DongVat dongVat){
        danhSach.add(dongVat);
    }

    public void sua(DongVat dongVat){
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getId() == dongVat.getId()) {
                danhSach.set(i, dongVat);
                return;
            }
        }
    }

    public void xoa(Integer id){
        danhSach.removeIf(dv -> dv.getId() == id);
    }

    public DongVat detail(Integer id) {
        for (DongVat dv : danhSach) {
            if (dv.getId() == id) return dv;
        }
        return null;
    }
}
