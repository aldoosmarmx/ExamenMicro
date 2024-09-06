/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Examen.service;

/**
 *
 * @author aldoo
 */
import Excepciones.ClienteExistenteException;
import com.example.Examen.model.Cliente;
import com.example.Examen.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);
    
    @Autowired
    private ClienteRepository clienteRepository;

    
    public Cliente guardarCliente(Cliente cliente) {
        logger.info("Guardando cliente: " + cliente.getNombre());
         if (clienteRepository.existsByNombre(cliente.getNombre())) {
            throw new ClienteExistenteException("Cliente con el correo proporcionado ya existe.");
        }
        return clienteRepository.save(cliente);
     
    }

    public Cliente obtenerClientePorId(Long id) {
        logger.info("Consultando cliente con ID: " + id);
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}

