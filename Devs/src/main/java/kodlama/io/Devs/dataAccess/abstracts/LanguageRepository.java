package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {

	List<Language> getAll();

	Language getById(int id);

	void add(Language language);

	void update(int id,Language language);

	void delete(int id);
}
