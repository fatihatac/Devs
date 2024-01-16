package kodlamaio.Devs.business.abstracts;

import java.util.List;

import kodlamaio.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.Devs.business.responses.GetByIdLanguageResponse;



public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguageResponse getById(int id);
    void add(CreateLanguageRequest createLanguageRequest);
}
