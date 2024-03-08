package br.com.pessoa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.pessoa.model.Pessoa;
import br.com.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	private final List<Pessoa> pessoas = new ArrayList<>();
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		
		List<Pessoa> pessoasList = (List<Pessoa>) pessoaRepository.findAll();
		if(pessoasList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for(Pessoa pessoa : pessoasList) {
				Long id = pessoa.getIdPessoa();
				pessoa.add(linkTo(methodOn(PessoaController.class).getOnePessoa(id)).withSelfRel());
			}
			return new ResponseEntity<List<Pessoa>>(pessoasList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getOnePessoa(@PathVariable(value="id") long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(!pessoa.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			pessoa.get().add(linkTo(methodOn(PessoaController.class).listarPessoas()).withRel("Lista de Pessoas"));
			return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);			
		}
	}
	
	@PostMapping
	public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
		pessoas.add(pessoa);
		return pessoa;
	}
}
