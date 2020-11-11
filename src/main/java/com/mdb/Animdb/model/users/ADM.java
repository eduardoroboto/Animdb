package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ADM implements User {
    private String name;
    private String email;
    private String id;
    private String password;
    private Map<String, HashMap<String,Production>> lista = new HashMap<String,HashMap<String,Production>>();


    public ADM(String name, String email, String id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public JSONObject getAll()  throws JSONException {

        JSONObject seriesJson = new JSONObject();
        seriesJson.put("name",name);
        seriesJson.put("email",email);
        seriesJson.put("id",id);
        seriesJson.put("password" , password);

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

    }

    @Override
    public void addProductions(String listName, Production... productions) {

    }

    @Override
    public String toString() {
        return "ADM{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", lista=" + lista +
                '}';
    }
}
