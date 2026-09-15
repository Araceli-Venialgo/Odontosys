package vista;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JDialog;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JTextFieldGenerico;
import controlador.OdontologoController;
import controlador.ProcedimientoController;

public class ProcedimientoVista extends JDialogGenerico{
		 private static final long serialVersionUID = 1L;
		    
		    // Atributos de la vista
		    private JTextFieldGenerico tfDescripcion;
		    private JTextFieldGenerico tfTratamiento;
		    private JTextFieldGenerico tfMonto;
		  
		    
		    
		    public static void main(String[] args) {
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                    ProcedimientoVista dialog = new ProcedimientoVista();
		                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		                    dialog.setControlador();
		                    dialog.setVisible(true);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		    }
		    
		    // Vincula el controlador
		    public void setControlador() {
		        new ProcedimientoController(this);
		    }

		    // Constructor inicializa los componentes
		    public ProcedimientoVista() {
		        getPanelFormulario().setBackground(SystemColor.menu);
		        getPanelFormulario().setLayout(null);
		        
		        JLabelGenerico lblgnrcDescripcion = new JLabelGenerico((String) null);
		        lblgnrcDescripcion.setText("Descripcion:");
		        lblgnrcDescripcion.setBounds(17, 37, 87, 25);
		        getPanelFormulario().add(lblgnrcDescripcion);
		        
		        JLabelGenerico lblgnrcTratamiento = new JLabelGenerico((String) null);
		        lblgnrcTratamiento.setText("Tratamiento:");
		        lblgnrcTratamiento.setBounds(17, 130, 87, 25);
		        getPanelFormulario().add(lblgnrcTratamiento);
		        
		        JLabelGenerico lblgnrcMonto = new JLabelGenerico((String) null);
		        lblgnrcMonto.setText("Monto:");
		        lblgnrcMonto.setBounds(24, 200, 80, 25);
		        getPanelFormulario().add(lblgnrcMonto);
		       
		        
		        // Inicialización de campos
		        tfDescripcion = new JTextFieldGenerico();
		        tfDescripcion.setBounds(107, 10, 251, 79);
		        getPanelFormulario().add(tfDescripcion);
		        
		        tfTratamiento = new JTextFieldGenerico();
		        tfTratamiento.setBounds(107, 130, 241, 24);
		        getPanelFormulario().add(tfTratamiento);
		        
		        tfMonto = new JTextFieldGenerico();
		        tfMonto.setBounds(107, 200, 184, 24);
		        getPanelFormulario().add(tfMonto);
		        
	
		        
		    }

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			public JTextFieldGenerico getTfDescripcion() {
				return tfDescripcion;
			}

			public JTextFieldGenerico getTfTratamiento() {
				return tfTratamiento;
			}

			public JTextFieldGenerico getTfMonto() {
				return tfMonto;
			}

			
	}



