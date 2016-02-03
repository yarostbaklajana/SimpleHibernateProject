package dao;

import entities.UniverGroup;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Named("dao")
@SessionScoped
public class DAO implements Serializable{
    private static final long serialVersionUID = 3L;
    private EntityManagerFactory emfactory;
    private EntityManager entitymanager;

    public DAO() {
        emfactory = Persistence.createEntityManagerFactory("yarostbaklajana.Group");
        entitymanager = emfactory.createEntityManager( );
    }

    public void createGroup(String groupName) {
        entitymanager.getTransaction( ).begin();
        UniverGroup group = new UniverGroup();
        group.setGroupName(groupName);
        entitymanager.persist(group);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }

    public List<String> getGroupList() {
        Query query = entitymanager.createQuery("Select g.groupName FROM UniverGroup g");
        List<String> list = query.getResultList();
        return list;
    }

}
