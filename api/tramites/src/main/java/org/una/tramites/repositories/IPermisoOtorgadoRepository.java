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
import org.una.tramites.entities.PermisoOtorgado;

/**
 *
 * @author farle_000
 */

public interface IPermisoOtorgadoRepository extends JpaRepository<PermisoOtorgado, Long>{
    public Optional<List<PermisoOtorgado>> findByUsuarioId(@Param("usuarios_id")Long usuariosId);      
    public Optional<List<PermisoOtorgado>> findByPermisoId(@Param("permisos_id")Long permisosId);       
    public Optional<List<PermisoOtorgado>> findByUsuarioIdAndEstado(@Param("usuarios_id")Long usuariosId,@Param("estado")boolean estado);     
    public Optional<List<PermisoOtorgado>> findByPermisoIdAndEstado(@Param("permisos_id")Long permisosId,@Param("estado")boolean estado);       
    public Optional<List<PermisoOtorgado>> findByFechaRegistroBetween(@Param("fecha_registro")Date start,@Param("fecha_registro")Date end);        
}
