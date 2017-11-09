/*CRIAÇÃO DO BANCO*/
CREATE DATABASE drywall;
USE drywall;

/*ENDERECO*/
CREATE TABLE Endereco(
	CodEndereco INT(11) AUTO_INCREMENT,
	Logradouro VARCHAR(50),
	Numero VARCHAR(10),
	Complemento VARCHAR(20),
	Cep VARCHAR(9),
	Bairro VARCHAR(30),
	Cidade VARCHAR(50),
	Uf VARCHAR(2),
	XDEAD BOOLEAN DEFAULT FALSE,
/*PK*/
	PRIMARY KEY(CodEndereco)
);
/*CLIENTE (--> Endereco)*/
CREATE TABLE Cliente(
	CodCliente INT(11) AUTO_INCREMENT,
	DataInscricao DATE,
	CodEndereco INT(11),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodEndereco) REFERENCES Endereco(CodEndereco),
/*PK*/
	PRIMARY KEY(CodCliente)
);
/*TELEFONE (--> Cliente)*/
CREATE TABLE Telefone(
	CodCliente INT(11),
	Numero VARCHAR(15),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente),
/*PK*/
	PRIMARY KEY(CodCliente, Numero)
);
/*PESSOAJURIDICA (--> Cliente)*/
CREATE TABLE PessoaJuridica(
	CodCliente INT(11),
	Cnpj VARCHAR(20),
	RazaoSocial VARCHAR(50),
	RamoAtuacao VARCHAR(30),
	DataFundacao DATE,
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente),
/*PK*/
	PRIMARY KEY(CodCliente)
);
/*PESSOAFISICA (--> Cliente)*/
CREATE TABLE PessoaFisica(
	CodCliente INT(11),
	Cpf VARCHAR(20),
	Nome VARCHAR(50),
	DataNascimento DATE,
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente),
/*PK*/
	PRIMARY KEY(CodCliente)
);

/*CONSTRUCAO*/
CREATE TABLE Construcao(
	CodConstrucao INT(11) AUTO_INCREMENT,
	Descricao VARCHAR(50),
	Detalhes VARCHAR(100),
	Qualidade INT(3),
	XDEAD BOOLEAN DEFAULT FALSE,
/*PK*/
	PRIMARY KEY(CodConstrucao)
);
/*PAREDE (--> Construcao)*/
CREATE TABLE Parede(
	CodConstrucao INT(11),
	Montante DECIMAL(10,5),
	AlturaLimite DECIMAL(10,5),
	EhSt BOOLEAN,
	EhRu BOOLEAN,
	EhRf BOOLEAN,
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodConstrucao) REFERENCES Construcao(CodConstrucao),
/*PK*/
	PRIMARY KEY(CodConstrucao)
);
/*FORRO (--> Construcao)*/
CREATE TABLE Forro(
	CodConstrucao INT(11),
	EhSt BOOLEAN,
	EhRu BOOLEAN,
	EhRf BOOLEAN,
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodConstrucao) REFERENCES Construcao(CodConstrucao),
/*PK*/
	PRIMARY KEY(CodConstrucao)
);
/*MATERIAL (--> Construcao)*/
CREATE TABLE Material(
	CodMaterial INT(11) AUTO_INCREMENT,
	Descricao VARCHAR(50),
	NomeUnidade VARCHAR(10),
	ConstanteMetro DECIMAL(10,5),
	PrecoUnitario DECIMAL(8,2),
	EhOpcional BOOLEAN,
	Qualidade INT(3),
	Tipo VARCHAR(20),
	QuantidadeMinima INT(6),
	CodConstrucao INT(11),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodConstrucao) REFERENCES Construcao(CodConstrucao),
/*PK*/
	PRIMARY KEY(CodMaterial)
);

/*ORCAMENTO (--> Cliente, Endereco)*/
CREATE TABLE Orcamento(
	CodOrcamento INT(11) AUTO_INCREMENT,
	DataHora DATE,
	CodCliente INT(11),
	CodEndereco INT(11),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodCliente) REFERENCES Cliente(CodCliente),
	FOREIGN KEY(CodEndereco) REFERENCES Endereco(CodEndereco),
