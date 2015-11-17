package com.sunxiaoyu.calculate;

import com.sunxiaoyu.calculate.model.CalculationRecordModel;
import org.apache.ibatis.session.*;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by sun on 15/11/12.
 */
public class Bootstrap {
    public static void main(String[] args) {

        CalculationRecordModel model = new CalculationRecordModel();
        model.setCreatedTime(new Date());
        model.setCurrentNumber(1.0);
        model.setPreNumber(2.0);
        model.setOperator("*");
        model.setResult(3.0);
        model.setStatus(1);
        model.setMacAddress("pc1");

        String resource = "config/mybatis-configuration.xml";
        InputStream is = Bootstrap.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        CalculationRecordModel calculationRecordModel = session.selectOne("CalculationRecordModel.getCalculationRecordByID", 1);
        System.out.println(calculationRecordModel + "getCalculationRecordByID success!");

        CalculationRecordModel calRecordModel = session.selectOne("CalculationRecordModel.getCalculationRecordByMacAddress", "sun");
        System.out.println(calRecordModel + "getCalculationRecordByMacAddress success!");

        session.insert("CalculationRecordModel.insertCalculationRecord", model);
        System.out.println("insertCalculationRecord success!");

        session.delete("CalculationRecordModel.deleteCalculationRecord", model.getID());
        System.out.println("delete operationRecord success!");

        session.update("CalculationRecordModel.updateCalculationRecord", model);
        System.out.println("update operationRecord success!");

        session.close();
    }
}
