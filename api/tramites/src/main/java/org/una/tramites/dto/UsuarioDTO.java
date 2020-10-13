/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.tramites.entities.Departamento;

/**
 *
 * @author farle_000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class UsuarioDTO {
 
    private Long id; 
    private String nombreCompleto;
    private String contraseñaEncriptada;
    private String cedula; 
    private boolean estado; 
    private Date fechaRegistro; 
    private Date fechaModificacion; 
    private boolean esJefe;
    private Departamento departamentos_id;
}

