package kodlamaio.Devs.business.rules;

import kodlamaio.Devs.core.utitilies.exceptions.BusinessException;
import kodlamaio.Devs.dataAccess.abstracts.LanguageRepository;

public class LanguageBusinessRules {
    private LanguageRepository languageRepository;

    public void checkIfBrandNameExists(String name){
        if (this.languageRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
