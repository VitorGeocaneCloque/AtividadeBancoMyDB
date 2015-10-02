package br.com.mydb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.conexao.ConexaoMySQL;
import br.com.mydb.model.Vendedor;

public class VendedorDAOImpl implements VendedorDAO{

	public void inserirVendedor(Vendedor vendedor) {
		
		StringBuilder sqlInsertVendedor = new StringBuilder();
		sqlInsertVendedor.append("INSERT INTO Vendedor (Nome, Comissao) VALUES(");
		sqlInsertVendedor.append("'").append(vendedor.getNome()).append("'");
		sqlInsertVendedor.append(",");
		sqlInsertVendedor.append(vendedor.getComissao());
		sqlInsertVendedor.append(")");
		
		try{
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			PreparedStatement ps = connection.prepareStatement(sqlInsertVendedor.toString());
			ps.execute();
			
		}catch(SQLException sqlException){
			System.out.println(sqlException.getMessage());
		}
	}

	public List<Vendedor> consultarTodosVendedores() {
		List<Vendedor> listVendedor = new ArrayList<Vendedor>();
		
		StringBuilder sqlSelectVendedor = new StringBuilder();
		sqlSelectVendedor.append("SELECT * FROM VENDEDOR");
		
		try{
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlSelectVendedor.toString());
			
			while(resultSet.next()){
				Vendedor vendedor = new Vendedor(resultSet.getInt("idVendedor"), resultSet.getString("Nome"), resultSet.getDouble("Comissao"));
				listVendedor.add(vendedor);
				System.out.println(vendedor);
			}
			
		}catch(Exception sqlException){
			System.out.println(sqlException.getMessage());
		}
		
		return listVendedor;
	}

	public void deletarVendedor(Vendedor vendedor) {
		StringBuilder sqlDeleteVendedor = new StringBuilder();
		
		if(vendedor.getIdVendedor() == null){
			throw new RuntimeException("IdVendedor nulo");
		}
		sqlDeleteVendedor.append("DELETE FROM Vendedor WHERE IdVendedor = ");
		sqlDeleteVendedor.append(vendedor.getIdVendedor());
		try{
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			PreparedStatement ps = connection.prepareStatement(sqlDeleteVendedor.toString());
			ps.execute();
			
		}catch(SQLException sqlException){
			System.out.println(sqlException.getMessage());
		}
	}

	public void atualizarVendedor(Vendedor vendedor) {
		StringBuilder sqlAtualizarVendedor = new StringBuilder();
		if(vendedor.getIdVendedor() == null){
			throw new RuntimeException("IdVendedor nulo");
		}
		sqlAtualizarVendedor.append("UPDATE Vendedor ");
		sqlAtualizarVendedor.append("set nome = ");
		sqlAtualizarVendedor.append("'").append(vendedor.getNome()).append("'");
		sqlAtualizarVendedor.append(",");
		sqlAtualizarVendedor.append("comissao=");
		sqlAtualizarVendedor.append(vendedor.getComissao());
		sqlAtualizarVendedor.append("WHERE IdVendedor ="); 
		sqlAtualizarVendedor.append(vendedor.getIdVendedor());
		try{
			
			Connection connection = ConexaoMySQL.getConexaoMySQL();
			PreparedStatement ps = connection.prepareStatement(sqlAtualizarVendedor.toString());
			ps.execute();
			
		}catch(SQLException sqlException){
			System.out.println(sqlException.getMessage());
		}
	}
}
