package tabla;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.ProcedimientoModelo;



	public class ModeloTablaProcedimiento extends AbstractTableModel {
	private String[] columnas = {"Código", "Descripcion", "Tratamiento", "Monto"};
	List<ProcedimientoModelo> lista = new ArrayList<ProcedimientoModelo>();
	
	
	public void setLista(List<ProcedimientoModelo> lista) {
		this.lista = lista;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int posicion) {
		// TODO Auto-generated method stub
		return columnas[posicion];
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		switch (columna) {
		case 0:
			return lista.get(fila).getId();
		case 1:
			return lista.get(fila).getDescripcion();
		case 2:
			return lista.get(fila).getTratamiento();
		case 3:
			return lista.get(fila).getMonto();
					
		default:
			return null;
		}
	}

}




