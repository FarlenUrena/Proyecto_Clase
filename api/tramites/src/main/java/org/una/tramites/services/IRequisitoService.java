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

/**
 *
 * @author thony
 */

public interface IRequisitoService {
    public Optional<RequisitoController> findById(Long id);
    //    public Optional<List<Transaccion>> findByUsuarioIdAndFechaRegistroBetween(Long usuarioId, Date startDate, Date endDate);
    //    public Optional<List<Transaccion>> findByPermisoIdAndFechaRegistroBetween(Long permisoId, Date startDate, Date endDate);
    public Optional<List<RequisitoController>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate);
    public Optional<List<RequisitoController>> findByFechaRegistroBetween(Date startDate, Date endDate);
    public RequisitoController create(RequisitoController requisito);

    public Optional<List<RequisitoController>> findByUsuarioId(Long usuarioId);

    public Optional<List<RequisitoController>> findByRequisitoId(Long requisitoId);

    public Optional<RequisitoController> update(RequisitoController requisitoModified, Long id);

    public void delete(Long id);

    public Optional<List<RequisitoController>> findAll();

    public void deleteAll();
}