/*PK*/
	PRIMARY KEY(CodOrcamento)
);
/*ITEM (--> Construcao, Orcamento)*/
CREATE TABLE Item(
	CodItem INT(11) AUTO_INCREMENT,
	Altura DECIMAL(10,5),
	Largura DECIMAL(10,5),
	AreaPorta DECIMAL(10,5),
	AreaJanela DECIMAL(10,5),
	PrecoTotal DECIMAL(8,2),
	CodConstrucao INT(11),
	CodOrcamento INT(11),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodConstrucao) REFERENCES Construcao(CodConstrucao),
	FOREIGN KEY(CodOrcamento) REFERENCES Orcamento(CodOrcamento),
/*PK*/
	PRIMARY KEY(CodItem)
);
/*MATERIALITEM (--> Material, Item)*/
CREATE TABLE MaterialItem(
	CodMaterial INT(11),
	CodItem INT(11),
	Quantidade INT(6),
	PrecoUnitario DECIMAL(8,2),
	XDEAD BOOLEAN DEFAULT FALSE,
/*FK*/
	FOREIGN KEY(CodMaterial) REFERENCES Material(CodMaterial),
	FOREIGN KEY(CodItem) REFERENCES Item(CodItem),
/*PK*/
	PRIMARY KEY(CodMaterial, CodItem)
);

/*FUNCIONARIO*/
CREATE TABLE Funcionario(
	CodFuncionario INT(11) AUTO_INCREMENT,
	Login VARCHAR(30),
	Senha VARCHAR(40),
	XDEAD BOOLEAN DEFAULT FALSE,
/*PK*/
	PRIMARY KEY(CodFuncionario)
);
/*REGISTROATIVIDADE (--> Funcionario)*/
CREATE TABLE RegistroAtividade(
	CodRegistro INT(11) AUTO_INCREMENT,
	CodFuncionario INT(11),
	DataHora DATE,
/*FK*/
	FOREIGN KEY(CodFuncionario) REFERENCES Funcionario(CodFuncionario),
/*PK*/
	PRIMARY KEY(CodRegistro)
);
/*REGISTROCONSTRUCAO (--> RegistroAtividade)*/
CREATE TABLE RegistroConstrucao(
	CodRegistro INT(11),
	Atividade VARCHAR(30),
	Tabela VARCHAR(20),
	Detalhe VARCHAR(100),
/*FK*/
	FOREIGN KEY(CodRegistro) REFERENCES RegistroAtividade(CodRegistro),
/*PK*/
	PRIMARY KEY(CodRegistro)
);
/*REGISTROORCAMENTO (--> RegistroAtividade)*/
CREATE TABLE RegistroOrcamento(
	CodRegistro INT(11),
	Atividade VARCHAR(30),
	Tabela VARCHAR(20),
	Detalhe VARCHAR(100),
/*FK*/
	FOREIGN KEY(CodRegistro) REFERENCES RegistroAtividade(CodRegistro),
/*PK*/
	PRIMARY KEY(CodRegistro)
);

/*==================================================*/
/*               INSERT DE DADOS                    */
/*==================================================*/

INSERT INTO `endereco` (`CodEndereco`, `Logradouro`, `Numero`, `Complemento`, `Cep`, `Bairro`, `Cidade`, `Uf`, `XDEAD`) VALUES
(1, 'Rua Gondelim', '90', 'Casa b', '04340-010', 'Americanópolis', 'São Paulo', 'SP', 0),
(2, 'Rua Inhambú', '22', '', '04520-010', 'Vila Uberabinha', 'São Paulo', 'SP', 0),
(3, 'Rua João Cachoeira', '33', '', '04535-010', 'Vila Nova Conceição', 'São Paulo', 'SP', 0),
(4, 'Rua Inhanduí', '44', '', '04535-020', 'Vila Nova Conceição', 'São Paulo', 'SP', 0),
(5, 'Rua Barão de Paranapiacaba', '93', '', '01004-000', 'Se', 'São Paulo', 'SP', 0),
(6, 'Vila Bueno', '55', '', '04535-010', 'Centro', 'São Paulo', 'SP', 0),
(7, 'Rua Aurora - até 334 - lado par', '35', '', '01209-000', 'Santa Efigênia', 'São Paulo', 'SP', 0);



