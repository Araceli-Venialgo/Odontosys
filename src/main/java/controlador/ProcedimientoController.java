package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.sql.rowset.FilteredRowSet;
import javax.swing.JOptionPane;

import dao.ProcedimientoDao;
import interfaces.InterfaceABM;
import modelo.ProcedimientoModelo;
import tabla.ModeloTablaProcedimiento;
import vista.ProcedimientoVista;


public class ProcedimientoController implements InterfaceABM {
    private ProcedimientoVista vista;
    private ProcedimientoModelo procedimiento;
    private ProcedimientoDao dao;
    private List<ProcedimientoModelo> procedimientos;
    private ModeloTablaProcedimiento tabla;

        public ProcedimientoController(ProcedimientoVista procedimientoVista) {
            super();
            this.vista = procedimientoVista;
            this.vista.setInterfaceABM(this); 
            dao = new ProcedimientoDao();
            tabla = new ModeloTablaProcedimiento();
            this.vista.getTabla().setModel(tabla);
            cargarTabla("");

            
            this.vista.getTabla().getSelectionModel().addListSelectionListener(e -> {
                int fila = vista.getTabla().getSelectedRow();
                if (fila >= 0) {
                    procedimiento = procedimientos.get(fila); 
                    this.vista.getBtnEditar().setEnabled(true);
                    this.vista.getBtnEliminar().setEnabled(true);
                }
            });

                
            

            estadoInicial();
        }

        private void cargarTabla(String filtro) {
            procedimientos = dao.buscarPorFiltro(filtro);
            tabla.setLista(procedimientos);
        }

        private void estadoInicial() {
            this.vista.getBtnNuevo().setEnabled(true);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnEliminar().setEnabled(false);
            this.vista.getBtnCancelar().setEnabled(true);
            this.vista.getBtnGuardar().setEnabled(false);

            this.vista.getTfDescripcion().setEnabled(false);
            this.vista.getTfTratamiento().setEnabled(false);
            this.vista.getTfMonto().setEnabled(false);
           

            
            this.vista.getTfDescripcion().setText("");
            this.vista.getTfTratamiento().setText("");
            this.vista.getTfMonto().setText("");
            
            procedimiento = null;
        }

        @Override
        public void nuevo() {
            this.vista.getBtnNuevo().setEnabled(false);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnEliminar().setEnabled(false);
            this.vista.getBtnCancelar().setEnabled(true);
            this.vista.getBtnGuardar().setEnabled(true);

            this.vista.getTfDescripcion().setEnabled(true);
            this.vista.getTfTratamiento().setEnabled(true);
            this.vista.getTfMonto().setEnabled(true);
            

            procedimiento = new ProcedimientoModelo(); 
        }

        @Override
        public void editar() {
            if (procedimiento == null) {
                JOptionPane.showMessageDialog(null, "Seleccione un procedimiento primero");
                return;
            }

            this.vista.getTfDescripcion().setText(procedimiento.getDescripcion());
            this.vista.getTfTratamiento().setText(procedimiento.getTratamiento());
            this.vista.getTfMonto().setText(String.valueOf(procedimiento.getMonto()));


            this.vista.getTfDescripcion().setEnabled(true);
            this.vista.getTfTratamiento().setEnabled(true);
            this.vista.getTfMonto().setEnabled(true);
            

            this.vista.getBtnNuevo().setEnabled(false);
            this.vista.getBtnEditar().setEnabled(false);
            this.vista.getBtnGuardar().setEnabled(true);
            this.vista.getBtnEliminar().setEnabled(false);
        }


        @Override
        public void guardar() {
            if (procedimiento == null) {
                procedimiento = new ProcedimientoModelo(); 
            }

            if (this.vista.getTfTratamiento().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El tratamiento es un campo obligatorio");
                return;
            }

 
            procedimiento.setDescripcion(this.vista.getTfDescripcion().getText());
            procedimiento.setTratamiento(this.vista.getTfTratamiento().getText());
            procedimiento.setMonto(Double.parseDouble(this.vista.getTfMonto().getText()));


          

            try {
                dao.guardar(procedimiento);
                cargarTabla("");
                estadoInicial();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void eliminar() {
            if (procedimiento == null) return;

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estas seguro que deseas eliminar el procedimiento " + procedimiento.getDescripcion() + "?",
                    "Atención", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    dao.eliminar(procedimiento);
                    estadoInicial();
                    cargarTabla("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void cancelar() {
            if (procedimiento == null)
                this.vista.dispose();
            else
                estadoInicial();
        }

        @Override
        public void buscar() {
            cargarTabla(vista.getTfBuscador().getText());
        }
    }


 
