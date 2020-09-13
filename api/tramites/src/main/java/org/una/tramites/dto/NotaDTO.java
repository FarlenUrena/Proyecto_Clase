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
import org.una.tramites.entities.PermisoOtorgado;

/**
 *
 * @author thony
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString

public class NotaDTO {
     private Long id; 
     private Date fechaRegistro;
     private PermisoOtorgado permisosOtorgados_id;
     private String objeto;
     private String descripcion;
}