INSERT INTO `cliente` (`CodCliente`, `DataInscricao`, `CodEndereco`, `XDEAD`) VALUES
(1, '2017-10-04', 1, 0),
(2, '2017-10-25', 2, 0),
(3, '2017-10-11', 3, 0),
(4, '2017-10-12', 4, 0),
(5, '2017-10-21', 5, 0),
(6, '2017-10-28', 6, 0),
(7, '2017-10-08', 7, 0);

INSERT INTO `construcao` (`CodConstrucao`, `Descricao`, `Detalhes`, `Qualidade`, `XDEAD`) VALUES
(1, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/600 - MONTANTE SIMPLES\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 1, 0),
(2, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/600 - MONTANTE SIMPLES\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 1, 0),
(3, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/600 - MONTANTE SIMPLES\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 1, 0),
(4, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/600 - MONTANTE DUPLO\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 1, 0),
(5, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/600 - MONTANTE DUPLO\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 0, 0),
(6, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/600 - MONTANTE DUPLO\r\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 1, 0),
(7, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/600 - MONTANTE SIMPLES\nRF 15,0', 1, 0),
(8, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/600 - MONTANTE SIMPLES\nRF 15,0', 100, 0),
(9, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/600 - MONTANTE SIMPLES\nRF 15,0', 100, 0),
(10, 'PAREDE SIMPLES - 1 CHAPA EM CADA', '73/48/600 - MONTANTE DUPLO\nRF 15,0', 100, 0),
(11, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/600 - MONTANTE DUPLO\nRF 15,0', 100, 0),
(12, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/600 - MONTANTE DUPLO	\nRF 15,0', 100, 0),
(13, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 100, 0),
(14, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 100, 0),
(15, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 90, 0),
(16, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 90, 0),
(17, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 90, 0),
(18, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(19, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(20, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(21, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(22, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '73/48/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(23, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '95/70/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(24, 'PAREDE SIMPLES - 1 CHAPA EM CADA LADO', '120/90/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(25, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/600 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(26, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/600 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(27, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/600 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(28, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/600 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(29, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/600 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(30, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/600 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(31, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/600 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(32, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/600 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(33, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/600 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(34, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/600 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(35, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/600 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(36, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/600 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(37, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(38, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(39, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/400 - MONTANTE SIMPLES\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(40, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(41, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(42, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/400 - MONTANTE DUPLO\nST12,5+ST12,5 ou RU 12,5 + RU 12,5', 99, 0),
(43, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(44, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(45, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/400 - MONTANTE SIMPLES\nRF 15,0', 99, 0),
(46, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '73/48/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(47, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '95/70/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(48, 'PAREDE SIMPLES - 2 CHAPAS EM CADA LADO', '120/90/400 - MONTANTE DUPLO\nRF 15,0', 99, 0),
(49, 'FORRO DE GESSO - 1 CHAPA', '530/600\nST12,5', 10, 0),
(50, 'FORRO DE GESSO - 1 CHAPA', '530/400\nRU12,5', 10, 0),
(51, 'FORRO DE GESSO - 2 CHAPAS', '530/400\r\nST12,5 + ST 12,5 ou RU12,5 + RU 12,5', 10, 0),
(52, 'FORRO DE GESSO - 1 CHAPA', '530/600\r\nRF 15,0', 10, 0),
(53, 'FORRO DE GESSO - 2 CHAPAS', '530/400\r\nRF 15,0 + RF 15,0', 10, 0);


INSERT INTO `funcionario` (`CodFuncionario`, `Login`, `Senha`, `XDEAD`) VALUES
(1, 'adm', '123', 0),
(2, 'admin', '123', 0),
(3, 'senior', '123', 0);


INSERT INTO `parede` (`CodConstrucao`, `Montante`, `AlturaLimite`, `EhSt`, `EhRu`, `EhRf`, `XDEAD`) VALUES
(1, '73.00000', '2.50000', 1, 1, 0, 0),
(2, '95.00000', '3.00000', 1, 1, 0, 0),
(3, '120.00000', '3.50000', 1, 1, 0, 0),
(4, '73.00000', '2.90000', 1, 1, 0, 0),
(5, '95.00000', '3.60000', 1, 1, 0, 0),
(6, '120.00000', '4.15000', 1, 1, 0, 0),
(7, '73.00000', '2.60000', 0, 0, 1, 0),
(8, '2.00000', '3.10000', 0, 0, 1, 0),
(9, '3.00000', '3.60000', 0, 0, 1, 0),
(10, '4.00000', '3.00000', 0, 0, 1, 0),
(11, '5.00000', '3.70000', 0, 0, 1, 0),
(12, '6.00000', '4.25000', 0, 0, 1, 0),
(13, '1.00000', '2.70000', 1, 1, 0, 0),
(14, '2.00000', '3.30000', 1, 1, 0, 0),
(15, '3.00000', '3.85000', 1, 1, 0, 0),
(16, '4.00000', '3.25000', 1, 1, 0, 0),
(17, '5.00000', '4.05000', 1, 1, 0, 0),
(18, '6.00000', '4.60000', 1, 1, 0, 0),
(19, '1.00000', '2.70000', 0, 0, 1, 0),
(20, '2.00000', '3.30000', 0, 0, 1, 0),
(21, '3.00000', '3.85000', 0, 0, 1, 0),
(22, '4.00000', '3.25000', 0, 0, 1, 0),
(23, '5.00000', '4.05000', 0, 0, 1, 0),
(24, '6.00000', '4.60000', 0, 0, 1, 0),
(25, '1.00000', '2.90000', 1, 1, 0, 0),
(26, '2.00000', '3.70000', 1, 1, 0, 0),
(27, '3.00000', '4.20000', 1, 1, 0, 0),
(28, '4.00000', '3.50000', 1, 1, 0, 0),
(29, '5.00000', '4.40000', 1, 1, 0, 0),
(30, '6.00000', '5.00000', 1, 1, 0, 0),
(31, '1.00000', '3.00000', 0, 0, 1, 0),
(32, '2.00000', '3.80000', 0, 0, 1, 0),
(33, '3.00000', '4.30000', 0, 0, 1, 0),
(34, '4.00000', '3.60000', 0, 0, 1, 0),
(35, '5.00000', '4.50000', 0, 0, 1, 0),
(36, '6.00000', '5.10000', 0, 0, 1, 0),
(37, '1.00000', '3.20000', 1, 1, 0, 0),
(38, '2.00000', '4.10000', 1, 1, 0, 0),
(39, '3.00000', '4.60000', 1, 1, 0, 0),
(40, '4.00000', '3.80000', 1, 1, 0, 0),
(41, '5.00000', '4.80000', 1, 1, 0, 0),
(42, '6.00000', '5.50000', 1, 1, 0, 0),
(43, '1.00000', '3.30000', 0, 0, 1, 0),
(44, '2.00000', '4.20000', 0, 0, 1, 0),
(45, '3.00000', '4.70000', 0, 0, 1, 0),
(46, '4.00000', '4.00000', 0, 0, 1, 0),
(47, '5.00000', '4.90000', 0, 0, 1, 0),
(48, '6.00000', '5.60000', 0, 0, 1, 0);

INSERT INTO `forro` (`CodConstrucao`, `EhSt`, `EhRu`, `EhRf`, `XDEAD`) VALUES
(49, 1, 0, 0, 0),
(50, 0, 1, 0, 0),
(51, 1, 1, 0, 0),
(52, 0, 0, 1, 0),
(53, 0, 0, 1, 0);

INSERT INTO `material` (`CodMaterial`, `Descricao`, `NomeUnidade`, `ConstanteMetro`, `PrecoUnitario`, `EhOpcional`, `Qualidade`, `Tipo`, `QuantidadeMinima`, `CodConstrucao`, `XDEAD`) VALUES
(1, 'PLACA ST 12,5 ou RU 12,5 (1200 x 1800) mm', 'CH', '0.97000', '1.00', 0, 10, 'Caixa', 1, 1, 0),
(2, 'FITA TELADA - 90M', 'RL', '0.03000', '1.00', 0, 4, 'Rolo', 1, 1, 0),
(3, 'MASSA PARA ACABAMENTO - 30KG', 'BD', '0.02000', '1.00', 0, 1, 'BD', 1, 1, 0),
(4, 'MONTANTE 48 - 3M', 'PÇ', '0.83000', '1.00', 0, 1, 'Peça', 1, 1, 0),
(5, 'GUIA 48 - 3M', 'PÇ', '0.30000', '1.00', 0, 1, 'Peça', 1, 1, 0),
(6, 'PARAFUSO TTPC 25 - 100UNID.', 'CX', '0.22000', '1.00', 0, 1, 'Caixa', 1, 1, 0),
(7, 'PARAFUSO TRPF 13 - 100UNID.', 'CX', '0.02000', '1.00', 0, 1, 'Caixa', 1, 1, 0),
(8, 'REBITE OU PINO - 100UNID.', 'CX', '0.05000', '1.00', 0, 1, 'Caixa', 1, 1, 0),
(9, 'ARRUELA OU FINCA PINO - 100UNID.', 'CX', '0.05000', '1.00', 0, 1, 'Caixa', 1, 1, 0),
(10, 'LÃ MINERAL (OPCIONAL) - 15M²', 'RL', '0.07000', '1.00', 1, 1, 'Rolo', 1, 1, 0),
(11, 'BANDA ACÚSTICA 48 (OPCIONAL) - 10M', 'RL', '0.09000', '1.00', 1, 1, 'Rolo', 1, 1, 0),
(12, 'PLACA ST 12,5 ou RU 12,5 (1200 x 1800) mm', 'CH', '0.97000', '1.00', 0, 1, 'CH', 1, 2, 0),
(13, 'FITA TELADA - 90M', 'RL', '0.03000', '1.00', 0, 1, 'Rolo', 1, 2, 0),
(14, 'MASSA PARA ACABAMENTO - 30KG', 'BD', '0.02000', '1.00', 0, 1, 'PD', 1, 2, 0),
(15, 'MONTANTE 70 - 3M', 'PÇ', '0.83000', '1.00', 0, 1, 'Peça', 1, 2, 0),
(16, 'GUIA 70 - 3M', 'PÇ', '0.30000', '1.00', 0, 1, 'Peça', 1, 2, 0),
(17, 'PARAFUSO TTPC 25 - 100UNID.', 'CX', '0.22000', '1.00', 0, 1, 'Caixa', 1, 2, 0),
(18, 'PARAFUSO TRPF 13 - 100UNID.', 'CX', '0.02000', '1.00', 0, 1, 'Caixa', 1, 2, 0),
(19, 'REBITE OU PINO - 100UNID.', 'CX', '0.05000', '1.00', 0, 1, 'Caixa', 1, 2, 0),
(20, 'ARRUELA OU FINCA PINO - 100UNID.', 'CX', '0.05000', '1.00', 0, 1, 'Caixa', 1, 2, 0),
(21, 'LÃ MINERAL (OPCIONAL) - 15M²', 'RL', '0.07000', '1.00', 1, 1, 'Rolo', 1, 2, 0),
(22, 'BANDA ACÚSTICA 70 (OPCIONAL) - 10M', 'RL', '0.09000', '1.00', 1, 99, 'Rolo', 1, 2, 0);

INSERT INTO `pessoafisica` (`CodCliente`, `Cpf`, `Nome`, `DataNascimento`, `XDEAD`) VALUES
(1, '121.133.133-11', 'João', '2007-10-04', 0),
(2, '122.131.112-71', 'Valdir', '2007-10-27', 0),
(3, '121.311.411-11', 'Mario', '1980-10-05', 0),
(4, '123.141.131-11', 'Joana', '1980-04-18', 0),
(5, '123.141.131-11', 'Pedro', '1975-11-20', 0);

INSERT INTO `pessoajuridica` (`CodCliente`, `Cnpj`, `RazaoSocial`, `RamoAtuacao`, `DataFundacao`, `XDEAD`) VALUES
(6, '45.131.323/3333-22', 'Novo rumo', 'Transportes', '2010-10-11', 0),
(7, '75.181.353/3344-24', 'Sorte João', 'Alimentos', '2010-10-11', 0);

INSERT INTO `telefone` (`CodCliente`, `Numero`, `XDEAD`) VALUES
(1, '(12)1000-1000', 0),
(2, '(12)1300-1002', 0),
(2, '(12)14000-1001', 0),
(3, '(12)10000-1003', 0),
(3, '(00)1000-1000', 0),
(3, '(00)1400-1003', 0),
(4, '(00)1050-1005', 0),
(5, '(11)1000-2000', 0),
(5, '(11)20000-1001', 0),
(5, '(11)1000-1000', 0),
(6, '(11)1060-1002', 0),
(6, '(11)1000-1003', 0),
(6, '(11)1060-1005', 0),
(7, '(11)1000-1007', 0),
(7, '(11)10000-1001', 0);

/*==================================================*/
/*               TABELAS DO APP                     */
/*==================================================*/

CREATE TABLE `pedido_orcamento` (
	`Id` int(11) NOT NULL,
	`Altura` varchar(100) DEFAULT NULL,
	`Largura` varchar(100) DEFAULT NULL,
	`Qtd_paredes` varchar(100) DEFAULT NULL,
	`Email` varchar(100) DEFAULT NULL,
	`Valor` varchar(100) DEFAULT NULL,
	`Ambiente` varchar(100) DEFAULT NULL,
	`Possui_porta` varchar(3) DEFAULT NULL,
	`Possui_janela` varchar(3) DEFAULT NULL,
	`Qtd_porta` varchar(100) DEFAULT NULL,
	`Qtd_janela` varchar(100) DEFAULT NULL,
	`Altura_porta` varchar(100) DEFAULT NULL,
	`Largura_porta` varchar(100) DEFAULT NULL,
	`Altura_janela` varchar(100) DEFAULT NULL,
	`Largura_janela` varchar(100) DEFAULT NULL,
	`Mao_obra` varchar(3) DEFAULT NULL,
/*PK*/
	PRIMARY KEY(`Id`)
  );

  
  ALTER TABLE `pedido_orcamento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
INSERT INTO `pedido_orcamento` (`Id`, `Altura`, `Largura`, `Qtd_paredes`, `Email`, `Valor`, `Ambiente`, `Possui_porta`, `Possui_janela`, `Qtd_porta`, `Qtd_janela`, `Altura_porta`, `Largura_porta`, `Altura_janela`, `Largura_janela`, `Mao_obra`) VALUES
(1, '100', '100', '4', 'fe_mmo@hotmail.com', '14000', 'Seco', 'Sim', 'Sim', '2', '1', '100', '150', '90', '90', 'Sim'),
(2, '150', '200', '4', 'duskmariner@gmail.com', '22000', 'Úmido', 'Não', 'Não', '', '', '', '', '', '', 'Não');




CREATE TABLE `usuarios` (
	`Id` int(11) NOT NULL,
	`Nome` varchar(100) DEFAULT NULL,
	`Email` varchar(100) DEFAULT NULL,
	`Senha` varchar(100) DEFAULT NULL,
/*PK*/
	PRIMARY KEY (`Id`)
);


INSERT INTO `usuarios` (`Id`, `Nome`, `Email`, `Senha`) VALUES
(1, 'Felipe', 'fe_mmo@hotmail.com', 'felipe515');

ALTER TABLE `usuarios`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
