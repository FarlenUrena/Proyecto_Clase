/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.RequisitoPresentadoDTO;
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.RequisitoPresentado;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.services.IRequisitoPresentadoService;
import org.una.tramites.services.ITramiteTipoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/requisitos_presentados") 
@Api(tags = {"RequisitosPresentados"})

public class RequisitoPresentadoController {
    @Autowired
    private IRequisitoPresentadoService requisitoPresentadoService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un requisito presentado con el id ingresado", response = RequisitoPresentadoDTO.class, responseContainer = "RequisitoPresentadoDto", tags = "RequisitosPresentados")
    public ResponseEntity<?> findId(@PathVariable(value = "requisitoPresentado_id") Long Id) {
        try {

            Optional<RequisitoPresentado> requisitoPresentadoFound = requisitoPresentadoService.findById(Id);
            if (requisitoPresentadoFound.isPresent()) {
                RequisitoPresentadoDTO requisitoPresentadoDto = MapperUtils.DtoFromEntity(requisitoPresentadoFound.get(), RequisitoPresentadoDTO.class);
                return new ResponseEntity<>(requisitoPresentadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}