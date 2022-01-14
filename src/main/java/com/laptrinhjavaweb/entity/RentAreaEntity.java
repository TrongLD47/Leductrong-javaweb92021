package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity {

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="building_id", nullable = false)
    private  BuildingEntity building;


    public BuildingEntity getBuilding() {
        return building;
    }
    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
