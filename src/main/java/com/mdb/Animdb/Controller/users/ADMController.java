package com.mdb.Animdb.Controller.users;


import com.mdb.Animdb.model.services.AdminService;
import com.mdb.Animdb.model.users.ADM;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// TODO Modificar os returns para retornar mensagens HTTP

@RestController
@RequestMapping("/admin")
public class ADMController {


    private final AdminService adminService;

    public ADMController(AdminService adminService) {

        this.adminService = adminService;
    }


    // add a new admin
    @PostMapping
    public ADM addNewADM(@RequestBody ADM adm) {

        return adminService.save(adm);
       // System.out.println("Post -> " + adm.toString());
    }

    @PutMapping("/me") //http://localhost:8080/admin/me
    public void changeADM(@RequestHeader Integer session_id,
                          @RequestBody ADM adm) {

            adminService.update(session_id,adm);
            System.out.println("Update Admin account ID --> +" + session_id);
        }


    // change admin info
    @PutMapping("/{id}") //http://localhost:8080/admin?id=21
    public void changeADM(@PathVariable("id") Integer id,
                          @RequestHeader Integer session_id,
                          @RequestBody ADM adm) {

        if (adminService.getAdmin(session_id).isPresent() && session_id.equals(1)) {
            adminService.update(id,adm);
            System.out.println("Changing Admin account ID --> +" + id + " by the Master Admin ");
        }

    }

    //Get my Admin information
    @GetMapping("/me") //http://localhost:8080/admin/me
    public Optional<ADM> getMyADM(@RequestHeader Integer session_id)  {

        return adminService.getAdmin(session_id);

    }
    //Get Another Admin information
    @GetMapping //http://localhost:8080/admin?id=021
    public Optional<ADM> getADM(@RequestParam(value = "id") Integer id,
                         @RequestHeader Integer session_id) {
            if (adminService.getAdmin(session_id).isPresent() && session_id.equals(1)) {
                return adminService.getAdmin(id);
            }
        return adminService.getAdmin(-1);
    }

    @DeleteMapping("/me")
    public void deleteADM(@RequestHeader("session_id" ) Integer session_id) {

            adminService.delete(session_id);
            System.out.println("Admin Delete Itself--> " + " ID = " + session_id);

    }
    @DeleteMapping("/{id}")
    public void deleteADM(@PathVariable("id") Integer id,
                          @RequestHeader("session_id") Integer session_id) {

        if (adminService.getAdmin(session_id).isPresent() && session_id.equals(1)) {
            adminService.delete(id);
            System.out.println("Admin Deleted by Admin Master --> " + " ID = " + id);
        }
    }
}
