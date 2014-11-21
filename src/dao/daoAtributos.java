/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Categoria;
import model.Cor;
import model.Estampa;
import model.Fornecedor;
import model.Tamanho;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Matheus Claudino
 */
public class daoAtributos {
    
    public void insertCor(Cor cor){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(cor);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    public void insertEstampa(Estampa estampa){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(estampa);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    public void insertCategoria(Categoria categoria){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(categoria);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    public void insertTamanho(Tamanho tamanho){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(tamanho);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    
    public List<Fornecedor> listarFornecedor() throws SQLException, Exception {

        Session sessao = null;
        try {
            sessao = util.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Fornecedor> resultado = sessao.createCriteria(Fornecedor.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar CIDADE: " + he.getMessage());
            return null;
        }
    }

    public List<Categoria> listarCategoria() {
        Session sessao = null;
        try {
            sessao = util.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Categoria> resultado = sessao.createCriteria(Categoria.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar CIDADE: " + he.getMessage());
            return null;
        }
    }
     public List<Tamanho> listarTamanho() {
        Session sessao = null;
        try {
            sessao = util.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Tamanho> resultado = sessao.createCriteria(Tamanho.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar CIDADE: " + he.getMessage());
            return null;
        }
    }
     public List<Cor> listarCor() {
        Session sessao = null;
        try {
            sessao = util.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Cor> resultado = sessao.createCriteria(Cor.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar CIDADE: " + he.getMessage());
            return null;
        }
    }
      public List<Estampa> listarEstampa() {
        Session sessao = null;
        try {
            sessao = util.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Estampa> resultado = sessao.createCriteria(Estampa.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar CIDADE: " + he.getMessage());
            return null;
        }
    }
    
}
