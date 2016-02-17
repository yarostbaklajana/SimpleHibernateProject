package controllers;

import dao.DAO;
import entities.UniverGroup;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("controller")
@RequestScoped
public class ComponentController implements Serializable{
    private static final long serialVersionUID = 4L;
    private DAO dao;

    @Inject
    public ComponentController(DAO dao) {
        this.dao = dao;
    }


    public List<String> getListOfGroups() {
        return dao.getGroupList();
    }

    public void createGroup(String groupName) {
        dao.createGroup(groupName);
    }
}
