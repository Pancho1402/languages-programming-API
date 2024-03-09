package fakeapi.languages.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fakeapi.languages.global.Params;
import fakeapi.languages.model.LanguageModel;
import fakeapi.languages.repository.ILanguageRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Pancho1402
 */
@Service
public class LanguageService implements ILanguageRepository {

    @Override
    public List<LanguageModel> getAllLanguages() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("languages.json");

        return Arrays.asList(objectMapper.readValue(file, LanguageModel[].class));
    }

    @Override
    public LanguageModel getLanguageById(Integer id) throws IOException {
        List<LanguageModel> list = getAllLanguages();

        return Params.filter(list,
                element -> element.getId().equals(id));
    }

    @Override
    public LanguageModel getLanguageByName(String name) throws IOException {
        List<LanguageModel> list = getAllLanguages();

        return Params.filter(list,
                element -> element.getName().equals(name));
    }

    @Override
    public List<LanguageModel> postLanguages(List<LanguageModel> languages) throws IOException {
        List<LanguageModel> list = new ArrayList<>(getAllLanguages());
        list.addAll(languages);

        return list;
    }

    @Override
    public List<LanguageModel> postLanguage(LanguageModel language) throws IOException{
        List<LanguageModel> list = new ArrayList<>(getAllLanguages());
        list.add(language);

        return list;
    }

    @Override
    public List<LanguageModel> putLanguage(Integer id, LanguageModel language) throws IOException {
        List<LanguageModel> list = new LinkedList<>(getAllLanguages());

        list.stream()
                .filter(element -> element.getId().equals(id))
                .forEach(element -> {
                    element.setName(language.getName());
                    element.setDescription(language.getDescription());
                    element.setYear(language.getYear());
                    element.setLevel(language.getLevel());
                    element.setOpenSource(language.getOpenSource());
                    element.setAuthor(language.getAuthor());
                    element.setParadigm(language.getParadigm());
                });

        return list;
    }

    @Override
    public List<LanguageModel> deleteLanguage(Integer id) throws IOException {
        List<LanguageModel> list = new LinkedList<>(getAllLanguages());
        list.removeIf(element -> element.getId().equals(id));

        return list;
    }

    @Override
    public List<LanguageModel> getLanguageByParams(Integer min,  Integer max) throws IOException {
        List<LanguageModel> list = new LinkedList<>(getAllLanguages());

        List<LanguageModel> listLimit = Params.getLimitList(min, max, list);
        if (!listLimit.isEmpty()) return listLimit;

        return Collections.emptyList();
    }
}
