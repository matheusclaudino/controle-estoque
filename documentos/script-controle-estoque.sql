-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(8) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(15) NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(25) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `referencia` VARCHAR(100) NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `Endereco_idEndereco` INT NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Pessoa_Endereco1_idx` (`Endereco_idEndereco` ASC),
  CONSTRAINT `fk_Pessoa_Endereco1`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `mydb`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `cnpj` VARCHAR(14) NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`cnpj`),
  INDEX `fk_Fornecedor_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  CONSTRAINT `fk_Fornecedor_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tamanho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tamanho` (
  `idTamanho` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idTamanho`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cor` (
  `idCor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idCor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estampa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estampa` (
  `idEstampa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idEstampa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `Fornecedor_cnpj` VARCHAR(14) NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  `Tamanho_idTamanho` INT NOT NULL,
  `Cor_idCor` INT NOT NULL,
  `Estampa_idEstampa` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_Produto_Categoria1_idx` (`Categoria_idCategoria` ASC),
  INDEX `fk_Produto_Tamanho1_idx` (`Tamanho_idTamanho` ASC),
  INDEX `fk_Produto_Cor1_idx` (`Cor_idCor` ASC),
  INDEX `fk_Produto_Estampa1_idx` (`Estampa_idEstampa` ASC),
  INDEX `fk_Produto_Fornecedor1_idx` (`Fornecedor_cnpj` ASC),
  CONSTRAINT `fk_Produto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `mydb`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Tamanho1`
    FOREIGN KEY (`Tamanho_idTamanho`)
    REFERENCES `mydb`.`Tamanho` (`idTamanho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Cor1`
    FOREIGN KEY (`Cor_idCor`)
    REFERENCES `mydb`.`Cor` (`idCor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Estampa1`
    FOREIGN KEY (`Estampa_idEstampa`)
    REFERENCES `mydb`.`Estampa` (`idEstampa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_Fornecedor1`
    FOREIGN KEY (`Fornecedor_cnpj`)
    REFERENCES `mydb`.`Fornecedor` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PessoaFisica` (
  `idPessoaFisica` INT NOT NULL AUTO_INCREMENT,
  `sexo` VARCHAR(45) NULL,
  `data_nascimento` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idPessoaFisica`),
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `mydb`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vendedor` (
  `idVendedor` INT NOT NULL AUTO_INCREMENT,
  `PessoaFisica_idPessoaFisica` INT NOT NULL,
  `salario` DOUBLE NOT NULL,
  `data_admissao` DATE NOT NULL,
  `data_demissao` DATE NULL,
  PRIMARY KEY (`idVendedor`),
  INDEX `fk_Vendedor_PessoaFisica1_idx` (`PessoaFisica_idPessoaFisica` ASC),
  CONSTRAINT `fk_Vendedor_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_idPessoaFisica`)
    REFERENCES `mydb`.`PessoaFisica` (`idPessoaFisica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Venda` (
  `idVenda` INT NOT NULL AUTO_INCREMENT,
  `Produto_idProduto` INT NOT NULL,
  `Vendedor_idVendedor` INT NOT NULL,
  `PessoaFisica_idPessoaFisica` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Saida_Produto1_idx` (`Produto_idProduto` ASC),
  INDEX `fk_Venda_Vendedor1_idx` (`Vendedor_idVendedor` ASC),
  INDEX `fk_Venda_PessoaFisica1_idx` (`PessoaFisica_idPessoaFisica` ASC),
  CONSTRAINT `fk_Saida_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `mydb`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Vendedor1`
    FOREIGN KEY (`Vendedor_idVendedor`)
    REFERENCES `mydb`.`Vendedor` (`idVendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_idPessoaFisica`)
    REFERENCES `mydb`.`PessoaFisica` (`idPessoaFisica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
