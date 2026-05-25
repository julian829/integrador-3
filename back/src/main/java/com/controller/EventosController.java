package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Eventos;
import com.service.EventosService;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping
    public List<Eventos> listar() {
        return eventosService.listar();
    }

    @PostMapping
    public Eventos guardar(@RequestBody Eventos evento) {
        return eventosService.guardar(evento);
    }

    @GetMapping("/{id}")
    public Eventos buscar(@PathVariable Long id) {
        return eventosService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eventosService.eliminar(id);
    }
}