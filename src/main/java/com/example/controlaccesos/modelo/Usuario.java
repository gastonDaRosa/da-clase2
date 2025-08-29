package com.example.controlaccesos.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Usuario {
    private String userName;
    private String nombre;
    private String apellido;
    private boolean habilitado;
    private List<Acceso> accesos;

    public Set<String> devolverAccesosMayorA(int numero) {
        Set<String> ret = new HashSet<>();
        for (Acceso accUsu : this.accesos) {
            long millisecondsDifference = accUsu.getSalida().getTime() - accUsu.getEntrada().getTime();
            long minutes = (millisecondsDifference % (1000 * 60 * 60)) / (1000 * 60);
            if (minutes > numero) {
                ret.add(this.getNombre() + " " + this.getApellido() + " " + "Ingreso " + minutes+ " minutos");
            }
        }
        return ret;
    }

}
