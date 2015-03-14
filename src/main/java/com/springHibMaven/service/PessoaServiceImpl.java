package com.springHibMaven.service;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springHibMaven.dao.PessoaDAO;
import com.springHibMaven.model.Pessoa;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDAO pessoaDAO;

	public void addPessoa(Pessoa pessoa) {
		pessoaDAO.addPessoa(pessoa);
	}

	public void updatePessoa(Pessoa pessoa) {
		pessoaDAO.updatePessoa(pessoa);
	}

	public Pessoa getPessoa(int id) {
		return pessoaDAO.getPessoa(id);
	}

	public void deletePessoa(int id) {
		pessoaDAO.deletePessoa(id);
	}

	public List getPessoas() {
		return pessoaDAO.getPessoas();
	}

}
