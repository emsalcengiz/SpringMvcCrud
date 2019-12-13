package com.emsalcengiz.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emsalcengiz.entities.Citys;
import com.emsalcengiz.services.CityServices;

@Controller
@RequestMapping(value = "citys")
public class CityController {

	@Autowired
	CityServices cityServices;
 

	 
	@RequestMapping(value = "/getPageCityAdd", method = RequestMethod.GET)
	private ModelAndView getPageCityAdd() {
		ModelAndView view = new ModelAndView("addCity");
		view.addObject("citys", new Citys());
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addCitys(@ModelAttribute("city") Citys citys) {
		cityServices.saveCity(city);
		return "redirect:/citys/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCitys(@ModelAttribute("city") Citys citys) {
		
		
		cityServices.updateCity(city); 
		return "redirect:/citys/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getAll(Citys citys) {
		ModelAndView view = new ModelAndView("homePage");
		List<Citys> data = cityServices.list();
		view.addObject("datas", data);

		return view;
	}

	@RequestMapping(value = "/cityDelete/{id}")
	public String delete(@PathVariable("id") int id) {
		cityServices.removeCitys(id);
		return "redirect:/citys/list";
	}

	@RequestMapping("/edit/{id}")
	public String editCity(@PathVariable("id") int id, Model model) {
		model.addAttribute("city", this.cityServices.getCity(id));
		return "editCity";
	}
}