/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.controllers;

import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.una.tramites.dto.ParametroGeneralDTO;
import org.una.tramites.entities.ParametroGeneral;
import org.una.tramites.services.IParametroGeneralService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author thony
 */

public class ParametroGeneralController {
    @Autowired
    private IParametroGeneralService parametroGeneralService;
      
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene parámetros con el id ingresado", response = ParametroGeneralDTO.class, responseContainer = "ParametroGeneralDto", tags = "ParametrosGenerales")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<ParametroGeneral> parametroGeneralFound = parametroGeneralService.findById(id);
            if (parametroGeneralFound.isPresent()) {
                ParametroGeneralDTO parametroGeneralDto = MapperUtils.DtoFromEntity(parametroGeneralFound.get(), ParametroGeneralDTO.class);
                return new ResponseEntity<>(parametroGeneralDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @GetMapping("/{fecha}")
//    @ApiOperation(value = "Obtiene una lista de parámetros según el rango de fechas ingresado", response = ParametroGeneralDTO.class, responseContainer = "ParametroGeneralDto", tags = "ParametrosGenerales")
//    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "fecha_registro") Date startDate,@PathVariable(value = "fecha_registro") Date endDate) {
//        try {
//
//            Optional<List<ParametroGeneral>> result = parametroGeneralService.findByFechaRegistroBetween(startDate, endDate);
//            if (result.isPresent()) {
//                List<ParametroGeneralDTO> ParametroGeneralDTO = MapperUtils.DtoListFromEntityList(result.get(), ParametroGeneralDTO.class);
//                return new ResponseEntity<>(ParametroGeneralDTO, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    /*
    @ApiOperation(value = "Otorga un nuevo permiso con la información suministrada", response = ParametroGeneralDTO.class, tags = "ParametrosGenerales") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroGeneral parametroGeneral) {
        try {
            ParametroGeneral parametroGeneralCreated = parametroGeneralService.create(parametroGeneral);
            ParametroGeneral parametroGeneralDto = MapperUtils.DtoFromEntity(parametroGeneralCreated, ParametroGeneralDTO.class);
            return new ResponseEntity<>(ParametroGeneralDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
}