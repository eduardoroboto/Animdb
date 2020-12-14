package com.mdb.Animdb.model.users;

import com.mdb.Animdb.model.productions.Production;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Table(name = "admin")
@Entity
public class ADM implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    //private Map<String, HashMap<String,Production>> lista = new HashMap<String,HashMap<String,Production>>();


    public ADM(String name, String email, Integer id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public ADM() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JSONObject admToJson()  throws JSONException {

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
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ADM{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
