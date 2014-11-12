package model;
// Generated 12/11/2014 11:14:00 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pessoafisica generated by hbm2java
 */
public class Pessoafisica  implements java.io.Serializable {


     private Integer idPessoaFisica;
     private Pessoa pessoa;
     private String sexo;
     private String dataNascimento;
     private String cpf;
     private Set vendas = new HashSet(0);
     private Set vendedors = new HashSet(0);

    public Pessoafisica() {
    }

	
    public Pessoafisica(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Pessoafisica(Pessoa pessoa, String sexo, String dataNascimento, String cpf, Set vendas, Set vendedors) {
       this.pessoa = pessoa;
       this.sexo = sexo;
       this.dataNascimento = dataNascimento;
       this.cpf = cpf;
       this.vendas = vendas;
       this.vendedors = vendedors;
    }
   
    public Integer getIdPessoaFisica() {
        return this.idPessoaFisica;
    }
    
    public void setIdPessoaFisica(Integer idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Set getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set vendas) {
        this.vendas = vendas;
    }
    public Set getVendedors() {
        return this.vendedors;
    }
    
    public void setVendedors(Set vendedors) {
        this.vendedors = vendedors;
    }




}

