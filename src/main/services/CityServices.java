package com.emsalcengiz.services;

import java.util.List;

import com.emsalcengiz.entities.Citys;

public interface CityServices {
	public List<Citys> list();

	public boolean delete(Citys citys);

	public boolean saveCity(Citys citys);

	public boolean updateCity(Citys citys);

	public Citys getCity(int id);

	public void removeCity(int id);
}