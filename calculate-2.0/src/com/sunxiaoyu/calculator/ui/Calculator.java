package com.sunxiaoyu.calculator.ui;

import com.sunxiaoyu.calculator.component.Faceplate;
import com.sunxiaoyu.calculator.component.Monitor;
import com.sunxiaoyu.calculator.enums.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

/**
 * Created by sun on 15/10/31.
 */
public class Calculator extends JFrame {
    private final static BigDecimal ZERO_NUMBER = new BigDecimal(0);
    private BigDecimal prevNumber = null;
    private BigDecimal currentNumber = null;
    private Operator currentOperator = Operator.UNDEFINED;
    private static final int decimalPrecision = 6; //精度
    private Monitor monitor;
    private Faceplate faceplate;

    private Calculator(String title) {
        super(title);
        initCalculator();
    }

    private static Calculator calculator = null;

    public static Calculator getCalculator() {
        if (calculator == null) {
            synchronized (Calculator.class) {
                if (calculator == null) {
                    calculator = new Calculator("简易计算器");
                }
            }
        }
        return calculator;
    }

    public void showTop() {
        this.setVisible(true);
    }

    public void initCalculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(232, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        Container container = this.getContentPane();

        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(232, 55));
        textPanel.setBackground(Color.GRAY);

        JTextArea showTextArea = new JTextArea();
        monitor = new Monitor(showTextArea);
        textPanel.setLayout(new GridLayout(1, 1));
        textPanel.add(showTextArea);

        faceplate = new Faceplate();
        JPanel operatorPanel = faceplate.getOperatorPanel();

        container.add(textPanel, BorderLayout.NORTH);
        container.add(operatorPanel, BorderLayout.SOUTH);

        this.pack();//外部容器自动调整成刚好装下这几个按钮的大小的尺寸
        this.setFocusable(true);//允许获取上层焦点
        //按键监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (c >= '0' && c <= '9') {
                    Calculator.this.clickNumber(c - '0');
                    //btn_1.doClick();
                } else if (c == '+') {
                    Calculator.this.clickOperator(Operator.PLUS);
                }
            }
        });
    }

    public void clickNumber(int num) {
        if (!monitor.isTextAvailable()) {
            monitor.clearText();
        } else {
            faceplate.getClearBtn().setText("C");
        }
        monitor.setTextAvailable(true);
        monitor.appendText(String.valueOf(num));
    }

    public void clickOperator(Operator operator) {
        switch (operator) {
            case DOT:
                monitor.appendText(".");
                break;
            case CLEAR:
                currentNumber = null;
                monitor.clearText();
                if ("AC".equals(faceplate.getClearBtn().getText())) {
                    currentOperator = Operator.UNDEFINED;
                    prevNumber = null;
                }
                faceplate.getClearBtn().setText("AC");
                break;
            case PLUS:
            case SUBSTRACT:
            case MULTIPLY:
            case DEVIDE:
            case RESULT:
            case MOD:
                calculate(operator);
                break;
            case REVERSE:
                monitor.reverseText();
                if (prevNumber != null) {
                    prevNumber = prevNumber.multiply(new BigDecimal(-1));
                }
                break;
            default:
                break;
        }
    }


    private void calculate(Operator operator) {
        if (currentOperator == Operator.UNDEFINED && operator != Operator.RESULT) {
            currentOperator = operator;//只有当上一次计算符为空才替换当前计算符，否则计算完毕才替换
        }

        if (monitor.isTextAvailable()) {
            currentNumber = new BigDecimal(monitor.getText());
        }

        if (currentNumber != null && prevNumber == null) {
            prevNumber = currentNumber;
            currentNumber = null;
            monitor.setTextAvailable(false);
        }

        if (currentNumber == null) {
            currentOperator = operator;//多次点击计算符，则替换
            return;
        }


        String result = "";
        BigDecimal resultNumber = ZERO_NUMBER;
        try {
            switch (currentOperator) {
                case PLUS:
                    resultNumber = prevNumber.add(currentNumber);
                    currentOperator = operator;
                    break;
                case SUBSTRACT:
                    resultNumber = prevNumber.subtract(currentNumber);
                    currentOperator = operator;
                    break;
                case MULTIPLY:
                    resultNumber = prevNumber.multiply(currentNumber);
                    currentOperator = operator;
                    break;
                case DEVIDE:
                    resultNumber = prevNumber.divide(currentNumber, decimalPrecision, BigDecimal.ROUND_HALF_UP);
                    currentOperator = operator;
                    break;
                case MOD:
                    resultNumber = prevNumber.divideAndRemainder(currentNumber)[1];
                    currentOperator = operator;
                    break;
                case RESULT:
                    currentOperator = Operator.UNDEFINED;
                    break;
                default:
                    throw new RuntimeException("unknown calculate");
            }
            result = resultNumber.toString();
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            prevNumber = resultNumber;
            currentNumber = null;
            monitor.setTextAvailable(false);
            monitor.setText(result);
        }
    }
}
