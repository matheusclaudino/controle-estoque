package model;
// Generated 20/11/2014 14:44:36 by Hibernate Tools 4.3.1

/**
 * Fornecedor generated by hbm2java
 */
public class Fornecedor  extends Pessoa {
    
     private String cnpj;

    public Fornecedor() {
    }
	
    public Fornecedor(Endereco endereco, String nome, String telefone, String cnpj) {
        super(endereco, nome, telefone);
        this.cnpj = cnpj;
    }
   
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
     public Object[] toArray(){
        return new Object[] {this.getIdPessoa(), this, this.cnpj};
    }
}


