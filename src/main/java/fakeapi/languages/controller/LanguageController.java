package fakeapi.languages.controller;

import fakeapi.languages.model.Language;
import fakeapi.languages.service.LanguageService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/languages")
public class LanguageController {

    private final LanguageService service;
    private final Logger logger = LoggerFactory.getLogger(LanguageController.class);

    public LanguageController(LanguageService service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<Language>> getAll(
        @RequestParam(name = "page_min", required = false) Integer min,
        @RequestParam(name = "page_max", required = false) Integer max) {
        try {
            List<Language> list = service.getAll(min, max);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Language> getLanguageByName(@NotBlank
     @PathVariable(value = "name") final String name) {
        try {
            Language language = service.getByName(name);
            return ResponseEntity.ok(language);
        }catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping()
    public ResponseEntity<List<Language>> saveLanguage(@NotNull @RequestBody final Language language) {
        try {
            List<Language> list = service.save(language);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateLanguage(@PathVariable(value = "id") final Integer id,
     @NotNull @RequestBody final Language language){
        try {
            service.update(id, language);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLanguage(@PathVariable(value = "id") final Integer id){
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}