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
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.dto.TransaccionDTO;
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.services.ITransaccionService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author farle_000
 */
@RestController
@RequestMapping("/transaccion") 
@Api(tags = {"Transacciones"})
public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionService;
  
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una transaccion con el id ingresado", response = TransaccionDTO.class, responseContainer = "TransaccionDto", tags = "Transacciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Transaccion> transaccionFound = transaccionService.findById(id);
            if (transaccionFound.isPresent()) {
                TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(transaccionFound.get(), TransaccionDTO.class);
                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{fecha}")
    @ApiOperation(value = "Obtiene una lista de transacciones según el rango de fechas ingresado", response = TransaccionDTO.class, responseContainer = "TransaccionDto", tags = "Transacciones")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "fecha_registro") Date startDate,@PathVariable(value = "fecha_registro") Date endDate) {
        try {

            Optional<List<Transaccion>> result = transaccionService.findByFechaRegistroBetween(startDate, endDate);
            if (result.isPresent()) {
                List<TransaccionDTO> TransacionDTO = MapperUtils.DtoListFromEntityList(result.get(), TransaccionDTO.class);
                return new ResponseEntity<>(TransacionDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @ApiOperation(value = "Otorga un nuevo permiso con la información suministrada", response = TransaccionDTO.class, tags = "Transacciones") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Transaccion permisoOtorgado) {
        try {
            Transaccion permisoOtorgadoCreated = transaccionService.create(permisoOtorgado);
            TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(permisoOtorgadoCreated, TransaccionDTO.class);
            return new ResponseEntity<>(transaccionDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
//     @ApiOperation(value = "Actualiza un permiso otorgado con la información suministrada si su id coincide con el ingresado", response = TransaccionDTO.class,  tags = "Transacciones") 
//    @PutMapping("/{id}") 
//    @ResponseBody
//    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Transaccion transaccionModified) {
//        try {
//            Optional<Transaccion> permisoOtorgadoUpdated = transaccionService.update(transaccionModified, id);
//            if (permisoOtorgadoUpdated.isPresent()) {
//                TransaccionDTO transaccionDto = MapperUtils.DtoFromEntity(permisoOtorgadoUpdated.get(), TransaccionDTO.class);
//                return new ResponseEntity<>(transaccionDto, HttpStatus.OK);
//
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
        
//        @ApiOperation(value = "Elimina un permiso otorgado si su id coincide con el ingresado", response = TransaccionDTO.class,  tags = "Transacciones") 
//    @DeleteMapping("/{id}") 
//    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
//        try {
//            Optional<Transaccion> transaccionFound = transaccionService.findById(id);
//            if (transaccionFound.isPresent()) {
//                transaccionService.delete(id);
//                return new ResponseEntity<>(null, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
        
//    @ApiOperation(value = "Elimina todos los permisos otorgados", response = TransaccionDTO.class, tags = "Transacciones") 
//    @DeleteMapping("/") 
//    public ResponseEntity<?> deleteAll() {
// 	//TODO: Implementar este método
//        try {
//            Optional<List<Transaccion>> result = transaccionService.findAll();
//            if (result.isPresent()) {
//                transaccionService.deleteAll();
//                return new ResponseEntity<>(null, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    } 
        
    }
   
