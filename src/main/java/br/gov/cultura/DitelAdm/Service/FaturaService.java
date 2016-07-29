package br.gov.cultura.DitelAdm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.cultura.DitelAdm.model.dtos.FaturaArquivoDTO;
import br.gov.cultura.DitelAdm.repository.Clientes;
import br.gov.cultura.DitelAdm.repository.Faturas;
import br.gov.cultura.DitelAdm.repository.Operadoras;
import br.gov.cultura.DitelAdm.repository.Resumos;

@Service
public class FaturaService {

	@Autowired
	private Operadoras operadoras;

	@Autowired
	private Clientes clientes;

	@Autowired
	private Faturas faturas;

	@Autowired
	private Resumos resumos;


	public void salvarOp(FaturaArquivoDTO faturaArquivoDTO) {
		operadoras.save(faturaArquivoDTO.getOperadora());
	}

	public void salvarCliente(FaturaArquivoDTO faturaArquivoDTO) {
		clientes.save(faturaArquivoDTO.getCliente());
	}

	public void salvarFat(FaturaArquivoDTO faturaArquivoDTO) {
		faturas.save(faturaArquivoDTO.getFatura());
	}

	public void salvarResumo(FaturaArquivoDTO faturaArquivoDTO) {
		resumos.save(faturaArquivoDTO.getResumo());
	}
}
