package vista;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import componentes.JDialogGenerico;
import componentes.JLabelGenerico;
import componentes.JTextFieldGenerico;
import controlador.OdontologoController;



public class OdontologoVista extends JDialogGenerico{
	 private static final long serialVersionUID = 1L;
	    
	    // Atributos de la vista
	    private JTextFieldGenerico tfNombre;
	    private JTextFieldGenerico tfApellido;
	    private JTextFieldGenerico tfDocumento;
	    private JTextFieldGenerico tfTelefono;
	    private JTextFieldGenerico tfCorreo;
	    private JTextFieldGenerico tfEspecialidad;
	    
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    OdontologoVista dialog = new OdontologoVista();
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
	        new OdontologoController(this);
	    }

	    // Constructor inicializa los componentes
	    public OdontologoVista() {
	        getPanelFormulario().setBackground(SystemColor.menu);
	        getPanelFormulario().setLayout(null);
	        
	        JLabelGenerico lblgnrcNombre = new JLabelGenerico((String) null);
	        lblgnrcNombre.setText("Nombre:");
	        lblgnrcNombre.setBounds(10, 10, 70, 25);
	        getPanelFormulario().add(lblgnrcNombre);
	        
	        JLabelGenerico lblgnrcApellido = new JLabelGenerico((String) null);
	        lblgnrcApellido.setText("Apellido:");
	        lblgnrcApellido.setBounds(10, 64, 70, 25);
	        getPanelFormulario().add(lblgnrcApellido);
	        
	        JLabelGenerico lblgnrcDocumento = new JLabelGenerico((String) null);
	        lblgnrcDocumento.setText("Documento:");
	        lblgnrcDocumento.setBounds(10, 118, 80, 25);
	        getPanelFormulario().add(lblgnrcDocumento);
	        
	        JLabelGenerico lblgnrcTelefono = new JLabelGenerico((String) null);
	        lblgnrcTelefono.setText("Telefono:");
	        lblgnrcTelefono.setBounds(10, 229, 70, 25);
	        getPanelFormulario().add(lblgnrcTelefono);
	        
	        JLabelGenerico lblgnrcCorreo = new JLabelGenerico((String) null);
	        lblgnrcCorreo.setText("Correo:");
	        lblgnrcCorreo.setBounds(10, 299, 70, 25);
	        getPanelFormulario().add(lblgnrcCorreo);
	        
	        JLabelGenerico lblgnrcEspecialidad = new JLabelGenerico((String) null);
	        lblgnrcEspecialidad.setText("Especialidad:");
	        lblgnrcEspecialidad.setBounds(10, 177, 80, 25);
	        getPanelFormulario().add(lblgnrcEspecialidad);
	        
	        // Inicialización de campos
	        tfNombre = new JTextFieldGenerico();
	        tfNombre.setBounds(90, 10, 241, 24);
	        getPanelFormulario().add(tfNombre);
	        
	        tfApellido = new JTextFieldGenerico();
	        tfApellido.setBounds(90, 64, 241, 24);
	        getPanelFormulario().add(tfApellido);
	        
	        tfDocumento = new JTextFieldGenerico();
	        tfDocumento.setBounds(100, 118, 148, 24);
	        getPanelFormulario().add(tfDocumento);
	        
	        
	        tfTelefono = new JTextFieldGenerico();
	        tfTelefono.setBounds(90, 229, 241, 24);
	        getPanelFormulario().add(tfTelefono);
	        
	        tfCorreo = new JTextFieldGenerico();
	        tfCorreo.setBounds(90, 299, 241, 24);
	        getPanelFormulario().add(tfCorreo);
	        
	     
	        
	       tfEspecialidad = new JTextFieldGenerico();
	       tfEspecialidad.setBounds(102, 177, 183, 24);
	       getPanelFormulario().add(tfEspecialidad);
	    		   
	        
	       
	        
	       
	        
	       
	        
	       
	        
	        
	    }

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public JTextFieldGenerico getTfNombre() {
			return tfNombre;
		}

		public JTextFieldGenerico getTfApellido() {
			return tfApellido;
		}

		public JTextFieldGenerico getTfDocumento() {
			return tfDocumento;
		}

		public JTextFieldGenerico getTfTelefono() {
			return tfTelefono;
		}

		public JTextFieldGenerico getTfCorreo() {
			return tfCorreo;
		}

		public JTextFieldGenerico getTfEspecialidad() {
			return tfEspecialidad;
		}
}
