/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.MclClientes;
import bean.MclProdutos;
import bean.MclUsuarios;
import bean.MclVendas;
import bean.MclVendasProdutos;
import bean.MclVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author padero
 */
public class DaoGeneric extends DaoAbstract {
    
    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }
    
    @Override
    public void update(Object object){
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }
    
    
    @Override
    public void delete(Object object){
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }
    
    
}
