package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Anime;
import com.mdb.Animdb.model.productions.Production;
import com.mdb.Animdb.model.users.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animes")
public class AnimeController {


    private fakeDB db;

    public AnimeController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public void postAnime(@RequestBody Anime anime){
        db.addProduction(anime);
        System.out.println(anime.toString());
    }

    @PutMapping("/{id}")
    public void changeAnime(@PathVariable("id") String id,
                            @RequestBody  Anime anime){

        db.deleteProduction(id);
        db.addProduction(anime);
    }

    @DeleteMapping("/{id}")
    public void deleteAnime(@PathVariable("id") String id){
        db.deleteProduction(id);
    }
}
