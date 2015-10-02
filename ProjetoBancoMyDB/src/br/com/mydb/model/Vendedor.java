package br.com.mydb.model;

public class Vendedor {

	private Integer idVendedor;
	private String nome;
	private Double comissao;
	
	public Vendedor() {
		
	}
	
	public Vendedor(Integer idVendedor, String nome, Double comissao) {
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.comissao = comissao;
		Vendedor vendedor = new Vendedor();
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getComissao() {
		return comissao;
	}
	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		return "Vendedor [idVendedor=" + idVendedor + ", nome=" + nome
				+ ", comissao=" + comissao + "]";
	}
}
