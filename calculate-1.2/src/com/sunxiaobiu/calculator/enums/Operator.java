package com.sunxiaobiu.calculator.enums;

/**
 * Created by sun on 15/10/31.
 */
public enum Operator {

    CLEAR("AC"),
    REVERSE("+/-"),
    MOD("%"),
    DEVIDE("÷"),
    MULTIPLY("x"),
    SUBSTRACT("-"),
    PLUS("+"),
    RESULT("="),
    DOT("."),
    UNDEFINED("?");

    private String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return operator;
    }

    public static Operator transform(String operator) {
        if ("+/-".equals(operator)) {
            return REVERSE;
        }
        if ("%".equals(operator)) {
            return MOD;
        }
        if ("÷".equals(operator)) {
            return DEVIDE;
        }
        if ("x".equals(operator)) {
            return MULTIPLY;
        }
        if ("-".equals(operator)) {
            return SUBSTRACT;
        }
        if ("+".equals(operator)) {
            return PLUS;
        }
        if ("=".equals(operator)) {
            return RESULT;
        }
        if (".".equals(operator)) {
            return DOT;
        }
        if ("AC".equals(operator) || "C".equals(operator)) {
            return CLEAR;
        }
        return UNDEFINED;
    }
}
