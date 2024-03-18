package fakeapi.languages.repository;

import fakeapi.languages.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Pancho1402
 */

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorModel, Integer> {
    Optional<AuthorModel> findByName(String name);
}
