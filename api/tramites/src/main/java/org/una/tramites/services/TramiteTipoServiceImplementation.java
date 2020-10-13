/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

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
    public Optional<TramiteTipo> findById(Long Id) {
    return tramiteTipoRepository.findById(Id);
    }
}