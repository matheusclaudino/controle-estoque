/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.Iterator;
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

            sessao.update(pes.getEndereco());
            sessao.update(pes);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
        }
    }

    public void alterarEndereco(Endereco ender) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.update(ender);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException he) {
            System.out.println(he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
        }
    }

    public Pessoa getPessoa(int id) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Pessoa pessoa = (Pessoa) sessao.get(Pessoa.class, new Integer(id));

            sessao.getTransaction().commit();
            sessao.close();
            return pessoa;

        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
            System.out.println("Erro ao tentar pegar a Pessoa: " + he.getMessage());
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
            } else if (tipo == 'V') {
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

            //IMPEDE QUE A LISTA DE CLIENTES SE MISTURE COM A DE VENDEDORES
            if (tipo == 'C') {
                Pessoa pes = null;
                Pessoa pesFiltro = null;
                List<Pessoa> listaFiltro = this.consultaPessoa('V'); 

                Iterator<Pessoa> itListaFiltro = listaFiltro.iterator();
                Iterator<Pessoa> itLista = lista.iterator();
                //   int i = 0;
                while (itLista.hasNext() && itListaFiltro.hasNext()) {
                    pes = itLista.next();
                    pesFiltro = itListaFiltro.next();
                    if (pesFiltro.getIdPessoa() == pes.getIdPessoa()) {
                        itLista.remove();
                    }
                }
            }
            //IMPEDE QUE A LISTA DE CLIENTES SE MISTURE COM A DE VENDEDORES
            
            return lista;
        }
    }

    public Endereco getEndereco(int idEndereco) {
        Session sessao = null;

        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Endereco endereco = (Endereco) sessao.get(Endereco.class, new Integer(idEndereco));

            sessao.getTransaction().commit();
            sessao.close();
            return endereco;

        } catch (HibernateException he) {
            System.out.println("Erro de CONSULTA DO ENDERECO: " + he.getMessage());
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("Erro de consulta do ENDERECO: " + he.getMessage());
            return null;
        }
    }

    public List<Vendedor> listarVendedor() throws SQLException, Exception {

        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            List<Vendedor> resultado = sessao.createCriteria(Vendedor.class).list();

            sessao.getTransaction().commit();
            sessao.close();
            return resultado;
        } catch (HibernateException he) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            System.out.println("ERRO listar Vendedor: " + he.getMessage());
            return null;
        }
    }

}
