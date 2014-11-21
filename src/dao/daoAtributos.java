/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Categoria;
import model.Fornecedor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Matheus Claudino
 */
public class daoAtributos {

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
}
