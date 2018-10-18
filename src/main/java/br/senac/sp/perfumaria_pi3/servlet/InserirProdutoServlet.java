/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.perfumaria_pi3.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.perfumaria.pi3.model.InserirProduto;
import br.senac.sp.perfumaria.pi3.model.Categoria;
import br.senac.sp.perfumaria.pi3.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbezerra
 */
@WebServlet(name = "InclusaoProdutoServlet", urlPatterns = {"/produto/inclusao"})
public class InserirProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Carregar aqui os departamentos
        List<Categoria> categorias = new ArrayList<Categoria>();

        try {
           categorias = ProdutoDAO.obterCategoria();
        } catch (Exception e) {
             e.printStackTrace();
        }
          
        request.setAttribute("categoria", categorias);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/Produto/form.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String[] categorias = request.getParameterValues("cat");        
        String qtdStr = request.getParameter("qtd");
        String precoCompraStr = request.getParameter("prcompra");
        String precoVendaStr = request.getParameter("prvenda");
        String descricao = request.getParameter("descricao"); 
      
        Double precoCompra = new Double(precoCompraStr);
        Double precoVenda = new Double(precoVendaStr);
        int qtd = Integer.parseInt(qtdStr);        

        InserirProduto p = new InserirProduto(nome, marca,categorias, qtd, precoCompra, precoVenda,descricao);
        
        try {
           ProdutoDAO.inserir(p);
        } catch (Exception e) {

        }
        
        request.setAttribute("prod", p);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/Produto/resultado.jsp");
        dispatcher.forward(request, response);
        
    }
}
