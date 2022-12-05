package servlet;

import dao.UserDao;
import models.Note;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNote extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();

        String username = (String) req.getSession().getAttribute("sessionname");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int purview = Integer.parseInt(req.getParameter("root"));


        userDao.addNote(new Note(username,title,content,purview));
        resp.sendRedirect("/printusernote");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
