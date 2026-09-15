package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.sql.rowset.FilteredRowSet;
import javax.swing.JOptionPane;


import dao.PacienteDao;
import interfaces.InterfaceABM;

import modelo.PacienteModelo;
import tabla.ModeloTablaPaciente;

import util.FechaUtil;

import vista.PacienteVista;

public class PacienteController implements InterfaceABM {
    private PacienteVista vista;
    private PacienteModelo paciente;
    private PacienteDao dao;
    private List<PacienteModelo> pacientes;
    private ModeloTablaPaciente tabla;

        public PacienteController(PacienteVista pacienteVista) {
            super();
            this.vista = pacienteVista;
            this.vista.setInterfaceABM(this); 
            dao = new PacienteDao();
            tabla = new ModeloTablaPaciente();
            this.vista.getTabla().setModel(tabla);
            cargarTabla("");

            
            this.vista.getTabla().getSelectionModel().addListSelectionListener(e -> {
                int fila = vista.getTabla().getSelectedRow();
                if (fila >= 0) {
                    paciente = pacientes.get(fila); 
                    this.vista.getBtnEditar().setEnabled(true);
                    this.vista.getBtnEliminar().setEnabled(true);
                }
            });

                
            

            estadoInicial();
        }

        private void cargarTabla(String filtro) {
            pacientes = dao.buscarPorFiltro(filtro);
            tabla.setLista(pacientes);
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
            this.vista.getTfFechaNacimiento().setEnabled(false);
            this.vista.getTfCorreo().setEnabled(false);
            this.vista.getTfTelefono().setEnabled(false);

            this.vista.getTfFechaNacimiento().setValue(null);
            this.vista.getTfNombre().setText("");
            this.vista.getTfApellido().setText("");
            this.vista.getTfDocumento().setText("");
            this.vista.getTfCorreo().setText("");
            this.vista.getTfTelefono().setText("");
            paciente = null;
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
            this.vista.getTfFechaNacimiento().setEnabled(true);
            this.vista.getTfCorreo().setEnabled(true);
            this.vista.getTfTelefono().setEnabled(true);

            paciente = new PacienteModelo(); 
        }

        @Override
        public void editar() {
            if (paciente == null) {
                JOptionPane.showMessageDialog(null, "Seleccione un paciente primero");
                return;
            }

            this.vista.getTfNombre().setText(paciente.getNombre());
            this.vista.getTfApellido().setText(paciente.getApellido());
            this.vista.getTfDocumento().setText(paciente.getDocumento());
            this.vista.getTfFechaNacimiento().setText(FechaUtil.fechaAString(paciente.getFechaNac()));
            this.vista.getTfCorreo().setText(paciente.getEmail());
            this.vista.getTfTelefono().setText(paciente.getTelefono());

            this.vista.getTfNombre().setEnabled(true);
            this.vista.getTfApellido().setEnabled(true);
            this.vista.getTfDocumento().setEnabled(true);
            this.vista.getTfFechaNacimiento().setEnabled(true);
            this.vista.getTfCorreo().setEnabled(true);
            this.vista.getTfTelefono().setEnabled(true);

            this.vista.getBtnNuevo().setEnabled(false);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnGuardar().setEnabled(true);
            this.vista.getBtnEliminar().setEnabled(false);
        }


        @Override
        public void guardar() {
            if (paciente == null) {
                paciente = new PacienteModelo(); 
            }

            if (this.vista.getTfNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
                return;
            }

            paciente.setFechaNac(FechaUtil.stringAFecha(this.vista.getTfFechaNacimiento().getText()));
            paciente.setNombre(this.vista.getTfNombre().getText());
            paciente.setApellido(this.vista.getTfApellido().getText());
            paciente.setDocumento(this.vista.getTfDocumento().getText());
            paciente.setTelefono(this.vista.getTfTelefono().getText());
            paciente.setEmail(this.vista.getTfCorreo().getText());

            try {
                dao.guardar(paciente);
                cargarTabla("");
                estadoInicial();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar() {
            if (paciente == null) return;

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estas seguro que deseas eliminar al paciente " + paciente.getNombre() + " " + paciente.getApellido() + "?",
                    "Atención", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    dao.eliminar(paciente);
                    estadoInicial();
                    cargarTabla("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void cancelar() {
            if (paciente == null)
                this.vista.dispose();
            else
                estadoInicial();
        }

        @Override
        public void buscar() {
            cargarTabla(vista.getTfBuscador().getText());
        }
    }


 


