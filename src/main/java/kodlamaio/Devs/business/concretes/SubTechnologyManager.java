package kodlamaio.Devs.business.concretes;



import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdLanguageResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;
import kodlamaio.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.Devs.entities.concretes.SubTechnology;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	private SubTechnologyRepository subTechnologyRepository;

	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
	}


	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<GetAllSubTechnologiesResponse> responses = new ArrayList<>();
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();

		for (SubTechnology subTechnology : subTechnologies){
			GetAllSubTechnologiesResponse response = new GetAllSubTechnologiesResponse();
			response.setId(subTechnology.getId());
			response.setName(subTechnology.getName());
			responses.add(response);
		}
		return responses;
	}

	@Override
	public GetByIdSubTechnologiesResponse getById(int id) {
		GetByIdSubTechnologiesResponse response = new GetByIdSubTechnologiesResponse();
		SubTechnology subTechnology = subTechnologyRepository.getReferenceById(id);
		response.setId(subTechnology.getId());
		response.setName(subTechnology.getName());
		return response;
	}
}
