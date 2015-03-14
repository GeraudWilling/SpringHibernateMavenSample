package com.springHibMaven.service;

import java.awt.List;
import com.springHibMaven.model.Pessoa;

public interface PessoaService {
	
	public void addPessoa(Pessoa team);
	public void updatePessoa(Pessoa team);
	public Pessoa getPessoa(int id);
	public void deletePessoa(int id);
	public List getPessoas();

}