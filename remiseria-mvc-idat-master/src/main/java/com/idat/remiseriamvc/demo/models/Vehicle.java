package com.idat.remiseriamvc.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private Integer idVehicle;

    @Column(length = 150)
    private String description;

    @Column(name = "id_user")
    private Integer idUser;


    @Column(length = 150)
    private String type;

    @Column(length = 150)
    private String plaque;

    @Column(length = 150)
    private String model;

    @Column(length = 150)
    private String mark;

    private Boolean active;

    //@JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;


}
