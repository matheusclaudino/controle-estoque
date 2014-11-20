-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema controleEstoque
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema controleEstoque
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controleEstoque` DEFAULT CHARACTER SET utf8 ;
USE `controleEstoque` ;

-- -----------------------------------------------------
-- Table `controleEstoque`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Produto` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(250) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  `data` DATE NOT NULL,
  `codigoFornecedor` INT NOT NULL,
  `codigoCor` INT NOT NULL,
  `codigoCategoria` INT NOT NULL,
  `codigoEstampa` INT NOT NULL,
  `codigoTamanho` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Produto_Categoria1_idx` (`codigoCategoria` ASC),
  INDEX `fk_Produto_Tamanho1_idx` (`codigoTamanho` ASC),
  INDEX `fk_Produto_Cor1_idx` (`codigoCor` ASC),
  INDEX `fk_Produto_Estampa1_idx` (`codigoEstampa` ASC),
  INDEX `fk_Produto_Fornecedor1_idx` (`codigoFornecedor` ASC),
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`codigoCategoria`)
    REFERENCES `controleEstoque`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Cor1`
    FOREIGN KEY (`codigoCor`)
    REFERENCES `controleEstoque`.`Cor` (`idCor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Estampa1`
    FOREIGN KEY (`codigoEstampa`)
    REFERENCES `controleEstoque`.`Estampa` (`idEstampa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Fornecedor1`
    FOREIGN KEY (`codigoFornecedor`)
    REFERENCES `controleEstoque`.`Fornecedor` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Tamanho1`
    FOREIGN KEY (`codigoTamanho`)
    REFERENCES `controleEstoque`.`Tamanho` (`idTamanho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`PessoaFisica` (
  `idPessoa` INT NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `controleEstoque`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Cor` (
  `idCor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idCor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `cep` CHAR(8) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(15) NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(25) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `referencia` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Estampa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Estampa` (
  `idEstampa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idEstampa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(11) NULL DEFAULT NULL,
  `idEndereco` INT NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Pessoa_Endereco1_idx` (`idEndereco` ASC),
  CONSTRAINT `fk_Pessoa_Endereco1`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `controleEstoque`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Fornecedor` (
  `idPessoa` INT NOT NULL,
  `cnpj` CHAR(14) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Fornecedor_Pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_Fornecedor_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `controleEstoque`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`PessoaFisica` (
  `idPessoa` INT NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `controleEstoque`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Tamanho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Tamanho` (
  `idTamanho` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idTamanho`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Produto` (
  `codigo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(250) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  `data` DATE NOT NULL,
  `codigoFornecedor` INT NOT NULL,
  `codigoCor` INT NOT NULL,
  `codigoCategoria` INT NOT NULL,
  `codigoEstampa` INT NOT NULL,
  `codigoTamanho` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Produto_Categoria1_idx` (`codigoCategoria` ASC),
  INDEX `fk_Produto_Tamanho1_idx` (`codigoTamanho` ASC),
  INDEX `fk_Produto_Cor1_idx` (`codigoCor` ASC),
  INDEX `fk_Produto_Estampa1_idx` (`codigoEstampa` ASC),
  INDEX `fk_Produto_Fornecedor1_idx` (`codigoFornecedor` ASC),
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`codigoCategoria`)
    REFERENCES `controleEstoque`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Cor1`
    FOREIGN KEY (`codigoCor`)
    REFERENCES `controleEstoque`.`Cor` (`idCor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Estampa1`
    FOREIGN KEY (`codigoEstampa`)
    REFERENCES `controleEstoque`.`Estampa` (`idEstampa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Fornecedor1`
    FOREIGN KEY (`codigoFornecedor`)
    REFERENCES `controleEstoque`.`Fornecedor` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Tamanho1`
    FOREIGN KEY (`codigoTamanho`)
    REFERENCES `controleEstoque`.`Tamanho` (`idTamanho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Vendedor` (
  `idPessoa` INT NOT NULL,
  `salario` DOUBLE NOT NULL,
  `data_admissao` DATE NOT NULL,
  `data_demissao` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Vendedor_PessoaFisica1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_Vendedor_PessoaFisica1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `controleEstoque`.`PessoaFisica` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `controleEstoque`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controleEstoque`.`Venda` (
  `idVenda` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  `idProduto` INT NOT NULL,
  `idVendedor` INT NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Saida_Produto1_idx` (`idProduto` ASC),
  INDEX `fk_Venda_Vendedor1_idx` (`idVendedor` ASC),
  CONSTRAINT `fk_Saida_Produto1`
    FOREIGN KEY (`idProduto`)
    REFERENCES `controleEstoque`.`Produto` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Vendedor1`
    FOREIGN KEY (`idVendedor`)
    REFERENCES `controleEstoque`.`Vendedor` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
