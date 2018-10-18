/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.perfumaria.pi3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.senac.sp.perfumaria.pi3.model.InserirProduto;
import br.senac.sp.perfumaria.pi3.model.Categoria;
import br.senac.sp.perfumaria.pi3.model.ConsultaProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbezerra
 */
public class ProdutoDAO {
    
    private static Connection obterConexao() throws ClassNotFoundException, SQLException{
        //
        Connection conn = null;
        // Passo 1: Registar Driver JBDC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexão
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/perfumaria",
                "root",
                "");
        
        return conn;
    }
    
     //Insere um produto na tabela "produto" do banco de dados
    public static void inserir(InserirProduto produto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "INSERT INTO PRODUTO (NOME, MARCA, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO) "
                + "VALUES (?, ?, ?, ?, ?, ?, NOW())";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setString (1, produto.getNome());
            preparedStatement.setString (2, produto.getMarca());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setDouble(4, produto.getPrecoCompra());
            preparedStatement.setDouble(5, produto.getPrecoVenda());
            preparedStatement.setInt(6, produto.getQuantidade());
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        connection = null;
        preparedStatement = null;
        ResultSet result = null;
        try{
            String sqlid = "select max(id) as id from PRODUTO";
             //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sqlid);
            
            result = preparedStatement.executeQuery();
            
            if(result.next()){
                long id = result.getLong("id");
                inserirCategoriaProduto(produto.getCategorias(), id);
            }
            
        } finally {
              //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    
    private static void inserirCategoriaProduto(String[] categorias, long id)
            throws SQLException, Exception {
        String sql = "INSERT INTO PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA) "
                + "VALUES (?, ?)";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
      for( String numero : categorias )
        {
              try {
                    //Abre uma conexão com o banco de dados
                    connection = obterConexao();
                    //Cria um statement para execução de instruções SQL
                    preparedStatement = connection.prepareStatement(sql);
                    //Configura os parâmetros do "PreparedStatement"
                    //preparedStatement.setDate(1, produto.getDatahora());
                    preparedStatement.setLong(1, id);
                    preparedStatement.setInt (2, Integer.parseInt(numero));
                    

                    //Executa o comando no banco de dados
                    preparedStatement.execute();
                } finally {
                    //Se o statement ainda estiver aberto, realiza seu fechamento
                    if (preparedStatement != null && !preparedStatement.isClosed()) {
                        preparedStatement.close();
                    }
                    //Se a conexão ainda estiver aberta, realiza seu fechamento
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                }
        }
    }
        
    
    //Obtém uma instância da classe "InserirProduto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static ConsultaProduto consulta(int id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("habilitado" com "true")
        String sql = "SELECT * FROM produto WHERE (id=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setLong(1, id);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Consulta e popula com os valores do BD
                                
                ConsultaProduto consulta = new ConsultaProduto();
                consulta.setId(result.getInt("ID"));
                
                //Retorna o resultado
                return consulta;
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
    
    
    //Obtém uma instância da classe "InserirProduto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static List<Categoria> obterCategoria()
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("habilitado" com "true")
        String sql = "SELECT * FROM CATEGORIA";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            List<Categoria> categorias = new ArrayList<Categoria>();
            
            //Verifica se há pelo menos um resultado
            while (result.next()) {
                //Cria uma instância de InserirProduto e popula com os valores do BD
                
                Categoria categoria = new Categoria();
                categoria.setId(result.getInt("ID"));
                categoria.setNome(result.getString("NOME"));
                categorias.add(categoria);
                //Retorna o resultado
            }
            
            return categorias;
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
       
    }
}
