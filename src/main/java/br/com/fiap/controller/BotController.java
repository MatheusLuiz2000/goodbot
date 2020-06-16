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

import br.com.fiap.model.BotModel;
import br.com.fiap.repository.BotRepository;

@Controller
@RequestMapping("/bot")
public class BotController {

	private static final String BOT_FOLDER = "bot/";
	
	@Autowired
	private BotRepository botRepository;
	
	@GetMapping("/form")
	public String open(@RequestParam String page, @RequestParam(required = false) Long id, @ModelAttribute("botModel")  BotModel botModel, Model model) {
		if("bot-editar".equals(page)) {
			model.addAttribute("botModel", botRepository.findById(id).get());
		}
		return BOT_FOLDER + page;
	}
	
	@GetMapping()
	public String getAll(Model model) {
		model.addAttribute("bots", botRepository.findAll());
		return BOT_FOLDER + "bots";
	}
	
	@GetMapping("/{id}")
	public String getId(Model model, @PathVariable long id) {
		model.addAttribute("bots", botRepository.findById(id));
		return BOT_FOLDER + "bot-detalhe";
	}
	
	@PostMapping()
	public String create(@Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			return BOT_FOLDER + "bot-novo";
		}
		botRepository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot cadastrado com sucesso.");
		return "redirect:/bot";
	}
	
	@PutMapping("/{id}")
	public String alterar(@Valid BotModel botModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, @PathVariable("id") long id, Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("bots", botRepository.findAll());
			return BOT_FOLDER + "bot-alterar";
		}

		botModel.setId_bot(id);
		botRepository.save(botModel);
		redirectAttributes.addFlashAttribute("messages", "Bot alterado com sucesso.");
		return "redirect:/bot";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")long id, RedirectAttributes redirectAttributes) {

		botRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Bot deletado com sucesso.");
		
		return "redirect:/bot";
	}
	
}
