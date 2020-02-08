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
import dev.fujioka.alissonlopes.CMV.model.Prontuario;
import dev.fujioka.alissonlopes.CMV.repository.ProntuarioRepository;

/**
 * @author alisson
 *
 */
@RestController
@RequestMapping("/centromedicoveterinario")
public class ProntuarioController {
	
	@Autowired
	ProntuarioRepository prontuarioRepository;

	@GetMapping("/prontuario")
	public List<Prontuario> getProntuario() {
		return prontuarioRepository.findAll();
	}

	@PostMapping("/prontuario")
	public Prontuario saveProntuario(@Valid @RequestBody Prontuario prontuario) {
		Prontuario prontuarioSalvo = prontuarioRepository.save(prontuario);
		return prontuarioSalvo;
	}

	@PutMapping("/prontuario/{id}")
	public Prontuario updateProntuario(@PathVariable(value = "id") Long id, @Valid @RequestBody Prontuario prontuarioDetails) {

		Prontuario prontuario = prontuarioRepository.findById(id).orElseThrow(() -> new BusinessException("Prontuario", "id", id));
        
		prontuario.setDataAtendimento(prontuarioDetails.getDataAtendimento());
		prontuario.setDescricao(prontuarioDetails.getDescricao());
		Prontuario updatedProntuario = prontuarioRepository.save(prontuario);
		return updatedProntuario;
	}

	@DeleteMapping("/prontuario/{id}")
	public ResponseEntity<Prontuario> deleteProntuario(@PathVariable(value = "id") Long id) {

		Prontuario prontuario = prontuarioRepository.findById(id).orElseThrow(() -> new BusinessException("Prontuario", "id", id));

		prontuarioRepository.delete(prontuario);
		return ResponseEntity.ok().build();
	}

}
