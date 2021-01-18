/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera.cargame.domain.juego.values;
import main.java.Carrera.cargame.doamin.juego.*;

/**
 *
 * @author User
 */
public class Podio {
    
    Jugador primerLugar;
    Jugador segundoLugar;
    Jugador tercerLugar;
    Boolean flag1 = false;
    Boolean flag2 = false;
    Boolean flag3 = false;
    Boolean lleno = false;
    String nombre1;
    String nombre2;
    String nombre3;
    
    
    public String asignarPrimerLugar(String player){
        nombre1 = player;
        flag1 = true;
        return nombre1;
        
        
    }
    public String asignarSegundoLugar(String player){
        nombre2 = player;
        flag2 = true;
        return nombre2;
    }
    public String asignarTercerLugar(String player){
        nombre3 = player;
        flag3 = true;
        return nombre3;
        
    }
    public void estaLLeno(){
        if(flag1 == true && flag2 == true && flag3 == true){
            lleno = true;
        }
    }
    
    
}
