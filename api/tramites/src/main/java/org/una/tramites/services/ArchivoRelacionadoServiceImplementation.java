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
import org.una.tramites.entities.ArchivoRelacionado;
import org.una.tramites.repositories.IArchivoRelacionadoRepository;

/**
 *
 * @author thony
 */

@Service
public class ArchivoRelacionadoServiceImplementation implements IArchivoRelacionadoService {
    @Autowired
    private IArchivoRelacionadoRepository archivoRelacionadoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<ArchivoRelacionado> findById(Long Id) {
    return archivoRelacionadoRepository.findById(Id);
    }
}