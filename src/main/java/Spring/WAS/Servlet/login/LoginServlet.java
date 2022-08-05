package Spring.WAS.Servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String role = req.getParameter("role");

        String output = "";
        if (role.equals("admin")) {
            output = id + " 관리자님 로그인 되셨습니다.";
            output += "<ul><li>모든 사용자 정보 조회</li>";
            output += "<li>돈 회수</li>";
            output += "<li>서비스 관리</li></ul>";


        }else if(role.equals("user")){
            output = id + "사용자님 환영합니다!";
            output += "<ul><li>내 정보 조회</li>";
            output += "<li>돈 지불</li>";
            output += "<li>라면 소환</li></ul>";

        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(output);


    }
}
