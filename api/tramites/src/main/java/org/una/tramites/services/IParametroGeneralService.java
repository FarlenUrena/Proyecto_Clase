/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.ParametroGeneral;

/**
 *
 * @author thony
 */

public interface IParametroGeneralService {
    public Optional<ParametroGeneral> findById(Long id);
    public Optional<List<ParametroGeneral>> findByFechaRegistroBetween(Date startDate, Date endDate);
    public ParametroGeneral create(ParametroGeneral parametroGeneral);
}