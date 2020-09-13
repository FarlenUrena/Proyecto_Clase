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
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.services.IPermisoOtorgadoService;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author farle_000
 */
@RestController
@RequestMapping("/permisos_otorgado") 
@Api(tags = {"PermisosOtorgados"})
public class PermisoOtorgadoController {
    @Autowired
    private IPermisoOtorgadoService permisoOtorgadoService;
  
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un permiso otorgado apartir del id ingresado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<PermisoOtorgado> permisoOtorgadoFound = permisoOtorgadoService.findById(id);
            if (permisoOtorgadoFound.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoFound.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{fecha}")
    @ApiOperation(value = "Obtiene una lista de permisos otorgados según el rango de fechas ingresado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByFechaRegistroBetween(@PathVariable(value = "fecha_registro") Date startDate,@PathVariable(value = "fecha_registro") Date endDate) {
        try {

            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findByFechaRegistroBetween(startDate, endDate);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisoOtorgadoDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
      @GetMapping("/{usuario}")
    @ApiOperation(value = "Obtiene la lista de permisos otorgados del usuario ingresado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByUsuarioId(@PathVariable(value = "usuario_id")Long usuarioId) {
        try {

            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findByUsuarioId(usuarioId);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisoOtorgadoDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
     @GetMapping("/{permiso}")
    @ApiOperation(value = "Obtiene la lista de permisos otorgados segund el permiso ingresado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByPermisoId(@PathVariable(value = "permiso_id")Long permisoId) {
        try {

            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findByPermisoId(permisoId);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisoOtorgadoDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
      @GetMapping("/usuario/{estado}")
    @ApiOperation(value = "Obtiene la lista de permisos otorgados del usuario ingresado según su estado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByUsuarioIdAndEstado(@PathVariable(value = "usuario_id")Long usuarioId,@PathVariable(value = "estado")boolean estado) {
        try {

            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findByPermisoIdAndEstado(usuarioId, estado);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisoOtorgadoDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
       @GetMapping("/permiso/{estado}")
    @ApiOperation(value = "Obtiene la lista de permisos otorgados del usuario ingresado según su estado", response = PermisoOtorgadoDTO.class, responseContainer = "PermisoOtorgadoDto", tags = "PermisosOtorgados")
    public ResponseEntity<?> findByPermisoIdAndEstado(@PathVariable(value = "permiso_id")Long permisoId,@PathVariable(value = "estado")boolean estado) {
        try {

            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findByPermisoIdAndEstado(permisoId, estado);
            if (result.isPresent()) {
                List<PermisoOtorgadoDTO> permisoOtorgadoDTO = MapperUtils.DtoListFromEntityList(result.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Crea un nuevo permiso con la información suministrada", response = PermisoOtorgadoDTO.class, tags = "PermisosOtorgados") 
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody PermisoOtorgado permisoOtorgado) {
        try {
            PermisoOtorgado permisoOtorgadoCreated = permisoOtorgadoService.create(permisoOtorgado);
            PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoCreated, PermisoOtorgadoDTO.class);
            return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
                 
     @ApiOperation(value = "Actualiza un permiso otorgado con la información suministrada si su id coincide con el ingresado", response = PermisoOtorgadoDTO.class,  tags = "PermisosOtorgados") 
    @PutMapping("/{id}") 
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PermisoOtorgado permisoOtorgadoModified) {
        try {
            Optional<PermisoOtorgado> permisoOtorgadoUpdated = permisoOtorgadoService.update(permisoOtorgadoModified, id);
            if (permisoOtorgadoUpdated.isPresent()) {
                PermisoOtorgadoDTO permisoOtorgadoDto = MapperUtils.DtoFromEntity(permisoOtorgadoUpdated.get(), PermisoOtorgadoDTO.class);
                return new ResponseEntity<>(permisoOtorgadoDto, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
        @ApiOperation(value = "Elimina un permiso otorgado si su id coincide con el ingresado", response = PermisoOtorgadoDTO.class,  tags = "PermisosOtorgados") 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        try {
            Optional<PermisoOtorgado> permisoOtorgadoFound = permisoOtorgadoService.findById(id);
            if (permisoOtorgadoFound.isPresent()) {
                permisoOtorgadoService.delete(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        
    @ApiOperation(value = "Elimina todos los permisos otorgados", response = PermisoOtorgadoDTO.class, tags = "PermisosOtorgados") 
    @DeleteMapping("/") 
    public ResponseEntity<?> deleteAll() {
 	//TODO: Implementar este método
        try {
            Optional<List<PermisoOtorgado>> result = permisoOtorgadoService.findAll();
            if (result.isPresent()) {
                permisoOtorgadoService.deleteAll();
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
        
    }
   
