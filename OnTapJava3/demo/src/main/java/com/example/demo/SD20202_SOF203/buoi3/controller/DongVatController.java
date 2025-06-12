package com.example.demo.SD20202_SOF203.buoi3.controller;

import com.example.demo.HelloServlet;
import com.example.demo.SD20202_SOF203.buoi3.model.DongVat;
import com.example.demo.SD20202_SOF203.buoi3.service.DongVatService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DongVatController", value = {
        "/buoi3/hien-thi", // GET
        "/buoi3/them", //POST
        "/buoi3/sua", //GET
        "/buoi3/chi-tiet",
        "/buoi3/xoa"
})
public class DongVatController extends HttpServlet {
    DongVatService dongVatService = new DongVatService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(request, response);
        } else if (uri.contains("sua")) {
            viewUpdate(request, response);
        } else if (uri.contains("chi-tiet")){
            detail(request,response);
        } else if (uri.contains("xoa")){
            xoa(request,response);
        }
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        dongVatService.xoa(id);
        response.sendRedirect("/buoi3/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        DongVat dv = dongVatService.detail(id);
        request.setAttribute("dongVat",dv);
        request.getRequestDispatcher("/views/buoi3/chi-tiet.jsp");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer. valueOf(req.getParameter("id"));
        DongVat dv = dongVatService.detail(id);
        req.setAttribute("dongVat",dv);
        req.getRequestDispatcher("/views/buoi3/sua.jsp").forward(req, resp);
    }
    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", dongVatService.getAll());
        req.getRequestDispatcher("/views/buoi3/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri =req.getRequestURI();
        if (uri.contains("them")){
            them(req, resp);
        } else if(uri.contains("sua")) {
            sua(req, resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Float giaTien = Float.valueOf(req.getParameter("giaTien"));

        DongVat dv = new DongVat(id, ten, gioiTinh, giaTien);
        dongVatService.sua(dv);

        resp.sendRedirect("/buoi3/hien-thi");
    }


    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));
        Float giaTien = Float.valueOf(req.getParameter("giaTien"));

        DongVat dv = new DongVat(id, ten, gioiTinh, giaTien);
        dongVatService.them(dv);

        resp.sendRedirect("/buoi3/hien-thi");
    }

}
