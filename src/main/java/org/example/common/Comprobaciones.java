package org.example.common;

import org.example.dao.Elementos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Comprobaciones {
    public static void comprobarPalabra(String palabra) throws ExcepcionCaracterEspecial {
        palabra = palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i)<65 || palabra.charAt(i)>90 ) {
                //throw new ExcepcionCaracterEspecial();
                throw new ExcepcionCaracterEspecial("La palabra " + palabra + " contiene caracteres no válidos, como por ejemplo: "
                        + palabra.charAt(i) + "\nNo se guardarán los cambios" );
            }
        }
    }

    public static boolean comprobarContraseña(){
        boolean acceso = false;
        Scanner sc = new Scanner(System.in);
        File contraseña = new File("Contraseña.txt");
        System.out.println(Constantes.SOLICITUD);
        String intento = sc.nextLine();
        sc.close();
        try {
            FileReader fr = new FileReader(contraseña);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            if (linea != null) {
                if (linea.equals(intento)) {
                    System.out.println(Constantes.PERMITIDO);
                    acceso = true;
                }else System.out.println(Constantes.DENEGADO);
            }else System.out.println(Constantes.VACIO);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acceso;
    }

    public static boolean comprobarCategoría(String categoria, Elementos e){
        boolean encontrado = false;
        for (int i = 0; i < e.getListaElementos().size(); i++) {
            if (categoria.equals(e.getListaElementos().get(i).getCategoria())) {
                encontrado = true;
            }else encontrado = false;
        }
        return encontrado;
    }
}
