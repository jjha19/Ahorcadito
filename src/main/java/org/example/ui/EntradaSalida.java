package org.example.ui;

import org.example.common.Comprobaciones;
import org.example.common.Constantes;
import org.example.common.ExcepcionCaracterEspecial;
import org.example.domain.Elemento;
import org.example.service.GestionElementos;
import org.example.service.GestionElementosImplementacion;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {
    private GestionElementos servicio;

    public EntradaSalida(GestionElementos ge) {
        this.servicio = ge;
    }

    public EntradaSalida() {
        servicio= new GestionElementosImplementacion();
    }

    public void mostrarListaElementos(){
        List<Elemento> lista = servicio.getListaElementos();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elemento " + i + ":" + lista.get(i));
        }
    }
    public static void mostrarListaElementos(GestionElementos ge){
        List<Elemento> lista = ge.getListaElementos();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print("Elemento " + i + ":" + lista.get(i));
        }
    }
    public static Elemento insertarElemento(){
        Scanner lector = new Scanner(System.in);
        String id;
        String palabra;
        String categoria;
        boolean erroneo;
        do {
            erroneo = false;
            System.out.println(Constantes.INSERTAR);
            id = lector.nextLine();
            palabra = lector.nextLine();
            categoria = lector.nextLine();
            try {
                Comprobaciones.comprobarPalabra(palabra);
                Comprobaciones.comprobarPalabra(categoria);
            } catch (ExcepcionCaracterEspecial e) {
                System.out.println(e.getMessage());
                erroneo = true;
            }
        }while (erroneo);

        return new Elemento(id,palabra,categoria);
    }
    public static int lectorDeOpcionesNumericas(){
        Scanner lector = new Scanner(System.in);
        int opcion = -1;
        do {
            try {
                opcion = lector.nextInt();
                lector.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (opcion == -1);
        lector.close();
        return opcion;
    }


}
