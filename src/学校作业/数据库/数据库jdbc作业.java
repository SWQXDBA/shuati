package 学校作业.数据库;

import java.time.LocalDate;

public class 数据库jdbc作业 {


    public static void main(String[] args) {
        System.out.println("增加");
        //初始化表数据
        MyJdbcUtil.update("truncate table goods");
        MyJdbcUtil.update("insert into goods (name,madetime,price) values(?,?,?)",
                "鞋子", LocalDate.now(),100);
        MyJdbcUtil.update("insert into goods (name,madetime,price) values(?,?,?)",
                "帽子", LocalDate.now(),50);
        System.out.println(MyJdbcUtil.query("select * from goods", Good.class));
        System.out.println("修改");
        MyJdbcUtil.update("update goods set price = ? where name = ?",666,"鞋子");
        System.out.println(MyJdbcUtil.query("select * from goods", Good.class));
        System.out.println("删除");
        MyJdbcUtil.update("delete from goods where name like ? ","_子");
        System.out.println(MyJdbcUtil.query("select * from goods", Good.class));

    }
}
