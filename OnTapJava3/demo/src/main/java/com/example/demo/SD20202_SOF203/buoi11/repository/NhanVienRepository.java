package com.example.demo.SD20202_SOF203.buoi11.repository;

import com.example.demo.SD20202_SOF203.buoi11.model.NhanVien;
import com.example.demo.SD20202_SOF203.buoi9.model.CapSach;
import com.example.demo.SD20202_SOF203.buoi9.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class NhanVienRepository {
    private Connection conn = null;

    public NhanVienRepository() {
        conn = DbConnection.getConnection();
    }

    public ArrayList<NhanVien> getAll() {
        String sql = "SELECT * FROM NhanVien";
        ArrayList<NhanVien> danhSach = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                danhSach.add(new NhanVien(
                        rs.getInt("id"),
                        rs.getString("ho_ten"),
                        rs.getFloat("luong"),
                        rs.getBoolean("la_quan_ly")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public void create(NhanVien nhanVien){
        String sql = "INSERT INTO NhanVien (id, ho_ten, luong, la_quan_ly) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nhanVien.getId());
            ps.setString(2, nhanVien.getTen());
            ps.setFloat(3, nhanVien.getLuong());
            ps.setBoolean(4, nhanVien.getQuanLy());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(NhanVien nhanVien){
        String sql = "UPDATE NhanVien SET ho_ten=?, luong=?, la_quan_ly=? WHERE id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nhanVien.getTen());
            ps.setFloat(2, nhanVien.getLuong());
            ps.setBoolean(3, nhanVien.getQuanLy());
            ps.setInt(4, nhanVien.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM NhanVien WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public CapSach getById(int id) {
        String sql = "SELECT * FROM  WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CapSach(
                        rs.getInt("id"),
                        rs.getString("ho_ten"),
                        rs.getFloat("gia"),
                        rs.getBoolean("la_quan_ly")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
