package geekbrains.lesson01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameWindow extends JFrame {
    private final String TEXT_EMPTY = "                                                                      ";

    public JFrameWindow() {
        setTitle("Simple Java Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        BoxLayout generalLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        GridLayout numbersGrid = new GridLayout(3, 3);
        GridLayout actionsGrid = new GridLayout(2, 2);
        setLayout(generalLayout);
        // панель с текстовым полем
        JTextField textField = new JTextField();
        JPanel textPanel = new JPanel();
        textField.setText(TEXT_EMPTY);
        textPanel.add(textField);

        JButton[] numbers = new JButton[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton("" + i);
        }
        // панель с цифрами и кнопкой сброса
        JPanel numbersPanel = new JPanel();
        numbersPanel.setLayout(numbersGrid);
        for (int i = 1; i < numbers.length; i++) {
            numbersPanel.add(numbers[i]);
        }
        numbersPanel.add(numbers[0]);
        JButton dot=new JButton(".");
        numbersPanel.add(dot);
        JButton reset = new JButton("RESET");
        numbersPanel.add(reset);
        // панель с действиями
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiple = new JButton("*");
        JButton divide = new JButton("/");
        JButton mod = new JButton("%");
        JButton equals = new JButton("=");
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(actionsGrid);
        actionPanel.add(plus);
        actionPanel.add(minus);
        actionPanel.add(multiple);
        actionPanel.add(divide);
        actionPanel.add(mod);
        actionPanel.add(equals);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(TEXT_EMPTY);
            }
        });
        for (int i = 0; i < numbers.length; i++) {
            String temp = numbers[i].getText();
            numbers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + temp);
                }
            });
        }

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=plus.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=minus.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        multiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=multiple.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=divide.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        mod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=mod.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=dot.getText();
                textField.setText(textField.getText()+temp);
            }
        });
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equation=textField.getText();
                double[] operands=ParseAndSolve.Parse(equation);
                char action=ParseAndSolve.getAction();
                Calculator calculator=new Calculator(operands,action);

                textField.setText(Double.toString(calculator.getResult()));

            }
        });


        add(textPanel);
        add(numbersPanel);
        add(actionPanel);


        setVisible(true);
    }
}
