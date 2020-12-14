package com.mdb.Animdb.model.repositories;

import com.mdb.Animdb.model.objects.Playlist;
import com.mdb.Animdb.model.productions.ProductionModel;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductionRepository extends JpaRepository<ProductionModel, Integer> {


    // JUST STRINGS

    List<ProductionModel> findByTitleContaining(String name);

    List<ProductionModel> findByAuthorContaining(String author);

    List<ProductionModel> findByStatusContains(String status);

    List<ProductionModel> findByFormat(String format);

    List<ProductionModel> findByRatingEquals(Integer rating);

    //SPECIAL QUERIES
    @Query("SELECT production " +
            " FROM ProductionModel production " +
            " WHERE( ?1 IS NULL OR production.title LIKE CONCAT('%',?1,'%') ) " +
            " AND ( ?2 IS NULL OR production.author LIKE CONCAT('%',?2,'%') ) " +
            " AND ( ?3 IS NULL OR production.status = ?3)  " +
            " AND ( ?4 IS NULL OR production.format = ?4)  ")

    List<ProductionModel> findByInfo (String title, String author, String status, String format);


    //SPECIAL QUERIES
   @Query("SELECT production " +
           "FROM ProductionModel production " +
           "INNER JOIN Tags tag ON tag.productionId = production.id " +
           "WHERE tag.value IN ?1  " +
           "GROUP BY production.id " +
           "HAVING COUNT(DISTINCT  tag.value) = ?2 " )
   List<ProductionModel> findByTags (List<String> anotherTag, Long count);


    @Query("SELECT production " +
            "FROM ProductionModel production " +
            "INNER JOIN Casting cast ON cast.productionId = production.id " +
            "WHERE cast.actor IN ?1  " +
            "GROUP BY production.id " +
            "HAVING COUNT(DISTINCT  cast.actor) = ?2 " )
    List<ProductionModel> findByCasting (List<String> casting, Long count);
}
