package kodlamaio.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Devs.business.abstracts.LanguageService;
import kodlamaio.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.Devs.business.responses.GetByIdLanguageResponse;
import kodlamaio.Devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for (Language language : languages) {
			GetAllLanguagesResponse response = new GetAllLanguagesResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			languagesResponse.add(response);
		}
		
		return  languagesResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		
		this.languageRepository.save(language);
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		GetByIdLanguageResponse response = new GetByIdLanguageResponse();
		Language language = languageRepository.getReferenceById(id);
		response.setId(language.getId());
		response.setName(language.getName());
		return response;
	}
}
