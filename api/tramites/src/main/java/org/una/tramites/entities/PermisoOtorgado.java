/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author farle_000
 */
@Entity
@Table(name = "permisos_otorgados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermisoOtorgado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name="usuarios_id")
    private Usuario usuario;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisoOtorgado") 
    private List<Transaccion> transacciones= new ArrayList<>();

    
    @ManyToOne 
    @JoinColumn(name="permisos_id")
    private Permiso permiso;
    
    
//    @Column(name = "usuario_id")
//    private Long usuarioId;
//
//    @Column( name = "permiso_id")
//    private Long permisoId;

    @Column
    private boolean estado;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;


    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
    }
    
    
}
