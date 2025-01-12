package com.idat.remiseriamvc.demo.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer idPayment;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private Double amount;

    @Column(name = "id_vehicle")
    private Integer idVehicle;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_vehicle", insertable = false, updatable = false)
    private Vehicle vehicle;

    @Column(name = "id_employee")
    private Integer idEmployee;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_employee", insertable = false, updatable = false)
    private User employee;

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
