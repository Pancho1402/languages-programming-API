package fakeapi.languages.service;

import fakeapi.languages.global.Params;
import fakeapi.languages.model.AuthorModel;
import fakeapi.languages.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Pancho1402
 */
@Transactional
@Service
public class AuthorService {
    private final IAuthorRepository repository;

    @Autowired
    public AuthorService(IAuthorRepository repository) {
        this.repository = repository;
    }
    public List<AuthorModel> getAllAuthor(){
        return repository.findAll();
    }
    public AuthorModel getAuthorById(Integer id){
        Optional<AuthorModel> author = repository.findById(id);
        return author.orElse(null);
    }
    public AuthorModel getAuthorByName(String name){
        Optional<AuthorModel> author = repository.findByName(name);
        return author.orElse(null);
    }
    public List<AuthorModel> postAuthors(List<AuthorModel> authors){
        repository.saveAll(authors);
        return getAllAuthor();
    }

    public List<AuthorModel> postAuthor(AuthorModel author){
        repository.save(author);
        return getAllAuthor();
    }
    public List<AuthorModel> putAuthor(int id, AuthorModel putAuthor){
        AuthorModel author =  getAuthorById(id);
        if (Objects.nonNull(author)) {
            author.setName(putAuthor.getName());
            repository.save(author);

            return getAllAuthor();
        }
        return Collections.emptyList();
    }
    public List<AuthorModel> deleteAuthor(int id){
        repository.deleteById(id);
        return getAllAuthor();
    }
    public List<AuthorModel> getAuthorByParams(Integer min, Integer max) {
        final List<AuthorModel> list = getAllAuthor();

        if (!list.isEmpty()) return Params.getLimitList(min, max, list);

        return Collections.emptyList();
    }
}