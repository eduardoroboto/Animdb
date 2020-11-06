package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;

import java.util.HashMap;
import java.util.Map;

public class Usuario implements User {
    private String name;
    private String email;
    private String id;
    private String password;
    private Map<String,HashMap<String,Production>> lista = new HashMap<String,HashMap<String,Production>>();

    public Usuario(String name, String email, String id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", lista=" + lista +
                '}';
    }

    @Override
    public void createList(String name) {

        this.lista.put(name,new HashMap<String,Production>());

    }

    @Override
    public void addProductions(String listName, Production... productions) {
        for (Production production : productions){
            this.lista.get(listName).put(production.getTitle(),production);
        }
    }
}

