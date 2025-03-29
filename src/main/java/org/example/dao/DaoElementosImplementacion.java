package org.example.dao;

import org.example.domain.Elemento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    private Elementos lista;

    public DaoElementosImplementacion(Elementos lista) {
        this.lista = lista;
    }

    public DaoElementosImplementacion() {
        lista = new Elementos();
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.getListaElementos().isEmpty();
    }

    @Override
    public boolean insertarElemento(Elemento Elemento) {
        //return lista.getListaElementos().add(Elemento);
        return lista.insertarElemento(Elemento);
    }

    @Override
    public boolean insertarElemento(int id, String palabra, String categoria) {
        return false;
    }

    @Override
    public List<Elemento> getElementos() {
        return lista.getListaElementos();
    }

    @Override
    public List<Elemento> getElementosCategoria(String categoria) {
        return List.of();
    }

    @Override
    public List<Elemento> listadoOrdenado(boolean ascendente) {
        return List.of();
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) {
        return false;
    }

    @Override
    public boolean modificarElemento(int id, String palabra) {
        return false;
    }

    @Override
    public void eliminarElemento(Elemento Elemento) {

    }

    @Override
    public boolean eliminarElemento(int id) {
        return false;
    }

    public void cambiarContraseña(){}
    public boolean compararConContraseña(String input){
        boolean acceso = false;
        String archivoContraseña = "Contraseña.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoContraseña))) {
            String linea = br.readLine();
            if (linea == null || input.equals(linea)) {
               acceso = true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return acceso;
    }
}
