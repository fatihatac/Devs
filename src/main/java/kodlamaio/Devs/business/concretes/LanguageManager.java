package kodlamaio.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kodlamaio.Devs.business.requests.UpdateLanguageRequest;
import kodlamaio.Devs.core.utitilies.mapper.ModelMapperService;
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
	private ModelMapperService modelMapperService;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository,ModelMapperService modelMapperService) {
		this.languageRepository = languageRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = languages.stream()
				.map(language -> modelMapperService.forResponse().map(language,GetAllLanguagesResponse.class))
				.collect(Collectors.toList());
		return  languagesResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = modelMapperService.forRequests().map(createLanguageRequest,Language.class);
		this.languageRepository.save(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = modelMapperService.forRequests().map(updateLanguageRequest,Language.class);
		this.languageRepository.save(language);
	}

	@Override
	public void delete(int id) {
		this.languageRepository.deleteById(id);
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageRepository.getReferenceById(id);
		GetByIdLanguageResponse response = modelMapperService.forResponse().map(language,GetByIdLanguageResponse.class);
		return response;
	}
}
