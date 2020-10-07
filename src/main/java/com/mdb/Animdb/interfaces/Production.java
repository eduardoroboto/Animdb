package com.mdb.Animdb.interfaces;

import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

public interface Production {
    public JSONObject getAll() throws JSONException;
    String getTitle();
}
