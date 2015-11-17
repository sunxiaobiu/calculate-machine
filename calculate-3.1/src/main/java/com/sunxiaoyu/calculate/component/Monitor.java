package com.sunxiaoyu.calculate.component;

import javax.swing.*;

/**
 * Created by sun on 15/11/7.
 * 计算器中显示视图类
 */
public class Monitor {

    private JTextArea showTextArea;
    private StringBuilder textStringBuilder = new StringBuilder();
    private boolean textAvailable = true;


    public String getText() {
        return textStringBuilder.toString();
    }

    public void setText(String text) {
        textStringBuilder.delete(0, textStringBuilder.length());
        appendText(text);
    }

    public void appendText(String text) {
        if (".".equals(text)) {
            if (textStringBuilder.toString().contains(".")) {
                return;
            }
        }
        if (textStringBuilder.length() == 1 && "0".equals(textStringBuilder.toString()) && !".".equals(text)) {
            textStringBuilder.delete(0, textStringBuilder.length());
        }

        textStringBuilder.append(text);
        showTextArea.setText(textStringBuilder.toString());
    }

    public void clearText() {
        textStringBuilder.delete(0, textStringBuilder.length());
        appendText("0");
    }

    public void reverseText() {
        if (textStringBuilder.length() >= 1) {
            if (textStringBuilder.charAt(0) == '-') {
                textStringBuilder.delete(0, 1);
            } else {
                textStringBuilder.insert(0, '-');
            }
            showTextArea.setText(textStringBuilder.toString());
        }
    }

    public Monitor(JTextArea showTextArea) {
        if (showTextArea == null) {
            throw new RuntimeException("monitor JTextArea cannot null");
        }
        this.showTextArea = showTextArea;
        this.showTextArea.setEditable(false);
        clearText();
    }

    public boolean isTextAvailable() {
        return textAvailable;
    }

    public void setTextAvailable(boolean textAvailable) {
        this.textAvailable = textAvailable;
    }
}
