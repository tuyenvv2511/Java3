package com.example.demo.SD20202_SOF203.buoi5.service;

import com.example.demo.SD20202_SOF203.buoi5.model.DienThoai;

import java.util.ArrayList;
import java.util.List;

public class DienThoaiService {
    List<DienThoai> danhSach = new ArrayList<>();
    public DienThoaiService(){
        danhSach.add(new DienThoai(1,"Iphone 13 Pro Max",11,true));
        danhSach.add(new DienThoai(2,"Samsung Galaxy Z Flip",9,false));
        danhSach.add((new DienThoai(3,"Redmi note 14",10,true)));
    }

    public List<DienThoai> getAll() {return danhSach;}

    public void them(DienThoai dienThoai){
        danhSach.add(dienThoai);
    }

    public void sua(DienThoai dienThoai){
        for (int i =0; i < danhSach.size(); i++){
            if (danhSach.get(i).getId() == dienThoai.getId()){
                danhSach.set(i, dienThoai);
                return;
            }
        }
    }

    public void xoa(Integer id){
        danhSach.removeIf(dt -> dt.getId() == id);
    }

    public DienThoai chiTiet(Integer id) {
        for(DienThoai dt: danhSach) {
            if(dt.getId() == id) {
                return dt;
            }
        }
        return null;
    }
}
