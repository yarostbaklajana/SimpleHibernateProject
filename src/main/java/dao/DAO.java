package dao;

import java.util.List;

/**
 * Created by yaros on 09.02.2016.
 */
public interface DAO {
    void createGroup(String groupName);

    List<String> getGroupList();
}
