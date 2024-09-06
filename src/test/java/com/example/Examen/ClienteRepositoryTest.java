package com.example.Examen;

import com.example.Examen.model.Cliente;
import com.example.Examen.repository.ClienteRepository;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testGuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Aldo");
        cliente.setApellidoPaterno("Ortiz");
        cliente.setApellidoMaterno("Ballona");
        cliente.setFechaNacimiento(LocalDate.of(1995, 5, 10));
        cliente.setSexo("M");
        cliente.setCorreo("Aldo.orti9@hotmail.com");
        cliente.setTelefono("123456789");

        Cliente savedCliente = clienteRepository.save(cliente);
        System.out.println("guardo: "+savedCliente.getId());
        assertNotNull(savedCliente.getId());  
    }
}

