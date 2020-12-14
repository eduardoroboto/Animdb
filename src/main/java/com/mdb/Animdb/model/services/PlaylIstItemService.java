package com.mdb.Animdb.model.services;


import com.mdb.Animdb.model.objects.PlaylistItem;
import com.mdb.Animdb.model.repositories.PlaylistItemRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylIstItemService {

    private final PlaylistItemRepository playlistItemRepository;


    public PlaylIstItemService(PlaylistItemRepository playlistItemRepository){
        this.playlistItemRepository = playlistItemRepository;
    }

    public PlaylistItem save(PlaylistItem playlistItem){
        return playlistItemRepository.save(playlistItem);
    }

    public PlaylistItem add(Integer productionId, Integer playlistId){
        PlaylistItem playlistItem = new PlaylistItem();
        playlistItem.setplaylistId(playlistId);
        playlistItem.setproductionId(productionId);
        return playlistItemRepository.save(playlistItem);
    }

    public void delete(Integer id){
       playlistItemRepository.deleteById(id);
    }

}
