package com.sunxiaoyu.calculator.bootstrap;


import com.sunxiaoyu.calculator.ui.Calculator;

/**
 * Created by sun on 15/10/31.
 */
public class Bootstrap {

    public static void main(String[] args) {
        Calculator calculator = Calculator.getCalculator();
        calculator.showTop();
    }
}
