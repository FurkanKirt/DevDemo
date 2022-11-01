package kodlama.io.Devs.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	private boolean checkedId(int id) {
		for (Language language : getAll()) {
			if (language.getId() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean checkedName(String name) throws Exception {
		if (name.isBlank()) {
			throw new Exception("dil kısmı boş olamaz!");
		}
		for (Language language : getAll()) {
			if (language.getName().equals(name)) {
				throw new Exception("dil ismi tekrar edemez!");
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		if (!checkedId(id)) {
			throw new Exception("Böyle bir ID bulunamadı!");
		}
		return languageRepository.getById(id);

	}

	@Override
	public void add(Language language) throws Exception {
		if (checkedId(language.getId())) {
			throw new Exception("Yazılım dili kullanılmış!");
		}
		if (checkedName(language.getName())) {
			languageRepository.add(language);
		}

	}

	@Override
	public void update(int id, Language language) throws Exception {
		if (!checkedId(id)) {
			throw new Exception("Böyle bir ID bulunamadı!");
		}
		if (checkedName(language.getName())) {
			languageRepository.update(id, language);
		}

	}

	@Override
	public void delete(int id) throws Exception {
		if (!checkedId(id)) {
			throw new Exception("Böyle bir ID bulunamadı!");
		}
		languageRepository.delete(id);

	}

}
