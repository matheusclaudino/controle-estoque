/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoPessoa;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Fornecedor;
import model.Pessoa;
import model.Pessoafisica;
import model.Vendedor;

/**
 *
 * @author Matheus Claudino
 */
public class controlPessoa {
    daoPessoa dao;
    List<Pessoa> lista;

    //PedidoDAO pedDAO;
    public controlPessoa() throws ClassNotFoundException, SQLException, Exception {
        this.dao = new daoPessoa();
        lista = null;
    }

    public int inserirPessoa(Endereco endereco, String nome, String telefone, String cpf,
            char sexo, Date dataNascimento, double salario, Date dataAdmissao, String cnpj, int tipo)//os valores especificos podem ser null
            throws SQLException, Exception {
       
        Pessoa pes = null;
        if (tipo == 'C') {
            pes = new Pessoafisica(endereco, nome, telefone, cpf, sexo, dataNascimento);
        } else if (tipo == 'F') {
            pes = new Fornecedor(endereco, nome, telefone, cnpj);
        } else if (tipo == 'V') {
            pes = new Vendedor(endereco, nome, telefone, cpf, sexo, dataNascimento, salario, dataAdmissao);
        }
        dao.inserir(pes);
        return pes.getIdPessoa();

    }

    public void alterarPessoa(int idPessoa, Endereco endereco, String nome, String telefone, String cpf,
            char sexo, Date dataNascimento, double salario, Date dataAdmissao, String cnpj, int tipo)//os valores especificos podem ser null
            throws SQLException, Exception {
        
        Pessoa pes = null;
        if (tipo == 'C') {
            pes = new Pessoafisica(endereco, nome, telefone, cpf, sexo, dataNascimento);
        } else if (tipo == 'F') {
            pes = new Fornecedor(endereco, nome, telefone, cnpj);
        } else if (tipo == 'V') {
            pes = new Vendedor(endereco, nome, telefone, cpf, sexo, dataNascimento, salario, dataAdmissao);
        }

        pes.setIdPessoa(idPessoa);

        dao.alterar(pes);

    }

    public void excluirPessoa(Pessoa pes, JTable tabela) throws SQLException, Exception {

        dao.excluir(pes);

        // Remover a linha selecionado
        int linha = tabela.getSelectedRow();
        ((DefaultTableModel) tabela.getModel()).removeRow(linha);
    }

    public void pesquisarPessoa(JTable tabela, String pesq, int tipo) {

        lista = dao.pesquisarNome(pesq, tipo);

        mostrarLista(tabela, tipo);

    }
}