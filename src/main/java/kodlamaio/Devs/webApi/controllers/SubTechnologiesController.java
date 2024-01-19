package kodlamaio.Devs.webApi.controllers;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frameworks")
public class SubTechnologiesController {
	private SubTechnologyService subTechnologyService;
	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		super();
		this.subTechnologyService = subTechnologyService;
	}
	@GetMapping()
	public List<GetAllSubTechnologiesResponse> getAll() {
		System.out.println(subTechnologyService.getAll());
		return subTechnologyService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdSubTechnologiesResponse getById(@PathVariable int id) {
		return subTechnologyService.getById(id);
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest){
		subTechnologyService.add(createSubTechnologyRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		subTechnologyService.delete(id);
	}
	@PutMapping
	public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest){
		subTechnologyService.update(updateSubTechnologyRequest);
	}
}
