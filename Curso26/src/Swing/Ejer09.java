package Swing;

import java.awt.FlowLayout;

import javax.swing.*;

public class Ejer09 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("JTextField");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

			JTextField txt = new JTextField(10);
			JButton btn = new JButton("Cambiar");
			JLabel lbl = new JLabel("...");
			
			btn.addActionListener(e -> lbl.setText(txt.getText()));
			txt.addActionListener(e -> lbl.setText(txt.getText()));

			p.add(new JLabel("Escribe:"));
			p.add(txt);
			p.add(btn);
			p.add(lbl);

			f.setContentPane(p);
			f.setSize(400, 100);
			f.setLocationRelativeTo(null);
			f.setVisible(true);

		});

	}
}
