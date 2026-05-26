package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import componentes.JButtonAccesoDirecto;
import componentes.JPanelPersonalizado;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import componentes.JMenuItemPersonalizado;



public class PantallaPrincipalVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanelPersonalizado contentPane;
	private JMenuItemPersonalizado mnGPOdontologo;
	private JMenuItemPersonalizado mnGPPacientes;
	private JMenuItemPersonalizado mnACReceta;
	private JMenuItemPersonalizado mnACProcedimientos;
	private JMenuItemPersonalizado mnACConsulta;
	private JMenu mnNewMenu_2;
	private JButtonAccesoDirecto btnPacientes;
	private JButtonAccesoDirecto btnOdontologo;
	private JButtonAccesoDirecto btnAgendamiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipalVista frame = new PantallaPrincipalVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipalVista() {
		setLocationRelativeTo(this);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("OdontoSys");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 780);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Gestión de Personas");
		menuBar.add(mnNewMenu);
		
		mnGPOdontologo = new JMenuItemPersonalizado();
		mnGPOdontologo.setText("odontologo");
		mnNewMenu.add(mnGPOdontologo);
		
		mnGPPacientes = new JMenuItemPersonalizado();
		mnGPPacientes.setText("pacientes");
		mnNewMenu.add(mnGPPacientes);
		
		JMenu mnNewMenu_1 = new JMenu("Atención Clinica");
		menuBar.add(mnNewMenu_1);
		
		mnACReceta = new JMenuItemPersonalizado();
		mnACReceta.setText("receta");
		mnNewMenu_1.add(mnACReceta);
		
		mnACProcedimientos = new JMenuItemPersonalizado();
		mnACProcedimientos.setText("procedimientos");
		mnNewMenu_1.add(mnACProcedimientos);
		
		mnACConsulta = new JMenuItemPersonalizado();
		mnACConsulta.setText("consulta");
		mnNewMenu_1.add(mnACConsulta);
		
		mnNewMenu_2 = new JMenu("Organización");
		menuBar.add(mnNewMenu_2);
		
		JMenuItemPersonalizado mnOrgAgendamiento = new JMenuItemPersonalizado();
		mnOrgAgendamiento.setText("agendamiento");
		mnNewMenu_2.add(mnOrgAgendamiento);
		contentPane = new JPanelPersonalizado("imagen.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOdontologo = new JButtonAccesoDirecto();
		btnOdontologo.setText("odontologo");
		btnOdontologo.setBounds(318, 47, 157, 131);
		contentPane.add(btnOdontologo);
		
		btnAgendamiento = new JButtonAccesoDirecto();
		btnAgendamiento.setText("agendamiento");
		btnAgendamiento.setBounds(542, 55, 185, 131);
		contentPane.add(btnAgendamiento);
		
		btnPacientes = new JButtonAccesoDirecto();
		btnPacientes.setText("pacientes");
		btnPacientes.setBounds(107, 44, 163, 137);
		contentPane.add(btnPacientes);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanelPersonalizado getContentPane() {
		return contentPane;
	}

	public JMenuItemPersonalizado getMnGPOdontologo() {
		return mnGPOdontologo;
	}

	public JMenuItemPersonalizado getMnGPPacientes() {
		return mnGPPacientes;
	}

	public JMenuItemPersonalizado getMnACReceta() {
		return mnACReceta;
	}

	public JMenuItemPersonalizado getMnACProcedimientos() {
		return mnACProcedimientos;
	}

	public JMenuItemPersonalizado getMnACConsulta() {
		return mnACConsulta;
	}

	public JMenu getMnNewMenu_2() {
		return mnNewMenu_2;
	}

	public JButtonAccesoDirecto getBtnPacientes() {
		return btnPacientes;
	}

	public JButtonAccesoDirecto getBtnOdontologo() {
		return btnOdontologo;
	}

	public JButtonAccesoDirecto getBtnAgendamiento() {
		return btnAgendamiento;
	}
	
}
