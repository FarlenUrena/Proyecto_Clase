/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.tramites.entities.Requisito;
import org.una.tramites.repositories.IRequisitoRepository;


/**
 *
 * @author thony
 */

@Service
public class RequisitoServiceImplementation implements IRequisitoService {
    
    @Autowired
    private IRequisitoRepository requisitoRepository;
    
    
    @Override
    public Optional<Requisito> findByRequisitoId(Long requisitoId) {
        return requisitoRepository.findByRequisitoId(requisitoId);
    }
}