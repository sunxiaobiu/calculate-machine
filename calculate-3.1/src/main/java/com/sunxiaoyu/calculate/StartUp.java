package com.sunxiaoyu.calculate;

import com.sunxiaoyu.calculate.dao.CalculationDao;
import com.sunxiaoyu.calculate.model.CalculationRecordModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * Created by sun on 15/11/14.
 */
public class StartUp {

    String resource = "config/mybatis-configuration.xml";
    InputStream is = Bootstrap.class.getClassLoader().getResourceAsStream(resource);
    private SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

    /**
     * 测试新增
     */
    @Test
    public void insert() {
        SqlSession session = null;
        try {
            CalculationRecordModel model = new CalculationRecordModel();
            model.setCreatedTime(new Date());
            model.setCurrentNumber(1.0);
            model.setPreNumber(2.0);
            model.setOperator("*");
            model.setResult(3.0);
            model.setStatus(1);
            model.setMacAddress("pc1");
            session = sessionFactory.openSession();
            CalculationDao calculationDao = session.getMapper(CalculationDao.class);
            //calculationDao.insertCalculationRecord(model);
            List<Integer> Ids = new ArrayList<Integer>();
            Ids.add(3);
            Ids.add(4);
            //int[] Ids = {1,2};
            List<CalculationRecordModel> modelList = calculationDao.getCalculationRecordByID(Ids);
            for (CalculationRecordModel calculationRecordModel : modelList) {
                System.out.println(calculationRecordModel);
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
    }


}
