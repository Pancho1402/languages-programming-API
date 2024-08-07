package fakeapi.languages.controller;

import fakeapi.languages.model.Language;
import fakeapi.languages.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {

    private final LanguageService service;
    private static final Logger logger = LoggerFactory.getLogger(LanguageController.class);

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Language>> getAll() {
        try {
            List<Language> list = service.getAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Language> getByName(@PathVariable(value = "name") String name) {
        try {
            Language language = service.getByName(name);
            return ResponseEntity.ok(language);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping()
    public ResponseEntity<List<Language>> saveLanguage(@RequestBody Language language) {
        try {
            List<Language> list = service.save(language);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateLanguage(@PathVariable(value = "id") Integer id, Language language){
        try {
            service.update(id, language);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLanguage(@PathVariable(value = "id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
