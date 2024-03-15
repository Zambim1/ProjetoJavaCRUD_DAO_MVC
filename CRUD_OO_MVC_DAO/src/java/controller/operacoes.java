/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author PTOLEDO
 */
@WebServlet(name = "operacoes", urlPatterns = {"/operacoes"})
public class operacoes extends HttpServlet {

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

            String op = request.getParameter("op");

            
            if (op.equals("CADASTRAR")) {
                String descricao = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                Produto prod = new Produto();
                ProdutoDAO pdao = new ProdutoDAO();
                prod.setDescricao(descricao);
                prod.setPreco(preco);
                try {
                    pdao.cadastrar(prod);
                    request.setAttribute("msg", "Cadastrado com sucesso");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }

            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Produto prod = new Produto();
                ProdutoDAO pdao = new ProdutoDAO();
                prod.setId(id);
                try {
                    pdao.deletar(prod);
                    request.setAttribute("msg", "Deletado com sucesso");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (op.equals("ATUALIZAR")) {
                out.println("<h1>Atualizar não implementado.</h1>");
            } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Produto prod = new Produto();
                ProdutoDAO pdao = new ProdutoDAO();
                prod.setId(id);
                try {
                    prod = pdao.consultarById(prod);                
                    
                    request.setAttribute("prod", prod);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                
            } else if (op.equals("CONSULTAR TODOS")) {
                out.println("<h1>Consultar Todos não implementado.</h1>");
            }

            
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
        processRequest(request, response);
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
