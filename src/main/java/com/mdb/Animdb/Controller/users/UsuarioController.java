package com.mdb.Animdb.Controller.users;

import com.mdb.Animdb.model.services.AdminService;
import com.mdb.Animdb.model.services.UsuarioService;
import com.mdb.Animdb.model.users.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

// TODO Modificar os returns para retornar mensagens HTTP

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AdminService adminService;

    public UsuarioController( UsuarioService usuarioService, AdminService adminService){

        this.usuarioService = usuarioService;
        this.adminService = adminService;
    }

    @PostMapping
    public void postUser(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        System.out.println("Adding +" + usuario );
    }

    @PutMapping("/me")
    public void changeMyUser(@RequestHeader Integer session_id,
                           @RequestBody Usuario usuario) {
            usuarioService.update(session_id,usuario);
    }

    @PutMapping("/{id}")
    public void changeAnotherUser(@PathVariable("id") Integer id,
                                  @RequestHeader Integer session_id,
                                  @RequestBody Usuario usuario) {

        if(adminService.getAdmin(session_id).isPresent()){
            usuarioService.update(id,usuario);
            System.out.println("Changing account ID --> +" + id + " by the Admin " + session_id);
        }
    }

    @GetMapping("/me") //http://localhost:8080/usuarios/me
    public Optional<Usuario> getMyUser(@RequestHeader Integer session_id)  {
        return usuarioService.getUser(session_id);
    }

    @GetMapping("/search") //http://localhost:8080/usuarios/me
    public List<Usuario> getMyUserByName(@RequestParam String name)  {
        return usuarioService.search(name);
    }
    @GetMapping //http://localhost:8080/usuarios?id=021
    public Optional<Usuario> getAnotherUser(@RequestParam(value = "id", required = true) Integer id,
                                    @RequestHeader Integer session_id)  {
       if( adminService.getAdmin(session_id).isPresent() ){
           return usuarioService.getUser(id);
        }
        return usuarioService.getUser(-1);
    }

    @DeleteMapping("/me") //http://localhost:8080/usuarios/me
    public void deleteMyUser(@RequestHeader("session_id") Integer session_id) {

            usuarioService.delete(session_id);
            System.out.println("User Delete itself--> " + " ID = " + session_id);

    }

    @DeleteMapping("/{id}")
    public void deleteAnotherUser(@PathVariable("id") Integer id,
                                  @RequestHeader("session_id") Integer session_id) {

        if( adminService.getAdmin(session_id).isPresent() ){
            usuarioService.delete(id);
            System.out.println("Admin Delete --> " + " ID = " + id);
        }

    }

}
