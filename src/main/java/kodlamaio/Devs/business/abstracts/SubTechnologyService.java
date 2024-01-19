package kodlamaio.Devs.business.abstracts;

import kodlamaio.Devs.business.requests.CreateSubTechnologyRequest;
import kodlamaio.Devs.business.requests.UpdateSubTechnologyRequest;
import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;

import java.util.List;


public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	GetByIdSubTechnologiesResponse getById(int id);

	void add(CreateSubTechnologyRequest createSubTechnologyRequest);
	void delete(int id);

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
}
