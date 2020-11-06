package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;

public interface User {
    public void createList(String name);
    public void addProductions(String listName, Production... productions);
}
