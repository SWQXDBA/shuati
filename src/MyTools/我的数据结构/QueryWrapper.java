package MyTools.我的数据结构;

import java.io.IOException;
import java.nio.file.Files;

class Student {
    Long id;
    String name;
    Integer age;
    String sex;
}
public class QueryWrapper {
    String sql = "";
    public QueryWrapper selectFrom(String tableName){
        sql+="select from "+tableName+" where 1 = 1 ";
        return this;
    }
    public QueryWrapper equalIfPresent(String field, Object value){
        if (value != null) {
            sql+=" and "+field+" = "+value;
        }
        return this;
    }
    public QueryWrapper greaterThanIfPresent(String field, Object value){
        if (value != null) {
            sql+=" and "+field+" > "+value;
        }
        return this;
    }
    public QueryWrapper lessThanIfPresent(String field, Object value){
        if (value != null) {
            sql+=" and "+field+" < "+value;
        }
        return this;
    }
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        student.name = "小明";
        student.age = 10;



        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.selectFrom("student")
                .equalIfPresent("name",student.name)
                .greaterThanIfPresent("age",student.age)
                .equalIfPresent("sex",student.sex);
        System.out.println(queryWrapper.sql);

    }

    public static Student queryStudent(Student example) {
        String sql = "select * from student where 1 = 1";
        if (example.id != null) {
            sql += " and id =" + example.id;
        }
        if (example.name != null) {
            sql += " and name = " + example.name;
        }
        if (example.age != null) {
            sql += " and age = " + example.age;
        }
        if (example.sex != null) {
            sql += " and sex = " + example.sex;
        }
        System.out.println(sql);
        //根据对数据库发出sql查询
        return null;
    }
}
