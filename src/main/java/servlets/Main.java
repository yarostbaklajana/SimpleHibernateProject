package servlets;

import dao.DAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/")
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        DAO dao = new DAO();
        dao.createGroup("FormGroup");
        try {

            out = response.getWriter();
            out.print("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
