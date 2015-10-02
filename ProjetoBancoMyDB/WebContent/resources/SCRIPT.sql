create database mydb;
use mydb;

create table Vendedor(
	idVendedor INTEGER not null primary key auto_increment,
	Nome varchar(45),
	Comissao numeric(16,2)
);

create table Produto(
	idProduto Integer primary key not null auto_increment,
	Valor decimal(16,2),
	Quantidade Integer,
	Descricao varchar(45)
);

create table Equipe(
	idEquipe integer primary key not null auto_increment,
	Descricao varchar(45)
);

create table Meta(
	idMeta integer primary key not null auto_increment,
	idEquipe integer,
	Valor_meta decimal(16,2),
	Data_referencia date,
	foreign key (idEquipe) references Equipe(idEquipe)
);

create table Equipe_Vendedor(
	idEquipeVendedor integer primary key not null auto_increment,
	idVendedor integer,
	idEquipe integer,
	idVendedorPai integer,
	foreign key (idVendedor) references Vendedor(idVendedor),
	foreign key (idEquipe) references Equipe (idEquipe),
	foreign key (idVendedorPai) references Vendedor(idVendedor)
);

create table Venda(
	idVenda integer primary key not null auto_increment,
	data date,
	Vendacol varchar(45),
	idEquipeVendedor integer,
	foreign key (idEquipeVendedor) references Equipe_Vendedor(idEquipeVendedor)
);

create table Venda_Produto(
	idVenda integer,
	idProduto integer,
	quantidade integer,
	valor_pago decimal(16,2),
foreign key (idProduto) references Produto(idProduto),	
foreign key (idVenda) references Venda(idVenda)
);
