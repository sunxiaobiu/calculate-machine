package com.sunxiaoyu.calculate.component;


import com.sunxiaoyu.calculate.enums.Operator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sun on 15/11/9.
 */

public class Faceplate {

    private JPanel operatorPanel = new JPanel();

    private JButton clearBtn = new OperationButton(Operator.CLEAR);
    private JButton reverseBtn = new OperationButton(Operator.REVERSE);
    private JButton modBtn = new OperationButton(Operator.MOD);
    private JButton divideBtn = new OperationButton(Operator.DEVIDE);
    private JButton multiplyBtn = new OperationButton(Operator.MULTIPLY);
    private JButton subtractBtn = new OperationButton(Operator.SUBSTRACT);
    private JButton plusBtn = new OperationButton(Operator.PLUS);
    private JButton dotBtn = new OperationButton(Operator.DOT);
    private JButton resultBtn = new OperationButton(Operator.RESULT);

    private JButton btn_1 = new NumberButton(1);
    private JButton btn_2 = new NumberButton(2);
    private JButton btn_3 = new NumberButton(3);
    private JButton btn_4 = new NumberButton(4);
    private JButton btn_5 = new NumberButton(5);
    private JButton btn_6 = new NumberButton(6);
    private JButton btn_7 = new NumberButton(7);
    private JButton btn_8 = new NumberButton(8);
    private JButton btn_9 = new NumberButton(9);
    private JButton btn_0 = new NumberButton(0);

    public Faceplate() {
        initFaceplate();
    }


    private void initFaceplate() {
        this.operatorPanel.setPreferredSize(new Dimension(232, 275));
        this.operatorPanel.setBackground(Color.ORANGE);
        this.operatorPanel.setLayout(new FlowLayout());
        operatorPanel.add(clearBtn);
        operatorPanel.add(reverseBtn);
        operatorPanel.add(modBtn);
        operatorPanel.add(divideBtn);
        operatorPanel.add(btn_7);
        operatorPanel.add(btn_8);
        operatorPanel.add(btn_9);
        operatorPanel.add(multiplyBtn);
        operatorPanel.add(btn_4);
        operatorPanel.add(btn_5);
        operatorPanel.add(btn_6);
        operatorPanel.add(subtractBtn);
        operatorPanel.add(btn_1);
        operatorPanel.add(btn_2);
        operatorPanel.add(btn_3);
        operatorPanel.add(plusBtn);
        this.btn_0.setPreferredSize(new Dimension(52 * 2, 49));
        operatorPanel.add(btn_0);
        operatorPanel.add(dotBtn);
        operatorPanel.add(resultBtn);
    }

    public JPanel getOperatorPanel() {
        return this.operatorPanel;
    }


    public JButton getClearBtn() {
        return clearBtn;
    }

}
