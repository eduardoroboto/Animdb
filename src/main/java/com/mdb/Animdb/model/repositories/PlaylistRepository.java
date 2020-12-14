package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.objects.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {

   List<Playlist> findByNameContaining(String name);


   @Query("  SELECT playlist " +
           " FROM Playlist playlist " +
           " INNER JOIN PlaylistItem item ON playlist.id = item.playlistId " +
           " INNER JOIN ProductionModel production ON item.productionId = production.id " +
           " WHERE production.title LIKE CONCAT('%',?1,'%') " )

   List<Playlist> findPlaylistByProduction(String title);

}
