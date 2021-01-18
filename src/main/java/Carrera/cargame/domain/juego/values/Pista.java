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
public class Pista {
    double kilometros;
    int numeroDeCarriles;
    
    public Pista (double _kilo, int _Carriles){
        kilometros = _kilo;
        numeroDeCarriles = _Carriles;
    }
    
    public double cantidadKm(){
        return kilometros;
    }
     
}
