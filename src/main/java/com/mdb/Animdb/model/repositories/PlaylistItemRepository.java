package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.objects.PlaylistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaylistItemRepository extends JpaRepository<PlaylistItem,Integer> {

    // JUST EMPTY SPACE!!

}
