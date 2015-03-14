package com.springHibMaven.dao;

import java.awt.List;

import com.springHibMaven.model.Pessoa;

public interface PessoaDAO {
	
    public void addPessoa(Pessoa Pessoa);

    public void updatePessoa(Pessoa Pessoa);

    public Pessoa getPessoa(int id);

    public void deletePessoa(int id);

    public List getPessoas();
    
}
