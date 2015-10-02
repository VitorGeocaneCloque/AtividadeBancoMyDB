package br.com.mydb.dao;

import java.util.List;

import br.com.mydb.model.Vendedor;


public interface VendedorDAO {

	public void inserirVendedor(Vendedor vendedor);
	
	public List<Vendedor> consultarTodosVendedores();
	
	public void deletarVendedor(Vendedor vendedor);
	
	public void atualizarVendedor(Vendedor vendedor);
}
