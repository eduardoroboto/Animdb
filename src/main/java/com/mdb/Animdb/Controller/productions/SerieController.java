package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Serie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SerieController {


    private fakeDB db;

    public SerieController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public ResponseEntity<?> postSerie(@RequestBody Serie serie){
        db.addProduction(serie);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeSerie(@PathVariable("id") String id,
                            @RequestBody  Serie serie){
        db.deleteProduction(id);
        db.addProduction(serie);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable("id") String id){
        db.deleteProduction(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
