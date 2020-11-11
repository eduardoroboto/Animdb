package com.mdb.Animdb.model.productions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

public interface Production {
    public JSONObject getAll() throws JSONException;
    String getTitle();
    String getId();
    String getAuthor();
}
