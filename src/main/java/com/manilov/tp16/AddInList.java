package com.manilov.tp16;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddInList", value = "/AddInList")
public class AddInList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        String value = request.getParameter("value");
        ListReader lr = new ListReader();
        lr.add(Integer.parseInt(number), value);
        lr.loadToTextFile(lr.getFilename());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
