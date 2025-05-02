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
        boolean valido = false;
        int opcion = 0;
        do {
            try {
                opcion = lector.nextInt();
                lector.nextLine();
                valido = true;
            } catch (Exception e) {
                System.out.println(Constantes.FORMATOERRONEO);
                lector.nextLine();
            }
        }while (!valido);
        return opcion;
    }

    public static char lectorChars (){
        Scanner lector = new Scanner(System.in);
        char c = ' ';
        try {
            c = lector.next().charAt(0);
            lector.nextLine();
        }catch (Exception e){
            System.out.println(Constantes.FORMATOERRONEO);
        }
        return c;
    }

    public static int eleccionRol (){
        int rol = 0;
        do {
            System.out.println(Constantes.OPCIONESROL + Constantes.MENU);
            int opcion = EntradaSalida.lectorDeOpcionesNumericas();
            switch (opcion) {
                case 1:
                    rol = 1;
                break;
                case 2:
                    if (Comprobaciones.comprobarContraseña()){
                        rol = 2;
                    }
                    break;
            }
        }while (rol == 0);
        return rol;
    }


}
