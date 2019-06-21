package df.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Dao {
    static SqlSessionFactory factory = null;

    static {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            String path = System.getProperty("user.dir")+ File.separator+"config"+File.separator+"mybatis.xml";
            InputStream is = new FileInputStream(new File(path));
            factory = builder.build(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return factory.openSession();
    }

    public static void closeSession(SqlSession sqlSession){
        sqlSession.close();
    }
}
