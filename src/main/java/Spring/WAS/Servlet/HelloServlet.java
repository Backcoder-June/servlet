package Spring.WAS.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        PrintWriter out = resp.getWriter();

        out.println("<h1> 회원님 웰컴 </h1>");

        String username = req.getParameter("username");
        System.out.println("username = " + username);


        resp.setContentType("text/plain");

        resp.setCharacterEncoding("utf-8");

        resp.getWriter().write("hello" + username);

    }
}
