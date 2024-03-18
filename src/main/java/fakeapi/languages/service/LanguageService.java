package fakeapi.languages.service;

import fakeapi.languages.global.Params;
import fakeapi.languages.model.LanguageModel;
import fakeapi.languages.repository.IAuthorLanguageRepository;
import fakeapi.languages.repository.ILanguageRepository;
import fakeapi.languages.repository.IParadigmLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @author Pancho1402
 */
@Transactional
@Service
public class LanguageService {
    private final ILanguageRepository repository;
    private final IAuthorLanguageRepository authorLanguageRepository;
    private final IParadigmLanguageRepository paradigmLanguageRepository;
    @Autowired
    public LanguageService(ILanguageRepository repository, IAuthorLanguageRepository authorLanguageRepository, IParadigmLanguageRepository paradigmLanguageRepository) {
        this.repository = repository;
        this.authorLanguageRepository = authorLanguageRepository;
        this.paradigmLanguageRepository = paradigmLanguageRepository;
    }

    public List<LanguageModel> getAllLanguages() {
        return repository.findAll();
    }

    public LanguageModel getLanguageById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public LanguageModel getLanguageByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public List<LanguageModel> deleteLanguage(Integer id) {
        authorLanguageRepository.deleteByLanguageId(id);
        paradigmLanguageRepository.deleteByLanguageId(id);
        repository.deleteById(id);
        return getAllLanguages();
    }

    public List<LanguageModel> getLanguageByParams(Integer min, Integer max) {
        final List<LanguageModel> list = getAllLanguages();

        if (!list.isEmpty()) return Params.getLimitList(min, max, list);

        return Collections.emptyList();
    }
}
