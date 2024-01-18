package kodlamaio.Devs.business.concretes;



import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdLanguageResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;
import kodlamaio.Devs.core.utitilies.mapper.ModelMapperService;
import kodlamaio.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.Devs.entities.concretes.SubTechnology;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	private SubTechnologyRepository subTechnologyRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ModelMapperService modelMapperService) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();

		List<GetAllSubTechnologiesResponse> responses = subTechnologies.stream()
				.map(subTechnology -> modelMapperService.forResponse().map(subTechnology,GetAllSubTechnologiesResponse.class))
				.collect(Collectors.toList());

		return responses;
	}

	@Override
	public GetByIdSubTechnologiesResponse getById(int id) {
		SubTechnology subTechnology = subTechnologyRepository.getReferenceById(id);
		GetByIdSubTechnologiesResponse response = modelMapperService.forResponse().map(subTechnology,GetByIdSubTechnologiesResponse.class);
		return response;
	}
}
