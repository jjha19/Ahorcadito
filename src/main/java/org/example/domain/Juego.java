package org.example.domain;


import org.example.common.Comprobaciones;
import org.example.common.Constantes;
import org.example.dao.Elementos;
import org.example.ui.EntradaSalida;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Juego {
    public Juego() {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        int errores = 0;
        Elementos elementos = new Elementos();
        char letraAdiv;
        boolean adivinada = false;

        System.out.println(Constantes.ELECCIONDIFICULTAD);
        int dificultad = EntradaSalida.lectorDeOpcionesNumericas();
        switch (dificultad) {
            case 1:
                errores = -3;
                break;
            case 2:
                errores = 0;
                break;
            case 3:
                errores = 2;
                break;
        }

        System.out.println(Constantes.ELECCIONCATEGORIA);
        String ctg = sc.nextLine();

        if (Comprobaciones.comprobarCategoría(ctg, elementos)) {
            List<Elemento> filtrados = elementos.getListaElementos().stream().filter(e -> e.getCategoria().equals(ctg)).toList();
            if (!filtrados.isEmpty()) {
                String palabra = filtrados.get(rd.nextInt(filtrados.size())).getPalabra();

                char[] palabraAdiv = new char[palabra.length()];
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == ' ') {
                        palabraAdiv[i] = palabra.charAt(i);
                    }
                }
                do {
                    for (int i = 0; i < palabraAdiv.length; i++) {
                        try {
                            System.out.print(palabraAdiv[i]);
                        } catch (NullPointerException e) {
                            System.out.print("＿");
                        }
                    }
                    System.out.println("\n" + Constantes.ESCRIBIRLETRA);
                    letraAdiv = EntradaSalida.lectorChars();

                    for (int i = 0; i < palabraAdiv.length; i++) {
                        if (letraAdiv == palabra.charAt(i)) {
                            palabraAdiv[i] = palabra.charAt(i);
                        } else {
                            errores++;
                        }
                    }

                    if (palabraAdiv.toString().equals(palabra)) {
                        adivinada = true;
                    }

                } while (errores < 7 || !adivinada);
                dibujarAhorcado(errores);
                System.out.println(Constantes.JUEGOTERMINADO);
            } else System.out.println(Constantes.LISTAVACIA);
        } else System.out.println(Constantes.CATEGORIANOENCONTRADA);

    }
    public void dibujarAhorcado(int errores){
        switch (errores) {
            case -3:
                System.out.println("""
                                    
                                     
                                           
                                    
                                          
                                    |
                                    """);
                break;
            case -2:
                System.out.println("""
                                    
                                           
                                           
                                    |
                                    |      
                                    |
                                    """);
                break;
            case -1:
                System.out.println("""
                                    |
                                    |       
                                    |       
                                    |
                                    |      
                                    |
                                    """);
                break;
            case 0:
                System.out.println("""
                                    |--------
                                    |       
                                    |       
                                    |
                                    |      
                                    |
                                    """);
                break;
            case 1:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       
                                    |
                                    |      
                                    |
                                    """);
                break;
            case 2:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |
                                    |      
                                    |
                                    """);
                break;
            case 3:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |       |
                                    |      
                                    |
                                    """);
                break;
            case 4:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |      /|
                                    |      
                                    |
                                    """);
                break;
            case 5:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |      /|\
                                    |      
                                    |
                                    """);
                break;
            case 6:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |      /|\
                                    |      / 
                                    |
                                    """);
                break;
            case 7:
                System.out.println("""
                                    |--------
                                    |       |
                                    |       O
                                    |      /|\
                                    |      / \
                                    |
                                    """);
                break;
        }
    }
}
