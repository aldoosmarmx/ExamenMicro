/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Examen.repository;

import com.example.Examen.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aldoo
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNombre(String nombre);
}
