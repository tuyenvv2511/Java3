package com.example.demo.SD20202_SOF203.buoi2.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TinhChuVi", value = {
        "/buoi2/tinh-chu-vi",//POST
        "/buoi2/ket-qua",//GET
})
public class ChuViVaDienTich extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/buoi2/tinh-chu-vi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String daiStr = req.getParameter("chieuDai");
        String rongStr = req.getParameter("chieuRong");

        double dai = 0, rong = 0;

        dai = Double.parseDouble(daiStr);
        rong = Double.parseDouble(rongStr);

        Double chuVi = null;
        Double dienTich = null;
        chuVi = 2 * (dai + rong);
        dienTich = dai * rong;

        req.setAttribute("chieuDai", daiStr);
        req.setAttribute("chieuRong", rongStr);
        req.setAttribute("chuVi", chuVi);
        req.setAttribute("dienTich", dienTich);

        req.getRequestDispatcher("/views/buoi2/ket-qua1.jsp").forward(req, resp);
    }
}
