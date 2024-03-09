package fakeapi.languages.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import fakeapi.languages.global.Params;
import fakeapi.languages.model.AuthorModel;
import fakeapi.languages.repository.IAuthorRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Pancho1402
 */
@Service
public class AuthorService implements IAuthorRepository {

    @Override
    public List<AuthorModel> getAllAuthors() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("author.json");

        return Arrays.asList(objectMapper.readValue(file, AuthorModel[].class));
    }

    @Override
    public AuthorModel getAuthorById(Integer id) throws IOException {
        final List<AuthorModel> list = getAllAuthors();

        return Params.filter(list,
                element -> element.getId().equals(id));
    }

    @Override
    public AuthorModel getAuthorByName(String name) throws IOException {
        final List<AuthorModel> list = getAllAuthors();

        return Params.filter(list,
                element -> element.getName().equals(name));
    }

    @Override
    public List<AuthorModel> postAuthors(List<AuthorModel> authors) throws IOException {
        List<AuthorModel> list = new ArrayList<>(getAllAuthors());
        list.addAll(authors);
        return list;
    }

    @Override
    public List<AuthorModel> postAuthor(AuthorModel author) throws IOException {
        List<AuthorModel> list = new ArrayList<>(getAllAuthors());
        list.add(author);
        return list;
    }

    @Override
    public List<AuthorModel> putAuthor(Integer id, AuthorModel author) throws IOException {
        List<AuthorModel> list = new LinkedList<>(getAllAuthors());
        list.stream()
                .filter(element -> element.getId().equals(id))
                .forEach(element -> element.setName(author.getName()));

        return list;
    }

    @Override
    public List<AuthorModel> deleteAuthors(Integer id) throws IOException {
        List<AuthorModel> list = new LinkedList<>(getAllAuthors());
        list.removeIf(element -> element.getId().equals(id));

        return list;
    }

    @Override
    public List<AuthorModel> getAuthorByParams(Integer min, Integer max) throws IOException {
        final List<AuthorModel> list = new LinkedList<>(getAllAuthors());
        final List<AuthorModel> listLimit = Params.getLimitList(min, max, list);

        if (!listLimit.isEmpty()) return listLimit;

        return Collections.emptyList();
    }

}