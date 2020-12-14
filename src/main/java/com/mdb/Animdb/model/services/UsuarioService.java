package com.mdb.Animdb.model.services;


import com.mdb.Animdb.model.repositories.UserRepository;
import com.mdb.Animdb.model.users.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UserRepository usuarioRepository;

    public UsuarioService(UserRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario usuario){
         return usuarioRepository.save(usuario);
    }
    
    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void update(Integer id, Usuario newUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setName(newUsuario.getName());
            usuario.setEmail(newUsuario.getEmail());
            usuario.setPassword(newUsuario.getPassword());


            usuarioRepository.save(usuario);
        }
    }

    public List<Usuario> listAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUser(Integer id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> search(String nome){
            if(nome != null && !"".equals(nome)){
                return usuarioRepository.findByNameContaining(nome);
            }

        return usuarioRepository.findAll();
    }

}
