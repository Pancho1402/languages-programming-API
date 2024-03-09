package fakeapi.languages.controller;

import fakeapi.languages.model.LanguageModel;
import fakeapi.languages.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ILanguageRepository dao;

    @Autowired
    public LanguageController(ILanguageRepository dao) {
        this.dao = dao;
    }

    @GetMapping()
    public ResponseEntity<List<LanguageModel>> getAllLanguages() {
        try {
            List<LanguageModel> list = dao.getAllLanguages();
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LanguageModel> getLanguageById(@PathVariable(value = "id") Integer id) {
        try{
            LanguageModel language = dao.getLanguageById(id);
            return language == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(language);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<LanguageModel> getLanguage(@PathVariable(value = "name") String name) {
        try {
            LanguageModel language = dao.getLanguageByName(name);
            return language == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(language);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/post-list")
    public ResponseEntity<List<LanguageModel>> postLanguages(@RequestBody List<LanguageModel> languages) {
        try {
            List<LanguageModel> list = dao.postLanguages(languages);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping()
    public ResponseEntity<List<LanguageModel>> postLanguage(@RequestBody LanguageModel language) {
        try {
            List<LanguageModel> list = dao.postLanguage(language);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<List<LanguageModel>> putLanguage(@PathVariable(value = "id") Integer id){
        try {
            List<LanguageModel> list = dao.putLanguage(id, new LanguageModel());
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<LanguageModel>> deleteLanguage(@PathVariable(value = "id") Integer id){
        try {
            List<LanguageModel> list = dao.deleteLanguage(id);
            return list.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/params")
    public ResponseEntity<List<LanguageModel>> getLanguagesByParams(
            @RequestParam(required = false, defaultValue = "1") Integer min,
            @RequestParam(required = false) Integer max) {
        try {
            List<LanguageModel> list = dao.getLanguageByParams(min, max);
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
