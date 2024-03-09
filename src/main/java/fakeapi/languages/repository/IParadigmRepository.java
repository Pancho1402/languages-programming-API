package fakeapi.languages.repository;

import fakeapi.languages.model.ParadigmModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author Pancho1402
 */

@Repository
public interface IParadigmRepository {
    List<ParadigmModel> getAllParadigm() throws IOException;
    ParadigmModel getParadigmById(Integer id) throws IOException;
    ParadigmModel getParadigmByType(String type) throws IOException;
    List<ParadigmModel> getParadigmByParams(Integer min, Integer max) throws IOException;
}
