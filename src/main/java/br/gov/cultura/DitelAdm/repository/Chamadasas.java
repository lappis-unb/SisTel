package br.gov.cultura.DitelAdm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.cultura.DitelAdm.modelo.Chamadas;



public interface Chamadasas extends JpaRepository<Chamadas, Long>{

	public List<Chamadas> findByIdContaining(String id);
}