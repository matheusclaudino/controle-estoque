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
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `idFornecedor` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`idFornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `idCategoria` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tamanho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tamanho` (
  `idTamanho` INT NOT NULL,
  `nome` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idTamanho`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cor` (
  `idCor` INT NOT NULL,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idCor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estampa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estampa` (
  `idEstampa` INT NOT NULL,
  `nome` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idEstampa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL,
  `Fornecedor_idFornecedor` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  `Tamanho_idTamanho` INT NOT NULL,
  `Cor_idCor` INT NOT NULL,
  `Estampa_idEstampa` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_Produto_Fornecedor_idx` (`Fornecedor_idFornecedor` ASC),
  INDEX `fk_Produto_Categoria1_idx` (`Categoria_idCategoria` ASC),
  INDEX `fk_Produto_Tamanho1_idx` (`Tamanho_idTamanho` ASC),
  INDEX `fk_Produto_Cor1_idx` (`Cor_idCor` ASC),
  INDEX `fk_Produto_Estampa1_idx` (`Estampa_idEstampa` ASC),
  CONSTRAINT `fk_Produto_Fornecedor`
    FOREIGN KEY (`Fornecedor_idFornecedor`)
    REFERENCES `mydb`.`Fornecedor` (`idFornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Saida` (
  `idSaida` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`idSaida`),
  INDEX `fk_Saida_Produto1_idx` (`Produto_idProduto` ASC),
  CONSTRAINT `fk_Saida_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `mydb`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
