/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.services.ITramiteTipoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/tramites_tipos") 
@Api(tags = {"TramitesTipos"})

public class TramiteTipoController {
    @Autowired
    private ITramiteTipoService tramiteTipoService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un trámite con el id ingresado", response = TramiteTipoDTO.class, responseContainer = "TramiteTipoDto", tags = "TramiteTipo")
    public ResponseEntity<?> findId(@PathVariable(value = "tramiteTipo_id") Long Id) {
        try {

            Optional<TramiteTipo> tramiteTipoFound = tramiteTipoService.findById(Id);
            if (tramiteTipoFound.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoFound.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /*
    @ApiOperation(value = "Crea un nuevo trámite con la información suministrada", response = TramiteTipoDTO.class, tags = "TramiteTipo") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TramiteTipo tramiteTipo) {
        try {
            TramiteTipo tramiteTipoCreated = tramiteTipoService.create(tramiteTipo);
            TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoCreated, TramiteTipoDTO.class);
            return new ResponseEntity<>(tramiteTipoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
    
    /*
    @ApiOperation(value = "Elimina un trámite si su id coincide con el ingresado", response = TramiteTipoDTO.class,  tags = "TramiteTipo") 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<TramiteTipo> tramiteTipoFound = tramiteTipoService.findById(id);
            if (tramiteTipoFound.isPresent()) {
                tramiteTipoService.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
}