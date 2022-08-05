package Spring.WAS.Servlet.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class calcServlet extends HttpServlet {



/*    두개 엮어서 사용
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // Post 방식은 읽어올 때, URL로 읽어오는게 아니므로, 인코딩 명시해줘야 한다.
    req.setCharacterEncoding("utf-8");
    doGet(req, resp); }
*/


        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();

            System.out.println(req.getMethod());

        // 요청클라이언트의 ip
        System.out.println(req.getRemoteAddr());

//        String user = req.getParameter("user");

  //      System.out.println(user);

//        resp.getWriter().println(user);


        String su1str = req.getParameter("su1");
        String su2str = req.getParameter("su2");



        if (su1str == null || su1str.equals("")
        || su2str == null || su2str.equals("")){
                writer.println("<a href ='calc.html'>다시입력하세요</a>");

                return;
            }


        int su1 = Integer.parseInt(su1str);
        int su2 = Integer.parseInt(su2str);

        String op = req.getParameter("op");

        String result = "";
        if (op.equals("+")) {
            result = su1 + op + su2 + " = " + (su1+su2);
        } else if (op.equals("-")) {
            result = su1 + op + su2 + " = " + (su1-su2);
        } else if (op.equals("*")) {
            result = su1 + op + su2 + " = " + (su1*su2);
        } else if (op.equals("/")) {
            result = su1 + op + su2 + " = " + (su1/su2);
        } else if (op.equals("%")) {
            result = su1 + op + su2 + " = " + (su1%su2);
        } else {
            result = "지원하지 않습니다.";}

        writer.println(result);
    }
}
