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

    public void getPessoaSelecionada(TelaCadastroPessoa telaCadastro, TelaExibirPessoas telaExibirPessoas, JTable tabela, int tipo) {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {

            pessoa = dao.getPessoa((int) tabela.getValueAt(linha, 0));

            telaCadastro.getjTextFieldNome().setText(pessoa.getNome());
            telaCadastro.getjTextFieldTelefone().setText(pessoa.getTelefone());
            telaCadastro.getjTextFieldCEP().setText(pessoa.getEndereco().getCep());
            telaCadastro.getjTextFieldCidade().setText(pessoa.getEndereco().getCidade());
            telaCadastro.getjTextFieldRua().setText(pessoa.getEndereco().getRua());
            telaCadastro.getjTextFieldNumero().setText(String.valueOf(pessoa.getEndereco().getNumero()));
            telaCadastro.getjTextFieldBairro().setText(pessoa.getEndereco().getBairro());
            telaCadastro.getjTextFieldComplemento().setText(pessoa.getEndereco().getComplemento());
            telaCadastro.getjTextFieldReferencia().setText(pessoa.getEndereco().getReferencia());
            telaCadastro.getjComboBoxEstado().getModel().setSelectedItem(pessoa.getEndereco().getEstado());

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

            telaExibirPessoas.setVisible(false);

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
