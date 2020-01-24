package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de Clientes");
		model.addAttribute("clientes",clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cli = new Cliente(); 
		model.put("cliente", cli);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value="id") long id, Map<String, Object> model) {
		Cliente cli = null;
		if(id>0) {
			cli = clienteDao.findOne(id);
		}
		else {
			return "redirect:listar";
		}
		model.put("cliente", cli);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid  Cliente cli, BindingResult result, Model model,SessionStatus sessionStatus) {
		if(result.hasErrors())
		{
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		clienteDao.save(cli);
		sessionStatus.setComplete();
		return "redirect:listar";
	}
}
