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
import org.una.tramites.entities.Transaccion;
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
    public Optional<Variacion> findById(Long id) {
        return variacionRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate) {
    return variacionRepository.findByObjetoAndFechaRegistroBetween(objeto,startDate,endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Variacion>> findByFechaRegistroBetween(Date startDate, Date endDate) {
    return variacionRepository.findByFechaRegistroBetween(startDate,endDate);
    }

    @Override
    @Transactional
    public Variacion create(Variacion variacion) {
    return variacionRepository.save(variacion);
    }
}