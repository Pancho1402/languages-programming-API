package fakeapi.languages.service;

import fakeapi.languages.global.Params;
import fakeapi.languages.model.LevelModel;
import fakeapi.languages.repository.ILevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


/**
 * @author Pancho1402
 */
@Service
public class LevelService {
    private final ILevelRepository repository;
    @Autowired
    public LevelService(ILevelRepository repository) {
        this.repository = repository;
    }
    public List<LevelModel> getAllLevel(){
        return repository.findAll();
    }
    public LevelModel getLevelById(int id){
        return repository.findById(id).orElse(null);
    }
    public LevelModel getLevelByType(String type){
        return repository.findByType(type).orElse(null);
    }

    public List<LevelModel> getLevelByParams(Integer min, Integer max) {
        final List<LevelModel> list = getAllLevel();

        if (!list.isEmpty()) return Params.getLimitList(min, max, list);

        return Collections.emptyList();
    }
}
