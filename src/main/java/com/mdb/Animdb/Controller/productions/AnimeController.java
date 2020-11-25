package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Anime;
import com.mdb.Animdb.model.productions.Production;
import com.mdb.Animdb.model.users.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animes")
public class AnimeController {


    private fakeDB db;

    public AnimeController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public ResponseEntity<?> postAnime(@RequestBody Anime anime){
        db.addProduction(anime);
        System.out.println(anime.toString());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeAnime(@PathVariable("id") String id,
                            @RequestBody  Anime anime){

        db.deleteProduction(id);
        db.addProduction(anime);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable("id") String id){

        db.deleteProduction(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
