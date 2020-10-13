/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.Nota;

/**
 *
 * @author thony
 */

public interface INotaService {
    public Optional<Nota> findById(Long id);
    public Optional<List<Nota>> findByFechaRegistroBetween(Date startDate, Date endDate);
}