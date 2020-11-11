package com.vertrad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Main extends JPanel implements MouseListener{
   private List<Rectangle2D> rectangle2DS = new ArrayList<>();
    private int frameWidth = 400;
    private int frameHeight = 400;
    private int rectWidth = 130;
    private int rectHeight = 130;


    @Override
    protected void paintComponent(Graphics g) {


        super.paintComponent(g);
        g.setColor(Color.BLUE);
//        g.fillRect(0,0,rectWidth,rectHeight);
//        g.setColor(Color.BLUE);
//        g.fillRect(131,0,rectWidth,rectHeight);
//        g.setColor(Color.BLUE);
//        g.fillRect(262, 0, rectWidth, rectHeight);
//        g.setColor(Color.BLUE);
//        g.fillRect(0, 131, rectWidth, rectHeight);
//        g.setColor(Color.BLUE);
//        g.fillRect(131, 131, rectWidth, rectHeight);
//        g.setColor(Color.BLUE);
//        g.fillRect(262, 131, rectWidth, rectHeight);
        creatingRectangles();
        paintingRectangles( (Graphics2D) g);

    }


    private void paintingRectangles( Graphics2D g) {

        for (Rectangle2D rectangle : rectangle2DS) {
            g.fill(rectangle);
        }
    }

    public void mouseClicked(MouseEvent e) {

        for (Rectangle2D rectangle2D : rectangle2DS) {

            if ((e.getButton() == 1) && rectangle2D.contains(e.getX(), e.getY())) {
                repaint();
                 JOptionPane.showMessageDialog(null,e.getX()+ "\n" + e.getY());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    void creatingRectangles() {

        int x = 0;
        int y;
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                x = rectWidth + 1;
            } else if (i == 2) {
                x = (2 * rectWidth) + 2;
            }

            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    y = 0;
                } else if (j == 1) {
                    y = rectWidth + 1;
                } else {
                    y = 2 * rectHeight + 2;
                }

                Rectangle2D rectangle2D = new Rectangle2D.Double(y, x, rectWidth, rectHeight);

                rectangle2DS.add(rectangle2D);
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(rectWidth + 2 * 20, rectHeight + 2 * 20);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showWindow();

            }
        });


    }

    private static void showWindow() {
        Main mainPanel = new Main();

        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setPreferredSize(new Dimension(mainPanel.frameWidth, mainPanel.frameHeight));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
