package fakeapi.languages.controller;

import fakeapi.languages.global.ResponseEntityBuilder;
import fakeapi.languages.model.LanguageModel;
import fakeapi.languages.service.LanguageService;
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
    private final LanguageService service;

    @Autowired
    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<LanguageModel>> getAllLanguages() {
        try {
            List<LanguageModel> list = service.getAllLanguages();
            return ResponseEntityBuilder.buildList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LanguageModel> getLanguageById(@PathVariable(value = "id") Integer id) {
        try{
            LanguageModel language = service.getLanguageById(id);
            return ResponseEntityBuilder.build(language);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<LanguageModel> getLanguage(@PathVariable(value = "name") String name) {
        try {
            LanguageModel language = service.getLanguageByName(name);
            return ResponseEntityBuilder.build(language);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<LanguageModel>> deleteLanguage(@PathVariable(value = "id") Integer id){
        try {
            List<LanguageModel> list = service.deleteLanguage(id);
            return ResponseEntityBuilder.buildList(list);
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
            List<LanguageModel> list = service.getLanguageByParams(min, max);
            return ResponseEntityBuilder.buildList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
