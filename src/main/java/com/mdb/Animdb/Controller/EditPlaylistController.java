package com.mdb.Animdb.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.productions.Production;
import com.mdb.Animdb.model.users.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlists/edit")
public class EditPlaylistController {

    private fakeDB db;
    private checkPrivilege check = new checkPrivilege();

    public  EditPlaylistController(fakeDB db) {
        this.db = db;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addToPlaylist(@PathVariable String id,
                                        @RequestBody ObjectNode new_entry){

        String playlist_name = new_entry.get("playlist_name").asText();
        String title = new_entry.get("title").asText();

        Usuario user = (Usuario) db.returnUser(id);
        Production production = db.returnProduction(title);
        user.addProductions(playlist_name,title);

        System.out.println("Adding " + title+ " --> " + "to the playlist " + playlist_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeFromPlaylist(@PathVariable("id") String id,
                                   @RequestBody ObjectNode old_entry){

        String playlist_name = old_entry.get("playlist_name").asText();
        String title = old_entry.get("title").asText();

        Usuario user = (Usuario) db.returnUser(id);
        user.removeProductionOnPlaylist(playlist_name,title);

        System.out.println("Delete Production --> " + " Prod = " +  title + " from playlist " + playlist_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
