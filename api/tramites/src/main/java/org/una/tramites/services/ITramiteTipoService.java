/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author thony
 */

public interface ITramiteTipoService {
    public Optional <List<TramiteTipo>> findAll();
    public Optional <TramiteTipo> findById(Long usuarioId);
    public Optional <List<TramiteTipo>> findByUsuarioId(Long usuarioId);
    public Optional <List<TramiteTipo>> findByTramiteId(Long permisoId);
    public Optional <List<TramiteTipo>> findByFechaRegistroBetween(Date startDate, Date endDate);
    public TramiteTipo create(TramiteTipo tramiteTipo);
    public Optional<TramiteTipo> update(TramiteTipo tramiteTipo, Long id);
    public void delete(Long id);
    public void deleteAll();
    /*
    public Optional<TramiteTipo> findById(Long id);
    public Optional<List<TramiteTipo>> findByTramiteIdAndEstado(Long usuarioId, boolean estado);
    */
}
