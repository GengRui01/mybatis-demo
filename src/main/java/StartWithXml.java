import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName StartNoXml
 * @Description 编程式配置MyBatis
 * @Author GengRui
 * @Date 2021/3/9 15:59
 */
@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "Duplicates"})
public class StartWithXml {
    public static void main(String[] args) throws IOException, SQLException {
        // 读取配置文件
        InputStream configuration = Resources.getResourceAsStream("mybatis-config.xml");
        // 得到 SqlSessionFactory 核心类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 开始一个 sql 会话
        SqlSession session = sqlSessionFactory.openSession();
        // 得到 sql 连接并运行 sql 语句
        PreparedStatement preStatement = session
                .getConnection()
                .prepareStatement("SELECT * FROM user WHERE id = ?");
        preStatement.setInt(1, 1);
        ResultSet result = preStatement.executeQuery();
        // 验证结果
        while (result.next()) {
            System.out.println("username: " + result.getString("username"));
            System.out.println("age: " + result.getString("age"));
        }
        // 关闭会话
        session.close();
    }
}
