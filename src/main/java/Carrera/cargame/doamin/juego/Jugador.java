/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Carrera.cargame.doamin.juego;

/**
 *
 * @author User
 */
public class Jugador {
    String Nombre;
    String Color;
    int Cedula;
    int puntos = 0 ;
    
    public void Asignacion( String _nombre, String _color, int cedula_){
        Nombre = _nombre;
        Color = _color;
        Cedula = cedula_;
        
    }
    
    public int asignarPuntos(int _puntos){
        puntos = _puntos + puntos;
        return puntos;
    }    
    public String nombreJugador(){
        return Nombre;
    }
    public int cedulaJugador(){
        return Cedula;
    }
    
    
}
