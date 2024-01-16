package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.entities.concretes.SubTechnology;

@RestController
@RequestMapping("/api/frameworks")
public class SubTechnologiesController {
	private SubTechnologyService subTechnologyService;
	
	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		super();
		this.subTechnologyService = subTechnologyService;
	}


	@GetMapping("/getAll")
	public List<SubTechnology> getAll() {
		try {
			return subTechnologyService.getAll();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;

	}
}
