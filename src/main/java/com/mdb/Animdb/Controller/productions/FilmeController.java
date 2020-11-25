package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Anime;
import com.mdb.Animdb.model.productions.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {


    private fakeDB db;

    public FilmeController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public ResponseEntity<?> postFilme(@RequestBody Filme filme){
        db.addProduction(filme);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeFilme(@PathVariable("id") String id,
                            @RequestBody  Filme filme){
        db.deleteProduction(id);
        db.addProduction(filme);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFilme(@PathVariable("id") String id){
        db.deleteProduction(id);

        return new ResponseEntity(HttpStatus.OK);

    }

}
