package br.gov.cultura.DitelAdm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.cultura.DitelAdm.model.AlocacaoLinhaCategoria;
import br.gov.cultura.DitelAdm.model.AlocacaoLinhaChip;
import br.gov.cultura.DitelAdm.model.AlocacaoLinhaDispositivo;
import br.gov.cultura.DitelAdm.model.AlocacaoUsuarioLinha;
import br.gov.cultura.DitelAdm.model.Categoria;
import br.gov.cultura.DitelAdm.model.Chip;
import br.gov.cultura.DitelAdm.model.Dispositivo;
import br.gov.cultura.DitelAdm.model.Linha;
import br.gov.cultura.DitelAdm.model.Usuario;
import br.gov.cultura.DitelAdm.repository.filtro.CadastroFiltroPesquisa;
import br.gov.cultura.DitelAdm.service.AlocacaoService;
import br.gov.cultura.DitelAdm.service.CadastroCategoriaService;
import br.gov.cultura.DitelAdm.service.CadastroChipService;
import br.gov.cultura.DitelAdm.service.CadastroDispositivoService;
import br.gov.cultura.DitelAdm.service.CadastroLinhaService;
import br.gov.cultura.DitelAdm.service.CadastroUsuarioService;

@Controller
@RequestMapping("/alocacoes")
public class AlocacaoController {

	@Autowired
	private AlocacaoService alocacaoService;
	@Autowired
	private CadastroDispositivoService cadastroDispositivoService;
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	@Autowired
	private CadastroChipService cadastroChipService;
	@Autowired
	private CadastroLinhaService cadastroLinhaService;
	@Autowired
	private CadastroCategoriaService cadastroCategoriaService;

	@RequestMapping("/disponibilizar")
	public @ResponseBody ModelAndView alocar(@ModelAttribute("filtro") CadastroFiltroPesquisa filtro) {
		ModelAndView mv = new ModelAndView("AlocacaoDisponibilizar");
		List<Dispositivo> todosDispositivos = cadastroDispositivoService.getIdDispositivo();
		mv.addObject("dispositivos", todosDispositivos);
		List<Usuario> todosUsuarios = cadastroUsuarioService.getIdUsuario();
		List<AlocacaoUsuarioLinha> alocacaoUsuarioLinhas = alocacaoService.getIdAlocacaoUsuarioLinha();
		mv.addObject("usuarios", todosUsuarios);
		List<Linha> todasLinhas = cadastroLinhaService.getIdLinha();
		List<AlocacaoLinhaDispositivo> alocacaoLinhaDispositivos = alocacaoService.getIdAlocacaoLinhaDispositivo();
		mv.addObject("linhas", todasLinhas);
		List<Chip> todosChips = cadastroChipService.getIdChip();
		mv.addObject("chips", todosChips);
		List<Categoria> todasCategorias = cadastroCategoriaService.getIdCategoria();
		mv.addObject("categorias", todasCategorias);

		return mv;
	}

	@RequestMapping("/devolver")
	public @ResponseBody @Context ModelAndView devolver(@ModelAttribute("filtro") CadastroFiltroPesquisa filtro,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("AlocacaoDevolver");
		List<AlocacaoUsuarioLinha> todosUsuarioLinha = alocacaoService.getIdAlocacaoUsuarioLinha();
		mv.addObject("usuariosDispositivos", todosUsuarioLinha);

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated AlocacaoUsuarioLinha alocacaoUsuarioLinha,
			@Validated AlocacaoLinhaCategoria alocacaoLinhaCategoria, @Validated AlocacaoLinhaChip alocacaoLinhaChip,
			@Validated AlocacaoLinhaDispositivo alocacaoLinhaDispositivo, Errors errors, RedirectAttributes attributes,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ParseException {

		if (servletRequest.getParameter("idAlocacaoUsuarioLinha") != null) {
			Integer idAlocacaoUsuarioLinha = Integer.parseInt(servletRequest.getParameter("idAlocacaoUsuarioLinha"));
			alocacaoUsuarioLinha = alocacaoService.getAlocacaoUsuarioLinha(idAlocacaoUsuarioLinha);
			Date dtDevolucao = new SimpleDateFormat().parse(servletRequest.getParameter("dtDevolucao"));
			
			Date dtRecebimentoBaixa = alocacaoUsuarioLinha.getDtRecebimento();
			String numeroLinhaBaixa = alocacaoUsuarioLinha.getLinha().getNumeroLinha();
			alocacaoLinhaDispositivo.setDtDevolucao(null);
		 Integer idAlocacoesBaixa = 0;
		/*	do{	++idAlocacoesBaixa;
				.getIdAlocacaoLinhaDispositivo(idAlocacoesBaixa); 
			}
				while(alocacaoLinhaDispositivo.getLinha().getNumeroLinha()!= numeroLinhaBaixa &
						alocacaoLinhaDispositivo.getDtRecebimento()!= dtRecebimentoBaixa); 
				
			
			alocacaoLinhaDispositivo.setDtDevolucao(dtDevolucao);*/
			alocacaoUsuarioLinha.setDtDevolucao(dtDevolucao);
			alocacaoService.salvar(alocacaoUsuarioLinha);
			attributes.addFlashAttribute("mensagem", "Registrada devolução de dispositivo do usuario!");
			return "redirect:/alocacoes/devolver";
		} else if (servletRequest.getParameter("dtRecebimento") != null) {
			alocacaoService.salvar(alocacaoLinhaChip);
			alocacaoService.salvar(alocacaoLinhaDispositivo);
			alocacaoService.salvar(alocacaoUsuarioLinha);
			alocacaoService.salvar(alocacaoLinhaCategoria);
			attributes.addFlashAttribute("mensagem", "Registrado vinculo!");
			return "redirect:/alocacoes/disponibilizar";
		}

		return "CADASTRO_VIEW1";

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Integer id, RedirectAttributes attributes) {
		alocacaoService.excluir(id);
		attributes.addFlashAttribute("mensagem", "Fornecimento CANCELADO com sucesso!");
		return "redirect:/inicio";
	}

}