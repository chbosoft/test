package com.java.calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Win extends JFrame implements ActionListener {

	String one, two, yun, ss;

	int i;

	JTextField f = new JTextField(20);

	JMenuBar m = new JMenuBar();

	JMenu m1 = new JMenu("查看");

	JMenu m2 = new JMenu("编辑");

	JMenu m3 = new JMenu("帮助");
	

	JPanel p = new JPanel();

	JPanel p1 = new JPanel();

	JPanel p2 = new JPanel();

	JPanel p3 = new JPanel();

	JPanel p4 = new JPanel();

	JPanel p5 = new JPanel();

	String data[] = { "9", "8", "7", "6", "5", "4", "3", "2", "1", "0" };

	JButton b1[] = new JButton[10];

	String yunsuan[] = { "+", "-", "*", "/" };

	JButton b2[] = new JButton[4];

	JButton b3 = new JButton(".");

	JButton b4 = new JButton("=");

	JButton b5 = new JButton("B");

	JButton b6 = new JButton("C");

	JButton b7 = new JButton("CE");

	JLabel label1 = new JLabel("    ");

	JLabel label2 = new JLabel("    ");

	JLabel label3 = new JLabel(" ");

	JLabel label4 = new JLabel(" ");

	public Win() {

		init();

		setTitle("java编写计算器，实现计算器的简单功能。实现实数的加减乘除运算，并实现清零，和逐个清除功能");

		setSize(250, 300);

		setVisible(true);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void init() {

		for (int i = 0; i < b1.length; i++) {

			b1[i] = new JButton(data[i]);

			b1[i].addActionListener(this);

		}

		for (int i = 0; i < b2.length; i++) {

			b2[i] = new JButton(yunsuan[i]);

			b2[i].addActionListener(this);

		}

		b3.addActionListener(this);

		b4.addActionListener(this);

		b5.addActionListener(this);

		b6.addActionListener(this);

		b7.addActionListener(this);

		m.add(m1);

		m.add(m2);

		m.add(m3);

		setJMenuBar(m);

		p.setLayout(new BorderLayout());

		p1.setLayout(new BorderLayout());

		p2.setLayout(new GridLayout(3, 1));

		p3.setLayout(new GridLayout(3, 3));

		p4.setLayout(new GridLayout(1, 3));

		p5.setLayout(new GridLayout(4, 1));

		p2.add(b5);

		p2.add(b6);

		p2.add(b7);

		for (int i = 0; i < b1.length - 1; i++) {

			p3.add(b1[i]);

		}

		p4.add(b4);

		p4.add(b1[9]);

		p4.add(b3);

		for (int i = 0; i < b2.length; i++) {

			p5.add(b2[i]);

		}

		f.setEditable(false);

		f.setHorizontalAlignment(JTextField.RIGHT);

		p1.add(f, BorderLayout.NORTH);

		p1.add(p2, BorderLayout.WEST);

		p1.add(p3, BorderLayout.CENTER);

		p1.add(p4, BorderLayout.SOUTH);

		p1.add(p5, BorderLayout.EAST);

		p.add(label1, BorderLayout.WEST);

		p.add(label2, BorderLayout.EAST);

		p.add(label3, BorderLayout.SOUTH);

		p.add(label4, BorderLayout.NORTH);

		p.add(p1, BorderLayout.CENTER);

		add(p);

	}

	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < b1.length; i++) {

			if (e.getSource() == b1[i]) {

				ss = f.getText();

				f.setText(ss + b1[i].getText());

			}

		}

		for (int i = 0; i < b2.length; i++) {

			if (e.getSource() == b2[i]) {

				yun = b2[i].getText();

				one = f.getText();

				f.setText(null);

			}

		}

		if (e.getSource() == b3 && (f.getText().indexOf(".") < 0)) {

			ss = f.getText();

			f.setText(ss + b3.getText());

		}

		if (e.getSource() == b4) {

			double x = Double.parseDouble(one);

			double y = Double.parseDouble(f.getText());

			if (yun.equals("+")) {

				f.setText(x + y + "");

			}

			if (yun.equals("-")) {

				f.setText(x - y + "");

			}

			if (yun.equals("*")) {

				f.setText(x * y + "");

			}

			if (yun.equals("/")) {

				f.setText(x / y + "");

			}

		}

		if (e.getSource() == b5) {

			ss = f.getText();

			String s1 = ss.substring(0, ss.length() - 1);

			f.setText(s1);

		}

		if (e.getSource() == b6) {

			f.setText("");

		}

		if (e.getSource() == b7) {

			f.setText("");

		}

	}
	
	public static void main(String[] args) {
		new Win();
	}

}