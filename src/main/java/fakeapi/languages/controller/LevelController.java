package fakeapi.languages.controller;

import fakeapi.languages.global.ResponseEntityBuilder;
import fakeapi.languages.model.LevelModel;
import fakeapi.languages.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Pancho1402
 */

@RestController
@RequestMapping("/api/v1/levels")
public class LevelController {
    private final LevelService service;

    @Autowired
    public LevelController(LevelService service) {
        this.service = service;
    }


    @GetMapping()
    public ResponseEntity<List<LevelModel>> getAllLevels(){
        try {
            List<LevelModel> list = service.getAllLevel();
            return ResponseEntityBuilder.buildList(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LevelModel> getLevelById(@PathVariable(value = "id") Integer id) {
        try{
            LevelModel level = service.getLevelById(id);
            return ResponseEntityBuilder.build(level);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<LevelModel> getLevelByType(@PathVariable(value="type") String type) {
        try {
            LevelModel level = service.getLevelByType(type);
            return ResponseEntityBuilder.build(level);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/params")
    public ResponseEntity<List<LevelModel>> getLevelByParams(
            @RequestParam(required = false, defaultValue = "1") Integer min,
            @RequestParam(required = false) Integer max){
        try {
            List<LevelModel> list = service.getLevelByParams(min, max);
            return ResponseEntityBuilder.buildList(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
