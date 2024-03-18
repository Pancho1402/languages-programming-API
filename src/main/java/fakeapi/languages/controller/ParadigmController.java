package fakeapi.languages.controller;

import fakeapi.languages.global.ResponseEntityBuilder;
import fakeapi.languages.model.ParadigmModel;
import fakeapi.languages.service.ParadigmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/programming_paradigm")
public class ParadigmController {
    private final ParadigmService service;

    @Autowired
    public ParadigmController(ParadigmService service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<ParadigmModel>> getAllParadigms(){
        try {
            List<ParadigmModel> list = service.getAllParadigm();
            return ResponseEntityBuilder.buildList(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ParadigmModel> getParadigmById(@PathVariable(value = "id") Integer id) {
        try {
            ParadigmModel paradigm = service.getParadigmById(id);
            return ResponseEntityBuilder.build(paradigm);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<ParadigmModel> getParadigmByType(@PathVariable(value="type") String type) {
        try {
            ParadigmModel paradigm = service.getParadigmByType(type);
            return ResponseEntityBuilder.build(paradigm);
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
            List<ParadigmModel> list = service.getParadigmByParams(min, max);
            return ResponseEntityBuilder.buildList(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
