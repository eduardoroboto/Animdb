package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNameContaining(String name);


}
