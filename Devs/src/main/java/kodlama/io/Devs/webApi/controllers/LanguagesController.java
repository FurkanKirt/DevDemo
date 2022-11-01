package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getAll")
	public List<Language> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public Language getById(@PathVariable int id) throws Exception {
		return languageService.getById(id);
	}

	@PostMapping
	public void add(@RequestBody Language language) throws Exception {
		languageService.add(language);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Language language) throws Exception {
		languageService.update(id, language);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		languageService.delete(id);
	}
}
