package dao;

import entities.UniverGroup;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
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
