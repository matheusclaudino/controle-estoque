 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Venda;
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
public class daoVenda {
    public void inserir(Venda venda) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.save(venda);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }
    
    public List<Venda> getVenda() {
        Session sessao = null;
        String nome = "";
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            //HQL
            //List<Cliente> res = sessao.createQuery("from Cliente cli JOIN FETCH cli.cidade ").list();
            // CRITERIA
            Criteria cons = sessao.createCriteria(Venda.class);
            cons.setFetchMode("produto", FetchMode.JOIN);
            cons.setFetchMode("vendedor", FetchMode.JOIN);

            //cons.add(Restrictions.like("idVenda", nome + "%"));

            cons.addOrder(Order.asc("idVenda"));

            List<Venda> res;
            res = cons.list();

            sessao.getTransaction().commit();
            sessao.close();
            return res;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro ao listar as VENDAS: " + he.getMessage());
            return null;
        }
    }
    
    public void delete(Venda venda) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.delete(venda);

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
