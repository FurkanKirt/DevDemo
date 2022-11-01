package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	private List<Language> languages;

	private InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "java"));
		languages.add(new Language(3, "python"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if (language.getId() == id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public void add(Language language) {
		languages.add(language);

	}

	@Override
	public void update(int id, Language language) {
		Language language2 = getById(id);
		language2.setName(language.getName());

	}

	@Override
	public void delete(int id) {
		languages.remove(getById(id));
		// languages.removeIf(item->language.getId()==id);
	}

}
