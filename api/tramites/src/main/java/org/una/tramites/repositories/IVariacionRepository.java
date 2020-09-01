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
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.entities.Usuario;
import org.una.tramites.entities.Variacion;

/**
 *
 * @author thony
 */

public interface IVariacionRepository extends JpaRepository<Usuario, Long> {
    public Optional<List<Variacion>> findByUsuarioId(@Param("usuarios_id")Long usuariosId);
    public Optional<List<Variacion>> findByTramiteTipoId(@Param("variacion_id")Long permisosId);        
    public Optional<List<Variacion>> findByFechaRegistroBetween(@Param("fecha_registro")Date start,@Param("fecha_registro")Date end);   
}