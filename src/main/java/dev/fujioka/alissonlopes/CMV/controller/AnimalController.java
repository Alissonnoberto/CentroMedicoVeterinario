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
import dev.fujioka.alissonlopes.CMV.model.Animal;
import dev.fujioka.alissonlopes.CMV.repository.AnimalRepository;

/**
 * @author alisson
 *
 */

@RestController
@RequestMapping("/centromedicoveterinario")
public class AnimalController {

	@Autowired
	AnimalRepository animalRepository;

	@GetMapping("/animal")
	public List<Animal> getPaciente() {
		return animalRepository.findAll();
	}

	@PostMapping("/animal")
	public Animal saveAnimal(@Valid @RequestBody Animal animal) {
		Animal animalSalvo = animalRepository.save(animal);
		return animalSalvo;
	}

	@PutMapping("/animal/{id}")
	public Animal updateAnimal(@PathVariable(value = "id") Long id, @Valid @RequestBody Animal animalDetails) {

		Animal animal = animalRepository.findById(id).orElseThrow(() -> new BusinessException("Animal", "id", id));

		animal.setEspecie(animalDetails.getEspecie());
		animal.setNome(animalDetails.getNome());
		animal.setIdade(animalDetails.getIdade());
		animal.setPeso(animalDetails.getPeso());
		animal.setSexo(animalDetails.getSexo());

		Animal updatedAnimal = animalRepository.save(animal);
		return updatedAnimal;
	}

	@DeleteMapping("/animal/{id}")
	public ResponseEntity<Animal> deletePaciente(@PathVariable(value = "id") Long id) {

		Animal animal = animalRepository.findById(id).orElseThrow(() -> new BusinessException("Animal", "id", id));

		animalRepository.delete(animal);
		return ResponseEntity.ok().build();
	}

}
