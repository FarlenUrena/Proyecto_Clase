/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.entities.Variacion;

/**
 *
 * @author thony
 */

public interface IVariacionService {
    public Optional<Variacion> findById(Long id);
    public Optional<List<Variacion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate);
    public Optional<List<Variacion>> findByFechaRegistroBetween(Date startDate, Date endDate);
    public Variacion create(Variacion variacion);
}