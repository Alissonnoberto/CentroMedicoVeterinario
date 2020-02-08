package dev.fujioka.alissonlopes.CMV.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fujioka.alissonlopes.CMV.model.Funcionario;

/**
 * @author alisson
 *
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
