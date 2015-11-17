package com.sunxiaoyu.calculate.component;


import com.sunxiaoyu.calculate.ui.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sun on 15/10/31.
 */
public class NumberButton extends JButton {

    private int num;

    public NumberButton(int num) {
        super(String.valueOf(num));
        this.setSize(58, 49);
        this.setPreferredSize(new Dimension(50, 49));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.num = num;

        //new 一个匿名内部类。。。
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.getCalculator().clickNumber(NumberButton.this.num);
            }
        });
    }

}
