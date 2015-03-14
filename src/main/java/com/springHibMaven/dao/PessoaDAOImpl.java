package com.springHibMaven.dao;

import java.awt.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springHibMaven.model.Pessoa;

@Repository
public class PessoaDAOImpl implements PessoaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addPessoa(Pessoa pessoa) {
		getCurrentSession().save(pessoa);
	}

	public void updatePessoa(Pessoa pessoa) {
		Pessoa pessoaEditada = getPessoa(pessoa.getId());
		pessoaEditada.setName(pessoa.getName());
		pessoaEditada.setCountry(pessoa.getCountry());
		getCurrentSession().update(pessoaEditada);
	}

	public Pessoa getPessoa(int id) {
		Pessoa pessoa = (Pessoa) getCurrentSession().get(Pessoa.class, id);
		return pessoa;
	}

	public void deletePessoa(int id) {
		Pessoa pessoa = getPessoa(id);
		if (pessoa != null){
			getCurrentSession().delete(pessoa);
		}
	}

	public List getPessoas() {
		return (List) getCurrentSession().createQuery("from Pessoa").list();
	}
    
}
