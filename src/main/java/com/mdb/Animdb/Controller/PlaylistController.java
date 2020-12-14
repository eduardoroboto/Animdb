package com.mdb.Animdb.Controller;

import com.mdb.Animdb.model.objects.Playlist;
import com.mdb.Animdb.model.services.PlaylIstItemService;
import com.mdb.Animdb.model.services.PlaylistService;
import com.mdb.Animdb.model.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {


    PlaylistService playlistService;
    PlaylIstItemService playlIstItemService;
    UsuarioService usuarioService;


    public PlaylistController(PlaylistService playlistService, UsuarioService usuarioService, PlaylIstItemService playlIstItemService) {
        this.playlistService = playlistService;
        this.usuarioService = usuarioService;
        this.playlIstItemService = playlIstItemService;
    }

    @PostMapping
    public Playlist postPlaylist(@RequestParam(value = "playlistName") String playlistName,
                                 @RequestParam(value = "usuarioId") Integer usuarioId){

       return playlistService.createPlaylist(playlistName,usuarioId);

    }

    @PatchMapping("/{id}") //alterar nome
    public void changePlaylist(@PathVariable("id") Integer id,
                               @RequestParam(name="name") String newName) {

        playlistService.patchName(id,newName);

    }


    @GetMapping("/{title}")
    public List<Playlist> getPlaylist(@PathVariable("title") String title){

        return playlistService.search(title);

    }

    @GetMapping
    public List<Playlist> getAllPlaylist(){

        return playlistService.listAll();

    }
    @GetMapping("/production/{title}")
    public List<Playlist> getPlaylistByProduction(@PathVariable("title") String title){

        return playlistService.searchByProduction(title);

    }


    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable("id") Integer id) {
        playlistService.delete(id);
        System.out.println("Delete --> " + " ID = " + id);
    }

}
