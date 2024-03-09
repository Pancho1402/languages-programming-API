package fakeapi.languages.repository;

import fakeapi.languages.model.LevelModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author Pancho1402
 */

@Repository
public interface ILevelRepository {
    List<LevelModel> getAllLevels() throws IOException;

    LevelModel getLevelById(Integer id) throws IOException;

    LevelModel getLevelByType(String type) throws IOException;

    List<LevelModel>getLevelByParams(Integer min, Integer max) throws IOException;

}
