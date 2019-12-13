package com.emsalcengiz.dao;
import java.util.List;

import com.emsalcengiz.entities.Citys;

public interface CityDao {
	public List<Citys> list();

	public boolean delete(Citys citys);

	public Citys getCity(int id);

	public void removeCity(int id);

	public boolean saveCity(Citys citys);

	public boolean updateCity(Citys citys);

}