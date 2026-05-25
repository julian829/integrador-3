package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Eventos;
import com.repository.EventosRepository;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    public List<Eventos> listar() {
        return eventosRepository.findAll();
    }

    public Eventos guardar(Eventos evento) {
        return eventosRepository.save(evento);
    }

    public Eventos buscarPorId(Long id) {
        return eventosRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        eventosRepository.deleteById(id);
    }
}