package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.users.ADM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends  JpaRepository<ADM, Integer> {

    List<ADM> findByNameContaining(String name);


}
