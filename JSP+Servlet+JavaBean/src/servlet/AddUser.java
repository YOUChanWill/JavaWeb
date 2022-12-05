package servlet;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        userDao.addUser(new User(username,password));

        req.getRequestDispatcher("/printuser").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
