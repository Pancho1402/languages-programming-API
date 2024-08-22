package fakeapi.languages.service;

import fakeapi.languages.model.Language;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Pancho1402
 */
@Service
public class LanguageService {
    
    private final List<Language> languages = new ArrayList<>();

    public List<Language> getAll(Integer min, Integer max) {
        if(Objects.isNull(min)) min = 1;

        if(max != null && max > 0) return languages.subList(--min, max);

        return languages;
    }

    public Language getByName(String name){
        return languages.stream()
                .filter(element -> element.getName().toLowerCase().equals(name))
                .findFirst().orElse(null);
    }

    public List<Language> save(Language language){
        List<Language> list = this.languages;
        list.add(language);
        return languages;
    }

    public List<Language> saveAll(List<Language> languages){
        this.languages.addAll(languages);
        return this.languages;
    }

    public void update(Integer id, Language language){
        List<Language> list = this.languages;
        list.stream()
                .filter(element -> element.getId().equals(id))
                .forEach(element -> {
                    element.setName(language.getName());
                });
    }

    public void delete(Integer id){
        List<Language> list = this.languages;
        list.removeIf(element -> element.getId().equals(id));
    }

}
