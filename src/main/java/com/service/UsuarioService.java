package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Usuario;
import com.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR
    public List<Usuario> listarUsuarios() {

        return usuarioRepository.findAll();
    }

    // GUARDAR
    public Usuario guardarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    // ELIMINAR
    public void eliminarUsuario(Long id) {

        usuarioRepository.deleteById(id);
    }

    // ACTUALIZAR
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario != null) {

            usuario.setNombre(usuarioActualizado.getNombre());

            return usuarioRepository.save(usuario);
        }

        return null;
    }
}