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
import java.util.ArrayList;
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
    
    private String pegarChavePrimaria(Class classe) {
        if(classe == MclClientes.class) {
            return "mclIdClientes";
        } else if(classe == MclProdutos.class) {
            return "mclIdProdutos";
        } else if(classe == MclUsuarios.class) {
            return "mclIdUsuarios";
        } else if(classe == MclVendas.class) {
            return "mclIdVendas";
        } else if(classe == MclVendasProdutos.class) {
            return "mclIdVendasProdutos";
        } else if(classe == MclVendedor.class) {
            return "mclIdVendedor"; 
        } else {
            throw new Error("bean invalido");
        }
    }
    
    @Override
    public Object list(Object bean, int codigo) {
        session.beginTransaction();
        Class classe = bean.getClass();
        String chave_primaria = pegarChavePrimaria(classe);
        Criteria criteria = session.createCriteria(classe);
        criteria.add(Restrictions.eq(chave_primaria, codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.isEmpty() ? null : lista.get(0);
    }
    
    @Override
    public ArrayList listAll(Object bean) {
        session.beginTransaction();
        Class classe = bean.getClass();
        pegarChavePrimaria(classe); //valida o bean passado
        Criteria criteria = session.createCriteria(classe);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }
    
    public Object listProdutos(MclVendas bean) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MclVendasProdutos.class);
        criteria.add(Restrictions.eq("mclVendas", bean));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public boolean autenticar(Object bean) {
        if(!(bean instanceof MclUsuarios)) throw new Error("bean invalido bobão");
        MclUsuarios usuario = (MclUsuarios) bean;
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MclUsuarios.class);
        criteria.add(Restrictions.and(Restrictions.eq("mclApelido", usuario.getMclNome()),Restrictions.eq("mclSenha", usuario.getMclSenha())));
        List lista = criteria.list();
        session.getTransaction().commit();
        return !lista.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println("Criando novo usuario");
        DaoGeneric teste = new DaoGeneric();
        MclUsuarios usuario = new MclUsuarios();
        usuario.setMclIdUsuarios(10000);
        usuario.setMclApelido("https://www.youtube.com/watch?v=-cGE6YMxsZc");
        usuario.setMclAtivo(1);
        usuario.setMclCpf("000.111.222-33");
        usuario.setMclDataNascimento(tools.Mcl_Util.strToDate("02/03/2077"));
        usuario.setMclNivel("Cliente");
        usuario.setMclNome("https://www.youtube.com/watch?v=Z-n9WEItZh8");
        usuario.setMclSenha("https://www.youtube.com/watch?v=L5q4uYj-gyg");
        MclUsuarios jaexiste = (MclUsuarios) teste.list((new MclUsuarios()), 10000);
        if(jaexiste != null) {
            System.out.println("Usuario 10000 ja existe, apagando");
            teste.delete(usuario);
        }
        System.out.println("Criando novo usuario 10000");
        teste.insert(usuario);
        
        System.out.println(teste.list(new MclUsuarios(), 10000));
        System.out.println(teste.listAll(new MclUsuarios()));
        usuario.setMclNivel("ultrakill");
        teste.update(usuario);
        System.out.println("Novo nivel:" +((MclUsuarios) teste.list(new MclUsuarios(), 10000)).getMclNivel());
        teste.delete(usuario);
        System.out.println(teste.listAll(new MclUsuarios()));
    }
}
