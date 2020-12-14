package com.mdb.Animdb.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mdb.Animdb.model.objects.PlaylistItem;
import com.mdb.Animdb.model.productions.Production;
import com.mdb.Animdb.model.services.PlaylIstItemService;
import com.mdb.Animdb.model.users.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playlist/edit")
public class EditPlaylistController {

    PlaylIstItemService playlIstItemService;

    public  EditPlaylistController(PlaylIstItemService playlIstItemService) {
        this.playlIstItemService = playlIstItemService;
    }

    @PostMapping()
    public PlaylistItem addToPlaylist(@RequestParam(name = "productionId") Integer productionId,
                                      @RequestParam(name = "playlistId") Integer playlistId){

       return playlIstItemService.add(productionId,playlistId);
    }

    @DeleteMapping("/{id}")
    public void removeFromPlaylist(@PathVariable("id") Integer id){

        playlIstItemService.delete(id);

        System.out.println("Delete Playlist Content with ID : --> " + id);
    }

}
