package com.sunxiaoyu.calculate;

import org.apache.ibatis.session.*;

import java.io.InputStream;

/**
 * Created by sun on 15/11/12.
 */
public class Bootstrap {
    public static void main(String[] args) {
        String resource = "config/mybatis-configuration.xml";
        InputStream is = Bootstrap.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        session.select("getCalculationRecordByID", 1, new ResultHandler() {
            public void handleResult(ResultContext resultContext) {
                System.out.println(resultContext);
            }
        });


        session.close();
    }
}
