package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import modelo.OdontologoModelo;


public class OdontologoDao extends GenericDAO<OdontologoModelo> {

	public OdontologoDao() {
		super(OdontologoModelo.class);
		
	}

	public List<OdontologoModelo> buscarPorFiltro(String filtro) {
		try(Session session = getSession()){
			String hql = "FROM tb_odontologo WHERE nombre ILIKE :filtro OR apellido ILIKE :filtro "
					+ " OR documento ILIKE :filtro ORDER BY id";
			Query<OdontologoModelo> query = session.createQuery(hql, OdontologoModelo.class);
			query.setParameter("filtro", "%"+filtro+"%");
			return query.getResultList();
		}
	}
	
}


