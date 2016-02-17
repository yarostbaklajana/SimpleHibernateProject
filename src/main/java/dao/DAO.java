package dao;

import entities.UniverGroup;

import java.util.List;

public interface DAO {
    void createGroup(String groupName);

    void deleteGroup(int id);

    List<UniverGroup> getGroupList();
}
