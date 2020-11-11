package com.mdb.Animdb.Controller.productions;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Production;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productions")
public class ProductionController {

    private fakeDB db;

    public ProductionController(fakeDB db){
        this.db = db;
    }

    @GetMapping
    public String getAnime(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "id", required = false) String id,
                           @RequestParam(value = "author", required = false) String author) throws JSONException {
        if(id != null){

            JSONObject jj = new JSONObject();
            for (Production prod: db.getAllProductions()
            ) {
                jj.put(prod.getId(),db.returnProduction(id));
            }
            return jj.toString();

        } else {
            JSONObject jj = new JSONObject();
            for (Production prod: db.getAllProductions()
            ) {
                jj.put(prod.getId(),db.findProduction(name, author));
            }
            return jj.toString();
        }
    }

}
