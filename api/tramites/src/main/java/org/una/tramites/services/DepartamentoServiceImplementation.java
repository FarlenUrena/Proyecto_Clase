/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.Departamento;
import org.una.tramites.repositories.IDepartamentoRepository;

/**
 *
 * @author farle_000
 */

@Service
public class DepartamentoServiceImplementation implements IDepartamentoService{
    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Departamento>> findByEstado(boolean estado) {
     return Optional.ofNullable(departamentoRepository.findByEstado(estado));
    }
}