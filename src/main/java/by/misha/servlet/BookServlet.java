package by.misha.servlet;

import by.misha.dao.BookDao;
import by.misha.dao.BookDaoImpl;
import by.misha.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    private List<Book> books;
    private List<Integer> links;
    private BookDao bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int from = 0;
        int to = 10;
        List<Book> subBooks;
        Integer idStudent = Integer.parseInt(req.getParameter("id"));
        books = bookDao.findAllBooksStudent(idStudent);
        setLinks();
        String link;
        if ((link = req.getParameter("link")) != null) {
            from = Integer.parseInt(link) * 10;
            to = (Integer.parseInt(link) + 1) * 10;
        }
        if (to > books.size())
            subBooks = books.subList(from, books.size());
        else
            subBooks = books.subList(from, to);
        req.setAttribute("books",subBooks);
        req.setAttribute("links",links);
        req.getRequestDispatcher("/book.jsp").forward(req, resp);
    }

    private void setLinks() {
        links = new ArrayList<>();
        for (int i = 0, j = 0; i < books.size(); i += 10, j++)
            links.add(j);
    }
}
