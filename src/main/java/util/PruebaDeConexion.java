package util;

import dao.PacienteDao;
import modelo.PacienteModelo;

public class PruebaDeConexion {
	public static void main(String[]args) {
		System.out.println("Inicio de prueba de conexion");
		try {
			PacienteDao pDao	 = new PacienteDao();
			PacienteModelo paciente = new PacienteModelo();
			paciente.setDocumento("1234568");
			paciente.setNombre("Nancy");
			paciente.setApellido("Vazquez");
			
			pDao.guardar(paciente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
