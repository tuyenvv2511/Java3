package com.example.demo.SD20202_SOF203.buoi11.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    private Integer id;
    private String ten;
    private Float luong;
    private Boolean quanLy;
}
