package fakeapi.languages.repository;

import fakeapi.languages.model.AuthorLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorLanguageRepository extends JpaRepository<AuthorLanguage, Integer> {
    void deleteByLanguageId(Integer idLanguage);
}
