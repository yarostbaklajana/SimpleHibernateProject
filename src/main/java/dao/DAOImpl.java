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
    public List<String> getGroupList() {
        Query query = entitymanager.createQuery("Select g.groupName FROM UniverGroup g");
        List<String> list = query.getResultList();
        return list;
    }

    @Override
    public void deleteGroup() {

    }
}
