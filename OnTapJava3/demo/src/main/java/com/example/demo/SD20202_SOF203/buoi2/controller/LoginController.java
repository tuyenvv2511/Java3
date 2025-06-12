 package com.example.demo.SD20202_SOF203.buoi2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.StringReader;

@WebServlet(name = "LoginController",value = {
        "/buoi2/login",//GET
        "/buoi2/thong-tin",//POST
        "/buoi2/data",//GET
})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("data")){
            showData(req,resp);
        } else if(uri.contains("login")){
            showLogin(req,resp);
        }
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/buoi2/login.jsp").forward(req,resp);
    }

    private void showData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ten", "Nguyen Van A");
        req.getRequestDispatcher("/views/buoi2/data.jsp").forward(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("thong-tin")){
            nhanThongTin(req,resp);
        }
    }

    private void nhanThongTin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay thong tin tu form
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        //Truyen thong tin xuong jsp
        req.setAttribute("user1",user);
        req.setAttribute("pass1",pass);
        req.getRequestDispatcher("/views/buoi2/ket-qua.jsp").forward(req,resp);
    }
}
