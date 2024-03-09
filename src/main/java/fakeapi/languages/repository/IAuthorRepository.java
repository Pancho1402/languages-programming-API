package fakeapi.languages.repository;

import fakeapi.languages.model.AuthorModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author Pancho1402
 */

@Repository
public interface IAuthorRepository {
    List<AuthorModel> getAllAuthors() throws IOException;
    AuthorModel getAuthorById(Integer id) throws IOException;
    AuthorModel getAuthorByName(String name) throws IOException;
    List<AuthorModel> postAuthors(List<AuthorModel> authors) throws IOException;
    List<AuthorModel> postAuthor(AuthorModel author) throws IOException;
    List<AuthorModel> putAuthor(Integer id, AuthorModel author) throws IOException;
    List<AuthorModel> deleteAuthors(Integer id) throws IOException;
    List<AuthorModel> getAuthorByParams(Integer min, Integer max) throws IOException;
}
