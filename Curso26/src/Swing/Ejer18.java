package Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ejer18 {

	private JFrame fr;
	
	private JTextField tfId, tfAula, tfTiempo;
	
	private JComboBox<String> cbTipo, cbPrio;
	
	private JCheckBox chkResuelta;
	
	private JButton btnAdd, btnEdit, btnDelete, btnClear, btnResuelta, btn10;
	
	private JLabel lblTotal, lblPendientes, lblTotalGeneral;
	
	String[] comboTipo = {"-", "PC", "Red", "Proyector", "Otro"};
	String[] comboPrio = {"-", "Baja", "Media", "Alta"};
	
	// Definimos nuestra tabla y su tipo
	private JTable t;
	
	private DefaultTableModel m;	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Ejer18().start();
		});
	}
	
	private void start() {
		// VENTANA PRINCIPAL
		fr = new JFrame("Gestor de incidencias del aula (helpdesk)");		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// MODELO
        m = new DefaultTableModel(
                new Object[]{"ID", "Aula", "Tipo", "Prioridad", "Resuelta", "Tiempo"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		
        // TABLA
        t = new JTable(m);
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t.setAutoCreateRowSorter(true);
		
		JScrollPane sp = new JScrollPane(t); //Importante no olvidarse del Scroll.
		
		// FORMULARIO
		JPanel f = new JPanel(new GridLayout(6,2,8,8));
		
		tfId = new JTextField();
		tfAula = new JTextField();
		cbTipo = new JComboBox<>(comboTipo);
		cbPrio = new JComboBox<>(comboPrio);
		chkResuelta = new JCheckBox("Sí");
		tfTiempo = new JTextField();		
		
		f.add(new JLabel("ID:"));
		f.add(tfId);
		f.add(new JLabel("Aula:"));
		f.add(tfAula);
		f.add(new JLabel("Tipo:"));
		f.add(cbTipo);
		f.add(new JLabel("Prioridad:"));
		f.add(cbPrio);
		f.add(new JLabel("Resuelta:"));
		f.add(chkResuelta);
		f.add(new JLabel("TIempo:"));
		f.add(tfTiempo);				
		
		// BOTONES
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnAdd = new JButton("Añadir");
        btnEdit = new JButton("Editar");
        btnDelete = new JButton("Borrar");
        btnClear = new JButton("Limpiar");
        btnResuelta = new JButton("Resuelta");
        btn10 = new JButton("+10 Minutos");

        buttons.add(btnAdd);
        buttons.add(btnEdit);
        buttons.add(btnDelete);
        buttons.add(btnClear);
        buttons.add(btnResuelta);
        buttons.add(btn10);
		
		// ORGANIZAR PANELES        
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(f);
        north.add(Box.createVerticalStrut(8));
        north.add(buttons);
        
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        south.add(new JLabel("Total incidencias:"));
        lblTotal = new JLabel("0");
        lblTotal.setEnabled(false);
        south.add(lblTotal);

        // Total pendientes
        south.add(new JLabel("Pendientes:"));
        lblPendientes = new JLabel("0");
        lblPendientes.setEnabled(false);
        south.add(lblPendientes);

        // Tiempo total acumulado
        south.add(new JLabel("Minutos totales:"));
        lblTotalGeneral = new JLabel("0");
        lblTotalGeneral.setEnabled(false);
        south.add(lblTotalGeneral);

        /*south.add(new JLabel("Total pendientes:"));
        tfTotalPrestados = new JTextField(5);
        tfTotalPrestados.setEnabled(false);
        south.add(tfTotalPrestados);

        south.add(new JLabel("Total días acumulados:"));
        tfTotalDias = new JTextField(6);
        tfTotalDias.setEnabled(false);
        south.add(tfTotalDias);*/

        // ------------------------
        //  8) LAYOUT PRINCIPAL
        // ------------------------
        fr.setLayout(new BorderLayout(10, 10));
        fr.add(north, BorderLayout.NORTH);
        fr.add(sp, BorderLayout.CENTER);
        fr.add(south, BorderLayout.SOUTH);

        north.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        sp.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        
        
		// MOSTRAR PROGRAMA
		fr.setSize(860,520);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		
		
		 // ------------------------
        //  9) INDICADORES INICIALES
        // ------------------------
        actualizarIndicadores();

        // ------------------------
        //  10) EVENTOS
        // ------------------------
        btnAdd.addActionListener(e -> addRow());
        btnEdit.addActionListener(e -> editSelectedRow());
        btnDelete.addActionListener(e -> deleteSelectedRow());
        btnClear.addActionListener(e -> clearForm());
        btnResuelta.addActionListener(e -> toggleResuelta());
        btn10.addActionListener(e -> plus10Min());

        t.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedRowToForm();
            }
        });

        fr.setSize(920, 520);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    // =========================================================
    //  MÉTODOS CRUD
    // =========================================================

    private void addRow() {
        Integer id = parseInt(tfId.getText(), "Id");
        if (id == null) return;

        String aula = tfAula.getText().trim();
        if (aula.isEmpty()) {
            showError("Aula", "El aula no puede estar vacía (ej: A-12).");
            return;
        }

        String tipo = String.valueOf(cbTipo.getSelectedItem());
        String prioridad = String.valueOf(cbPrio.getSelectedItem());

        Integer minutos = parseInt(tfTiempo.getText(), "Minutos invertidos");
        if (minutos == null) return;
        if (minutos < 0) {
            showError("Minutos invertidos", "Los minutos no pueden ser negativos.");
            return;
        }

        boolean resuelta = chkResuelta.isSelected();

        m.addRow(new Object[]{id, aula, tipo, prioridad, resuelta, minutos});

        actualizarIndicadores();
        clearForm();
    }

    private void editSelectedRow() {
        int viewRow = t.getSelectedRow();
        int row = t.convertRowIndexToModel(viewRow);

        if (row == -1) {
            JOptionPane.showMessageDialog(fr, "Selecciona una incidencia para editar.");
            return;
        }

        Integer id = parseInt(tfId.getText(), "Id");
        if (id == null) return;

        String aula = tfAula.getText().trim();
        if (aula.isEmpty()) {
            showError("Aula", "El aula no puede estar vacía (ej: A-12).");
            return;
        }

        String tipo = String.valueOf(cbTipo.getSelectedItem());
        String prioridad = String.valueOf(cbPrio.getSelectedItem());

        Integer minutos = parseInt(tfTiempo.getText(), "Minutos invertidos");
        if (minutos == null) return;
        if (minutos < 0) {
            showError("Minutos invertidos", "Los minutos no pueden ser negativos.");
            return;
        }

        boolean resuelta = chkResuelta.isSelected();

        m.setValueAt(id, row, 0);
        m.setValueAt(aula, row, 1);
        m.setValueAt(tipo, row, 2);
        m.setValueAt(prioridad, row, 3);
        m.setValueAt(resuelta, row, 4);
        m.setValueAt(minutos, row, 5);

        actualizarIndicadores();
        clearForm();
    }

    private void deleteSelectedRow() {
        int viewRow = t.getSelectedRow();
        int row = t.convertRowIndexToModel(viewRow);

        if (row == -1) {
            JOptionPane.showMessageDialog(fr, "Selecciona una incidencia para borrar.");
            return;
        }

        int opt = JOptionPane.showConfirmDialog(
                fr,
                "¿Seguro que quieres borrar la incidencia seleccionada?",
                "Confirmar borrado",
                JOptionPane.YES_NO_OPTION
        );

        if (opt == JOptionPane.YES_OPTION) {
            m.removeRow(row);
            actualizarIndicadores();
            clearForm();
        }
    }

    private void loadSelectedRowToForm() {
        int row = t.getSelectedRow();
        if (row == -1) return;

        int rowModel = t.convertRowIndexToModel(row);

        tfId.setText(String.valueOf(m.getValueAt(rowModel, 0)));
        tfAula.setText(String.valueOf(m.getValueAt(rowModel, 1)));

        cbTipo.setSelectedItem(String.valueOf(m.getValueAt(rowModel, 2)));
        cbPrio.setSelectedItem(String.valueOf(m.getValueAt(rowModel, 3)));

        Boolean resueltaObj = (Boolean) m.getValueAt(rowModel, 4);
        chkResuelta.setSelected(resueltaObj != null && resueltaObj);

        tfTiempo.setText(String.valueOf(m.getValueAt(rowModel, 5)));
    }

    // =========================================================
    //  ACCIONES EXTRA
    // =========================================================

    private void toggleResuelta() {
        int viewRow = t.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(fr, "Selecciona una incidencia en la tabla.");
            return;
        }

        int row = t.convertRowIndexToModel(viewRow);

        Boolean resObj = (Boolean) m.getValueAt(row, 4);
        boolean resActual = (resObj != null) ? resObj : false;

        boolean resNuevo = !resActual;
        m.setValueAt(resNuevo, row, 4);

        chkResuelta.setSelected(resNuevo);

        actualizarIndicadores();
    }

    private void plus10Min() {
        int viewRow = t.getSelectedRow();
        if (viewRow == -1) {
            JOptionPane.showMessageDialog(fr, "Selecciona una incidencia en la tabla.");
            return;
        }

        int row = t.convertRowIndexToModel(viewRow);

        Object minObj = m.getValueAt(row, 5);
        int minutosActual = (minObj != null) ? Integer.parseInt(String.valueOf(minObj)) : 0;

        minutosActual += 10;

        m.setValueAt(minutosActual, row, 5);
        tfTiempo.setText(String.valueOf(minutosActual));

        actualizarIndicadores();
    }

    // =========================================================
    //  INDICADORES
    // =========================================================

    private void actualizarIndicadores() {
        int total = calculaTotalIncidencias(m);
        int pendientes = calculaPendientes(m);
        int tiempoTotal = calculaTiempoTotal(m);

        lblTotal.setText(String.valueOf(total));
        lblPendientes.setText(String.valueOf(pendientes));
        lblTotalGeneral.setText(String.valueOf(tiempoTotal));

    }

    public static int calculaTotalIncidencias(DefaultTableModel model) {
        return model.getRowCount();
    }

    public static int calculaPendientes(DefaultTableModel model) {
        int total = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            Object res = model.getValueAt(row, 4);
            boolean resuelta = Boolean.TRUE.equals(res);
            if (!resuelta) total++;
        }
        return total;
    }

    public static int calculaTiempoTotal(DefaultTableModel model) {
        int total = 0;
        for (int row = 0; row < model.getRowCount(); row++) {
            Object m = model.getValueAt(row, 5);
            if (m == null) continue;
            total += Integer.parseInt(String.valueOf(m));
        }
        return total;
    }

    // =========================================================
    //  LIMPIEZA + VALIDACIÓN
    // =========================================================

    private void clearForm() {
        tfId.setText("");
        tfAula.setText("");
        cbTipo.setSelectedIndex(0);
        cbPrio.setSelectedIndex(0);
        chkResuelta.setSelected(false);
        tfTiempo.setText("");

        t.clearSelection();

        tfId.requestFocus();
    }

    private Integer parseInt(String text, String field) {
        String t = text.trim();
        if (t.isEmpty()) {
            showError(field, "El campo está vacío.");
            return null;
        }
        try {
            return Integer.parseInt(t);
        } catch (NumberFormatException ex) {
            showError(field, "Debe ser un número entero.");
            return null;
        }
    }

    private void showError(String field, String msg) {
        JOptionPane.showMessageDialog(fr, msg, "Error en " + field, JOptionPane.ERROR_MESSAGE);
    }

}
