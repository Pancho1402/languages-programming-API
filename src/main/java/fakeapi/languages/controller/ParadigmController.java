package fakeapi.languages.controller;

import fakeapi.languages.model.ParadigmModel;
import fakeapi.languages.repository.IParadigmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/paradimg_programming")
public class ParadigmController {
    private final IParadigmRepository dao;

    @Autowired
    public ParadigmController(IParadigmRepository dao) {
        this.dao = dao;
    }
    @GetMapping()
    public ResponseEntity<List<ParadigmModel>> getAllParadigms(){
        try {
            List<ParadigmModel> list = dao.getAllParadigm();
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ParadigmModel> getParadigmById(@PathVariable(value = "id") Integer id) {
        try {
            ParadigmModel paradigm = dao.getParadigmById(id);
            return paradigm == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(paradigm);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<ParadigmModel> getParadigmByType(@PathVariable(value="type") String type) {
        try {
            ParadigmModel paradigm = dao.getParadigmByType(type);
            return paradigm == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(paradigm);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/params")
    public ResponseEntity<List<ParadigmModel>> getLevelByParams(
            @RequestParam(required = false, defaultValue = "1") Integer min,
            @RequestParam(required = false) Integer max){
        try {
            List<ParadigmModel> list = dao.getParadigmByParams(min, max);
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
