package com.mdb.Animdb.model.objects;

import javax.persistence.*;

@Table(name = "playlist_content")
@Entity
public class PlaylistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer playlistId;
    private Integer productionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getplaylistId() {
        return playlistId;
    }

    public void setplaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public Integer getproductionId() {
        return productionId;
    }

    public void setproductionId(Integer productionId) {
        this.productionId = productionId;
    }
}
