package com.example.demo.SD20202_SOF203.buoi9.repository;

import com.example.demo.SD20202_SOF203.buoi9.model.CapSach;
import com.example.demo.SD20202_SOF203.buoi9.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class CapSachRepository {
    private Connection conn = null;

    public CapSachRepository() {
        conn = DbConnection.getConnection();
    }

    public ArrayList<CapSach> getAll() {
        String sql = "SELECT * FROM CapSach";
        ArrayList<CapSach> danhSach = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                danhSach.add(new CapSach(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getFloat("gia"),
                        rs.getBoolean("chong_nuoc")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public void insert(CapSach capSach) {
        String sql = "INSERT INTO CapSach (id, ten, gia, chong_nuoc) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, capSach.getId());
            ps.setString(2, capSach.getTen());
            ps.setFloat(3, capSach.getGia());
            ps.setBoolean(4, capSach.getChongNuoc());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(CapSach capSach) {
        String sql = "UPDATE CapSach SET ten=?, gia=?, chong_nuoc=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, capSach.getTen());
            ps.setFloat(2, capSach.getGia());
            ps.setBoolean(3, capSach.getChongNuoc());
            ps.setInt(4, capSach.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM CapSach WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CapSach getById(int id) {
        String sql = "SELECT * FROM CapSach WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CapSach(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getFloat("gia"),
                        rs.getBoolean("chong_nuoc")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
