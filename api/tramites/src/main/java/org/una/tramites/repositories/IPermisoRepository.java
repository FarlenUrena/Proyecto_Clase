/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.Permiso;

/**
 *
 * @author farle_000
 */
public interface IPermisoRepository extends JpaRepository<Permiso, Long>{
    public Optional<List<Permiso>> findByEstado(@Param("estado")boolean estado);
    public Optional<List<Permiso>> findByFechaRegistroBetween(@Param("fecha_registro")Date start,@Param("fecha_registro")Date end);
}
