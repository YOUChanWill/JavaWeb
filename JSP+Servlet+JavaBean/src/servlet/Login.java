package servlet;

import dao.PrintDao;
import dao.UserDao;
import models.Note;
import tools.DBTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;

public class Login extends HttpServlet {

    public static Note note;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (UserDao.Login(username,password)){

            note = new Note();

            note.setUsername(username);

            req.getSession().setAttribute("sessionname",username);

            if (username.equals("admin") ) {
                req.getRequestDispatcher("/printuser").forward(req, resp);
            } else{
                req.getRequestDispatcher("/printusernote").forward(req, resp);
            }

        }else{
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
