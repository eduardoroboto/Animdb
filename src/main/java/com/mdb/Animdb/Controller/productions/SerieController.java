package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Serie;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SerieController {


    private fakeDB db;

    public SerieController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public void postSerie(@RequestBody Serie serie){
        db.addProduction(serie);
    }

    @PutMapping("/{id}")
    public void changeSerie(@PathVariable("id") String id,
                            @RequestBody  Serie serie){
        db.deleteProduction(id);
        db.addProduction(serie);
    }

    @DeleteMapping("/{id}")
    public void deleteSerie(@PathVariable("id") String id){
        db.deleteProduction(id);
    }

}
