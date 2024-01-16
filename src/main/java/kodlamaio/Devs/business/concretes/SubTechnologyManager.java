package kodlamaio.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.SubTechnologyService;
import kodlamaio.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlamaio.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	private SubTechnologyRepository subTechnologyRepository;

	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
	}


	@Override
	public List<SubTechnology> getAll() {
		System.out.println(subTechnologyRepository.findAll()+  " Manager");
		return subTechnologyRepository.findAll();
	}
	
	
	
}
