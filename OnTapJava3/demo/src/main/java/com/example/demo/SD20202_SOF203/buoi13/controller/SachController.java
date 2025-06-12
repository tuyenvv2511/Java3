package com.example.demo.SD20202_SOF203.buoi13.controller;

import com.example.demo.SD20202_SOF203.buoi11.model.NhanVien;
import com.example.demo.SD20202_SOF203.buoi13.model.Sach;
import com.example.demo.SD20202_SOF203.buoi13.repository.SachRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SachController", value = {
        "/buoi13/hien-thi",   // GET
        "/buoi13/them",       // POST
        "/buoi13/sua",        // GET + POST
        "/buoi13/chi-tiet",   // GET
        "/buoi13/xoa"         // GET
})
public class SachController extends HttpServlet {
    SachRepository repo = new SachRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.getRequestDispatcher("/views/buoi13/hien-thi.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Sach sach = repo.getAll().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst().orElse(null);
        req.setAttribute("sach", sach);
        req.getRequestDispatcher("/views/buoi13/chi-tiet.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Sach sach = repo.getAll().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst().orElse(null);
        req.setAttribute("sach", sach);
        req.getRequestDispatcher("/views/buoi13/sua.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        repo.deleteByID(id);
        resp.sendRedirect("/buoi13/hien-thi");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("them")) {
            them(req, resp);
        } else if (uri.contains("sua")) {
            sua(req, resp);
        }
    }


}
