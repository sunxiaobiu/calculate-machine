package com.sunxiaoyu.calculate.model;

/**
 * Created by sun on 15/11/14.
 */
public class ServiceResult {
    public static final Integer INTERNAL_ERROR = 500;
    public static final Integer SUCCESS = 200;

    private Integer code = SUCCESS;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ServiceResult fail(String msg) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(INTERNAL_ERROR);
        serviceResult.setMsg(msg);
        return serviceResult;
    }

    public static ServiceResult success(Object data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(SUCCESS);
        serviceResult.setData(data);
        return serviceResult;
    }
}
