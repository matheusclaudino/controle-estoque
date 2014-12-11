/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Categoria;
import model.Cor;
import model.Estampa;
import model.Fornecedor;
import model.Produto;
import model.Tamanho;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Matheus Claudino
 */
public class daoProduto {

    public void insert(Produto produto) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(produto);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void update(Produto produto) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.update(produto);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void delete(Produto produto) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.delete(produto);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public Produto getProduto(int id) {
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Produto produto = (Produto) sessao.get(Produto.class, new Integer(id));
            //System.out.println(produto.getCategoria().getNome());
            sessao.getTransaction().commit();
            sessao.close();
            return produto;

        } catch (HibernateException he) {
            System.out.println("Erro de inserção do PRODUTO : " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de inserção do PRODUTO : " + he.getMessage());
            return null;
        }
    }

    public List getNome(String nome) {
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            //HQL
            //List<Cliente> res = sessao.createQuery("from Cliente cli JOIN FETCH cli.cidade ").list();
            // CRITERIA
            Criteria cons = sessao.createCriteria(Produto.class);
            cons.setFetchMode("fornecedor", FetchMode.JOIN);
            cons.setFetchMode("categoria", FetchMode.JOIN);
            cons.setFetchMode("cor", FetchMode.JOIN);
            cons.setFetchMode("estampa", FetchMode.JOIN);
            cons.setFetchMode("tamanho", FetchMode.JOIN);

            cons.add(Restrictions.like("nome", nome + "%"));

            cons.addOrder(Order.asc("nome"));

            List<Produto> res = cons.list();

            sessao.getTransaction().commit();
            sessao.close();
            return res;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro ao listar os PRODUTOS: " + he.getMessage());
            return null;
        }
    }
    
    public Fornecedor getFornecedor(int idFornecedor){
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Fornecedor fornecedor = (Fornecedor) sessao.get(Fornecedor.class, new Integer(idFornecedor));
            
            sessao.getTransaction().commit();
            sessao.close();
            return fornecedor;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DO FORNECEDOR: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta de FORNECEDOR: " + he.getMessage());
            return null;
        }
    }
    
    public Categoria getCategoria(int idCategoria){
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Categoria categoria = (Categoria) sessao.get(Categoria.class, new Integer(idCategoria));
            
            sessao.getTransaction().commit();
            sessao.close();
            return categoria;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DO CATEGORIA: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta de CATEGORIA: " + he.getMessage());
            return null;
        }
    }
    
    public Tamanho getTamanho(int idTamanho){
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Tamanho tamanho = (Tamanho) sessao.get(Tamanho.class, new Integer(idTamanho));
            
            sessao.getTransaction().commit();
            sessao.close();
            return tamanho;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DO TAMANHO: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta de TAMANHO: " + he.getMessage());
            return null;
        }
    }
    
    public Cor getCor(int idCor){
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Cor cor = (Cor) sessao.get(Cor.class, new Integer(idCor));
            
            sessao.getTransaction().commit();
            sessao.close();
            return cor;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DO COR: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta de COR: " + he.getMessage());
            return null;
        }
    }
    
    public Estampa getEstampa(int idEstampa){
        Session sessao = null;
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
 
            Estampa estampa = (Estampa) sessao.get(Estampa.class, new Integer(idEstampa));
            
            sessao.getTransaction().commit();
            sessao.close();
            return estampa;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DA ESTAMPA: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta de ESTAMPA: " + he.getMessage());
            return null;
        }
    }
    public List<Produto> listarProduto() throws Exception {

        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Produto> resultado = sessao.createCriteria(Produto.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar Produto: " + he.getMessage());
            return null;
        }
    }
}
