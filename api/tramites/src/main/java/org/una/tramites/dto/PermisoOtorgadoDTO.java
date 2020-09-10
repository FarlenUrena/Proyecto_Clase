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
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.Transaccion;
import org.una.tramites.entities.Usuario;

/**
 *
 * @author farle_000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class PermisoOtorgadoDTO {
    private Long id; 
    private Usuario usuarios_id; 
    private Permiso permisos_id; 
    private Date fechaRegistro; 
    private boolean estado;   
}
