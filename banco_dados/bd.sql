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
(1, 'Logradouro', '90', 'Complemento', '2222', 'bairro', 'cidade', 'SP', 0),
(2, 'Logradouro2', '22', 'Complemento2', '333', 'bairro2', 'cidade2', 'SP', 0),
(3, '_Logradouro5', '33', '_Complemento5', '555', '_bairro5', '_cidade5', 'SP', 0),
(4, 'Logradouro2', '22', 'Complemento2', '333', 'bairro2', 'cidade2', 'SP', 1),
(5, '_Logradouro5', '33', '_Complemento5', '555', '_bairro5', '_cidade5', 'SP', 0),
(6, 'Logradouro2', '22', 'Complemento2', '333', 'bairro2', 'cidade2', 'SP', 1),
(7, 'Logradouro2', '22', 'Complemento2', '333', 'bairro2', 'cidade2', 'SP', 0),
(8, 'Logradouro2', '22', 'Compl8888', '333', 'bairro2', 'cid88', 'SP', 0),
(9, 'Logradouro2', '22', 'Complemento2', '4444', 'bairro2', 'cidade2', 'SP', 1);


INSERT INTO `cliente` (`CodCliente`, `DataInscricao`, `CodEndereco`, `XDEAD`) VALUES
(1, '2017-10-04', 2, 0),
(2, '2017-10-25', 6, 0),
(3, '2017-10-11', 3, 0),
(4, '2017-10-25', 5, 0);

INSERT INTO `construcao` (`CodConstrucao`, `Descricao`, `Detalhes`, `Qualidade`, `XDEAD`) VALUES
(1, 'ffffff', 'sdfsdfsdfsdfsdf', 3, 0),
(2, 'sdfsdf', 'sdfsdfsdfsdfsdf', 3, 0),
(3, 'ssdfsd', 'sdfsdfwefwaf', 3, 0),
(4, 'wefwdcwacf fdc', 'wefwsfc', 6, 0),
(5, 'ssdfsdsdfsdfsdf', 'sdfsddddddddddddddd', 2, 0),
(6, 'sdfsdfdcthjnyukuiuiiiii', 'iiiiiiiiiiiiiiiiiiiiiiiii', 8, 0);


INSERT INTO `forro` (`CodConstrucao`, `EhSt`, `EhRu`, `EhRf`, `XDEAD`) VALUES
(1, 4, 2, 3, 0),
(2, 2, 3, 4, 0),
(3, 3, 4, 2, 0),
(6, 1, 0, 0, 0);

INSERT INTO `funcionario` (`CodFuncionario`, `Login`, `Senha`, `XDEAD`) VALUES
(1, 'adm', '123', 0),
(2, 'admin', '123', 0),
(3, 'corcovado', '123', 0),
(4, 'senior', '123', 0);


INSERT INTO `orcamento` (`CodOrcamento`, `DataHora`, `CodCliente`, `CodEndereco`, `XDEAD`) VALUES
(1, '2017-10-03', 2, 1, 0),
(2, '2017-10-24', 2, 8, 0);


INSERT INTO `item` (`CodItem`, `Altura`, `Largura`, `AreaPorta`, `AreaJanela`, `PrecoTotal`, `CodConstrucao`, `CodOrcamento`, `XDEAD`) VALUES
(1, '2.00000', '2.00000', '1.00000', '2.00000', '123.00', 4, 2, 0),
(2, '2.00000', '2.00000', '2.00000', '2.00000', '12.00', 3, 1, 0);

INSERT INTO `material` (`CodMaterial`, `Descricao`, `NomeUnidade`, `ConstanteMetro`, `PrecoUnitario`, `EhOpcional`, `Qualidade`, `Tipo`, `QuantidadeMinima`, `CodConstrucao`, `XDEAD`) VALUES
(1, 'Descrição', 'nomeUnidad', '1.00000', '2.00', 1, 2, 'tipo', 3, 1, 0),
(2, 'Descrição2', 'nomeUn2', '4.00000', '5.00', 1, 6, 'tipo2', 7, 2, 0),
(3, 'Descrição3', 'we', '2.00000', '2.00', 0, 3, 'tipo3', 2, 1, 0),
(4, 'Descrição', 'nomeUn2', '1.00000', '2.00', 0, 2, 'tipo', 2, 1, 0),
(5, 'sdfsdf', 'ewedd', '3.00000', '3.00', 1, 1, 'ddf', 2, 1, 0),
(6, 'Descrição3', 'nomeUnidad', '4.00000', '34.00', 0, 3, 'tipo2', 2, 6, 0),
(7, 'dddddddddddd', 'ewedd', '3.00000', '12.00', 1, 1, 'ddf', 4, 5, 0),
(8, 'ffffff', 'nomeUade', '1.00000', '3.00', 0, 1, 'tipo3', 5, 6, 0),
(9, 'sdfsdf', 'mmmmm', '4.00000', '11.00', 1, 9, 'ddf', 2, 5, 0),
(10, 'Descrição2', 'tttt', '1.00000', '2.00', 0, 1, 'tipo', 2, 5, 0),
(11, 'sdfsdf', 'ccccc', '3.00000', '11.00', 1, 1, 'ddf', 2, 4, 0);

INSERT INTO `materialitem` (`CodMaterial`, `CodItem`, `Quantidade`, `PrecoUnitario`, `XDEAD`) VALUES
(1, 1, 12, '2.00', 0),
(2, 1, 21, '12.00', 0);

INSERT INTO `parede` (`CodConstrucao`, `Montante`, `AlturaLimite`, `EhSt`, `EhRu`, `EhRf`, `XDEAD`) VALUES
(1, '32.00000', '22.00000', 1, 1, 1, 0),
(3, '32.00000', '23.00000', 0, 0, 1, 0);

INSERT INTO `pessoafisica` (`CodCliente`, `Cpf`, `Nome`, `DataNascimento`, `XDEAD`) VALUES
(1, '12121212121212121212', 'dsfsdfsdf', '2017-10-04', 0),
(2, '11001100110011001123', 'dsfsdfsdf', '2017-10-27', 0),
(3, '132349222342', 'sdfsdfsdf', '2017-10-05', 0),
(4, '1293123', 'dsfsdfsdf', '2017-10-18', 0);

INSERT INTO `pessoajuridica` (`CodCliente`, `Cnpj`, `RazaoSocial`, `RamoAtuacao`, `DataFundacao`, `XDEAD`) VALUES
(4, '232323', 'sdsdf', 'sdfsdf', '2017-10-11', 0);

INSERT INTO `telefone` (`CodCliente`, `Numero`, `XDEAD`) VALUES
(1, '11111111', 0),
(1, '1211111111', 0),
(1, '22213', 0),
(2, '1111231111', 0),
(3, '22213', 0),
(4, '11111111', 0);

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
