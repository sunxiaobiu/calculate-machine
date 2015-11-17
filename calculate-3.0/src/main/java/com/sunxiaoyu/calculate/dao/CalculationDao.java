package com.sunxiaoyu.calculate.dao;

import com.sunxiaoyu.calculate.model.CalculationRecordModel;

/**
 * Created by sun on 15/11/12.
 */
public interface CalculationDao {

    public void insertCalculationRecord(CalculationRecordModel calculationRecord);

    public void deleteCalculationRecord(CalculationRecordModel calculationRecord);

    public void updateCalculationRecord(CalculationRecordModel calculationRecord);

    public CalculationRecordModel getCalculationRecordByID(Integer calculationRecordID);

    public CalculationRecordModel getCalculationRecordByMacAddress(String MacAddress);

}
