-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 02-Nov-2017 às 22:06
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cmd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido_orcamento`
--

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
  `Mao_obra` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido_orcamento`
--

INSERT INTO `pedido_orcamento` (`Id`, `Altura`, `Largura`, `Qtd_paredes`, `Email`, `Valor`, `Ambiente`, `Possui_porta`, `Possui_janela`, `Qtd_porta`, `Qtd_janela`, `Altura_porta`, `Largura_porta`, `Altura_janela`, `Largura_janela`, `Mao_obra`) VALUES
(1, '100', '100', '4', 'fe_mmo@hotmail.com', '14000', 'Seco', 'Sim', 'Sim', '2', '1', '100', '150', '90', '90', 'Sim'),
(2, '150', '200', '4', 'duskmariner@gmail.com', '22000', 'Úmido', 'Não', 'Não', '', '', '', '', '', '', 'Não');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pedido_orcamento`
--
ALTER TABLE `pedido_orcamento`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pedido_orcamento`
--
ALTER TABLE `pedido_orcamento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

