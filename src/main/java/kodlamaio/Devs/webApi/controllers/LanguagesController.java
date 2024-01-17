package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import kodlamaio.Devs.business.requests.UpdateLanguageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import kodlamaio.Devs.business.abstracts.LanguageService;
import kodlamaio.Devs.business.requests.CreateLanguageRequest;
import kodlamaio.Devs.business.responses.GetAllLanguagesResponse;
import kodlamaio.Devs.business.responses.GetByIdLanguageResponse;


@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @GetMapping()
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }
    
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @GetMapping("{id}")
    public GetByIdLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }

    @PutMapping()
    public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
        languageService.update(updateLanguageRequest);
    }
}




