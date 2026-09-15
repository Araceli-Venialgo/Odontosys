package controlador;

import java.util.List;

import javax.swing.JOptionPane;

import dao.OdontologoDao;
import interfaces.InterfaceABM;
import modelo.OdontologoModelo;
import tabla.ModeloTablaOdontologo;
import util.FechaUtil;
import vista.OdontologoVista;


public class OdontologoController implements InterfaceABM {
    private OdontologoVista vista;
    private OdontologoModelo odontologo;
    private OdontologoDao dao;
    private List<OdontologoModelo> odontologos;
    private ModeloTablaOdontologo tabla;

        public OdontologoController(OdontologoVista odontologoVista) {
            super();
            this.vista = odontologoVista;
            this.vista.setInterfaceABM(this); 
            dao = new OdontologoDao();
            tabla = new ModeloTablaOdontologo();
            this.vista.getTabla().setModel(tabla);
            cargarTabla("");

            
            this.vista.getTabla().getSelectionModel().addListSelectionListener(e -> {
                int fila = vista.getTabla().getSelectedRow();
                if (fila >= 0) {
                    odontologo = odontologos.get(fila); 
                    this.vista.getBtnEditar().setEnabled(true);
                    this.vista.getBtnEliminar().setEnabled(true);
                }
            });

                
            

            estadoInicial();
        }

        private void cargarTabla(String filtro) {
            odontologos = dao.buscarPorFiltro(filtro);
            tabla.setLista(odontologos);
        }

        private void estadoInicial() {
            this.vista.getBtnNuevo().setEnabled(true);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnEliminar().setEnabled(false);
            this.vista.getBtnCancelar().setEnabled(true);
            this.vista.getBtnGuardar().setEnabled(false);

            this.vista.getTfNombre().setEnabled(false);
            this.vista.getTfApellido().setEnabled(false);
            this.vista.getTfDocumento().setEnabled(false);
            this.vista.getTfCorreo().setEnabled(false);
            this.vista.getTfTelefono().setEnabled(false);
            this.vista.getTfEspecialidad().setEnabled(false);

           
        }

        @Override
        public void nuevo() {
            this.vista.getBtnNuevo().setEnabled(false);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnEliminar().setEnabled(false);
            this.vista.getBtnCancelar().setEnabled(true);
            this.vista.getBtnGuardar().setEnabled(true);

            this.vista.getTfNombre().setEnabled(true);
            this.vista.getTfApellido().setEnabled(true);
            this.vista.getTfDocumento().setEnabled(true);
            this.vista.getTfCorreo().setEnabled(true);
            this.vista.getTfTelefono().setEnabled(true);
            this.vista.getTfEspecialidad().setEnabled(true);

            odontologo = new OdontologoModelo(); 
        }

        @Override
        public void editar() {
            if (odontologo == null) {
                JOptionPane.showMessageDialog(null, "Seleccione un odontologo primero");
                return;
            }

            this.vista.getTfNombre().setText(odontologo.getNombre());
            this.vista.getTfApellido().setText(odontologo.getApellido());
            this.vista.getTfDocumento().setText(odontologo.getDocumento());
            this.vista.getTfCorreo().setText(odontologo.getEmail());
            this.vista.getTfTelefono().setText(odontologo.getTelefono());
            this.vista.getTfEspecialidad().setText(odontologo.getEspecialidad());

            this.vista.getTfNombre().setEnabled(true);
            this.vista.getTfApellido().setEnabled(true);
            this.vista.getTfDocumento().setEnabled(true);
            this.vista.getTfCorreo().setEnabled(true);
            this.vista.getTfTelefono().setEnabled(true);
            this.vista.getTfEspecialidad().setEnabled(true);

            this.vista.getBtnNuevo().setEnabled(false);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnGuardar().setEnabled(true);
            this.vista.getBtnEliminar().setEnabled(false);
        }


        @Override
        public void guardar() {
            if (odontologo == null) {
                odontologo = new OdontologoModelo(); 
            }

            if (this.vista.getTfNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
                return;
            }

            odontologo.setNombre(this.vista.getTfNombre().getText());
            odontologo.setApellido(this.vista.getTfApellido().getText());
            odontologo.setDocumento(this.vista.getTfDocumento().getText());
            odontologo.setTelefono(this.vista.getTfTelefono().getText());
            odontologo.setEmail(this.vista.getTfCorreo().getText());
            odontologo.setEspecialidad(this.vista.getTfEspecialidad().getText());

            try {
                dao.guardar(odontologo);
                cargarTabla("");
                estadoInicial();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar() {
            if (odontologo == null) return;

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estas seguro que deseas eliminar al odontologo " + odontologo.getNombre() + " " + odontologo.getApellido() + "?",
                    "Atención", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    dao.eliminar(odontologo);
                    estadoInicial();
                    cargarTabla("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void cancelar() {
            if (odontologo == null)
                this.vista.dispose();
            else
                estadoInicial();
        }

        @Override
        public void buscar() {
            cargarTabla(vista.getTfBuscador().getText());
        }
        
    }


 


