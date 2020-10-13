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
import org.una.tramites.entities.Transaccion;

/**
 *
 * @author farle_000
 */

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long>{       
    public Optional<List<Transaccion>> findByObjetoAndFechaRegistroBetween(@Param("objeto")String objeto,@Param("fecha_registro") Date startDate,@Param("fecha_registro") Date endDate);
    public Optional<List<Transaccion>> findByFechaRegistroBetween(@Param("fecha_registro")Date startDate,@Param("fecha_registro")Date endDate);        
}
