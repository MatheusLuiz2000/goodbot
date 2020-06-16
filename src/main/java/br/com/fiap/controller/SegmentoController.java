package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.SegmentoModel;
import br.com.fiap.repository.BotRepository;
import br.com.fiap.repository.SegmentoRepository;

@Controller
@RequestMapping("/segmento")
public class SegmentoController {

	@Autowired
	private SegmentoRepository segmentoRepository;
	
	@Autowired
	public BotRepository botRepository;
	
	private static final String SEGMENTO_FOLDER = "segmento/";
	
	@GetMapping("/form")
	public String getform(@RequestParam String page, @RequestParam(required = false) Long id, @ModelAttribute("segmentoModel")  SegmentoModel segmentoModel, Model model) {
		if ("segmento-editar".equals(page)) {
			model.addAttribute("segmentoModel",segmentoRepository.findById(id).get());			
		}
		model.addAttribute("bots", botRepository.findAll());
		return SEGMENTO_FOLDER + page;
	}
	
	@GetMapping
	public String get(Model model) {
		model.addAttribute("bots", botRepository.findAll());
		model.addAttribute("segmentos", segmentoRepository.findAll());
		return SEGMENTO_FOLDER + "segmentos";
	}
	
	@GetMapping("/{id}")
	public String getId(@PathVariable("id") long id, Model model) {
		model.addAttribute("segmento", segmentoRepository.findById(id).get());
		return SEGMENTO_FOLDER + "segmento-editar";
	}
	
	@PostMapping
	public String create(@Valid SegmentoModel segmentoModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			return SEGMENTO_FOLDER + "segmento-novo";
		}
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addAttribute("messages", "Segmento criado com sucesso.");
		return "redirect:/segmento";
	}
	
	@PutMapping("/{id}")
	public String alterar(@Valid SegmentoModel segmentoModel, BindingResult bindingResult,  RedirectAttributes redirectAttributes, @PathVariable("id") long id,  Model model) {
		System.out.println(id);
		if(bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			return SEGMENTO_FOLDER + "segmento-editar";
		}
		
		segmentoModel.setId_segment(id);
		segmentoRepository.save(segmentoModel);
		redirectAttributes.addAttribute("messages", "Segmento alterado com sucesso.");
		return "redirect:/segmento";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")long id, RedirectAttributes redirectAttributes) {
		
		segmentoRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Segmento excluido com sucesso.");
		
		return "redirect:/segmento";
	}
	
	
}
