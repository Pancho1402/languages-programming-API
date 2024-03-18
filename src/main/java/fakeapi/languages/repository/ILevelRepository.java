package fakeapi.languages.repository;

import fakeapi.languages.model.LevelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Pancho1402
 */

@Repository
public interface ILevelRepository extends JpaRepository<LevelModel, Integer> {
    Optional<LevelModel> findByType(String type);
}
