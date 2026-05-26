package componentes;

import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;

import interfaces.InterfaceABM;

import javax.swing.JScrollPane;

public class JDialogGenerico extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTable tabla;
	private JButtonABM btnNuevo;
	private JButtonABM btnEditar;
	private JButtonABM btnGuardar;
	private JButtonABM btnEliminar;
	private JButtonABM btnCancelar;
	private JTextFieldGenerico tfBuscador;
	private JPanel panelFormulario;
	private InterfaceABM interfaceABM;
	
	public void setInterfaceABM(InterfaceABM interfaceABM) {
		this.interfaceABM = interfaceABM;
	}

	/**
	 * Create the dialog.
	 */
	public JDialogGenerico() {
		setBounds(100, 100, 1008, 680);
		getContentPane().setLayout(null);
		
		btnNuevo = new JButtonABM();
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setText("Nuevo");
		btnNuevo.setBounds(10, 11, 82, 73);
		getContentPane().add(btnNuevo);
		
		panelFormulario = new JPanel();
		panelFormulario.setBackground(new Color(192, 192, 192));
		panelFormulario.setBounds(10, 92, 455, 518);
		getContentPane().add(panelFormulario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 92, 507, 518);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		JLabelGenerico labelGenerico = new JLabelGenerico((String) null);
		labelGenerico.setBounds(594, 57, 1, 1);
		getContentPane().add(labelGenerico);
		
		JLabelGenerico labelGenerico_1 = new JLabelGenerico((String) null);
		labelGenerico_1.setBounds(568, 57, 1, 1);
		getContentPane().add(labelGenerico_1);
		
		JLabelGenerico lblgnrcBuscador = new JLabelGenerico((String) null);
		lblgnrcBuscador.setText("Buscador:");
		lblgnrcBuscador.setBounds(475, 52, 75, 27);
		getContentPane().add(lblgnrcBuscador);
		
		tfBuscador = new JTextFieldGenerico();
		tfBuscador.setBounds(549, 53, 433, 24);
		getContentPane().add(tfBuscador);
		
		btnEditar = new JButtonABM();
		btnEditar.setText("Editar");
		btnEditar.setBounds(102, 11, 82, 73);
		getContentPane().add(btnEditar);
		
		btnGuardar = new JButtonABM();
		btnGuardar.setText("Guardar");
		btnGuardar.setBounds(194, 11, 82, 73);
		getContentPane().add(btnGuardar);
		
		btnEliminar = new JButtonABM();
		btnEliminar.setText("Eliminar");
		btnEliminar.setBounds(286, 11, 82, 73);
		getContentPane().add(btnEliminar);
		
		btnCancelar = new JButtonABM();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(383, 11, 82, 73);
		getContentPane().add(btnCancelar);

		setAcciones();
		
	}
	
	private void setAcciones() {
		btnNuevo.addActionListener(this);
		btnEditar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnCancelar.addActionListener(this);
		tfBuscador.setActionCommand("Buscar");
		tfBuscador.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Nuevo":
			interfaceABM.nuevo();
			break;
		case "Editar":
			interfaceABM.editar();
			break;
		case "Guardar":
			interfaceABM.guardar();
			break;
		case "Eliminar":
			interfaceABM.eliminar();
			break;
		case "Cancelar":
			interfaceABM.cancelar();
			break;
		case "Buscar":
			interfaceABM.buscar();
			break;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTable getTabla() {
		return tabla;
	}

	public JButtonABM getBtnNuevo() {
		return btnNuevo;
	}

	public JButtonABM getBtnEditar() {
		return btnEditar;
	}

	public JButtonABM getBtnGuardar() {
		return btnGuardar;
	}

	public JButtonABM getBtnEliminar() {
		return btnEliminar;
	}

	public JButtonABM getBtnCancelar() {
		return btnCancelar;
	}

	public JTextFieldGenerico getTfBuscador() {
		return tfBuscador;
	}

	public JPanel getPanelFormulario() {
		return panelFormulario;
	}

	public InterfaceABM getInterfaceABM() {
		return interfaceABM;
	}
}
