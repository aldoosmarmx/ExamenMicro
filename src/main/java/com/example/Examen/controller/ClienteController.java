/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Examen.controller;

import Excepciones.ClienteExistenteException;
import com.example.Examen.model.Cliente;
import com.example.Examen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aldoo
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Long> agregarCliente(@RequestBody Cliente cliente) {
         try {
            Cliente nuevoCliente = clienteService.guardarCliente(cliente);
            return ResponseEntity.ok(nuevoCliente.getId());
        } catch (ClienteExistenteException e) {
            return (ResponseEntity<Long>) ResponseEntity.status(HttpStatus.CONFLICT); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(cliente);
    }
}
