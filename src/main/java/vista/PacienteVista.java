package vista;

import componentes.JDialogGenerico;
import java.awt.Color;
import java.awt.EventQueue;

import controlador.PacienteController;
import util.FechaUtil;
import componentes.JTextFieldGenerico;
import componentes.JLabelGenerico;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.SystemColor;

public class PacienteVista extends JDialogGenerico {
    
    private static final long serialVersionUID = 1L;
    
    // Atributos de la vista
    private JTextFieldGenerico tfNombre;
    private JTextFieldGenerico tfApellido;
    private JTextFieldGenerico tfDocumento;
    private JFormattedTextField tfFechaNac;
    private JTextFieldGenerico tfTelefono;
    private JTextFieldGenerico tfCorreo;
    
   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PacienteVista dialog = new PacienteVista();
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
        new PacienteController(this);
    }

    // Constructor inicializa los componentes
    public PacienteVista() {
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
        
        JLabelGenerico lblgnrcFechaNacimiento = new JLabelGenerico((String) null);
        lblgnrcFechaNacimiento.setText("Fecha Nacimiento:");
        lblgnrcFechaNacimiento.setBounds(10, 172, 126, 25);
        getPanelFormulario().add(lblgnrcFechaNacimiento);
        
        JLabelGenerico lblgnrcTelefono = new JLabelGenerico((String) null);
        lblgnrcTelefono.setText("Telefono:");
        lblgnrcTelefono.setBounds(10, 226, 70, 25);
        getPanelFormulario().add(lblgnrcTelefono);
        
        JLabelGenerico lblgnrcCorreo = new JLabelGenerico((String) null);
        lblgnrcCorreo.setText("Correo:");
        lblgnrcCorreo.setBounds(10, 280, 70, 25);
        getPanelFormulario().add(lblgnrcCorreo);
        
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
        
        tfFechaNac = new JFormattedTextField(FechaUtil.getFormatoFecha());
		tfFechaNac.setBounds(134, 172, 100, 25);
		getPanelFormulario().add(tfFechaNac);
        
        tfTelefono = new JTextFieldGenerico();
        tfTelefono.setBounds(90, 226, 241, 24);
        getPanelFormulario().add(tfTelefono);
        
        tfCorreo = new JTextFieldGenerico();
        tfCorreo.setBounds(90, 280, 241, 24);
        getPanelFormulario().add(tfCorreo);
    }

    // Getters para acceder desde el controlador
    public JTextFieldGenerico getTfNombre() {
        return tfNombre;
    }

    public JTextFieldGenerico getTfApellido() {
        return tfApellido;
    }

    public JTextFieldGenerico getTfDocumento() {
        return tfDocumento;
    }

    public JFormattedTextField getTfFechaNacimiento() {
        return tfFechaNac;
    }

    public JTextFieldGenerico getTfTelefono() {
        return tfTelefono;
    }

    public JTextFieldGenerico getTfCorreo() {
        return tfCorreo;
    }
}
