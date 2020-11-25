package com.mdb.Animdb.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.users.Usuario;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {


    private fakeDB db;
    private checkPrivilege check = new checkPrivilege();

    public PlaylistController(fakeDB db) {
        this.db = db;
    }

    @PostMapping("/{id}")
    public void postPlaylist(@PathVariable("id") String id,
                             @RequestBody ObjectNode objectNode) {

        String playlist_name = objectNode.get("playlist_name").asText();

        System.out.println(playlist_name);
        Usuario user = (Usuario) db.returnUser(id);
        user.createList(playlist_name);


    }

    @PatchMapping("/{id}") //alterar nome
    public void changePlaylist(@PathVariable("id") String id,
                               @RequestBody ObjectNode name_change) {

        String old_name = name_change.get("old_name").asText();
        String new_name = name_change.get("new_name").asText();

        Usuario user = (Usuario) db.returnUser(id);
        user.renamePlaylist(old_name, new_name);

    }

    @GetMapping("/{id}") // getPlaylist
    public String getPlaylist(@PathVariable("id") String id,
                              @RequestParam(value = "name", required = false) String name) throws JSONException {
        Usuario user = (Usuario) db.returnUser(id);
        JSONObject playlist = new JSONObject();

        if (name == null) {
            for (String playname : user.returnAllPlaylist().keySet()) {
                System.out.println(playname);
                playlist.put(playname, user.returnPlaylist(playname));
            }
            return playlist.toString();
        } else {
            playlist.put(name, user.returnPlaylist(name));
            return playlist.toString();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable("id") String id,
                               @RequestParam(value = "name") String name) {
        Usuario user = (Usuario) db.returnUser(id);
        user.deletePlaylist(name);
        System.out.println("Delete --> " + " ID = " + id);
    }

}
