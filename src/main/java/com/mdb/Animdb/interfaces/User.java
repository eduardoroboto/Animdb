package com.mdb.Animdb.interfaces;

public interface User {
    public void createList(String name);
    public void addProductions(String listName, Production... productions);
}
