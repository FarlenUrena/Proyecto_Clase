/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.una.tramites.dto.AuthenticationRequest;
import org.una.tramites.dto.AuthenticationResponse;
import org.una.tramites.dto.PermisoOtorgadoDTO;
import org.una.tramites.dto.UsuarioDTO;
import org.una.tramites.entities.Usuario;
import org.una.tramites.jwt.JwtProvider;
import org.una.tramites.utils.MapperUtils;

/**
 *
 * @author farle_000
 */

@Service
public class AutenticacionServiceImplementation implements IAutenticacionService{
    
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
               Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getCedula(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        Optional<Usuario> usuario = usuarioService.findByCedula(authenticationRequest.getCedula());

        if (usuario.isPresent()) {
            authenticationResponse.setJwt(jwtProvider.generateToken(authenticationRequest));
            UsuarioDTO usuarioDto = MapperUtils.DtoFromEntity(usuario.get(), UsuarioDTO.class);
            authenticationResponse.setUsuario(usuarioDto);
            List<PermisoOtorgadoDTO> permisosOtorgadosDto = MapperUtils.DtoListFromEntityList(usuario.get().getPermisosOtorgados(), PermisoOtorgadoDTO.class);
            authenticationResponse.setPermisos(permisosOtorgadosDto);

            return authenticationResponse;
        } else {
            return null;
        }

 
    }
    
}
