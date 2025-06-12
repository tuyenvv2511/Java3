package com.example.demo.SD20202_SOF203.buoi13.repository;

import com.example.demo.SD20202_SOF203.buoi13.model.Sach;
import com.example.demo.SD20202_SOF203.buoi9.util.DbConnection;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class SachRepository implements CrudRepository<Sach, Integer> {
    private Connection conn = null;

    public SachRepository() {
        conn = DbConnection.getConnection();
    }

    @Override
    public Boolean create(Sach entity) {
        String sql = "INSERT INTO Sach (id, ma, ten, so_trang, don_gia, id_nxb, trang_thai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getMa());
            ps.setString(3, entity.getTen());
            ps.setInt(4, entity.getSoTrang());
            ps.setFloat(5,entity.getDonGia());
            ps.setInt(6,entity.getIdNXB());
            ps.setBoolean(7,entity.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(Sach entity) {
        String sql = "UPDATE Sach SET ma=?, ten=?, so_trang=?, don_gia=?, id_nxb=?, trang_thai=? WHERE id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getMa());
            ps.setString(2, entity.getTen());
            ps.setInt(3, entity.getSoTrang());
            ps.setFloat(4,entity.getDonGia());
            ps.setInt(5,entity.getIdNXB());
            ps.setBoolean(6,entity.getTrangThai());
            ps.setInt(7, entity.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteByID(Integer integer) {
        String sql = "DELETE FROM NhanVien WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, integer);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Sach getByID(Integer integer) {
        String sql = "SELECT * FROM Sach WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, integer);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sach(
                        rs.getInt("id"),
                        rs.getString("ma"),
                        rs.getString("ten"),
                        rs.getInt("so_trang"),
                        rs.getFloat("don_gia"),
                        rs.getInt("id_nxb"),
                        rs.getBoolean("trang_thai")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<Sach> getAll() {
        String sql = "SELECT * FROM Sach";
        ArrayList<Sach> danhSach = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                danhSach.add(new Sach(
                        rs.getInt("id"),
                        rs.getString("ma"),
                        rs.getString("ten"),
                        rs.getInt("so_trang"),
                        rs.getFloat("don_gia"),
                        rs.getInt("id_nxb"),
                        rs.getBoolean("trang_thai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
