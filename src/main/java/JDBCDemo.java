import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName JDBCDemo
 * @Description JDBC连接及操作数据库
 * @Author GengRui
 * @Date 2021/3/9 15:23
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis_demo", "root", "root");
        //3.获取Statement对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user WHERE id = ?");
        preparedStatement.setInt(1, 1);
        //4.执行SQL语句返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println("username: " + resultSet.getString("username"));
            System.out.println("age: " + resultSet.getString("age"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
