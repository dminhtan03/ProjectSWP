/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class Calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calculator at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            double a = Integer.parseInt(request.getParameter("a"));
            double b = Integer.parseInt(request.getParameter("b"));
            String operator = request.getParameter("operator");
            double result = 0;
            switch (operator) {
                case "a+b":
                    result = a + b;
                    break;

                case "a-b":
                    result = a - b;
                    break;

                case "a*b":
                    result = a * b;
                    break;

                case "a/b":
                    if (b == 0) {
                        out.println("<h1>Can't devide by zero!</h1>");
                        break;
                    } else {
                        result = a / b;
                        break;
                    }

                case "UCLN":
                    result = timUocChungLonNhat(a, b);
                    break;

                case "BCNN":
                    result = boiChungNhoNhat(a, b);
                    break;
                default:
                    throw new AssertionError();
            }
            out.println("<h1>Result: " + result + "</h1>");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }         
    }

    public static double timUocChungLonNhat(double a, double b) {
        while (b != 0) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static double boiChungNhoNhat(double a, double b) {
        return Math.abs(a * b) / timUocChungLonNhat(a, b);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
