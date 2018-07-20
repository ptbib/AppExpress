/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bib.Class;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author joko
 */
public class ClassMataUang extends JTextField {

    private char separator = '.';

    public ClassMataUang() {
        super();
        setHorizontalAlignment(SwingConstants.RIGHT);
        setText("0");
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                ClassMataUang.super.setText(getText());
                ClassMataUang.super.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                setText(ClassMataUang.super.getText());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        // */
    }

    public void setSeparator(char s) {
        separator = s;
    }

    public void setText(String s) {
        super.setText(formatNumber(s));
    }

    public String getText() {
        String s = super.getText();
        return s.replaceAll("[^0-9]", "");
    }

    public String getNumberFormattedText() {
        return super.getText();
    }

    public String formatNumber(String s) {
        try {
            long v = Long.parseLong(s);
            return String.format("%,d", v).replace(",", separator + "");
        } catch (Exception e) {
            return "0";
        }
    }
}
