package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Usuario;
import com.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario login(@RequestBody Usuario usuario) {

        Usuario user = repository.findByCorreo(usuario.getCorreo()).orElse(null);

        if (user != null && user.getPassword().equals(usuario.getPassword())) {
            return user;
        }

        return null;
    }
}