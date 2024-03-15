/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.FabricaConexao;

/**
 *
 * @author PTOLEDO
 */
public class ProdutoDAO {
    
    public void cadastrar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con =  FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produtos (descricao, preco) values (?,?)");
        comando.setString(1, prod.getDescricao());
        comando.setDouble(2, prod.getPreco());
        comando.execute();
        con.close();
    }
    
    public void deletar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id = ?");
        comando.setInt(1, prod.getId());
        comando.execute();
        con.close();
    }
    
    public Produto consultarById(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id=?");
        comando.setInt(1, prod.getId());
        ResultSet rs = comando.executeQuery();

        Produto p = new Produto();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));
        }

        con.close();
        return p;
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {

        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos");
        ResultSet rs = comando.executeQuery();
        List<Produto> lprod = new ArrayList();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            lprod.add(prod);
        }
        return lprod;
    }
}
