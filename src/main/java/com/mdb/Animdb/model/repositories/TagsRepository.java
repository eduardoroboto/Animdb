package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.objects.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TagsRepository extends JpaRepository<Tags,Integer> {



    Tags getByProductionIdAndValue(Integer productionId, String tag);



}
