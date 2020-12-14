package com.mdb.Animdb.model.services;

import com.mdb.Animdb.Controller.productions.ProductionController;
import com.mdb.Animdb.model.objects.Playlist;
import com.mdb.Animdb.model.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

 private final PlaylistRepository playlistRepository;


 public PlaylistService(PlaylistRepository playlistRepository){
    this.playlistRepository = playlistRepository;
 }


 public Playlist save(Playlist playlist){
     return playlistRepository.save(playlist);
 }

 public Playlist createPlaylist(String name, Integer usuarioId){
     Playlist playlist = new Playlist();
     playlist.setName(name);
     playlist.setUsuarioId(usuarioId);
     return playlistRepository.save(playlist);
 }


 public void delete(Integer id){
        playlistRepository.deleteById(id);
 }

 public void patchName(Integer id, String name){
     Optional<Playlist> playlistOptional = playlistRepository.findById(id);
   if (playlistOptional.isPresent()){
       Playlist playlist = playlistOptional.get();
       playlist.setName(name);

      playlistRepository.save(playlist);
   }
 }

 public List<Playlist> listAll(){
      return playlistRepository.findAll();
 }

 public List<Playlist> search(String name){
     if(name!=null && !"".equals(name)){
         return playlistRepository.findByNameContaining(name);
     }
     return playlistRepository.findAll();
 }


 public List<Playlist> searchByProduction(String title){
     return playlistRepository.findPlaylistByProduction(title);
 }

}
