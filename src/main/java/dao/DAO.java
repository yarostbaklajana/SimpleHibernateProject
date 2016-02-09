package dao;

import java.util.List;

public interface DAO {
    void createGroup(String groupName);

    List<String> getGroupList();
}
