package Swing;

import java.awt.*;
import javax.swing.*;

public class Ejer11 {

	public static String[] Clases = { "Elige una opción...", "Matemáticas", "Informática", "Historia", "Inglés" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame("Formulario");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel p_base = new JPanel(new GridLayout(3, 1, 10, 10));
			p_base.setBorder(BorderFactory.createEmptyBorder());

			JPanel p_formulario = new JPanel(new GridLayout(6, 2, 8, 8));

			JPanel p_btn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

			JLabel lbl_name = new JLabel("<*> Nombre:");
			JTextField txt_name = new JTextField();
			JLabel lbl_apellido1 = new JLabel("<*> Apellido 1:");
			JTextField txt_apellido1 = new JTextField();
			JLabel lbl_apellido2 = new JLabel("<*> Apellido 2:");
			JTextField txt_apellido2 = new JTextField();
			JLabel lbl_edad = new JLabel("<*> Edad:");
			JTextField txt_edad = new JTextField();
			JLabel lbl_curso = new JLabel("<*> Curso:");
			JComboBox<String> txt_curso = new JComboBox<String>(Clases);
			JLabel lbl_pass = new JLabel("<*> Contraseña:");
			JPasswordField txt_pass = new JPasswordField();

			p_formulario.add(lbl_name);
			p_formulario.add(txt_name);
			p_formulario.add(lbl_apellido1);
			p_formulario.add(txt_apellido1);
			p_formulario.add(lbl_apellido2);
			p_formulario.add(txt_apellido2);
			p_formulario.add(lbl_edad);
			p_formulario.add(txt_edad);
			p_formulario.add(lbl_curso);
			p_formulario.add(txt_curso);
			p_formulario.add(lbl_pass);
			p_formulario.add(txt_pass);

			JLabel mensaje = new JLabel("Datos del alumno");

			JButton btn_enviar = new JButton("Enviar");
			JButton btn_eliminar = new JButton("Borrar");

			p_base.add(p_formulario);

			p_base.add(mensaje);

			p_btn.add(btn_enviar);
			p_btn.add(btn_eliminar);

			p_base.add(p_btn);

			f.setContentPane(p_base);
			f.setSize(500,500);
			f.setLocationRelativeTo(null);
			f.setVisible(true);

			btn_enviar.addActionListener(
					e -> enviar_info(txt_name, txt_apellido1, txt_apellido2, txt_edad, txt_curso, mensaje, txt_pass));
			btn_eliminar.addActionListener(
					e -> borrar_info(txt_name, txt_apellido1, txt_apellido2, txt_edad, txt_curso, mensaje, txt_pass));

		});

	}

	private static void enviar_info(JTextField name, JTextField apellido1, JTextField apellido2, JTextField edad,
			JComboBox<String> cursos, JLabel mensaje, JPasswordField pass) {

		String data_name = name.getText();
		String data_apellido1 = apellido1.getText();
		String data_apellido2 = apellido2.getText();
		String data_edad = edad.getText();
		String data_curso = (String) cursos.getSelectedItem();
		char[] data_pass = pass.getPassword();

		if (data_name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Nombre está vacío");
			name.requestFocus();

		}
		if (data_apellido1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Apellido 1 está vacío");
			apellido1.requestFocus();
		}
		if (data_apellido2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo Apellido 2 está vacío");
			apellido2.requestFocus();
		}

		int edad_txt;
		String pass_txt;

		try {

			edad_txt = Integer.parseInt(data_edad);

			if (edad_txt < 0) {
				JOptionPane.showMessageDialog(null, "La edad debe ser un número positivo");
				edad.requestFocus();
				return;
			}

			pass_txt = new String(data_pass);
			if (pass_txt.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo Password está vacío");
				pass.requestFocus();
			}

			mensaje.setText("Datos del alumno: " + data_name + " " + data_apellido1 + " " + data_apellido2 + " "
					+ edad_txt + " " + data_curso + " " + pass_txt);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El campo Edad está vacío");
			edad.requestFocus();
		}

	}

	private static void borrar_info(JTextField name, JTextField apellido1, JTextField apellido2, JTextField edad,
			JComboBox<String> cursos, JLabel mensaje, JPasswordField pass) {

		name.setText("");
		apellido1.setText("");
		apellido2.setText("");
		edad.setText("");
		cursos.setSelectedIndex(0);
		mensaje.setText("Datos del alumno");
		pass.setText("");
		name.requestFocus();

	}
}
