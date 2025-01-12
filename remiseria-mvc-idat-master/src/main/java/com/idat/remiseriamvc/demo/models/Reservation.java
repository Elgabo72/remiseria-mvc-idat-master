package com.idat.remiseriamvc.demo.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Integer idReservation;


    @Temporal(TemporalType.TIMESTAMP)
    private Date travelDate;


    @Column(length = 150)
    private String description;


    @Column(name = "id_tariff")
    private Integer idTariff;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_tariff", insertable = false, updatable = false)
    private Tariff tariff;

    @Column(name = "id_state_reservation")
    private Integer idStateReservation;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_state_reservation", insertable = false, updatable = false)
    private StateReservation stateReservation;

    @Column(name = "id_passenger")
    private Integer idPassenger;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_passenger", insertable = false, updatable = false)
    private User passenger;

    @Column(name = "id_driver")
    private Integer idDriver;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_driver", insertable = false, updatable = false)
    private User driver;


    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;


}
