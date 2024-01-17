package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.business.responses.GetAllSubTechnologiesResponse;
import kodlamaio.Devs.business.responses.GetByIdSubTechnologiesResponse;
import kodlamaio.Devs.entities.concretes.SubTechnology;


public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	GetByIdSubTechnologiesResponse getById(int id);
}
