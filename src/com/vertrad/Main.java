package com.vertrad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {
    private List<JButton> buttons = new ArrayList<>();
    private JPanel p = new JPanel();
    private JButton button1 = new JButton();
    private String a = "O";

    public Main() throws HeadlessException {

        this.setTitle("TicTacToe");
        this.setPreferredSize(new Dimension(400, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createButtons();


        settingSigns();
        this.getContentPane().add(p);
        this.pack();
        this.setVisible(true);
    }


    public void createButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton b1 = new JButton();
                p.setLayout(null);
                b1.setBounds(i * 100, j * 100, 100, 100);

                p.add(b1);
                buttons.add(b1);
            }
        }
    }

    void settingSigns() {
        for (JButton button : buttons) {
            mouseListener(button);
        }
    }

    private void mouseListener(JButton button) {
        button.addActionListener(e -> {
            System.out.println(button.getY() + " " + button.getX());
            if (button.getText().equals("")) {
                button.setText(a);
                if (a.equals("O")) {
                    a = "X";
                } else {
                    a = "O";

                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button1.getText().equals("")) {
            button1.setText(a);
            if (a.equals("O")) {
                a = "X";
            } else {
                a = "O";

            }
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> showWindow());
    }

    private static void showWindow() {
        Main z = new Main();


    }

}
