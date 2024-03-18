package fakeapi.languages.repository;

import fakeapi.languages.model.LanguageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Pancho1402
 */

@Repository
public interface ILanguageRepository extends JpaRepository<LanguageModel, Integer> {
    Optional<LanguageModel> findByName(String name);
}
