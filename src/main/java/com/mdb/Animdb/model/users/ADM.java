package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;

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

    @Override
    public void createList(String name) {

    }

    @Override
    public void addProductions(String listName, Production... productions) {

    }
}
