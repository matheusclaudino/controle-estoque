/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.controlPessoa;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.DataFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Matheus Claudino
 */
public class TelaCadastroPessoa extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastroPessoa
     */
    controlPessoa control;
    int IdPessoa; //recupera o id para operações no banco

    public TelaCadastroPessoa(java.awt.Frame parent, boolean modal) throws SQLException, Exception {
        super(parent, modal);
        initComponents();
        jPanelCliente.setVisible(false);
        jPanelFornecedor.setVisible(false);
        jPanelVendedor.setVisible(false);
        this.control = new controlPessoa();
    }

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(int IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public ButtonGroup getButtonGroupTipoPessoa() {
        return buttonGroupTipoPessoa;
    }

    public void setButtonGroupTipoPessoa(ButtonGroup buttonGroupTipoPessoa) {
        this.buttonGroupTipoPessoa = buttonGroupTipoPessoa;
    }

    public JRadioButton getjRadioButtonCliente() {
        return jRadioButtonCliente;
    }

    public void setjRadioButtonCliente(JRadioButton jRadioButtonCliente) {
        this.jRadioButtonCliente = jRadioButtonCliente;
    }

    public JRadioButton getjRadioButtonFornecedor() {
        return jRadioButtonFornecedor;
    }

    public void setjRadioButtonFornecedor(JRadioButton jRadioButtonFornecedor) {
        this.jRadioButtonFornecedor = jRadioButtonFornecedor;
    }

    public JRadioButton getjRadioButtonVendedor() {
        return jRadioButtonVendedor;
    }

    public void setjRadioButtonVendedor(JRadioButton jRadioButtonVendedor) {
        this.jRadioButtonVendedor = jRadioButtonVendedor;
    }

    public JPanel getjPanelFornecedor() {
        return jPanelFornecedor;
    }

    public void setjPanelFornecedor(JPanel jPanelFornecedor) {
        this.jPanelFornecedor = jPanelFornecedor;
    }

    public JPanel getjPanelCliente() {
        return jPanelCliente;
    }

    public void setjPanelCliente(JPanel jPanelCliente) {
        this.jPanelCliente = jPanelCliente;
    }

    public JPanel getjPanelVendedor() {
        return jPanelVendedor;
    }

    public void setjPanelVendedor(JPanel jPanelVendedor) {
        this.jPanelVendedor = jPanelVendedor;
    }

    //AREA DE CORTE DIFERENCIAÇÃO DE METODOS
    public JLabel getjLabelDataAdmissao() {
        return jLabelDataAdmissao;
    }

    public void setjLabelDataAdmissao(JLabel jLabelDataAdmissao) {
        this.jLabelDataAdmissao = jLabelDataAdmissao;
    }

    public JTextField getjTextFieldAdmissao() {
        return jTextFieldAdmissao;
    }

    public void setjTextFieldAdmissao(JTextField jTextFieldAdmissao) {
        this.jTextFieldAdmissao = jTextFieldAdmissao;
    }

    public JTextField getjTextFieldBairro() {
        return jTextFieldBairro;
    }

    public void setjTextFieldBairro(JTextField jTextFieldBairro) {
        this.jTextFieldBairro = jTextFieldBairro;
    }

    public JTextField getjTextFieldCEP() {
        return jTextFieldCEP;
    }

    public void setjTextFieldCEP(JTextField jTextFieldCEP) {
        this.jTextFieldCEP = jTextFieldCEP;
    }

    public JTextField getjTextFieldCNPJ() {
        return jTextFieldCNPJ;
    }

    public void setjTextFieldCNPJ(JTextField jTextFieldCNPJ) {
        this.jTextFieldCNPJ = jTextFieldCNPJ;
    }

    public JTextField getjTextFieldCPF() {
        return jTextFieldCPF;
    }

    public void setjTextFieldCPF(JTextField jTextFieldCPF) {
        this.jTextFieldCPF = jTextFieldCPF;
    }

    public JTextField getjTextFieldCidade() {
        return jTextFieldCidade;
    }

    public void setjTextFieldCidade(JTextField jTextFieldCidade) {
        this.jTextFieldCidade = jTextFieldCidade;
    }

    public JTextField getjTextFieldComplemento() {
        return jTextFieldComplemento;
    }

    public void setjTextFieldComplemento(JTextField jTextFieldComplemento) {
        this.jTextFieldComplemento = jTextFieldComplemento;
    }

    public JTextField getjTextFieldDataNascimento() {
        return jTextFieldDataNascimento;
    }

    public void setjTextFieldDataNascimento(JTextField jTextFieldDataNascimento) {
        this.jTextFieldDataNascimento = jTextFieldDataNascimento;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public JTextField getjTextFieldNumero() {
        return jTextFieldNumero;
    }

    public void setjTextFieldNumero(JTextField jTextFieldNumero) {
        this.jTextFieldNumero = jTextFieldNumero;
    }

    public JTextField getjTextFieldReferencia() {
        return jTextFieldReferencia;
    }

    public void setjTextFieldReferencia(JTextField jTextFieldReferencia) {
        this.jTextFieldReferencia = jTextFieldReferencia;
    }

    public JTextField getjTextFieldRua() {
        return jTextFieldRua;
    }

    public void setjTextFieldRua(JTextField jTextFieldRua) {
        this.jTextFieldRua = jTextFieldRua;
    }

    public JTextField getjTextFieldSalario() {
        return jTextFieldSalario;
    }

    public void setjTextFieldSalario(JTextField jTextFieldSalario) {
        this.jTextFieldSalario = jTextFieldSalario;
    }

    public JTextField getjTextFieldTelefone() {
        return jTextFieldTelefone;
    }

    public void setjTextFieldTelefone(JTextField jTextFieldTelefone) {
        this.jTextFieldTelefone = jTextFieldTelefone;
    }

    public JComboBox getjComboBoxEstado() {
        return jComboBoxEstado;
    }

    public void setjComboBoxEstado(JComboBox jComboBoxEstado) {
        this.jComboBoxEstado = jComboBoxEstado;
    }

    public JComboBox getjComboBoxSexo() {
        return jComboBoxSexo;
    }

    public void setjComboBoxSexo(JComboBox jComboBoxSexo) {
        this.jComboBoxSexo = jComboBoxSexo;
    }

    public JButton getjButtonAlterar() {
        return jButtonAlterar;
    }

    public void setjButtonAlterar(JButton jButtonAlterar) {
        this.jButtonAlterar = jButtonAlterar;
    }

    public JButton getjButtonExcluir() {
        return jButtonExcluir;
    }

    public void setjButtonExcluir(JButton jButtonExcluir) {
        this.jButtonExcluir = jButtonExcluir;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoPessoa = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTelaCadastroPessoa = new javax.swing.JPanel();
        jPanelInformacoesGerais = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jLabelRua = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCEP = new javax.swing.JTextField();
        jLabelCEP = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jLabelEstado = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldReferencia = new javax.swing.JTextField();
        jPanelTipoPessoa = new javax.swing.JPanel();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jRadioButtonFornecedor = new javax.swing.JRadioButton();
        jRadioButtonVendedor = new javax.swing.JRadioButton();
        jPanelCliente = new javax.swing.JPanel();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabelCPF = new javax.swing.JLabel();
        jLabelFormatoData = new javax.swing.JLabel();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jLabelDataNascimento = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabelSexo = new javax.swing.JLabel();
        jPanelFornecedor = new javax.swing.JPanel();
        jTextFieldCNPJ = new javax.swing.JTextField();
        jLabelCNPJ = new javax.swing.JLabel();
        jPanelVendedor = new javax.swing.JPanel();
        jTextFieldSalario = new javax.swing.JTextField();
        jLabelSalario = new javax.swing.JLabel();
        jTextFieldAdmissao = new javax.swing.JTextField();
        jLabelDataAdmissao = new javax.swing.JLabel();
        jLabelFormatoData1 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setTitle("Cadastro");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(410, 708));

        jPanelInformacoesGerais.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Gerais"));

        jLabelNome.setText("Nome");

        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });

        jLabelTelefone.setText("Telefone");

        jLabelRua.setText("Rua");

        jTextFieldCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCidadeActionPerformed(evt);
            }
        });

        jLabelCidade.setText("Cidade");

        jLabelBairro.setText("Bairro");

        jLabelNumero.setText("Numero");

        jSeparator1.setToolTipText("Endereço");

        jLabel1.setText("Endereço");

        jLabelCEP.setText("CEP");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));

        jLabelEstado.setText("Estado");

        jLabelComplemento.setText("Complemento");

        jLabel2.setText("Referência");

        javax.swing.GroupLayout jPanelInformacoesGeraisLayout = new javax.swing.GroupLayout(jPanelInformacoesGerais);
        jPanelInformacoesGerais.setLayout(jPanelInformacoesGeraisLayout);
        jPanelInformacoesGeraisLayout.setHorizontalGroup(
            jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(jLabelBairro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCEP, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCEP)
                                .addComponent(jLabelRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldRua, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEstado)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldCidade)
                                .addComponent(jTextFieldTelefone)
                                .addComponent(jTextFieldNumero)
                                .addComponent(jTextFieldComplemento)
                                .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                                    .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTelefone)
                                        .addComponent(jLabelCidade)
                                        .addComponent(jLabelNumero)
                                        .addComponent(jLabelComplemento))
                                    .addGap(95, 95, 95))))))
                .addContainerGap())
        );
        jPanelInformacoesGeraisLayout.setVerticalGroup(
            jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                                .addComponent(jLabelCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                                .addComponent(jLabelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                                .addComponent(jLabelRua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(jLabelComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInformacoesGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInformacoesGeraisLayout.createSequentialGroup()
                        .addComponent(jLabelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTipoPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Pessoa"));

        buttonGroupTipoPessoa.add(jRadioButtonCliente);
        jRadioButtonCliente.setMnemonic('C');
        jRadioButtonCliente.setText("Cliente");
        jRadioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonClienteActionPerformed(evt);
            }
        });

        buttonGroupTipoPessoa.add(jRadioButtonFornecedor);
        jRadioButtonFornecedor.setMnemonic('F');
        jRadioButtonFornecedor.setText("Fornecedor");
        jRadioButtonFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFornecedorActionPerformed(evt);
            }
        });

        buttonGroupTipoPessoa.add(jRadioButtonVendedor);
        jRadioButtonVendedor.setMnemonic('V');
        jRadioButtonVendedor.setText("Vendedor");
        jRadioButtonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTipoPessoaLayout = new javax.swing.GroupLayout(jPanelTipoPessoa);
        jPanelTipoPessoa.setLayout(jPanelTipoPessoaLayout);
        jPanelTipoPessoaLayout.setHorizontalGroup(
            jPanelTipoPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoPessoaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jRadioButtonCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonFornecedor)
                .addGap(50, 50, 50)
                .addComponent(jRadioButtonVendedor)
                .addGap(28, 28, 28))
        );
        jPanelTipoPessoaLayout.setVerticalGroup(
            jPanelTipoPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTipoPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCliente)
                    .addComponent(jRadioButtonFornecedor)
                    .addComponent(jRadioButtonVendedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabelCPF.setText("CPF");

        jLabelFormatoData.setText("dd/mm/aaaa");

        jLabelDataNascimento.setText("Data de Nascimento");

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Feminino", "Masculino" }));

        jLabelSexo.setText("Sexo");

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCPF)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelClienteLayout.createSequentialGroup()
                                .addComponent(jLabelDataNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelFormatoData))))
                    .addGroup(jPanelClienteLayout.createSequentialGroup()
                        .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSexo)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClienteLayout.createSequentialGroup()
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPF)
                    .addComponent(jLabelDataNascimento)
                    .addComponent(jLabelFormatoData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelFornecedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor"));

        jLabelCNPJ.setText("CNPJ");

        javax.swing.GroupLayout jPanelFornecedorLayout = new javax.swing.GroupLayout(jPanelFornecedor);
        jPanelFornecedor.setLayout(jPanelFornecedorLayout);
        jPanelFornecedorLayout.setHorizontalGroup(
            jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCNPJ)
                    .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFornecedorLayout.setVerticalGroup(
            jPanelFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFornecedorLayout.createSequentialGroup()
                .addComponent(jLabelCNPJ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanelVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendedor"));

        jTextFieldSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSalarioActionPerformed(evt);
            }
        });

        jLabelSalario.setText("Salario");

        jLabelDataAdmissao.setText("Data de Admissão");

        jLabelFormatoData1.setText("dd/mm/aaaa");

        javax.swing.GroupLayout jPanelVendedorLayout = new javax.swing.GroupLayout(jPanelVendedor);
        jPanelVendedor.setLayout(jPanelVendedorLayout);
        jPanelVendedorLayout.setHorizontalGroup(
            jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSalario)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelVendedorLayout.createSequentialGroup()
                        .addComponent(jLabelDataAdmissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFormatoData1))
                    .addComponent(jTextFieldAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanelVendedorLayout.setVerticalGroup(
            jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVendedorLayout.createSequentialGroup()
                .addGroup(jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSalario)
                    .addComponent(jLabelDataAdmissao)
                    .addComponent(jLabelFormatoData1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jButtonCadastrar.setText("CADASTRAR");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("LIMPAR");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTelaCadastroPessoaLayout = new javax.swing.GroupLayout(jPanelTelaCadastroPessoa);
        jPanelTelaCadastroPessoa.setLayout(jPanelTelaCadastroPessoaLayout);
        jPanelTelaCadastroPessoaLayout.setHorizontalGroup(
            jPanelTelaCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaCadastroPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTelaCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformacoesGerais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTipoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelTelaCadastroPessoaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButtonAlterar)
                .addGap(37, 37, 37)
                .addComponent(jButtonCadastrar)
                .addGap(32, 32, 32)
                .addComponent(jButtonExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTelaCadastroPessoaLayout.setVerticalGroup(
            jPanelTelaCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaCadastroPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInformacoesGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTelaCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelTelaCadastroPessoa);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jTextFieldCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCidadeActionPerformed

    private void jTextFieldSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSalarioActionPerformed

    private void jRadioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonClienteActionPerformed
        jPanelCliente.setVisible(true);
        jPanelFornecedor.setVisible(false);
        jPanelVendedor.setVisible(false);
    }//GEN-LAST:event_jRadioButtonClienteActionPerformed

    private void jRadioButtonFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFornecedorActionPerformed
        jPanelCliente.setVisible(false);
        jPanelFornecedor.setVisible(true);
        jPanelVendedor.setVisible(false);
    }//GEN-LAST:event_jRadioButtonFornecedorActionPerformed

    private void jRadioButtonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVendedorActionPerformed
        jPanelCliente.setVisible(true);
        jPanelFornecedor.setVisible(false);
        jPanelVendedor.setVisible(true);
    }//GEN-LAST:event_jRadioButtonVendedorActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String nascimento = jTextFieldDataNascimento.getText();
        String admissao = jTextFieldAdmissao.getText();
        Date dataNascimento = null;
        Date dataAdmissao = null;
        try {
            if (!jTextFieldDataNascimento.getText().equals("")) {
                dataNascimento = formatter.parse(nascimento);
            }
            if (!jTextFieldAdmissao.getText().equals("")) {
                dataAdmissao = formatter.parse(admissao);
            }
            if (jTextFieldSalario.getText().equals("")) {
                jTextFieldSalario.setText("0.0");
            }
            int id;

            id = control.inserirPessoa(
                    jTextFieldNome.getText(),
                    jTextFieldTelefone.getText(),
                    jTextFieldCEP.getText(),
                    jTextFieldCidade.getText(),
                    jTextFieldRua.getText(),
                    Integer.parseInt(jTextFieldNumero.getText().toString().trim()),
                    jTextFieldBairro.getText(),
                    jTextFieldComplemento.getText(),
                    jTextFieldReferencia.getText(),
                    jComboBoxEstado.getSelectedItem().toString(),
                    buttonGroupTipoPessoa.getSelection().getMnemonic(),
                    jTextFieldCPF.getText(),
                    dataNascimento,
                    jComboBoxSexo.getSelectedItem().toString(),
                    jTextFieldCNPJ.getText(),
                    Double.parseDouble(jTextFieldSalario.getText().toString().trim()),
                    dataAdmissao
            );
            JOptionPane.showMessageDialog(this, "Pessoa " + id + " foi cadastrada");
            cleanFields();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String nascimento = jTextFieldDataNascimento.getText();
        String admissao = jTextFieldAdmissao.getText();
        Date dataNascimento = null;
        Date dataAdmissao = null;

        if (!jTextFieldDataNascimento.getText().equals("")) {
            try {
                dataNascimento = formatter.parse(nascimento);
            } catch (ParseException ex) {
                Logger.getLogger(TelaCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!jTextFieldAdmissao.getText().equals("")) {
            try {
                dataAdmissao = formatter.parse(admissao);
            } catch (ParseException ex) {
                Logger.getLogger(TelaCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            control.alterarPessoa(this.getIdPessoa(),
                    jTextFieldNome.getText(),
                    jTextFieldTelefone.getText(),
                    jTextFieldCEP.getText(),
                    jTextFieldCidade.getText(),
                    jTextFieldRua.getText(),
                    Integer.parseInt(jTextFieldNumero.getText().toString().trim()),
                    jTextFieldBairro.getText(),
                    jTextFieldComplemento.getText(),
                    jTextFieldReferencia.getText(),
                    jComboBoxEstado.getSelectedItem().toString(),
                    buttonGroupTipoPessoa.getSelection().getMnemonic(),
                    jTextFieldCPF.getText(),
                    dataNascimento,
                    jComboBoxSexo.getSelectedItem().toString(),
                    jTextFieldCNPJ.getText(),
                    Double.parseDouble(jTextFieldSalario.getText().toString().trim()),
                    dataAdmissao
            );
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        this.cleanFields();
    }//GEN-LAST:event_jButtonExcluirActionPerformed
   
    public void cleanFields() {
        jTextFieldNome.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldCEP.setText("");
        jTextFieldCidade.setText("");
        jTextFieldRua.setText("");
        jTextFieldNumero.setText("");
        jTextFieldBairro.setText("");
        jTextFieldComplemento.setText("");
        jTextFieldReferencia.setText("");
        jComboBoxEstado.setSelectedIndex(0);
        jTextFieldCPF.setText("");
        jTextFieldDataNascimento.setText("");
        jComboBoxSexo.setSelectedIndex(0);
        jTextFieldCNPJ.setText("");
        jTextFieldSalario.setText("");
        jTextFieldAdmissao.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaCadastroPessoa dialog;
                try {
                    dialog = new TelaCadastroPessoa(new javax.swing.JFrame(), true);

                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(TelaCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoPessoa;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCEP;
    private javax.swing.JLabel jLabelCNPJ;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelDataAdmissao;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFormatoData;
    private javax.swing.JLabel jLabelFormatoData1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelFornecedor;
    private javax.swing.JPanel jPanelInformacoesGerais;
    private javax.swing.JPanel jPanelTelaCadastroPessoa;
    private javax.swing.JPanel jPanelTipoPessoa;
    private javax.swing.JPanel jPanelVendedor;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JRadioButton jRadioButtonFornecedor;
    private javax.swing.JRadioButton jRadioButtonVendedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAdmissao;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCEP;
    private javax.swing.JTextField jTextFieldCNPJ;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldReferencia;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSalario;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
