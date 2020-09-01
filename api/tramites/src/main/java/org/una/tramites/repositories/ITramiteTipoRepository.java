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
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author thony
 */

public interface ITramiteTipoRepository extends JpaRepository<PermisoOtorgado, Long> {
    public Optional<List<TramiteTipo>> findByUsuarioId(@Param("usuarios_id")Long usuariosId);
    public Optional<List<TramiteTipo>> findByTramiteTipoId(@Param("tramites_id")Long permisosId);        
    public Optional<List<TramiteTipo>> findByFechaRegistroBetween(@Param("fecha_registro")Date start,@Param("fecha_registro")Date end);        
}