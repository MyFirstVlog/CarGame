/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Carrera.Carrera.cargame.domain.carro;

/**
 *
 * @author User
 */
public class Carro {
    Conductor conductor ;
    int distancia;
    String carrilID;
    String color;
    String cedulaConductor;
    int distanciaRecorrida = 0;

    
    public void asignarConductor(String cedula, String Color_){
        cedulaConductor = cedula;
        color = Color_;
    }
    
    public int avanzarEnCarril(Conductor driver){
        conductor = driver;
        //carrilID= cID;
        distanciaRecorrida = distanciaRecorrida + conductor.lanzarDado();
        return distanciaRecorrida;
    }
    public int entregaInfo(){
        return Integer.parseInt(cedulaConductor);
    }   
    public int distRecorrida(){
        return distanciaRecorrida;
    }

    
}
