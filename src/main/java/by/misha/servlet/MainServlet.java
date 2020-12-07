package by.misha.servlet;

import by.misha.dao.StudentDao;
import by.misha.dao.StudentDaoImpl;
import by.misha.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private StudentDao students;
    private List<Integer> links;
    private List<Student> studentList;

    @Override
    public void init() throws ServletException {
        super.init();
        students = new StudentDaoImpl();
        studentList = students.findAll();
        setLinks();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int from = 0;
        int to = 10;
        List<Student> subStudent;
        studentList = students.findAll();
        if(links!=null&&studentList.size()>links.size()*10)
            setLinks();
        String link;
        if ((link = req.getParameter("link")) != null) {
            from = Integer.parseInt(link) * 10;
            to = (Integer.parseInt(link) + 1) * 10;
        }
        if (to > studentList.size())
            subStudent = studentList.subList(from, studentList.size());
        else
            subStudent = studentList.subList(from, to);
        req.setAttribute("studs", subStudent);
        req.setAttribute("links", links);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    private void setLinks() {
        links = new ArrayList<>();
        for (int i = 0, j = 0; i < studentList.size(); i += 10, j++)
            links.add(j);
    }

}
