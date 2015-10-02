package br.com.mydb.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mydb.dao.VendedorDAOImpl;
import br.com.mydb.model.Vendedor;

@ManagedBean
@ViewScoped
public class VendedorMB {

	private List<Vendedor> listaVendedores;
	private Vendedor vendedores;
	private VendedorDAOImpl vendedor;

	// Inicialização da Página
	@PostConstruct
	public void init() {
		listaVendedores = new ArrayList<Vendedor>();
		vendedores = new Vendedor();
		listaVendedores = vendedor.consultarTodosVendedores();
	}

	// Ciração de objeto
	private void criarVendedor() {
		vendedores = new Vendedor();
	}

	// Salva ou Atualiza Vendedores
	public String salvar() {
		vendedor.inserirVendedor(vendedores);
		listaVendedores.add(vendedores);
		criarVendedor();
		return "";
	}

	public String editar() {
		if (vendedores.getIdVendedor() != null) {
			vendedor.atualizarVendedor(vendedores);
		} else {
			return "";
		}
		return "";
	}
	
	public void deletar(){
		vendedor.deletarVendedor(vendedores);
	}
	
	//getters and setters 
	public List<Vendedor> getListaVendedores() {
		return listaVendedores;
	}

	public void setListaVendedores(List<Vendedor> listaVendedores) {
		this.listaVendedores = listaVendedores;
	}

	public Vendedor getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedor vendedores) {
		this.vendedores = vendedores;
	}

	public VendedorDAOImpl getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDAOImpl vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listaVendedores == null) ? 0 : listaVendedores.hashCode());
		result = prime * result
				+ ((vendedor == null) ? 0 : vendedor.hashCode());
		result = prime * result
				+ ((vendedores == null) ? 0 : vendedores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendedorMB other = (VendedorMB) obj;
		if (listaVendedores == null) {
			if (other.listaVendedores != null)
				return false;
		} else if (!listaVendedores.equals(other.listaVendedores))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		if (vendedores == null) {
			if (other.vendedores != null)
				return false;
		} else if (!vendedores.equals(other.vendedores))
			return false;
		return true;
	}

}
