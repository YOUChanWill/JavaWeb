package servlet;

import dao.RootDao;
import dao.UserDao;
import models.Note;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoteRoot extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RootDao rootDao = new RootDao();

        String username = (String) req.getSession().getAttribute("sessionname");
        String title = req.getParameter("title");
        int purview = Integer.parseInt(req.getParameter("root"));

        rootDao.updateRoot(new Note(username,title,purview));
        resp.sendRedirect("/printusernote");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
