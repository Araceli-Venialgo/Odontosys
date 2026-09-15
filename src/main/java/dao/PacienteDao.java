package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.PacienteModelo;

public class PacienteDao extends GenericDAO<PacienteModelo> {

	public PacienteDao() {
		super(PacienteModelo.class);
		
	}

	public List<PacienteModelo> buscarPorFiltro(String filtro) {
		try(Session session = getSession()){
			String hql = "FROM tb_paciente WHERE nombre ILIKE :filtro OR apellido ILIKE :filtro "
					+ " OR documento ILIKE :filtro ORDER BY id";
			Query<PacienteModelo> query = session.createQuery(hql, PacienteModelo.class);
			query.setParameter("filtro", "%"+filtro+"%");
			return query.getResultList();
		}
		
	}

}
