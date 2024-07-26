package fakeapi.languages.service;

import fakeapi.languages.model.Language;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @author Pancho1402
 */
@Service
public class LanguageService {
    List<Language> languages = new ArrayList<>();

    public List<Language> getAllLanguages(){
        return languages;
    }

    public Language getLanguageByName(String name){
        return languages.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst().orElse(null);
    }

    public List<Language> postLanguage(Language language){
        languages.add(language);
        return languages;
    }

    public List<Language> saveAll(List<Language> languages){
        this.languages = languages;
        return this.languages;
    }

    public void putLanguage(Integer id, Language language){
        languages.stream()
                .filter(element -> element.getId().equals(id))
                .forEach(element -> {
                    element.setName(language.getName());
                });
    }

    public void deleteLanguage(Integer id){
        languages.removeIf(element -> element.getId().equals(id));
    }

}
