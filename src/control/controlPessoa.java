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

import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import view.TelaCadastroPessoa;
import view.TelaExibirPessoas;

/**
 *
 * @author Matheus Claudino
 */
public class controlPessoa {

    daoPessoa dao;
    List<Pessoa> lista;
    Pessoa pessoa;

    //PedidoDAO pedDAO;
    public controlPessoa() throws ClassNotFoundException, SQLException, Exception {
        this.dao = new daoPessoa();
        lista = null;
        this.pessoa = null;
    }

    public int inserirPessoa(String nome, String telefone, String cep, String cidade, String rua, int numero, String bairro,
            String complemento, String referencia, String estado, int tipoPessoa, String cpf, Date dataNascimento,
            String sexo, String cnpj, Double salario, Date dataAdmissao)//os valores especificos podem ser null
            throws SQLException, Exception {

        char s = tipoSexo(sexo);
        Pessoa pes;
        Endereco endereco = new Endereco(cep, rua, numero, bairro, cidade, estado);
        dao.inserirEndereco(endereco);
        if (tipoPessoa == 'C') {
            pes = new Pessoafisica(endereco, nome, telefone, cpf, s, dataNascimento);
        } else if (tipoPessoa == 'F') {
            pes = new Fornecedor(endereco, nome, telefone, cnpj);
        } else {
            pes = new Vendedor(endereco, nome, telefone, cpf, s, dataNascimento, salario, dataAdmissao);
        }
        dao.inserir(pes);

        return pes.getIdPessoa();
    }

    public void alterarPessoa(int idPessoa, String nome, String telefone, String cep, String cidade, String rua, int numero, String bairro,
            String complemento, String referencia, String estado, int tipoPessoa, String cpf, Date dataNascimento,
            String sexo, String cnpj, Double salario, Date dataAdmissao)//os valores especificos podem ser null
            throws SQLException, Exception {

        char s = tipoSexo(sexo);
        Pessoa pes = null;
        Endereco endereco = new Endereco(cep, rua, numero, bairro, cidade, estado);
        if (tipoPessoa == 'C') {
            pes = new Pessoafisica(endereco, nome, telefone, cpf, s, dataNascimento);
        } else if (tipoPessoa == 'F') {
            pes = new Fornecedor(endereco, nome, telefone, cnpj);
        } else {
            pes = new Vendedor(endereco, nome, telefone, cpf, s, dataNascimento, salario, dataAdmissao);
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

    public void consultaPessoa(JTable tabela, int tipo) {

        lista = dao.consultaPessoa(tipo);

        exibirLista(tabela, tipo);

    }

    public void exibirLista(JTable tabela, int tipo) {
        String nomeClasse = null;
        Pessoa pes = null;

        switch (tipo) {
            case 'C': // Pessoa Fisica
                nomeClasse = "modelo.Pessoafisica";
                break;
            case 'F': // Pessoa Fornecedor
                nomeClasse = "modelo.Fornecedor";
                break;
            case 'V': // Pessoa Vendedor
                nomeClasse = "modelo.Vendedor";
                break;
        }

        // Percorrer a LISTA
        if (lista != null) {
            ((DefaultTableModel) tabela.getModel()).setRowCount(0);
            Iterator<Pessoa> it = lista.iterator();
            while (it.hasNext()) {
                pes = it.next();
                ((DefaultTableModel) tabela.getModel()).addRow(pes.toArray());
            }
        }

    }

    public void getPessoaSelecionada(TelaCadastroPessoa telaCadastro, TelaExibirPessoas telaExibirPessoas, JTable tabela, int tipo) throws Exception {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            telaCadastro = new TelaCadastroPessoa(null, true);
            pessoa = (Pessoa) tabela.getValueAt(linha, 1);
            
            telaCadastro.getjTextFieldNome().setText(pessoa.toString());
            telaCadastro.getjTextFieldTelefone().setText(pessoa.getTelefone());
            Endereco endereco = dao.getEndereco(pessoa.getEndereco().getIdEndereco());
            telaCadastro.getjTextFieldCEP().setText(endereco.getCep());
            telaCadastro.getjTextFieldCidade().setText(endereco.getCidade());
            telaCadastro.getjTextFieldRua().setText(endereco.getRua());
            telaCadastro.getjTextFieldNumero().setText(String.valueOf(endereco.getNumero()));
            telaCadastro.getjTextFieldBairro().setText(endereco.getBairro());
            telaCadastro.getjTextFieldComplemento().setText(endereco.getComplemento());
            telaCadastro.getjTextFieldReferencia().setText(endereco.getReferencia());
            telaCadastro.getjComboBoxEstado().getModel().setSelectedItem(endereco.getEstado());

            switch (tipo) {
                case 'C': // Pessoa Fisica
                    Pessoafisica pessoafisica = (Pessoafisica) pessoa;
                    telaCadastro.getjRadioButtonCliente().setSelected(true);
                    telaCadastro.getjTextFieldCPF().setText(pessoafisica.getCpf());
                    telaCadastro.getjTextFieldDataNascimento().setText(pessoafisica.getDataNascimento().toString());
                    telaCadastro.getjComboBoxSexo().getModel().setSelectedItem(pessoafisica.getSexo());
                    break;

                case 'F': // Pessoa Fornecedor
                    Fornecedor fornecedor = (Fornecedor) pessoa;
                    telaCadastro.getjRadioButtonFornecedor().setSelected(true);
                    telaCadastro.getjTextFieldCNPJ().setText(fornecedor.getCnpj());
                    break;

                case 'V': // Pessoa Vendedor
                    Vendedor vendedor = (Vendedor) pessoa;
                    telaCadastro.getjRadioButtonVendedor().setSelected(true);
                    telaCadastro.getjTextFieldCPF().setText(vendedor.getCpf());
                    telaCadastro.getjTextFieldDataNascimento().setText(vendedor.getDataNascimento().toString());
                    telaCadastro.getjComboBoxSexo().getModel().setSelectedItem(vendedor.getSexo());
                    telaCadastro.getjTextFieldAdmissao().setText(vendedor.getDataAdmissao().toString());
                    break;
            }

            telaCadastro.getjButtonAlterar().setEnabled(true);
            telaCadastro.getjButtonExcluir().setEnabled(true);
            telaExibirPessoas.setVisible(false);
            telaCadastro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(telaExibirPessoas, "Selecione alguem.");
        }
    }

    public char tipoSexo(String sexo) {
        char s;
        if (sexo.equalsIgnoreCase("Feminino")) {
            s = 'F';
        } else {
            s = 'M';
        }

        return s;
    }
}
