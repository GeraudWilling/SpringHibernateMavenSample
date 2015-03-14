package com.springHibMaven.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springHibMaven.model.Pessoa;
import com.springHibMaven.service.PessoaService;

@Controller
@RequestMapping(value="/Pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService PessoaService;
	
	/**
	 * carrega formulario de adicionar pessoa
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPessoaPage() {
		ModelAndView modelAndView = new ModelAndView("adicionar-pessoa-form");
		modelAndView.addObject("Pessoa", new Pessoa());
		return modelAndView;
	}
	
	/**
	 * adiciona uma pessoa e redireciona a home page
	 * @param Pessoa
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPessoa(@ModelAttribute Pessoa Pessoa) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		PessoaService.addPessoa(Pessoa);
		
		String mensagem = "Pessoa adicionada com sucesso!";
		modelAndView.addObject("mensagem", mensagem);
		
		return modelAndView;
	}
	
	/**
	 * carrega lista de pessoas
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView listOfPessoas() {
		ModelAndView modelAndView = new ModelAndView("lista-de-pessoas");
		
		List Pessoas = PessoaService.getPessoas();
		modelAndView.addObject("Pessoas", Pessoas);
		
		return modelAndView;
	}
	
	/**
	 * carrega formulario de editar pessoa
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPessoaPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("editar-pessoa-form");
		Pessoa Pessoa = PessoaService.getPessoa(id);
		modelAndView.addObject("Pessoa",Pessoa);
		return modelAndView;
	}
	
	/**
	 * edita uma pessoa e redireciona a home page
	 * @param Pessoa
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPessoa(@ModelAttribute Pessoa Pessoa, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		PessoaService.updatePessoa(Pessoa);
		
		String mensagem = "Pessoa editada com sucesso!";
		modelAndView.addObject("mensagem", mensagem);
		
		return modelAndView;
	}
	
	/**
	 * deleta uma pessoa e redireciona a pagina inicial
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePessoa(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		PessoaService.deletePessoa(id);
		String mensagem = "Pessoa deletada com sucesso!";
		modelAndView.addObject("mensagem", mensagem);
		return modelAndView;
	}

}
