package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.model.Usuario;
import com.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {

        return usuarioService.listarUsuarios();
    }

    
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.guardarUsuario(usuario);
    }

    
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {

        usuarioService.eliminarUsuario(id);
    }

    // PUT
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuario) {

        return usuarioService.actualizarUsuario(id, usuario);
    }
}