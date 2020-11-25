package com.mdb.Animdb.Controller.users;

import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.users.User;
import com.mdb.Animdb.model.users.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> apostUser(@RequestBody Usuario usuario) {
        db.addUser(usuario);
        System.out.println("Adding +" + usuario );
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> changeUser(@PathVariable("id") String id,
                           @RequestHeader String session_id,
                           @RequestBody Usuario usuario) {

        User user = db.returnUser(session_id);
        if(check.checkAdmin(user)){

            db.deleteUser(id);
            db.addUser(usuario);
            System.out.println("Changing account ID --> +" + id + " by the Admin " + user.getId());
           return new ResponseEntity<>(HttpStatus.OK);
        }
        if(user.getId().equals(usuario.getId()) && session_id.equals(id)){

            db.deleteUser(id);
            db.addUser(usuario);

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping //http://localhost:8080/usuarios?id=021
    public  ResponseEntity<String> getUser(@RequestParam(value = "id", required = false) String id,
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
                return new ResponseEntity<String>(jj.toString(),HttpStatus.OK);
            }
        } else {
            if(check.checkAdmin(session_user) || session_id.equals(id)){
                System.out.println("Return User --> " + " ID = " + id);
                JSONObject one = new JSONObject();
                User user = db.returnUser(id);
                one.put(user.getId(),user.getAll());
                return new ResponseEntity<String>(one.toString(),HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id,
                           @RequestHeader("session_id") String session_id) {

        User user = db.returnUser(session_id);
        if(check.checkAdmin(user)){
            db.deleteUser(id);
            System.out.println("Admin Delete --> " + " ID = " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        if(user.getId().equals(id)){
            db.deleteUser(id);
            System.out.println("User Delete itself--> " + " ID = " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
