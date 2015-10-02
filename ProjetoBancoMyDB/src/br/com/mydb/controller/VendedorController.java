package br.com.mydb.controller;

import java.util.List;

import br.com.mydb.dao.VendedorDAOImpl;
import br.com.mydb.model.Vendedor;

public class VendedorController {

	private VendedorDAOImpl vendedorDAOImpl = new VendedorDAOImpl();
	
	private static VendedorController vendedorController;
	
	private VendedorController(){
	}
	
	public static VendedorController getInstance(){
		if(vendedorController == null){
			vendedorController = new VendedorController();
		}
		return vendedorController; 
	}

	public void inserirVendedor(Vendedor vendedor){
		vendedorDAOImpl.inserirVendedor(vendedor);
		vendedorDAOImpl.consultarTodosVendedores();
	}
	
	public List<Vendedor> consultarTodosVendedores(){
		return vendedorDAOImpl.consultarTodosVendedores();
	}
	
	public void deletarVendedor(Vendedor vendedor){
		vendedorDAOImpl.deletarVendedor(vendedor);
		vendedorDAOImpl.consultarTodosVendedores();
	}
	
	public void atualizarVendedor(Vendedor vendedor){
		vendedorDAOImpl.atualizarVendedor(vendedor);
		vendedorDAOImpl.consultarTodosVendedores();
	}
}
