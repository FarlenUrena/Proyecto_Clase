/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.controllers.RequisitoController;
import org.una.tramites.entities.Requisito;

/**
 *
 * @author thony
 */

public interface IRequisitoService {
    // public Optional<Requisito> findById(Long id);
    // public Requisito create(Requisito requisito);
    public Optional<Requisito> findByRequisitoId(Long requisitoId);
    // public void delete(Long id);
    // public void deleteAll();
}