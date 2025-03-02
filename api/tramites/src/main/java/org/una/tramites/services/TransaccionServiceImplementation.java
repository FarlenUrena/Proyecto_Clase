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
import org.una.tramites.repositories.ITransaccionRepository;

/**
 *
 * @author farle_000
 */

@Service
public class TransaccionServiceImplementation implements ITransaccionService {
    @Autowired
    private ITransaccionRepository transaccionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByObjetoAndFechaRegistroBetween(String objeto, Date startDate, Date endDate) {
    return transaccionRepository.findByObjetoAndFechaRegistroBetween(objeto,startDate,endDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Transaccion>> findByFechaRegistroBetween(Date startDate, Date endDate) {
    return transaccionRepository.findByFechaRegistroBetween(startDate,endDate);
    }

    @Override
    @Transactional
    public Transaccion create(Transaccion transaccion) {
    return transaccionRepository.save(transaccion);
    }
}
