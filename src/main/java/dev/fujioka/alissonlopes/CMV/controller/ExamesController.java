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
import dev.fujioka.alissonlopes.CMV.model.Exames;
import dev.fujioka.alissonlopes.CMV.repository.ExamesRepository;

/**
 * @author alisson
 *
 */

@RestController
@RequestMapping("/centromedicoveterinario")
public class ExamesController {

	@Autowired
	ExamesRepository ExamesRepository;

	@GetMapping("/exames")
	public List<Exames> getExames() {
		return ExamesRepository.findAll();
	}

	@PostMapping("/exames")
	public Exames saveExames(@Valid @RequestBody Exames exames) {
		Exames examesSalvo = ExamesRepository.save(exames);
		return examesSalvo;
	}

	@PutMapping("/exames/{id}")
	public Exames updateExames(@PathVariable(value = "id") Long id, @Valid @RequestBody Exames examesDetails) {

		Exames exames = ExamesRepository.findById(id).orElseThrow(() -> new BusinessException("Exames", "id", id));

		exames.setDataExame(examesDetails.getDataExame());
		exames.setExame(examesDetails.getExame());
		exames.setValor(examesDetails.getValor());

		Exames updatedExames = ExamesRepository.save(exames);
		return updatedExames;
	}

	@DeleteMapping("/exames/{id}")
	public ResponseEntity<Exames> deleteExames(@PathVariable(value = "id") Long id) {

		Exames exames = ExamesRepository.findById(id).orElseThrow(() -> new BusinessException("Exames", "id", id));

		ExamesRepository.delete(exames);
		return ResponseEntity.ok().build();
	}

}
