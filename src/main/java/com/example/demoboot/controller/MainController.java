package com.example.demoboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoboot.dao.PersonDAO;
import com.example.demoboot.entity.Person;


@Controller
public class MainController {

	@Autowired
	private PersonDAO personDAO;

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personDAO.findAll();

		StringBuilder sb = new StringBuilder();

		all.forEach(p -> sb.append(p.getFullName() + "<br>"));

		return sb.toString();
	}

}