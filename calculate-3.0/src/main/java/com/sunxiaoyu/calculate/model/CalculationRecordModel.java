package com.sunxiaoyu.calculate.model;

import java.util.Date;

/**
 * Created by sun on 15/11/11.
 */

public class CalculationRecordModel {

    /**
     * 记录ID
     */
    private Integer ID;

    /**
     * 用户MAC地址
     */
    private String macAddress;

    /**
     * 第一个计算数值
     */
    private Double preNumber;

    /**
     * 第二个计算数值
     */
    private Double currentNumber;

    /**
     * 运算符
     */
    private String operator;

    /**
     * 计算结果
     */
    private Double result;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 是否有效
     */
    private int status;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Double getPreNumber() {
        return preNumber;
    }

    public void setPreNumber(Double preNumber) {
        this.preNumber = preNumber;
    }

    public Double getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Double currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
