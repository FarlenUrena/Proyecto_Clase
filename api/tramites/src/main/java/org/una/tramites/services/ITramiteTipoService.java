/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Optional;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author thony
 */

public interface ITramiteTipoService {
    public Optional<TramiteTipo> findById(Long Id);
}
