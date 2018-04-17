package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;
import spittr.domain.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	 private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	private SpittleRepository spittleRepository;
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING)long max,
			@RequestParam(value="count",defaultValue="10")int count) {
		List<Spittle> spittleList =spittleRepository.findSpittles(max, count);
		return spittleList;
	}
	@RequestMapping(value="{spittleId}", method=RequestMethod.GET)
	public String spittle(@PathVariable long spittleId,Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(SpittleForm spittleForm,Model model) {
		spittleRepository.save(new Spittle(null,spittleForm.getMessage(),new Date(),spittleForm.getLongitude(),spittleForm.getLatitude()));
		return "redirect:/spittles";
	}
}
