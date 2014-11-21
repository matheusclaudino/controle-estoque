/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoAtributos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.Categoria;
import model.Cor;
import model.Estampa;
import model.Tamanho;

/**
 *
 * @author Matheus Claudino
 */
public class controlAtributos {
    daoAtributos dao;

    public controlAtributos() {
        this.dao = new daoAtributos();
    }
    
    public int inserirAtributo(int tipo, String nome){
        if(tipo == '1'){
            Cor cor = new Cor(nome);
            dao.insertCor(cor);
            return cor.getIdCor();
        }else if(tipo == '2'){
            Estampa estampa = new Estampa(nome);
            dao.insertEstampa(estampa);
            return estampa.getIdEstampa();
        }else if(tipo == '3'){
            Categoria categoria = new Categoria(nome);
            dao.insertCategoria(categoria);
            return categoria.getIdCategoria();
        }else{
            Tamanho tamanho = new Tamanho(nome);
            dao.insertTamanho(tamanho);
            return tamanho.getIdTamanho();
        }
        
    }
    public void carregarComboFornecedor(JComboBox Fornecedor) {
        List lista;
        try {
            lista = dao.listarFornecedor();
            Fornecedor.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Fornecedor.setModel(null);
            Logger.getLogger(controlAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarComboCategoria(JComboBox Categoria){
         List lista;
        try {
            lista = dao.listarCategoria();
            Categoria.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Categoria.setModel(null);
            Logger.getLogger(controlAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarComboTamanho(JComboBox Tamanho){
         List lista;
        try {
            lista = dao.listarTamanho();
            Tamanho.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Tamanho.setModel(null);
            Logger.getLogger(controlAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarComboCor(JComboBox Cor){
         List lista;
        try {
            lista = dao.listarCor();
            Cor.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Cor.setModel(null);
            Logger.getLogger(controlAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void carregarComboEstampa(JComboBox Estampa){
         List lista;
        try {
            lista = dao.listarEstampa();
            Estampa.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (Exception ex) {
            Estampa.setModel(null);
            Logger.getLogger(controlAtributos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
