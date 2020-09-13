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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.NotaDTO;
import org.una.tramites.entities.Nota;
import org.una.tramites.services.INotaService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/notas") 
@Api(tags = {"Notas"})

public class NotaController {
    @Autowired
    private INotaService notaService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un trámite con el id ingresado", response = NotaDTO.class, responseContainer = "NotaDto", tags = "Notas")
    public ResponseEntity<?> findId(@PathVariable(value = "nota_id") Long Id) {
        try {

            Optional<Nota> notaFound = notaService.findById(Id);
            if (notaFound.isPresent()) {
                NotaDTO notaDto = MapperUtils.DtoFromEntity(notaFound.get(), NotaDTO.class);
                return new ResponseEntity<>(notaDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}