package Spring.WAS.Servlet.login.Service;

import Spring.WAS.Servlet.login.DAO.servletMember_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    servletMember_DAO dao = new servletMember_DAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String role = req.getParameter("role");


        int condition = dao.selectMember(id, pw);

        String output = "";

        if (condition == 2) {

            if (role.equals("admin")) {
                output = id + " 관리자님 로그인 되셨습니다.";
                output += "<ul><li>모든 사용자 정보 조회</li>";
                output += "<li>돈 회수</li>";
                output += "<li>서비스 관리</li></ul>";


            } else if (role.equals("user")) {
                output = id + "사용자님 환영합니다!";
                output += "<ul><li>내 정보 조회</li>";
                output += "<li>돈 지불</li>";
                output += "<li>라면 소환</li></ul>";
            }
        } else if(condition == 1 ){
            output = "비밀번호가 일치하지않습니다";
        }
        else{
            output = "<a href = 'join.html'>회원가입이 필요합니다</a>";}

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(output);


    }
}
