package com.example.demo.SD20202_SOF203.buoi11.controller;

import com.example.demo.SD20202_SOF203.buoi11.model.NhanVien;
import com.example.demo.SD20202_SOF203.buoi11.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "NhanVienController", value = {
        "/buoi11/hien-thi",   // GET
        "/buoi11/them",       // POST
        "/buoi11/sua",        // GET + POST
        "/buoi11/chi-tiet",   // GET
        "/buoi11/xoa"         // GET
})
public class NhanVienController extends HttpServlet {
    NhanVienRepository repo = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("sua")) {
            viewUpdate(req, resp);
        } else if (uri.contains("chi-tiet")) {
            chiTiet(req, resp);
        } else if (uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhSach", repo.getAll());
        req.getRequestDispatcher("/views/buoi11/hien-thi.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        NhanVien nv = repo.getAll().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst().orElse(null);
        req.setAttribute("nv", nv);
        req.getRequestDispatcher("/views/buoi11/chi-tiet.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        NhanVien nv = repo.getAll().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst().orElse(null);
        req.setAttribute("nv", nv);
        req.getRequestDispatcher("/views/buoi11/sua.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        repo.delete(id);
        resp.sendRedirect("/buoi11/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("them")) {
            them(req, resp);
        } else if (uri.contains("sua")) {
            sua(req, resp);
        }
    }

    private void them(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Boolean quanLy = req.getParameter("quanLy") != null;

        NhanVien nv = new NhanVien(id, ten, luong, quanLy);
        repo.create(nv);

        resp.sendRedirect("/buoi11/hien-thi");
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Boolean quanLy = req.getParameter("quanLy") != null;

        NhanVien nv = new NhanVien(id, ten, luong, quanLy);
        repo.update(nv);

        resp.sendRedirect("/buoi11/hien-thi");
    }
}
