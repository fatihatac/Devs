package kodlamaio.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getAll")
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }
    
    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
        languageService.add(createLanguageRequest);
    }

    @GetMapping("/getById/{id}")
    public GetByIdLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }


//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable int id) {
//        languageService.delete(id);
//    }
//
//    @PutMapping("update/{id}")
//    public void update(@RequestBody Language language, @PathVariable int id) {
//        languageService.update(id, language);
//    }
}




