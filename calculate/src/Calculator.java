import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * Created by sun on 15/10/31.
 */
public class Calculator extends JFrame {

    private BigDecimal hideNumber = new BigDecimal(0);

    private BigDecimal showIntegerNumber = new BigDecimal(0);

    private BigDecimal showDecimalNumber = new BigDecimal(0.0);

    private int decimalNumberPrecision = 0;

    private Operator operatorNow = Operator.UNDEFINED;

    private Operator operatorFront = Operator.UNDEFINED;

    private JTextArea showTextArea;

    private static final int precision = 6; //精度

    private Calculator(String title) {
        super(title);
        init();
    }

    private static Calculator calculator = null;// = new Calculator("简易计算器");
//    懒汉模式
//    public static Calculator getCalculator() {
//        return calculator;
//    }


    //饿汉模式
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

    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(232, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        Container container = this.getContentPane();

        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(232, 55));
        textPanel.setBackground(Color.GRAY);

        showTextArea = new JTextArea();
        showTextArea.setEditable(false);
        showTextArea.setText("0");

        textPanel.setLayout(new GridLayout(1, 1));
        textPanel.add(showTextArea);

        JPanel operatorPanel = new JPanel();
        operatorPanel.setPreferredSize(new Dimension(232, 275));
        operatorPanel.setBackground(Color.ORANGE);
        operatorPanel.setLayout(new FlowLayout());

        JButton clearBtn = new OperationButton(Operator.CLEAR);
        operatorPanel.add(clearBtn);

        JButton reverseBtn = new OperationButton(Operator.REVERSE);
        operatorPanel.add(reverseBtn);

        JButton modBtn = new OperationButton(Operator.MOD);
        operatorPanel.add(modBtn);

        JButton devideBtn = new OperationButton(Operator.DEVIDE);
        operatorPanel.add(devideBtn);

        JButton btn_7 = new NumberButton(7);
        operatorPanel.add(btn_7);


        JButton btn_8 = new NumberButton(8);
        operatorPanel.add(btn_8);


        JButton btn_9 = new NumberButton(9);
        operatorPanel.add(btn_9);

        JButton multiplyBtn = new OperationButton(Operator.MULTIPLY);
        operatorPanel.add(multiplyBtn);

        JButton btn_4 = new NumberButton(4);
        operatorPanel.add(btn_4);


        JButton btn_5 = new NumberButton(5);
        operatorPanel.add(btn_5);


        JButton btn_6 = new NumberButton(6);
        operatorPanel.add(btn_6);

        JButton subtractBtn = new OperationButton(Operator.SUBSTRACT);
        operatorPanel.add(subtractBtn);

        JButton btn_1 = new NumberButton(1);
        operatorPanel.add(btn_1);

        JButton btn_2 = new NumberButton(2);
        operatorPanel.add(btn_2);

        JButton btn_3 = new NumberButton(3);
        operatorPanel.add(btn_3);

        JButton plusBtn = new OperationButton(Operator.PLUS);
        operatorPanel.add(plusBtn);


        JButton btn_0 = new NumberButton(0);
        btn_0.setPreferredSize(new Dimension(52 * 2, 49));
        operatorPanel.add(btn_0);

        JButton dotBtn = new OperationButton(Operator.DOT);
        operatorPanel.add(dotBtn);

        JButton resultBtn = new OperationButton(Operator.RESULT);
        operatorPanel.add(resultBtn);

        container.add(textPanel, BorderLayout.NORTH);
        container.add(operatorPanel, BorderLayout.SOUTH);
        this.pack();
    }

    public void clickNumber(int num) {
        if (showIntegerNumber.equals(new BigDecimal(0)) && this.operatorNow != Operator.DOT) {
            showIntegerNumber = new BigDecimal(num);
        } else if(this.operatorNow != Operator.DOT){
            showIntegerNumber = showIntegerNumber.multiply(new BigDecimal(10)).add(new BigDecimal(num));
        }
        //
        if(this.operatorNow.equals(Operator.RESULT)){
            hideNumber = showIntegerNumber;
            showIntegerNumber = new BigDecimal(0);
        }else if (this.operatorNow == Operator.DOT) {
            decimalNumberPrecision++;
            showDecimalNumber = showDecimalNumber.multiply(new BigDecimal(10)).add(new BigDecimal(num));
            showIntegerNumber = showIntegerNumber.add(new BigDecimal(num).movePointLeft(decimalNumberPrecision));
        }

        //show
        if(this.operatorNow.equals(Operator.RESULT)){
            this.showTextArea.setText(hideNumber.toString());
        }else {
            this.showTextArea.setText(showIntegerNumber.toString());
        }
    }

    public void clickOperator(Operator operator) {
        this.operatorNow = operator;
        switch (operator) {
            case CLEAR:
                hideNumber = new BigDecimal(0);
                showIntegerNumber = new BigDecimal(0);
                showDecimalNumber = new BigDecimal(0.0);
                decimalNumberPrecision = 0;
                this.showTextArea.setText(showIntegerNumber.toString());
                this.operatorNow = Operator.UNDEFINED;
                break;
            case REVERSE:
                if(!showIntegerNumber.equals(new BigDecimal(0))){
                    showIntegerNumber = showIntegerNumber.multiply(new BigDecimal(-1));
                    this.showTextArea.setText(showIntegerNumber.toString());
                }else {
                    hideNumber = hideNumber.multiply(new BigDecimal(-1));
                    this.showTextArea.setText(hideNumber.toString());
                }
                break;
            case RESULT:
                switch (this.operatorFront){
                    case MOD:
                        showIntegerNumber = hideNumber.divideAndRemainder(showIntegerNumber)[1];
                        break;
                    case DEVIDE:
                        showIntegerNumber = hideNumber.divide(showIntegerNumber, precision, BigDecimal.ROUND_HALF_UP);
                        break;
                    case MULTIPLY:
                        showIntegerNumber = hideNumber.multiply(showIntegerNumber);
                        break;
                    case SUBSTRACT:
                        showIntegerNumber = hideNumber.subtract(showIntegerNumber);
                        break;
                    case PLUS:
                        showIntegerNumber = hideNumber.add(showIntegerNumber);
                        break;
                }
                this.showTextArea.setText(showIntegerNumber.toString());
                hideNumber = showIntegerNumber;
                showIntegerNumber = new BigDecimal(0);
                showDecimalNumber = new BigDecimal(0.0);
                decimalNumberPrecision = 0;
                break;
            case DOT:
                if(this.operatorNow.equals(Operator.RESULT)){
                    this.showTextArea.setText(hideNumber.toString().concat("."));
                }else {
                    this.showTextArea.setText(showIntegerNumber.toString().concat("."));
                }
                break;
            case UNDEFINED:
                break;
            default:
                this.operatorFront = operator;
                this.operatorNow = Operator.UNDEFINED;
                if(showIntegerNumber != new BigDecimal(0) && hideNumber.equals(BigDecimal.ZERO)){
                    hideNumber = showIntegerNumber;
                    showIntegerNumber = new BigDecimal(0);
                }
                break;
        }
    }
}
