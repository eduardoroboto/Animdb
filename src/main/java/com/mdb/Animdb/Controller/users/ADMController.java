package com.mdb.Animdb.Controller.users;


import com.mdb.Animdb.Controller.checkPrivilege;
import com.mdb.Animdb.model.fakeDB;
import com.mdb.Animdb.model.users.ADM;
import com.mdb.Animdb.model.users.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ADMController {


    private fakeDB db;
    private checkPrivilege check = new checkPrivilege();

    public ADMController(fakeDB db) {
        this.db = db;
    }


    // add a new admin
    @PostMapping
    public void addNewADM(@RequestBody ADM adm) {
        db.addUser(adm);
        System.out.println("Post -> " + adm.toString());
    }

    // change admin info
    @PutMapping("/{id}")
    public void changeADM(@PathVariable("id") String id,
                          @RequestHeader String session_id,
                          @RequestBody ADM adm) {


        User user = db.returnUser(session_id);
        if (check.checkAdmin(user) && user.getId().equals("000")) {

            db.deleteUser(id);
            db.addUser(adm);
            System.out.println("Changing account ID --> +" + id + " by the Admin " + user.getId());
        }
        if (user.getId().equals(adm.getId())) {

            db.deleteUser(id);
            db.addUser(adm);
            System.out.println("Changing account ID --> +" + id);
        }


    }

    //Get all Admin information
    @GetMapping //http://localhost:8080/administradores?id=021
    public String getADM(@RequestParam(value = "id", required = false) String id,
                         @RequestHeader String session_id) throws JSONException {
        if (id == null) {
            if (session_id.equals("000")) {

                System.out.println("GetAll!");
                System.out.println(db.getAllUsers());
                JSONObject jj = new JSONObject();
                for (User user : db.getAllUsers()) {
                    if (check.checkAdmin(user)) {
                        jj.put(user.getId(), user.getAll());
                    }
                }
                return jj.toString();
            }
            return "Not Authorized";

        } else {
            if(session_id.equals("000") || session_id.equals(id)){

                System.out.println("Return User --> " + " ID = " + id);
                JSONObject one = new JSONObject();
                User user = db.returnUser(id);
                one.put(user.getId(), user.getAll());
                return one.toString();
            }

        }
        return "Not Authorized";
    }

    @DeleteMapping("/{id}")
    public void deleteADM(@PathVariable("id") String id,
                          @RequestHeader("session_id") String session_id) {

        User user = db.returnUser(session_id);
        if (check.checkAdmin(user) && user.getId().equals("000")) {
            db.deleteUser(id);
            System.out.println("Admin Delete --> " + " ID = " + id);
        }
        if (user.getId().equals(id)) {
            db.deleteUser(id);
            System.out.println("Admin Delete Itself--> " + " ID = " + id);
        }
        System.out.println("Delete --> " + " ID = " + id);
    }
}
