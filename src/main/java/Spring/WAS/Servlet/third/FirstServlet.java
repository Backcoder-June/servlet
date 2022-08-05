package Spring.WAS.Servlet.third;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// localhost:8080/Servlet/fisrt
// url 별명
@WebServlet(name = "asdf", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().append("Served at : ").append(req.getContextPath());

        resp.getWriter().println("<h1>title</h1>");

    }
}
