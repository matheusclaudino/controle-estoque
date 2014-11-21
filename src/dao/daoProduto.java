/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Matheus Claudino
 */
public class daoProduto {
    public void insert(Produto produto){
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
}
