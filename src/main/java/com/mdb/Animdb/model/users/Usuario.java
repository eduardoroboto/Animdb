package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usuario implements User {
    private String name;
    private String email;
    private String id;
    private String password;
    private Map<String, ArrayList<String> > playlists = new HashMap<String,ArrayList<String>>();

    public Usuario(String name, String email, String id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", playlists=" + playlists +
                '}';
    }
    public JSONObject getAll()  throws JSONException {

        JSONObject seriesJson = new JSONObject();
        seriesJson.put("name",name);
        seriesJson.put("email",email);
        seriesJson.put("id",id);
        seriesJson.put("password" , password);
        seriesJson.put("playlist" , playlists);

        return seriesJson;
    }


public String[] getCredentials(){
        String credentials[] = {email,password};
        return credentials;
}

    @Override
    public String getId() {
        return id;
    }


    @Override
    public void createList(String name) {

        this.playlists.put(name,new ArrayList<String>());

    }

    public Map<String, ArrayList<String>> returnAllPlaylist(){
        return this.playlists;
    }

    public void deletePlaylist(String name){
        playlists.remove(name);
    }

    public void resetPlaylist(String name){
        deletePlaylist(name);
        createList(name);
    }

    public void renamePlaylist(String old_name, String new_name){
        createList(new_name);
        for (String production : this.playlists.get(old_name)){
            this.playlists.get(new_name).add(production);
        }
        deletePlaylist(old_name);
    }

    public ArrayList<String> returnPlaylist(String name){
       return this.playlists.get(name);
    }

    public void removeProductionOnPlaylist(String playlist_name,String title){
        ArrayList<String> playlist = this.playlists.get(playlist_name);
        playlist.remove(title);
    }

    @Override
    public void addProductions(String listName, Production... productions) {
        for (Production production : productions){
            this.playlists.get(listName).add(production.getTitle());
        }
    }
    public void addProductions(String listName, String... titles) {
        for (String title :  titles){
            this.playlists.get(listName).add(title);
        }
    }
}

