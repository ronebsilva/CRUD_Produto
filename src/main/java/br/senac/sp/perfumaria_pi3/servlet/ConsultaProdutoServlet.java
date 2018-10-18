/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.perfumaria_pi3.servlet;

import br.senac.sp.perfumaria.pi3.dao.ProdutoDAO;
import br.senac.sp.perfumaria.pi3.model.ConsultaProduto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "ConsultaProdutoServlet", urlPatterns = {"/produto/consulta"})
    public class ConsultaProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Carregar aqui os departamentos
          
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/Produto/pesquisaproduto.jsp");
        dispatcher.forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String idProd = request.getParameter("idProd");

        int id = Integer.parseInt(idProd); 

        ConsultaProduto c = new ConsultaProduto(id);
        
        try {
           ProdutoDAO.consulta(id);
        } catch (Exception e) {

        }
        
        request.setAttribute("result", c);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/Produto/resultadoConsulta.jsp");
        dispatcher.forward(request, response);
    }
}