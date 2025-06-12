package com.example.demo.SD20202_SOF203.buoi5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DienThoai {
    private Integer id;
    private String ten;
    private Integer chieuCao;
    private Boolean chongNuoc; // - True - Co chong nuoc, False - Khong chong nuoc
}
