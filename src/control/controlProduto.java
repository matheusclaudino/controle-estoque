/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoAtributos;
import dao.daoPessoa;
import dao.daoProduto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    daoAtributos daoAtri;
    daoPessoa daoPess;

    public controlProduto() {
        this.dao = new daoProduto();
        this.daoAtri = new daoAtributos();
        this.daoPess = new daoPessoa();
    }

    public int inserirProduto(int codigo, String nome, String descricao, BigDecimal preco, int unidade, Date dataEntrada, Object forne,
            Object cate, Object tam, Object c, Object est) {

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

    public void alterarProduto(int codigo, String nome, String descricao, BigDecimal preco, int unidade, Date dataEntrada, Object forne,
            Object cate, Object tam, Object c, Object est) {
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

    public void pesquisarProduto(int tipo, String pesquisa, JTable tabela) {
        List<Produto> lista = null;
        Produto produto = null;

        try {
            if (tipo == 0) { //CÓDIGO
                int id = Integer.parseInt(pesquisa);
                produto = dao.getProduto(id);
            } else if (tipo == 1) { //NOME
                lista = dao.getNome(pesquisa);
            }
//                else if(tipo == 2){ // Pesquisar por BAIRRO
//                    lista = cliDAO.pesquisarBairro(pesq);
//                }    

            ((DefaultTableModel) tabela.getModel()).setRowCount(0);

            if (lista != null) {
                Iterator<Produto> it = lista.iterator();
                while (it.hasNext()) {
                    produto = it.next();
                    ((DefaultTableModel) tabela.getModel()).addRow(produto.toArray());
                }
            } else if (produto != null) {
                ((DefaultTableModel) tabela.getModel()).addRow(new Vector());
                int col = 0;
                tabela.setValueAt(produto.getCodigo(), 0, col++);
                tabela.setValueAt(produto.getNome(), 0, col++);
                tabela.setValueAt(daoPess.getPessoa(produto.getFornecedor().getIdPessoa()), 0, col++);
                tabela.setValueAt(daoAtri.getCategoria(produto.getCategoria().getIdCategoria()), 0, col++);
                tabela.setValueAt(daoAtri.getTamanho(produto.getTamanho().getIdTamanho()), 0, col++);
                tabela.setValueAt(daoAtri.getCor(produto.getCor().getIdCor()), 0, col++);
                tabela.setValueAt(daoAtri.getEstampa(produto.getEstampa().getIdEstampa()), 0, col++);
                tabela.setValueAt(produto.getPreco(), 0, col++);
                tabela.setValueAt(produto.getQuantidade(), 0, col++);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
        } catch (Exception ex) {
            // tabela.setModel( null );
            Logger.getLogger(controlProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
