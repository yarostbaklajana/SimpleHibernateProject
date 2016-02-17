package dao;

import entities.UniverGroup;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;



public class DAOImpl implements Serializable, DAO {
    private static final long serialVersionUID = 3L;

    private EntityManagerFactory emfactory;
    private EntityManager entitymanager;

    public DAOImpl() {
        emfactory = Persistence.createEntityManagerFactory("yarosGroup");
        entitymanager = emfactory.createEntityManager( );
    }

    @Override
    public void createGroup(String groupName) {
        entitymanager.getTransaction( ).begin();
        UniverGroup group = new UniverGroup();
        group.setGroupName(groupName);
        entitymanager.persist(group);
        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UniverGroup> getGroupList() {
        Query query = entitymanager.createQuery("Select g FROM UniverGroup g");
        List<UniverGroup> list = query.getResultList();
        return (List<UniverGroup>) list;
    }

    @Override
    public void deleteGroup(int id) {
        entitymanager.getTransaction( ).begin();
        Query query = entitymanager.createNativeQuery("DELETE FROM UniverGroup WHERE id = " + id);
        query.executeUpdate();
        entitymanager.getTransaction().commit();
    }
}
