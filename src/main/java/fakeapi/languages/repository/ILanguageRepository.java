package fakeapi.languages.repository;

import fakeapi.languages.model.LanguageModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author Pancho1402
 */

@Repository
public interface ILanguageRepository {
    List<LanguageModel> getAllLanguages() throws IOException;
    LanguageModel getLanguageById(Integer id) throws IOException;
    LanguageModel getLanguageByName(String name) throws IOException;
    List<LanguageModel> postLanguages(List<LanguageModel> languages) throws IOException;
    List<LanguageModel> postLanguage(LanguageModel language) throws IOException;
    List<LanguageModel> putLanguage(Integer id, LanguageModel language) throws IOException;
    List<LanguageModel> deleteLanguage(Integer id) throws IOException;
    List<LanguageModel>getLanguageByParams(Integer min,  Integer max) throws IOException;

}
