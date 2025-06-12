package com.example.demo.SD20202_SOF203.buoi9.controller;

import com.example.demo.SD20202_SOF203.buoi9.model.CapSach;
import com.example.demo.SD20202_SOF203.buoi9.repository.CapSachRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CapSachController", value = {
        "/buoi9/hien-thi",  // GET
        "/buoi9/them",      // POST
        "/buoi9/sua",       // GET + POST
        "/buoi9/chi-tiet",  // GET
        "/buoi9/xoa"        // GET
})
public class CapSachController extends HttpServlet {
    CapSachRepository capSachRepository = new CapSachRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("sua")) {
            viewUpdate(req, resp);
        } else if (uri.contains("chi-tiet")) {
            detail(req, resp);
        } else if (uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", capSachRepository.getAll());
        req.getRequestDispatcher("/views/buoi9/hien-thi.jsp").forward(req, resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        capSachRepository.delete(id);
        resp.sendRedirect("/buoi9/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CapSach cs = capSachRepository.getById(id);
        req.setAttribute("capSach", cs);
        req.getRequestDispatcher("/views/buoi9/chi-tiet.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CapSach cs = capSachRepository.getById(id);
        req.setAttribute("capSach", cs);
        req.getRequestDispatcher("/views/buoi9/sua.jsp").forward(req, resp);
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

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Boolean chongNuoc = Boolean.valueOf(req.getParameter("chongNuoc"));

        CapSach cs = new CapSach(id, ten, gia, chongNuoc);
        capSachRepository.insert(cs);

        resp.sendRedirect("/buoi9/hien-thi");
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Float gia = Float.parseFloat(req.getParameter("gia"));
        Boolean chongNuoc = req.getParameter("chongNuoc") != null;

        CapSach cs = new CapSach(id, ten, gia, chongNuoc);
        capSachRepository.update(cs);

        resp.sendRedirect("/buoi9/hien-thi");
    }
}
