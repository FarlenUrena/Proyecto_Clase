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
import org.una.tramites.controllers.RequisitoController;
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author thony
 */

public interface IRequisitoRepository extends JpaRepository<Permiso, Long> {
    public Optional<List<RequisitoController>> findByUsuarioId(@Param("usuarios_id")Long usuariosId);
    public Optional<List<RequisitoController>> findByTramiteTipoId(@Param("permisos_id")Long permisosId);        
    public Optional<List<RequisitoController>> findByFechaRegistroBetween(@Param("fecha_registro")Date start,@Param("fecha_registro")Date end);     
}
