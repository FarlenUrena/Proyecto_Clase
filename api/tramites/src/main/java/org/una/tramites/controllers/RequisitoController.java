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
import org.una.tramites.dto.RequisitoDTO;
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
    @ApiOperation(value = "Obtiene un requisito a partir del id ingresado", response = RequisitoDTO.class, responseContainer = "RequisitoDto", tags = "Requisitos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<RequisitoController> requisitoFound = requisitoService.findById(id);
            if (requisitoFound.isPresent()) {
                RequisitoDTO RequisitoDto = MapperUtils.DtoFromEntity(requisitoFound.get(), RequisitoDTO.class);
                return new ResponseEntity<>(RequisitoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{fecha}")
    @ApiOperation(value = "Obtiene una lista de requisitos según el rango de fechas ingresado", response = RequisitoDTO.class, responseContainer = "RequisitoDto", tags = "Requisitos")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "fecha_registro") Date startDate,@PathVariable(value = "fecha_registro") Date endDate) {
        try {

            Optional<List<RequisitoController>> result = requisitoService.findByFechaRegistroBetween(startDate, endDate);
            if (result.isPresent()) {
                List<RequisitoDTO> requisitoDTO = MapperUtils.DtoListFromEntityList(result.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{requisito}")
    @ApiOperation(value = "Obtiene la lista de requisitos otorgados", response = RequisitoDTO.class, responseContainer = "RequisitoDto", tags = "RequisitosOtorgados")
    public ResponseEntity<?> findByTramiteId(@PathVariable(value = "requisito_id")Long requisitoId) {
        try {

            Optional<List<RequisitoController>> result = requisitoService.findByRequisitoId(requisitoId);
            if (result.isPresent()) {
                List<RequisitoDTO> requisitoDTO = MapperUtils.DtoListFromEntityList(result.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
    @ApiOperation(value = "Crea un nuevo requisito con la información suministrada", response = RequisitoDTO.class, tags = "Requisitos") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RequisitoController requisito) {
        try {
            RequisitoController requisitoCreated = requisitoService.create(requisito);
            RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoCreated, RequisitoDTO.class);
            return new ResponseEntity<>(requisitoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
    @ApiOperation(value = "Actualiza un requisito otorgado con la información suministrada si su id coincide con el ingresado", response = RequisitoDTO.class,  tags = "Requisitos") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RequisitoController requisitoModified) {
        try {
            Optional<RequisitoController> requisitoUpdated = requisitoService.update(requisitoModified, id);
            if (requisitoUpdated.isPresent()) {
                RequisitoDTO requisitoDto = MapperUtils.DtoFromEntity(requisitoUpdated.get(), RequisitoDTO.class);
                return new ResponseEntity<>(requisitoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
    @ApiOperation(value = "Elimina un requisito otorgado si su id coincide con el ingresado", response = RequisitoDTO.class,  tags = "Requisitos") 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<RequisitoController> requisitoFound = requisitoService.findById(id);
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
        
    @ApiOperation(value = "Elimina todos los requisitos otorgados", response = RequisitoDTO.class, tags = "Requisitos") 
    @DeleteMapping("/") 
    public ResponseEntity<?> deleteAll() {
 	//TODO: Implementar este método
        try {
            Optional<List<RequisitoController>> result = requisitoService.findAll();
            if (result.isPresent()) {
                requisitoService.deleteAll();
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}