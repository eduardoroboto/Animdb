package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.objects.Casting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastingRepository extends JpaRepository<Casting,Integer> {


    List<Casting> findByProductionId(Integer productionId);

}
