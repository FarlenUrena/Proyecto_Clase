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
import org.una.tramites.entities.ParametroGeneral;
import org.una.tramites.entities.PermisoOtorgado;

/**
 *
 * @author thony
 */

public interface IParametroGeneralRepository extends JpaRepository<ParametroGeneral, Long>{
    public Optional<List<ParametroGeneral>> findByFechaRegistroBetween(@Param("fecha_registro")Date startDate,@Param("fecha_registro")Date endDate);        
    public ParametroGeneral save(PermisoOtorgado parametroGeneral);
}