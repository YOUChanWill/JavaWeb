package servlet;

import dao.PrintDao;
import models.Note;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintUserNote extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = (String) req.getSession().getAttribute("sessionname");

        req.getSession().setAttribute("UserNoteList", new PrintDao().searchNote(new Note(username)));
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
