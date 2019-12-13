package com.emsalcengiz.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emsalcengiz.dao.CityDao;
import com.emsalcengiz.entities.Citys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class CityDaoImpl implements CityDao {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Citys> list() {
		return sessionFactory.getCurrentSession().createCriteria(Citys.class).list();

	}

	public boolean delete(Citys citys) {
		try {
			sessionFactory.getCurrentSession().delete(citys);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean saveCitys(Citys citys) {
		sessionFactory.getCurrentSession().save(citys);
		return true;
	}

	public Citys getCity(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		// get city
		Citys city= (Citys) session.get(Citys.class, new Integer(id));
		return city;
	}

	public void removeCity(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Citys p = (Citys) session.load(Citys.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("City deleted successfully, City details=" + p);

	}

	public boolean updateCity(Citys citys) { 
		sessionFactory.getCurrentSession().update(citys); 
		return true;
	}

}