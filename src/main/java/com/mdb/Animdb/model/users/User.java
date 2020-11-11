package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;
import org.json.JSONException;
import org.json.JSONObject;

public interface User {
    public void createList(String name);
    public void addProductions(String listName, Production... productions);
    public String[] getCredentials();
    public String getId();
    public JSONObject getAll() throws JSONException;
}
