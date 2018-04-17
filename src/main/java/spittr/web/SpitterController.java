package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpitterRepository;
import spittr.domain.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository =spitterRepository;
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegisterForm() {
		return "registerForm";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegisteration(@Valid Spitter spitter,Errors errors) {
	/*	if(errors.hasErrors()) {
			return "registerForm";
		}*/
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSpitterPorfile(@PathVariable String username,Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
