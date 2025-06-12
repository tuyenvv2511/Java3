package com.example.demo.SD20202_SOF203.buoi13.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sach {
    private Integer id;
    private String ma;
    private String ten;
    private Integer soTrang;
    private Float donGia;
    private Integer idNXB;
    private Boolean trangThai;
}
