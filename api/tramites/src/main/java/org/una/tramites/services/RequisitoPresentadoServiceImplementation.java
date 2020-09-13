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
import org.una.tramites.entities.RequisitoPresentado;
import org.una.tramites.repositories.IRequisitoPresentadoRepository;

/**
 *
 * @author thony
 */

@Service
public class RequisitoPresentadoServiceImplementation implements IRequisitoPresentadoService {
    @Autowired
    private IRequisitoPresentadoRepository requisitoPresentadoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<RequisitoPresentado> findById(Long Id) {
    return requisitoPresentadoRepository.findById(Id);
    }
}