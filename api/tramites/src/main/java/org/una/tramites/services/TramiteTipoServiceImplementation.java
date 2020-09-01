/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.repositories.ITramiteTipoRepository;

/**
 *
 * @author thony
 */

@Service
public class TramiteTipoServiceImplementation implements ITramiteTipoService {
    @Autowired
    private ITramiteTipoRepository tramiteTipoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteTipo> findById(Long usuarioId) {
        return tramiteTipoRepository.findById(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByUsuarioId(Long usuarioId) {
    return tramiteTipoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByTramiteTipoId(Long tramiteTipoId) {
      return tramiteTipoRepository.findByTramiteTipoId(tramiteTipoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByFechaRegistroBetween(Date startDate, Date endDate) {
    return tramiteTipoRepository.findByFechaRegistroBetween(startDate,endDate);
    
    }

    @Override
    @Transactional
    public TramiteTipo create(TramiteTipo tramiteTipo) {
        return tramiteTipoRepository.save(tramiteTipo);
    }

    @Override
    @Transactional
    public Optional<TramiteTipo> update(TramiteTipo tramiteTipo, Long id) {
    if (tramiteTipoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramiteTipoRepository.save(tramiteTipo));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
    tramiteTipoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    tramiteTipoRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findAll() {
        return Optional.ofNullable(tramiteTipoRepository.findAll());
    }
}