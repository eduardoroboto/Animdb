package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Anime;
import com.mdb.Animdb.model.productions.Filme;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {


    private fakeDB db;

    public FilmeController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public void postFilme(@RequestBody Filme filme){
        db.addProduction(filme);
    }

    @PutMapping("/{id}")
    public void changeFilme(@PathVariable("id") String id,
                            @RequestBody  Filme filme){
        db.deleteProduction(id);
        db.addProduction(filme);
    }

    @DeleteMapping("/{id}")
    public void deleteFilme(@PathVariable("id") String id){
        db.deleteProduction(id);
    }

}
