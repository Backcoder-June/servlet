package Spring.WAS.Servlet.login.Service;

import Spring.WAS.Servlet.login.DAO.servletMember_DAO;
import Spring.WAS.Servlet.login.DTO.servletmember_DTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/join")
public class JoinService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //doPost 에서 첫문장으로 쓰자.
        req.setCharacterEncoding("utf-8");
        //이건 공용으로 처음에 셋팅
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();


        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");

        // MVC 처럼 바로 받아와주는 DTO는 아닌데, 그냥 한번에 편하게 객체로 넘기는 용도
        servletmember_DTO dto = new servletmember_DTO(id, pw, name);

        servletMember_DAO dao = new servletMember_DAO();

        int condition = dao.selectMember(id, pw);

        // select 할때 id pw 없는 경우
        if (condition==3) {
            dao.joinMember(dto);
            writer.println("회원가입이 완료되었습니다");
        } else { writer.println("이미 가입된 회원입니다.");
        }

        writer.println("<br>");
        writer.println("<a href ='login.html'>로그인하러 가기</a>");


    }
}
