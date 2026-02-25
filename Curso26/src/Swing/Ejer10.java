package Swing;

import javax.swing.*;
import java.awt.*;

public class Ejer10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("Desactivar Botón");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
			
			JLabel lbl = new JLabel("");
			JButton btn = new JButton("Pulsar");
			JButton btn2 = new JButton("Desbloquear");
			
			btn.addActionListener(e -> {
				lbl.setText("Botón bloqueado");
				btn.setEnabled(false);
				btn.setText("Bloqueado");
			});
			
			btn2.addActionListener(e -> {
				btn.setEnabled(true);
				lbl.setText("Botón desbloqueado");
				btn.setText("Pulsar");
			});
			
			p.add(btn2);
			p.add(btn);
			p.add(lbl);
		
			
			f.setContentPane(p);
			f.setSize(375,90);
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			
		});
		
		
		
	}

}
