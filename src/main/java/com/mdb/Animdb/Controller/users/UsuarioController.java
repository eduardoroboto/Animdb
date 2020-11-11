package com.mdb.Animdb.Controller.users;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.users.User;
import com.mdb.Animdb.model.users.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.mdb.Animdb.Controller.checkPrivilege;

import java.util.ArrayList;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private fakeDB db;
    private checkPrivilege check = new checkPrivilege();

    public UsuarioController(fakeDB db){
        this.db = db;
    }

    @PostMapping
    public void postUser(@RequestBody Usuario usuario) {
        db.addUser(usuario);
        System.out.println("Adding +" + usuario );
    }

    @PutMapping("/{id}")
    public void changeUser(@PathVariable("id") String id,
                           @RequestHeader String session_id,
                           @RequestBody Usuario usuario) {

        User user = db.returnUser(session_id);
        if(check.checkAdmin(user)){

            db.deleteUser(id);
            db.addUser(usuario);
            System.out.println("Changing account ID --> +" + id + " by the Admin " + user.getId());
        }
        if(user.getId().equals(usuario.getId())){

            db.deleteUser(id);
            db.addUser(usuario);

        }


    }

    @GetMapping //http://localhost:8080/usuarios?id=021
    public String getUser(@RequestParam(value = "id", required = false) String id,
                          @RequestHeader String session_id) throws JSONException {
        User session_user = db.returnUser(session_id);
        if (id == null) {
            if(check.checkAdmin(session_user)){

                System.out.println("GetAll!");
                System.out.println(db.getAllUsers());
                JSONObject jj = new JSONObject();
                for (User user: db.getAllUsers()) {
                    if(check.checkUsuario(user)){
                        jj.put(user.getId(),user.getAll());
                    }
                }
                return jj.toString();
            }
        } else {
            if(check.checkAdmin(session_user) || session_id.equals(id)){

                System.out.println("Return User --> " + " ID = " + id);
                JSONObject one = new JSONObject();
                User user = db.returnUser(id);
                one.put(user.getId(),user.getAll());
                return one.toString();
            }
        }
        return "Not Authorized";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id,
                           @RequestHeader("session_id") String session_id) {

        User user = db.returnUser(session_id);
        if(check.checkAdmin(user)){
            db.deleteUser(id);
            System.out.println("Admin Delete --> " + " ID = " + id);
        }
        if(user.getId().equals(id)){
            db.deleteUser(id);
            System.out.println("User Delete itself--> " + " ID = " + id);
        }

    }
}
