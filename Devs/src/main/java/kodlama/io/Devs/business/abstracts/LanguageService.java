package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {

	List<Language> getAll();

	Language getById(int id) throws Exception;

	void add(Language language) throws Exception;

	void update(int id, Language language) throws Exception;

	void delete(int id) throws Exception;
}
