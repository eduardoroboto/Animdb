package com.mdb.Animdb.model;

import com.mdb.Animdb.model.productions.Production;
import com.mdb.Animdb.model.users.ADM;
import com.mdb.Animdb.model.users.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class fakeDB {

    private ArrayList<User> users;
    private ArrayList<Production> productions;


    public fakeDB(){
        users = new ArrayList<>();
        productions = new ArrayList<>();
    }

    public User returnUser(String id) {

        for (User user : this.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public Production returnProduction(String id) {

        for (Production production  : this.productions) {
            String productionId = production.getId();
            if (id.equals(productionId)) {
                return production;
            }
        }
        return null;
    }

    public User deleteUser(String id){

        User user = returnUser(id);
        this.users.remove(user);
        return user;

    }

    public Production deleteProduction(String Id){

        Production production = returnProduction(Id);
        this.productions.remove(production);
        return production;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addProduction(Production production){
        this.productions.add(production);
    }

    public ArrayList<User> getAllUsers() {
        return this.users;
    }

    public ArrayList<Production> getAllProductions() {
        return this.productions;
    }

    public ArrayList<Production> findProduction(String name, String author){
        ArrayList<Production> prodReturn = new ArrayList<Production>();
        for (Production production: this.productions) {
            if(name != null && author != null){
                if(name.equals(production.getTitle()) && author.equals(production.getAuthor())){
                    prodReturn.add(production);
                }
            } else {
                if (name != null) {
                    if (name.equals(production.getTitle())) {
                        prodReturn.add(production);
                    }
                }
                if (author != null) {
                    if (author.equals(production.getAuthor())) {
                        prodReturn.add(production);
                    }
                }
            }
        }
        return prodReturn;
    }

}