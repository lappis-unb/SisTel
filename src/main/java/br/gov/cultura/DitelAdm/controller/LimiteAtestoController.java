package br.gov.cultura.DitelAdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.cultura.DitelAdm.model.LimiteAtesto;
import br.gov.cultura.DitelAdm.repository.filtro.CadastroFiltroPesquisa;
import br.gov.cultura.DitelAdm.service.LimiteAtestoService;

@Controller
@RequestMapping("/limite-atesto")
public class LimiteAtestoController {
	
	private static final String CADASTRO_VIEW = "CadastroLimiteAtesto";
 
	
	@Autowired
	private LimiteAtestoService limiteAtestoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(@ModelAttribute("filtro")CadastroFiltroPesquisa filtro){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		List<LimiteAtesto> limiteAtesto = limiteAtestoService.getLimitesAtesto();
		mv.addObject("limiteAtesto", limiteAtesto);
		mv.addObject(new LimiteAtesto());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated LimiteAtesto limiteAtesto, Errors errors, RedirectAttributes attributes){
		limiteAtestoService.salvar(limiteAtesto);
		attributes.addFlashAttribute("mensagem","Limite atesto cadastrado com sucesso!");
		return "redirect:/limite-atesto/novo";		
	}

//	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
//	public String excluir(@PathVariable Integer id, RedirectAttributes attributes){
//		cadastroDispositivoService.excluir(id);
//		attributes.addFlashAttribute("mensagem","Cadastro do dispositivo removido com sucesso!");
//		return "redirect:/consulta";
//		}	
//	
//	@RequestMapping("{id}")
//	public ModelAndView edicao(@PathVariable("id") Dispositivo dispositivos){
//		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
//		mv.addObject(dispositivos);
//				return mv;
//	}
//	
//	//DropDownMenu Atributos
//	@ModelAttribute("tipoDispositivoMap")
//	public Map<String,String> populateTipoDispositivoMap() throws MalformedURLException, IOException 
//	{
//
//	    Map<String,String> tipoDispositivoMap = new HashMap<String,String> ();
//	    tipoDispositivoMap.put("Fixo","Fixo");
//	    tipoDispositivoMap.put("Celular","Celular");
//	    tipoDispositivoMap.put("Tablet","Tablet");
//	    tipoDispositivoMap.put("Modem","Modem");
////	    tipoDispositivoMap.put("NoteBook","NoteBook");
//	    return tipoDispositivoMap;
//	   
//	}
}