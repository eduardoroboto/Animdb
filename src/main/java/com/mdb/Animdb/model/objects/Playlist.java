package com.mdb.Animdb.model.objects;

import com.mdb.Animdb.model.users.Usuario;

import javax.persistence.*;
import java.util.List;

@Table(name = "playlist")
@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer usuarioId;

    @OneToMany(mappedBy = "playlistId")
    private List<PlaylistItem> playlistItemList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<PlaylistItem> getPlaylistItemList() {
        return playlistItemList;
    }

    public void setPlaylistItemList(List<PlaylistItem> playlistItemList) {
        this.playlistItemList = playlistItemList;
    }
}
