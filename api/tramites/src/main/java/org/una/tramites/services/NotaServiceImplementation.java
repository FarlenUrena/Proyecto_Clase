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
import org.una.tramites.entities.Nota;
import org.una.tramites.repositories.INotaRepository;

/**
 *
 * @author thony
 */

@Service
public class NotaServiceImplementation implements INotaService {
    @Autowired
    private INotaRepository notaRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Nota> findById(Long Id) {
    return notaRepository.findById(Id);
    }

    @Override
    public Optional<List<Nota>> findByFechaRegistroBetween(Date startDate, Date endDate) {
    return null;
    }
}
