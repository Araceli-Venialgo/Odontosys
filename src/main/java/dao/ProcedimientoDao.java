package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import modelo.ProcedimientoModelo;

public class ProcedimientoDao extends GenericDAO<ProcedimientoModelo>{

	public ProcedimientoDao() {
		super(ProcedimientoModelo.class);
		
			}
	public List<ProcedimientoModelo> buscarPorFiltro(String filtro) {
		try(Session session = getSession()){
			String hql = "FROM tb_procedimiento WHERE descripcion ILIKE :filtro OR tratamiento ILIKE :filtro "
					+ " ORDER BY id";
			Query<ProcedimientoModelo> query = session.createQuery(hql, ProcedimientoModelo.class);
			query.setParameter("filtro", "%"+filtro+"%");
			return query.getResultList();
		}
		

	}
}
