package com.sunxiaoyu.calculate.controller;

import com.sunxiaoyu.calculate.dao.CalculationDao;
import com.sunxiaoyu.calculate.model.CalculationRecordModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by sun on 15/11/14.
 */
public class CalculateRecordController {
    public static void main(String[] args) {

        ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("config/spring/local/context-mybatis.xml");
        CalculationDao calculationDao = (CalculationDao) ctx.getBean("calculationDao");
        //添加一条数据
        CalculationRecordModel model = new CalculationRecordModel();
        model.setCreatedTime(new Date());
        model.setCurrentNumber(1.0);
        model.setPreNumber(2.0);
        model.setOperator("*");
        model.setResult(3.0);
        model.setStatus(1);
        model.setMacAddress("pc1");
        calculationDao.insertCalculationRecord(model);
        System.out.println("添加成功");
    }
}
