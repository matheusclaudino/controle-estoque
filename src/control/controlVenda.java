/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoVenda;
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
import model.Produto;
import model.Venda;
import model.Vendedor;
import view.TelaPesqProduto;
import view.TelaPesqVenda;

/**
 *
 * @author Matheus Claudino
 */
public class controlVenda {

    daoVenda dao;
    Produto produto;
    Vendedor vendedor;

    //TelaCadastroProduto janelaProduto;
    public controlVenda() {
        this.dao = new daoVenda();
        this.produto = null;
        this.vendedor = null;
    }

    public int inserirVenda(Object vendedor, Object produto, int quantidade, double valor, Date data) {

        Venda venda;
        this.vendedor = (Vendedor) vendedor;
        this.produto = (Produto) produto;
        venda = new Venda(this.produto, this.vendedor, quantidade, valor, data);

        dao.inserir(venda);
        return venda.getIdVenda();
    }

    public void preencherTabela(TelaPesqVenda telaVenda, JTable tabela) {

        List<Venda> lista = null;
        Venda venda;

        lista = (List<Venda>) dao.getVenda();
//        System.out.println(lista.get(0).getIdVenda());
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);

        if (lista != null) {
            Iterator<Venda> it = lista.iterator();
            while (it.hasNext()) {
                venda = (Venda) it.next();
                ((DefaultTableModel) tabela.getModel()).addRow(venda.toArray());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Venda não encontrado!");
        }
    }
    
    public void excluirVenda(JTable tabela) throws SQLException, Exception {
        Venda venda;
        int linha = tabela.getSelectedRow();
        
        if ( linha >= 0) {
            venda = (Venda) tabela.getValueAt(linha,0);//GAMBIARRA
            try {
                dao.delete(venda);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO ao excluir VENDA.");
                Logger.getLogger(controlProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma VENDA.");
        }
        
        ((DefaultTableModel) tabela.getModel()).removeRow(linha);
    }
}
