package fakeapi.languages.controller;

import fakeapi.languages.model.AuthorModel;
import fakeapi.languages.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final  IAuthorRepository dao;
    @Autowired
    public AuthorController(IAuthorRepository dao) {
        this.dao = dao;
    }

    @GetMapping()
    public ResponseEntity<List<AuthorModel>> getAllAuthor(){
        try {
            List<AuthorModel> list = dao.getAllAuthors();
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<AuthorModel> getAuthorById(@PathVariable(value = "id") Integer id) {
        try {
            AuthorModel author = dao.getAuthorById(id);
            return author == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(author);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<AuthorModel> getAuthorByName(@PathVariable(value = "name") String name) {
        try {
            AuthorModel author = dao.getAuthorByName(name);
            return author == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(author);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/post-list")
    public ResponseEntity<List<AuthorModel>> postAuthors(@RequestBody List<AuthorModel> authors) {
        try {
            List<AuthorModel> list = dao.postAuthors(authors);
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping()
    public ResponseEntity<List<AuthorModel>> postAuthor(@RequestBody AuthorModel author) {
        try {
            List<AuthorModel> list = dao.postAuthor(author);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<List<AuthorModel>> putAuthor(@PathVariable(value = "id") Integer id,
                                                       @RequestBody AuthorModel author) {
        try {
            List<AuthorModel> list = dao.putAuthor(id, author);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<AuthorModel>> deleteAuthor(@PathVariable(value = "id") Integer id) {
        try {
            List<AuthorModel> list = dao.deleteAuthors(id);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/params")
    public ResponseEntity<List<AuthorModel>> getAuthorByParams(
            @RequestParam(required = false, defaultValue = "1") Integer min,
            @RequestParam(required = false, defaultValue = "1") Integer max) {
        try {
            List<AuthorModel> list = dao.getAuthorByParams(min, max);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}