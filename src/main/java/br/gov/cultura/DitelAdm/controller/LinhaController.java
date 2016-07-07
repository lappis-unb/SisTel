package br.gov.cultura.DitelAdm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.gov.cultura.DitelAdm.Service.CadastroLinhaService;
import br.gov.cultura.DitelAdm.model.CadastroLinha;


@Controller
@RequestMapping("/linhas")
public class LinhaController extends UrlController {
	
	private static final String CADASTRO_VIEW = "CadastroLinha";
 	
	@Autowired
	private CadastroLinhaService cadastroLinhaService;
	
	@RequestMapping("/nova")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new CadastroLinha());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated CadastroLinha cadastroLinha, Errors errors, RedirectAttributes attributes){
		//TODO: Salva no banco de dados
		
		if(errors.hasErrors()){
	 		return CADASTRO_VIEW;
	 	}
		try {
			cadastroLinhaService.salvar(cadastroLinha);
			attributes.addFlashAttribute("mensagem","Linha cadastrada com sucesso!");
			return "redirect:/linhas/nova";		
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return CADASTRO_VIEW;
 		}
		
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes){
		cadastroLinhaService.excluir(id);
		attributes.addFlashAttribute("mensagem","Linha removida com sucesso!");
		return "redirect:/inicio";
		}	

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") CadastroLinha linhas){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(linhas);
				return mv;
	}
}