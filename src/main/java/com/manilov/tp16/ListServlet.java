package com.manilov.tp16;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ListReader lr = new ListReader();
        out.println("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <title>List</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
                "    <script src=\"script.js\"></script>\n" +
                "    <style></style>\n" +
                "</head>\n" +
                "<body>");
        out.println(lr.toString());
        out.println("<form>\n");
        out.println("<input type=\"text\" name=\"number\">\n");
        out.println("<input type=\"text\" name=\"value\">\n");
        out.println("<input type=\"submit\" value=\"Add\">\n");
        out.println("</form>\n");
        out.println("<body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
