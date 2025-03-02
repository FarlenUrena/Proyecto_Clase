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
import org.una.tramites.entities.Variacion;
import org.una.tramites.repositories.IVariacionRepository;


/**
 *
 * @author thony
 */

@Service
public class VariacionServiceImplementation implements IVariacionService {
    @Autowired
    private IVariacionRepository variacionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Variacion> findById(Long Id) {
        return variacionRepository.findById(Id);
    }
}