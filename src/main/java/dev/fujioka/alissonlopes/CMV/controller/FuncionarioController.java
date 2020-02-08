package dev.fujioka.alissonlopes.CMV.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.alissonlopes.CMV.exception.BusinessException;
import dev.fujioka.alissonlopes.CMV.model.Funcionario;
import dev.fujioka.alissonlopes.CMV.repository.FuncionarioRepository;

/**
 * @author alisson
 *
 */
@RestController
@RequestMapping("/centromedicoveterinario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@GetMapping("/funcionario")
	public List<Funcionario> getFuncionario() {
		return funcionarioRepository.findAll();
	}

	@PostMapping("/funcionario")
	public Funcionario saveFuncionario(@Valid @RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		return funcionarioSalvo;
	}

	@PutMapping("/funcionario/{id}")
	public Funcionario updateFuncionario(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Funcionario funcionarioDetails) {

		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Funcionario", "id", id));

		funcionario.setCpf(funcionarioDetails.getCpf());
		funcionario.setFuncao(funcionarioDetails.getFuncao());
		funcionario.setNome(funcionarioDetails.getNome());
		funcionario.setIdade(funcionarioDetails.getIdade());

		Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
		return updatedFuncionario;
	}

	@DeleteMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable(value = "id") Long id) {

		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Funcionario", "id", id));

		funcionarioRepository.delete(funcionario);
		return ResponseEntity.ok().build();
	}

}
