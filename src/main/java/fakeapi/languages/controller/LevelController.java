package fakeapi.languages.controller;

import fakeapi.languages.model.LevelModel;
import fakeapi.languages.repository.ILevelRepository;
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
    ILevelRepository dao;

    @Autowired
    public LevelController(ILevelRepository dao) {
        this.dao = dao;
    }

    @GetMapping()
    public ResponseEntity<List<LevelModel>> getAllLevels(){
        try {
            List<LevelModel> list = dao.getAllLevels();
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LevelModel> getLevelById(@PathVariable(value = "id") Integer id) {
        try{
            LevelModel level = dao.getLevelById(id);
            return level == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(level);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<LevelModel> getLevelByType(@PathVariable(value="type") String type) {
        try {
            LevelModel level = dao.getLevelByType(type);
            return level == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(level);
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
            List<LevelModel> list = dao.getLevelByParams(min, max);
            return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
