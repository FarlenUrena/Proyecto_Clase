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
    @ApiOperation(value = "Obtiene un trámite a partir del id ingresado", response = TramiteTipoDTO.class, responseContainer = "TramiteTipoDto", tags = "TramitesTipos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<TramiteTipo> tramiteTipoFound = tramiteTipoService.findById(id);
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
    
    @GetMapping("/{fecha}")
    @ApiOperation(value = "Obtiene una lista de trámites según el rango de fechas ingresado", response = TramiteTipoDTO.class, responseContainer = "TramiteTipoDto", tags = "TramitesTipos")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "fecha_registro") Date startDate,@PathVariable(value = "fecha_registro") Date endDate) {
        try {

            Optional<List<TramiteTipo>> result = tramiteTipoService.findByFechaRegistroBetween(startDate, endDate);
            if (result.isPresent()) {
                List<TramiteTipoDTO> tramiteTipoDTO = MapperUtils.DtoListFromEntityList(result.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
      @GetMapping("/{usuario}")
    @ApiOperation(value = "Obtiene la lista de trámites otorgados del usuario ingresado", response = TramiteTipoDTO.class, responseContainer = "TramiteTipoDto", tags = "TramitesTipos")
    public ResponseEntity<?> findByUsuarioId(@PathVariable(value = "usuario_id")Long usuarioId) {
        try {

            Optional<List<TramiteTipo>> result = tramiteTipoService.findByUsuarioId(usuarioId);
            if (result.isPresent()) {
                List<TramiteTipoDTO> tramiteTipoDTO = MapperUtils.DtoListFromEntityList(result.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
     @GetMapping("/{tramite}")
    @ApiOperation(value = "Obtiene la lista de trámites otorgados segun el tramite ingresado", response = TramiteTipoDTO.class, responseContainer = "TramiteTipoDto", tags = "TramitesOtorgados")
    public ResponseEntity<?> findByTramiteId(@PathVariable(value = "tramite_id")Long tramiteId) {
        try {

            Optional<List<TramiteTipo>> result = tramiteTipoService.findByTramiteId(tramiteId);
            if (result.isPresent()) {
                List<TramiteTipoDTO> tramiteTipoDTO = MapperUtils.DtoListFromEntityList(result.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea un nuevo trámite con la información suministrada", response = TramiteTipoDTO.class, tags = "TramitesTipos") 
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
    
    
                 
     @ApiOperation(value = "Actualiza un trámite con la información suministrada si su id coincide con el ingresado", response = TramiteTipoDTO.class,  tags = "TramitesTipos") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TramiteTipo tramiteTipoModified) {
        try {
            Optional<TramiteTipo> tramiteTipoUpdated = tramiteTipoService.update(tramiteTipoModified, id);
            if (tramiteTipoUpdated.isPresent()) {
                TramiteTipoDTO tramiteTipoDto = MapperUtils.DtoFromEntity(tramiteTipoUpdated.get(), TramiteTipoDTO.class);
                return new ResponseEntity<>(tramiteTipoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
        @ApiOperation(value = "Elimina un trámite si su id coincide con el ingresado", response = TramiteTipoDTO.class,  tags = "TramitesTipos") 
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
        
    @ApiOperation(value = "Elimina todos los trámites", response = TramiteTipoDTO.class, tags = "TramitesTipos") 
    @DeleteMapping("/") 
    public ResponseEntity<?> deleteAll() {
        try {
            Optional<List<TramiteTipo>> result = tramiteTipoService.findAll();
            if (result.isPresent()) {
                tramiteTipoService.deleteAll();
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}
