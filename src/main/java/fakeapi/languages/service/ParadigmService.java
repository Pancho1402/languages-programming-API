package fakeapi.languages.service;

import fakeapi.languages.global.Params;
import fakeapi.languages.model.ParadigmModel;
import fakeapi.languages.repository.IParadigmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Pancho1402
 */
@Service
public class ParadigmService {
    private final IParadigmRepository repository;

    @Autowired
    public ParadigmService(IParadigmRepository repository) {
        this.repository = repository;
    }
    public List<ParadigmModel> getAllParadigm(){
        return repository.findAll();
    }

    public ParadigmModel getParadigmById(Integer id) {
        Optional<ParadigmModel> author = repository.findById(id);
        return author.orElse(null);
    }

    public ParadigmModel getParadigmByType(String type) {
        Optional<ParadigmModel> author = repository.findByType(type);
        return author.orElse(null);
    }

    public List<ParadigmModel> getParadigmByParams(Integer min, Integer max) {
        final List<ParadigmModel> list = getAllParadigm();

        if (!list.isEmpty()) return Params.getLimitList(min, max, list);

        return Collections.emptyList();
    }
}
