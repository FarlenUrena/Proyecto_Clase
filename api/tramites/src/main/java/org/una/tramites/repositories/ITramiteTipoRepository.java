/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.una.tramites.entities.TramiteTipo;

/**
 *
 * @author thony
 */

public interface ITramiteTipoRepository extends JpaRepository<TramiteTipo, Long> {
    public Optional<TramiteTipo> findById(@Param("id")Long Id);
}