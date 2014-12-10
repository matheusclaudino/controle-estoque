package model;
// Generated 21/11/2014 10:23:45 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Produto generated by hbm2java
 */
public class Produto  implements java.io.Serializable {


     private int codigo;
     private Categoria categoria;
     private Cor cor;
     private Estampa estampa;
     private Fornecedor fornecedor;
     private Tamanho tamanho;
     private String nome;
     private String descricao;
     private int quantidade;
     private BigDecimal preco;
     private Date data;
     private Set vendas = new HashSet(0);

    public Produto() {
    }

	
    public Produto(int codigo, Categoria categoria, Cor cor, Estampa estampa, Fornecedor fornecedor, Tamanho tamanho, String nome, String descricao, int quantidade, BigDecimal preco, Date data) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.cor = cor;
        this.estampa = estampa;
        this.fornecedor = fornecedor;
        this.tamanho = tamanho;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
    }
    public Produto(int codigo, Categoria categoria, Cor cor, Estampa estampa, Fornecedor fornecedor, Tamanho tamanho, String nome, String descricao, int quantidade, BigDecimal preco, Date data, Set vendas) {
       this.codigo = codigo;
       this.categoria = categoria;
       this.cor = cor;
       this.estampa = estampa;
       this.fornecedor = fornecedor;
       this.tamanho = tamanho;
       this.nome = nome;
       this.descricao = descricao;
       this.quantidade = quantidade;
       this.preco = preco;
       this.data = data;
       this.vendas = vendas;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Cor getCor() {
        return this.cor;
    }
    
    public void setCor(Cor cor) {
        this.cor = cor;
    }
    public Estampa getEstampa() {
        return this.estampa;
    }
    
    public void setEstampa(Estampa estampa) {
        this.estampa = estampa;
    }
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Tamanho getTamanho() {
        return this.tamanho;
    }
    
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getPreco() {
        return this.preco;
    }
    
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public Set getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set vendas) {
        this.vendas = vendas;
    }
    
     @Override
    public String toString(){
        return String.valueOf(this.codigo);
    }

    public Object[] toArray() {
        return new Object[] {this, this.nome,this.fornecedor,this.categoria
                , this.tamanho, this.cor, this.estampa, this.preco, this.quantidade };
    } 


}