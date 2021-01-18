/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Carrera.Carrera.cargame.domain.carro;
import java.util.Random;

/**
 *
 * @author User
 */
public class Conductor {
    String Nombre;
    
    public String nombre(String _nombre){
        Nombre = _nombre;
        return Nombre;
    }
    public int lanzarDado(){
       int max = 6;
       int min = 1;
       double random_double = Math.random() * (max - min + 1) + min;
       int IntValue = (int) random_double;
       IntValue = IntValue*100;
       return IntValue;       
    }
    
    
}
