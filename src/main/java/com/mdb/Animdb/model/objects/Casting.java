package com.mdb.Animdb.model.objects;

import com.mdb.Animdb.model.productions.ProductionModel;

import javax.persistence.*;

@Table(name = "casting")
@Entity
public class Casting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cast")
    private String actor;

    private Integer productionId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public Integer getId() {
        return id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
