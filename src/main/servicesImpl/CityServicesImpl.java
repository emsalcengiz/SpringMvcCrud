package com.emsalcengiz.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsalcengiz.dao.CityDao;
import com.emsalcengiz.entities.Citys;
import com.emsalcengiz.services.CityServices;

@Service
public class CityServicesImpl implements CityServices {

	@Autowired
	CityDao cityDao;

	public List<Citys> list() {
		return cityDao.list();
	}

	public boolean delete(Citys citys) {
		return cityDao.delete(citys);
	}

	public boolean saveCity(Citys citys) {
		return cityDao.saveCity(citys);
	}

	public Citys getCity(int id) {
		return cityDao.getCity(id);
	}

	public void removeCity(int id) {
		cityDao.removeCity(id);

	}

	public boolean updateCity(Citys citys) {
		return cityDao.updateCity(citys);
	}

}