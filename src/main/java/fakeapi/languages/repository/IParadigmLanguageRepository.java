package fakeapi.languages.repository;

import fakeapi.languages.model.ParadigmLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParadigmLanguageRepository extends JpaRepository<ParadigmLanguage, Integer> {
    void deleteByLanguageId(Integer idLanguage);
}