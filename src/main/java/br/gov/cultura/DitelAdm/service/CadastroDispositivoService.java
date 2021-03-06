package br.gov.cultura.DitelAdm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.cultura.DitelAdm.model.Dispositivo;
import br.gov.cultura.DitelAdm.model.Usuario;
import br.gov.cultura.DitelAdm.repository.Dispositivos;
import br.gov.cultura.DitelAdm.repository.filtro.FiltroPesquisa;

@Service
@Transactional
public class CadastroDispositivoService {

	@Autowired
	private Dispositivos dispositivos;

	public void salvar(Dispositivo cadastroDispositivo) {
		try {
			dispositivos.save(cadastroDispositivo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data invalido!");
		}
	}

	public void excluir(Integer idDispositivo){
		dispositivos.delete(idDispositivo);
	}
	
	public List<Dispositivo> getIdDispositivo() {
		return dispositivos.findAll();
	}
	
	public List<Dispositivo> listarDispositivoDisponivel(){
		return dispositivos.findByNumeroSerieDispositivo();
	}
	
	public Dispositivo getDispositivoById(Integer idDispositivo){
		return dispositivos.findByIdDispositivo(idDispositivo);
	}

	public List<Dispositivo> filtroPesquisa(FiltroPesquisa filtro){
		String filtroPesquisa =  filtro.getNumeroSerie() == null ? "%" : filtro.getNumeroSerie();
		return dispositivos.findByNumeroSerieDispositivoContaining(filtroPesquisa);
	}
}
