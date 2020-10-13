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
import org.una.tramites.dto.VariacionDTO;
import org.una.tramites.entities.Variacion;
import org.una.tramites.services.IVariacionService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/variaciones") 
@Api(tags = {"Variaciones"})

public class VariacionController {
    
    @Autowired
    private IVariacionService variacionService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una variación con el id ingresado", response = VariacionDTO.class, responseContainer = "VariacionDto", tags = "Variaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long Id) {
        try {

            Optional<Variacion> variacionFound = variacionService.findById(Id);
            if (variacionFound.isPresent()) {
                VariacionDTO variacionDto = MapperUtils.DtoFromEntity(variacionFound.get(), VariacionDTO.class);
                return new ResponseEntity<>(variacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}