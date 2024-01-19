package kodlamaio.Devs.business.concretes;


import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;
import kodlamaio.Devs.core.utitilies.mapper.ModelMapperService;
import kodlamaio.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.Devs.entities.concretes.SubTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		SubTechnology subTechnology = modelMapperService.forRequests().map(createSubTechnologyRequest,SubTechnology.class);
		this.subTechnologyRepository.save(subTechnology);
	}
	@Override
	public void delete(int id) {
		subTechnologyRepository.deleteById(id);
	}
	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology subTechnology = modelMapperService.forRequests().map(updateSubTechnologyRequest,SubTechnology.class);
		this.subTechnologyRepository.save(subTechnology);
	}
}
