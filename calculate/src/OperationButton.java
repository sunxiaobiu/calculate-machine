import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sun on 15/10/31.
 */
public class OperationButton extends JButton {

    private Operator operator;

    public OperationButton(final Operator operator) {
        super(operator.getOperator());
        this.setSize(58, 49);
        this.setPreferredSize(new Dimension(50, 49));
        this.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.operator = operator;
        //new 一个匿名内部类。。。
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.getCalculator().clickOperator(OperationButton.this.operator);
            }
        });
    }

}
