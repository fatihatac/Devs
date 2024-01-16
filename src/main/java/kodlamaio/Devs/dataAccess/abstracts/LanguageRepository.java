package kodlamaio.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Devs.entities.concretes.Language;


public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
