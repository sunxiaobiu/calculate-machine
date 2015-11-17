package com.sunxiaoyu.calculate.dao;

import com.sunxiaoyu.calculate.dao.lang.MybatisExtendedLanguageDriver;
import com.sunxiaoyu.calculate.model.CalculationRecordModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sun on 15/11/12.
 */
public interface CalculationDao {

    //public void insertCalculationRecord(CalculationRecordModel calculationRecord);

    //public void deleteCalculationRecord(CalculationRecordModel calculationRecord);

    //public void updateCalculationRecord(CalculationRecordModel calculationRecord);

    //public CalculationRecordModel getCalculationRecordByID(Integer calculationRecordID);

    //public CalculationRecordModel getCalculationRecordByMacAddress(String MacAddress);


//    @Select("<script>" +
//            "select * from OperationInfo where ID IN" +
//            "<foreach item='item' collection='IdList' open='(' separator=',' close=')'>" +
//            "#{item}" +
//            "</foreach>" +
//            "</script>")

    @Lang(MybatisExtendedLanguageDriver.class)
    @Select("select * from OperationInfo where ID IN (#{IdList})")
    public List<CalculationRecordModel> getCalculationRecordByID(@Param("IdList") List<Integer> IdList);

    @Select("select * from OperationInfo where MacAddress = #{macAddress}")
    public List<CalculationRecordModel> getCalculationRecordByMacAddress(String MacAddress);

    @Insert("insert into OperationInfo" +
            "(MacAddress,PreNumber,CurrentNumber,Operator,Result,CreatedTime,Status)" +
            "values(#{macAddress},#{preNumber},#{currentNumber},#{operator},#{result},#{createdTime},#{status})")
    public void insertCalculationRecord(CalculationRecordModel calculationRecord);

    @Update("update OperationInfo set " +
            "PreNumber=#{preNumber}," +
            "CurrentNumber=#{currentNumber}," +
            "Operator=#{operator}," +
            "Result=#{result}, " +
            "CreatedTime=#{createdTime}" +
            "Status=#{status}" +
            "where ID = #{ID}")
    public void updateCalculationRecord(CalculationRecordModel calculationRecord);

    @Delete("delete from OperationInfo where ID = #{ID}")
    public void deleteCalculationRecord(int ID);


}
