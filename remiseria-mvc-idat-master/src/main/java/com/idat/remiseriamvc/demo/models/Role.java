package com.idat.remiseriamvc.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRole;

    @Column(length = 100)
    private String description;

    @OneToMany(mappedBy = "role", cascade = {CascadeType.ALL})
    private List<Permission> permissions;


    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    // cada usuario tendra un rol
    // @Column(name = "id_client")
    // private Integer idClient;
    // una categoria puede tener muchos productos
    // @OneToMany(mappedBy = "role")
    // private List<Client> clients;

}
