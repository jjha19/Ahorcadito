package org.example.ui;

import org.example.common.Comprobaciones;
import org.example.common.Constantes;
import org.example.domain.Juego;
import org.example.service.GestionElementos;
import org.example.service.GestionElementosImplementacion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(Constantes.BIENVENIDA);
        GestionElementos ge = new GestionElementosImplementacion();
        int rol = EntradaSalida.eleccionRol();
        do {
            if (rol == 1) {
                System.out.println(Constantes.ELECCIONPARTIDA);
                int eleccion = EntradaSalida.lectorDeOpcionesNumericas();
                if (eleccion == 1) {
                    Juego jg = new Juego();
                } else if (eleccion == 2) {
                    System.out.println("Esta parte me falta");
                }

            } else if (rol == 2) {
                if (Comprobaciones.comprobarContraseña()){

                }
            }
        } while (rol != 1 && rol != 2);
    }
}