/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Endereco;
import model.Fornecedor;
import model.Pessoa;
import model.Pessoafisica;
import model.Vendedor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Matheus Claudino
 */
public class daoPessoa {

    public void inserir(Pessoa pes) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(pes);
            System.out.println("lol");
            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    
    public void inserirEndereco(Endereco pes) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(pes);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void excluir(Pessoa pes) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.delete(pes);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void alterar(Pessoa pes) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.update(pes);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public Pessoa getPessoa(Pessoa pes, int id) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Pessoa pessoa = (Pessoa) sessao.get( Pessoa.class, new Integer(id) );
        
            sessao.getTransaction().commit(); 
            sessao.close();
            return pessoa;
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
            System.out.println("Erro ao tentar pegar a Pessoa: " + he.getMessage() );
        } finally {
            if (sessao != null) {
                sessao.close();
            }
            return null;
        }
    }

    public List consultaPessoa(int tipo) {
        Session sessao = null;
        List<Pessoa> lista = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Criteria consulta = null;
            if (tipo == 'C') {
                consulta = sessao.createCriteria(Pessoafisica.class);
            } else if (tipo == 'F') {
                consulta = sessao.createCriteria(Fornecedor.class);
            } else if (tipo == 'V'){
                consulta = sessao.createCriteria(Vendedor.class);
            }

            lista = consulta.list();

            sessao.getTransaction().commit();

        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
            return lista;
        }
    }

}
