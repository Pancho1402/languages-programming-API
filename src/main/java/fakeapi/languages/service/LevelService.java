package fakeapi.languages.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fakeapi.languages.global.Params;
import fakeapi.languages.model.LevelModel;
import fakeapi.languages.repository.ILevelRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Pancho1402
 */
@Service
public class LevelService implements ILevelRepository {
    @Override
    public List<LevelModel> getAllLevels() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("level.json");

        return Arrays.asList(objectMapper.readValue(file, LevelModel[].class));
    }

    @Override
    public LevelModel getLevelById(Integer id) throws IOException {
        List<LevelModel> list = getAllLevels();

        return Params.filter(list,
                element -> element.getId().equals(id));
    }

    @Override
    public LevelModel getLevelByType(String type) throws IOException {
        List<LevelModel> list = getAllLevels();

        return Params.filter(list,
                element -> element.getLevel().equals(type));
    }

    @Override
    public List<LevelModel> getLevelByParams(Integer min, Integer max) throws IOException {
        List<LevelModel> list = getAllLevels();

        List<LevelModel> listLimit = Params.getLimitList(min, max, list);
        if (!listLimit.isEmpty()) return listLimit;

        return Collections.emptyList();
    }
}
