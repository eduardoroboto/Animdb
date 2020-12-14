package com.mdb.Animdb.model.objects;

import javax.persistence.*;

@Table(name ="tags")
@Entity

public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "tag")
    private String value;
    private Integer productionId;

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String tag) {
        this.value = tag;
    }

    public Integer _getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }
}
