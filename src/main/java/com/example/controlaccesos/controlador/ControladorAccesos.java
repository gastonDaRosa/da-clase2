package com.example.controlaccesos.controlador;


import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.controlaccesos.modelo.ServiciosUsuario;
import com.example.controlaccesos.modelo.Usuario;

@RestController
public class ControladorAccesos {

    ServiciosUsuario serviciosUsuario = ServiciosUsuario.getInstancia();
    
    @GetMapping("/todos")
    public List<Usuario> todosLosUsuarios() {
        return serviciosUsuario.getUsuarios();
    }

    @GetMapping("/lista")
    public Set<String> usuariosHabilitadosConAccesoMayorA(@RequestParam int minutos) {
        return serviciosUsuario.stringUsuariosHabilitadosConAccesoMayorA(minutos); // Implementación pendiente
    }

}
