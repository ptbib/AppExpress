package bib.Class;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class button extends JButton {

    private Paint p;
    private boolean over;
    private boolean press;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }
    private Image image;

    public button() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }

        });
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        if (isOver()) {
            p = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0F), 0,
                    getHeight(), new Color(1F, 1F, 1F, 0.5F));
            if (isPress()) {
                p = new GradientPaint(0, 0, new Color(0.5F, 0.5F, 0.5F, 0.5F),
                        0, getHeight(), new Color(0.5F, 0.5F, 0.5F, 0.5F));
            }
        } else {
            p = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0,
                    getHeight(), new Color(1F, 1F, 1F, 0F));
        }

        gd.setPaint(p);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        gd.dispose();

    }

}
