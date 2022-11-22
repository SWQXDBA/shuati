package 学校作业.数据库;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyJdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String mysqlUrl = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    static String username = "root";
    static String password = "root";

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(mysqlUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static PreparedStatement getPreparedStatement(String sql, Object... params) {
        PreparedStatement statement = null;
        try {
            statement = Objects.requireNonNull(getConnection()).prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i+1, params[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static int update(String sql, Object... params) {
        try {
            return  getPreparedStatement(sql,params).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static <T> List<T> query(String sql, Class<T> type,Object... params) {
        try {
            final ResultSet resultSet = getPreparedStatement(sql, params).executeQuery();
            final List<Field> fields = List.of(type.getDeclaredFields());
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                //使用反射注入属性
                final T resultObj = type.getDeclaredConstructor().newInstance();
                for (Field field : fields) {
                    final Object filedValue = resultSet.getObject(field.getName().toLowerCase());
                    field.setAccessible(true);
                    field.set(resultObj,filedValue);
                }
                result.add(resultObj);
            }
            return result;
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return List.of();
    }
}
