import java.sql.*;

public class ConnectAccess {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=G:\\编程课程和资料\\源码前端后端整改文档\\图书借阅系统第三方\\数据库\\MpTsg.mdb";
            Connection con = DriverManager.getConnection(url, "admin", "zywtsggl");//没有用户名和密码的时候直接为空
            Statement sta = con.createStatement();
            ResultSet rst = sta.executeQuery("select * from book");//demoTable为access数据库中的一个表名
            if (rst.next()) {
                System.out.println("纯java代码实现:" + rst.getString("book_vcmc"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
