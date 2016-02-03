package dao;

import entities.UniverGroup;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

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

}
