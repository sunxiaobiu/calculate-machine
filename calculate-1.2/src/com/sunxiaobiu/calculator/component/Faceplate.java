package com.sunxiaobiu.calculator.component;

import com.sunxiaobiu.calculator.enums.Operator;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sun on 15/11/8.
 */
public class Faceplate extends Container {

    private JPanel textPanel;
    private JPanel operatorPanel;
    private JButton clearBtn;

    public void getTextPanel(){
        textPanel.setPreferredSize(new Dimension(232, 55));
        textPanel.setBackground(Color.GRAY);
        JButton btn_7 = new NumberButton(7);
        operatorPanel.add(btn_7);


        JButton btn_8 = new NumberButton(8);
        operatorPanel.add(btn_8);


        JButton btn_9 = new NumberButton(9);
        operatorPanel.add(btn_9);

        JButton btn_4 = new NumberButton(4);
        operatorPanel.add(btn_4);


        JButton btn_5 = new NumberButton(5);
        operatorPanel.add(btn_5);


        JButton btn_6 = new NumberButton(6);
        operatorPanel.add(btn_6);

        JButton btn_1 = new NumberButton(1);
        operatorPanel.add(btn_1);

        JButton btn_2 = new NumberButton(2);
        operatorPanel.add(btn_2);

        JButton btn_3 = new NumberButton(3);
        operatorPanel.add(btn_3);

        final JButton btn_0 = new NumberButton(0);
        btn_0.setPreferredSize(new Dimension(52 * 2, 49));
    }

    public void getOperatorPanel(){
        operatorPanel.setPreferredSize(new Faceplate(232,275));
        operatorPanel.setBackground(Color.ORANGE);
        operatorPanel.setLayout(new FlowLayout());

        clearBtn = new OperationButton(Operator.CLEAR);
        operatorPanel.add(clearBtn);

        JButton reverseBtn = new OperationButton(Operator.REVERSE);
        operatorPanel.add(reverseBtn);

        JButton modBtn = new OperationButton(Operator.MOD);
        operatorPanel.add(modBtn);

        JButton devideBtn = new OperationButton(Operator.DEVIDE);
        operatorPanel.add(devideBtn);

        JButton multiplyBtn = new OperationButton(Operator.MULTIPLY);
        operatorPanel.add(multiplyBtn);

        JButton subtractBtn = new OperationButton(Operator.SUBSTRACT);
        operatorPanel.add(subtractBtn);

        JButton plusBtn = new OperationButton(Operator.PLUS);
        operatorPanel.add(plusBtn);
    }

    operatorPanel.add(btn_0);

    JButton dotBtn = new OperationButton(Operator.DOT);
    operatorPanel.add(dotBtn);

    JButton resultBtn = new OperationButton(Operator.RESULT);
    operatorPanel.add(resultBtn);

    container.add(textPanel, BorderLayout.NORTH);
    container.add(operatorPanel, BorderLayout.SOUTH);
}
