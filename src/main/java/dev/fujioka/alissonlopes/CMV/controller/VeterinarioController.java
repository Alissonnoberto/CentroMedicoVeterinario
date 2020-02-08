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
import dev.fujioka.alissonlopes.CMV.model.Veterinario;
import dev.fujioka.alissonlopes.CMV.repository.VeterinarioRepository;

/**
 * @author alisson
 *
 */
@RestController
@RequestMapping("/centromedicoveterinario")
public class VeterinarioController {

	@Autowired
	VeterinarioRepository veterinarioRepository;

	@GetMapping("/veterinario")
	public List<Veterinario> getVeterinario() {
		return veterinarioRepository.findAll();
	}

	@PostMapping("/veterinario")
	public Veterinario saveVeterinario(@Valid @RequestBody Veterinario veterinario) {
		Veterinario veterinarioSalvo = veterinarioRepository.save(veterinario);
		return veterinarioSalvo;
	}

	@PutMapping("/veterinario/{id}")
	public Veterinario updateVeterinario(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Veterinario veterinariolDetails) {

		Veterinario veterinario = veterinarioRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Veterinario", "id", id));
		veterinario.setNome(veterinariolDetails.getNome());
		veterinario.setEspecialidade(veterinariolDetails.getEspecialidade());
		veterinario.setCrmv(veterinariolDetails.getCrmv());
		Veterinario updatedVeterinario = veterinarioRepository.save(veterinario);
		return updatedVeterinario;
	}

	@DeleteMapping("/veterinario/{id}")
	public ResponseEntity<Veterinario> deleteVeterinario(@PathVariable(value = "id") Long id) {

		Veterinario veterinario = veterinarioRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Veterinario", "id", id));

		veterinarioRepository.delete(veterinario);
		return ResponseEntity.ok().build();
	}
}
