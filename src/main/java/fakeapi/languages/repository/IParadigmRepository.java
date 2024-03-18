package fakeapi.languages.repository;

import fakeapi.languages.model.ParadigmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Pancho1402
 */

@Repository
public interface IParadigmRepository extends JpaRepository<ParadigmModel, Integer> {

    Optional<ParadigmModel> findByType(String type);
}
