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
import org.una.tramites.dto.ArchivoRelacionadoDTO;
import org.una.tramites.dto.TramiteTipoDTO;
import org.una.tramites.entities.ArchivoRelacionado;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.services.IArchivoRelacionadoService;
import org.una.tramites.services.ITramiteTipoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

@RestController
@RequestMapping("/archivos_relacionados") 
@Api(tags = {"ArchivosRelacionados"})

public class ArchivoRelacionadoController {
    @Autowired
    private IArchivoRelacionadoService archivoRelacionadoService;
  
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un archivo relacionado con el id ingresado", response = ArchivoRelacionadoDTO.class, responseContainer = "ArchivoRelacionadoDto", tags = "ArchivosRelacionados")
    public ResponseEntity<?> findId(@PathVariable(value = "archivoRelacionado_id") Long Id) {
        try {

            Optional<ArchivoRelacionado> archivoRelacionadoFound = archivoRelacionadoService.findById(Id);
            if (archivoRelacionadoFound.isPresent()) {
                ArchivoRelacionadoDTO archivoRelacionadoDto = MapperUtils.DtoFromEntity(archivoRelacionadoFound.get(), ArchivoRelacionadoDTO.class);
                return new ResponseEntity<>(archivoRelacionadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
