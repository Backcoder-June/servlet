package Spring.WAS.Servlet.login.DAO;

import Spring.WAS.Servlet.login.DTO.servletmember_DTO;

import java.sql.*;

public class servletMember_DAO {

    public int selectMember(String id, String userpw) {

        Connection con = null;

        int condition = 0;

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/backcoder", "backcoder", "1111");
            System.out.println("연결 완료!");

            String sql = "select id, pw from servletmember where id=?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1,id);
            ResultSet rs = pt.executeQuery();

            String dbid= null;
            String dbpw = null;
            if (rs.next()) {
                condition=1;

                dbid = rs.getString("id");
                dbpw = rs.getString("pw");

                if (dbpw.equals(userpw)) {
                    condition=2;
                }
            } else {condition = 3; }


        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }
        return condition;
    }


    public int joinMember(servletmember_DTO dto) {
        int condition = 0;

        Connection con = null;


        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://127.0.0.1:3306/backcoder", "backcoder", "1111");
            System.out.println("연결 완료!");

            String sql = "insert into servletmember values(?,?,?)";

            PreparedStatement pr = con.prepareStatement(sql);

            pr.setString(1,dto.getId());
            pr.setString(2,dto.getPw());
            pr.setString(3,dto.getName());

            int joinResult = pr.executeUpdate();

            condition = joinResult;

        } catch (SQLException e) {
            System.err.println("연결 오류" + e.getMessage());
            e.printStackTrace();
        }
        return condition;
    }






}
