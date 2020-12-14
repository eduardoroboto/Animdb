package com.mdb.Animdb.model.productions;

import org.json.JSONException;
import org.json.JSONObject;

public interface Production {
    public JSONObject getAll() throws JSONException;
    String getTitle();
    Integer getId();
    String getAuthor();
}
