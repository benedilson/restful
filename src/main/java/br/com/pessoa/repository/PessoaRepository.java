package br.com.pessoa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.com.pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
