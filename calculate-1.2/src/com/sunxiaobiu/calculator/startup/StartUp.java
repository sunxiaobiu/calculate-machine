package com.sunxiaobiu.calculator.startup;

import com.sunxiaobiu.calculator.ui.Calculator;

/**
 * Created by sun on 15/11/8.
 */
public class StartUp {
    public static void main(String[] args) {
        Calculator calculator = Calculator.getCalculator();
        calculator.showTop();
    }
}
