/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoProduto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Cor;
import model.Estampa;
import model.Fornecedor;
import model.Produto;
import model.Tamanho;

/**
 *
 * @author Matheus Claudino
 */
public class controlProduto {
    daoProduto dao;

    public controlProduto() {
        this.dao = new daoProduto();
    }
    
    public int inserirProduto(int codigo,String nome, String descricao, BigDecimal preco, int unidade, Date dataEntrada, Object forne,
                Object cate, Object tam, Object c, Object est){
        
        Produto pro;
        Fornecedor fornecedor = (Fornecedor) forne;
        Categoria categoria = (Categoria) cate;
        Tamanho tamanho = (Tamanho) tam;
        Cor cor = (Cor) c;
        Estampa estampa = (Estampa) est;
        pro = new Produto(codigo, categoria, cor, estampa, fornecedor, tamanho, nome, descricao, unidade, preco, dataEntrada);
        
        dao.insert(pro);
        return pro.getCodigo();
    }
    public void alterarProduto(int codigo,String nome, String descricao, BigDecimal preco, int unidade, Date dataEntrada, Object forne,
                Object cate, Object tam, Object c, Object est){
        Produto pro;
        Fornecedor fornecedor = (Fornecedor) forne;
        Categoria categoria = (Categoria) cate;
        Tamanho tamanho = (Tamanho) tam;
        Cor cor = (Cor) c;
        Estampa estampa = (Estampa) est;
        pro = new Produto(codigo, categoria, cor, estampa, fornecedor, tamanho, nome, descricao, unidade, preco, dataEntrada);
        
        dao.update(pro);
    }
    public void excluirPessoa(Produto produto, JTable tabela) throws SQLException, Exception {

        dao.delete(produto);

        // Remover a linha selecionado
        int linha = tabela.getSelectedRow();
        ((DefaultTableModel) tabela.getModel()).removeRow(linha);
    }
           
}
