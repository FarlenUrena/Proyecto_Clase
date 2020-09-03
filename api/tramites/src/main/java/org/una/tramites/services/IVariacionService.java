/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.Variacion;

/**
 *
 * @author thony
 */

public interface IVariacionService {
    // public Variacion create(Variacion variacion);
    public Optional<Variacion> findById(@Param("id")Long Id);
}