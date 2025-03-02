/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.tramites.components;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.tramites.entities.Permiso;
import org.una.tramites.entities.PermisoOtorgado;
import org.una.tramites.entities.Usuario;
import org.una.tramites.loaders.Permisos;
import org.una.tramites.services.IPermisoOtorgadoService;
import org.una.tramites.services.IPermisoService;
import org.una.tramites.services.IUsuarioService;

/**
 *
 * @author farle_000
 */

@Component
public class DataLoader implements ApplicationRunner {

    @Value("${app.admin-user}")
    private String cedula;

    @Value("${app.password}")
    private String password;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPermisoService permisoService;

    @Autowired
    private IPermisoOtorgadoService permisoOtorgadoService;

    @Override
    public void run(ApplicationArguments args) {
        if(permisoService.ContarPermisos() == 0 || permisoService.ContarPermisos() == 1){
        createPermisos();
        }
        if (usuarioService.findByCedula(cedula).isEmpty()) {
            Permiso permiso;
            final String codigo = "Usu01"; 
            Optional<Permiso> permisoBuscado = permisoService.findByCodigo(codigo);
            if (permisoBuscado.isEmpty()) { 
                permiso = new Permiso();
                permiso.setCodigo(codigo);
                permiso.setDescripcion("Registrar usuario nuevo");
                permiso = permisoService.create(permiso);
            } else {
                permiso = permisoBuscado.get();
            }
            Usuario usuario = new Usuario();
            usuario.setNombreCompleto("Usuario Admin");
            usuario.setCedula(cedula);
            usuario.setPasswordEncriptado(password);
            usuario = usuarioService.create(usuario);
            
            PermisoOtorgado permisoOtorgado = new PermisoOtorgado();
            permisoOtorgado.setPermiso(permiso);
            permisoOtorgado.setUsuario(usuario);
            permisoOtorgadoService.create(permisoOtorgado);
            System.out.println("Se agrega el usuario inicial");
        } else {
            System.out.println("Se encontró el admin");
        }
    }
        private void createPermisos() {
        for (Permisos permiso : Permisos.values()) {
            Permiso nuevoPermiso = new Permiso();
            nuevoPermiso.setCodigo(permiso.getCodigo());
            nuevoPermiso.setDescripcion(permiso.name());
            permisoService.create(nuevoPermiso);
        } 
    }
}