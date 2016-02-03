package entities;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "univergroup")
public class UniverGroup implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String groupName;

    public UniverGroup() {

    }

    public  UniverGroup(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;

    }

    public String toString() {
        return this.getId() + " - " + this.getGroupName();
    }
}
