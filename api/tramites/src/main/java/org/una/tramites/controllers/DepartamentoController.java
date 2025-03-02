/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.tramites.dto.DepartamentoDTO;
import org.una.tramites.entities.Departamento;
import org.una.tramites.services.IDepartamentoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author farle_000
 */

@RestController
@RequestMapping("/departamentos") 
@Api(tags = {"Departamentos"})
public class DepartamentoController {
    @Autowired
    private IDepartamentoService departamentoService;
    
    @GetMapping("/{estado}")
    @ApiOperation(value = "Obtiene una lista de todos los departamentos con el estado solicitado", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    public @ResponseBody
        ResponseEntity<?> findByEstado(@PathVariable(value = "estado") boolean estado) {
        try {
            Optional<List<Departamento>> result = departamentoService.findByEstado(true);
            if (result.isPresent()) {
                List<DepartamentoDTO> departamentoDTO = MapperUtils.DtoListFromEntityList(result.get(), DepartamentoDTO.class);
                return new ResponseEntity<>(departamentoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}