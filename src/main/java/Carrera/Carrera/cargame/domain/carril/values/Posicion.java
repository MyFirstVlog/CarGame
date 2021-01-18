/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Carrera.Carrera.cargame.domain.carril.values;

/**
 *
 * @author User
 */
public class Posicion {
    int posicion=0;    
    public int actual(int paso) {
        posicion = posicion + paso;
         return posicion;    
    }          
    
}
