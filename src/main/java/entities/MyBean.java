package entities;

import sun.net.www.http.KeepAliveStream;

import javax.enterprise.context.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("myBean")
@javax.enterprise.context.SessionScoped
public class MyBean implements Serializable{
    private static final long serialVersionUID = 2L;

    public void myMethod(String str) {
        System.out.print(str);
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
