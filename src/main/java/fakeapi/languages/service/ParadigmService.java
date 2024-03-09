package fakeapi.languages.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fakeapi.languages.global.Params;
import fakeapi.languages.model.ParadigmModel;
import fakeapi.languages.repository.IParadigmRepository;
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
public class ParadigmService implements IParadigmRepository {
    @Override
    public List<ParadigmModel> getAllParadigm() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("paradigm.json");

        return Arrays.asList(objectMapper.readValue(file, ParadigmModel[].class));
    }

    @Override
    public ParadigmModel getParadigmById(Integer id) throws IOException {
        List<ParadigmModel> list = getAllParadigm();

        return Params.filter(list,
                element -> element.getId().equals(id));
    }

    @Override
    public ParadigmModel getParadigmByType(String type) throws IOException {
        List<ParadigmModel> list = getAllParadigm();

        return Params.filter(list,
                element -> element.getType().equals(type));
    }

    @Override
    public List<ParadigmModel> getParadigmByParams(Integer min, Integer max) throws IOException {
        List<ParadigmModel> list = getAllParadigm();

        List<ParadigmModel> listLimit = Params.getLimitList(min, max, list);
        if (!listLimit.isEmpty()) return listLimit;

        return Collections.emptyList();
    }

}
