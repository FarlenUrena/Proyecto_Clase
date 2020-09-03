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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.RequisitoDTO;
import org.una.tramites.entities.Requisito;
import org.una.tramites.services.IRequisitoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/requisitos") 
@Api(tags = {"Requisitos"})

public class RequisitoController {
    
    @Autowired
    private IRequisitoService requisitoService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un requisito con el id ingresado", response = RequisitoDTO.class, responseContainer = "RequisitoDto", tags = "Requisitos")
    public ResponseEntity<?> findByRequisitoId(@PathVariable(value = "requisitoId") Long requisitoId) {
        try {

            Optional<Requisito> requisitoFound = requisitoService.findByRequisitoId(requisitoId);
            if (requisitoFound.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /*
    @ApiOperation(value = "Crea un nuevo requisito con la información suministrada", response = RequisitoDTO.class, tags = "Requisitos") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Requisito requisito) {
        try {
            Requisito requisitoCreated = requisitoService.create(requisito);
            RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoCreated, RequisitoDTO.class);
            return new ResponseEntity<>(requisitoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
    
    /*
    @ApiOperation(value = "Elimina un requisito si su id coincide con el ingresado", response = RequisitoDTO.class,  tags = "Requisitos") 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<Requisito> requisitoFound = requisitoService.findById(id);
            if (requisitoFound.isPresent()) {
                requisitoService.delete(id);
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