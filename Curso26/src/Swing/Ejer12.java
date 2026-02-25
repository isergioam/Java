package Swing;

import javax.swing.*;
import java.awt.*;

public class Ejer12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("Ejercicio: Mini-Notas");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel p_base = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
			JPanel p_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

			JLabel titulo = new JLabel("Mis notas");
			p_base.add(titulo, BorderLayout.NORTH);

			JTextArea txt = new JTextArea(10, 35);
			txt.setLineWrap(true);
			txt.setWrapStyleWord(true);
			JScrollPane scroll = new JScrollPane(txt);
			p_base.add(scroll, BorderLayout.CENTER);

			JButton btn1 = new JButton("Contador");
			JLabel lbl_cnt = new JLabel("");
			JButton btn2 = new JButton("Limpiar");

			p_btn.add(lbl_cnt);
			p_btn.add(btn1);
			p_btn.add(btn2);

			btn1.addActionListener(e -> lbl_cnt.setText("Carácteres: " + txt.getText().length()));
			btn2.addActionListener(e -> txt.setText(""));

			p_base.add(p_btn, BorderLayout.SOUTH);

			f.setContentPane(p_base);
			f.setSize(450, 300);
			f.setLocationRelativeTo(null);
			f.setVisible(true);

		}

		);

	}

}
