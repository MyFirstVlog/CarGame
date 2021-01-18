/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Carrera.cargame.doamin.juego;
import main.java.Carrera.Carrera.cargame.domain.carril.values.*;
import main.java.Carrera.Carrera.cargame.domain.carro.*;
import main.java.Carrera.Carrera.cargame.domain.carro.*;
import main.java.Carrera.cargame.domain.carril.*;
//import main.java.Carrera.cargame.domain.juego.values.*;
import Carrera.cargame.domain.juego.values.Pista;
import Carrera.cargame.domain.juego.values.Podio;
import main.java.Carrera.Carrera.cargame.domain.carril.values.*;
//import main.java.Carrera.cargame.domain.juego.values.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**;
 *
 * @author Alejandro Estrada Moscoso
 */
public class Juego {
    
    //cantidad de carros participantes 
    private static final String USERNAME = "root" ;
    private static final String PASSWORD = "root" ;
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/cargame" ;
    
        
        
      
    
    public static void main(String[] args) throws IOException, SQLException {     
        PreparedStatement pst = null;
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Connected");
            
        }catch(SQLException e){
            System.err.println(e);
        }
        
        String text ="";
        String path =  new File("").getAbsolutePath();
        String nombreTXT= "/cargamedb.txt";
        String abPath = path + nombreTXT;
        FileWriter fichero = new FileWriter(path + nombreTXT,true);  // el archivo se guarda en la carpta directorio de la java app  
        
      while(true){
          
        Boolean banderaDoc = false;
        Boolean jugar = false;
        
        Boolean ver = false;      
        String nombre1 = "";
        String nombre2 = "";
        String nombre3 = "";      
        
          
        System.out.println("Para jugar digite 1, Para ver tabla de resultados digite 2 o para salir 3");
        Scanner scan8= new Scanner(System.in);     
        int opcion= scan8.nextInt();
        
        if(opcion == 1){
        Boolean flag1 = false;
        Boolean flag2 = false;
        Boolean flag3 = false;
        
        while (flag1 == false){
            System.out.println("Ingrese la cantidad de carros participantess:");
            Scanner scan = new Scanner(System.in);     
            int cantidadCars = scan.nextInt();
            Jugador players[] = new Jugador[cantidadCars]; // defino jugadores
            Carro carros[] = new Carro[cantidadCars];
            Conductor conductores[] = new Conductor[cantidadCars];// defino numero de carros
            System.out.println("Disrancia de la carrera en KM");
            Scanner scan4 = new Scanner(System.in);
            float longPista = scan4.nextFloat();            
            Pista pista = new Pista(longPista, cantidadCars);  //creo el objeto tipo pista
            Podio podio = new Podio();
            
            
            for(int i=0; i<=(cantidadCars-1); i++){
             //Se crea lista de objetos de los jugadores con un vector 
                Scanner scan2 = new Scanner(System.in);  
                System.out.println("Nombre:");
                String nombre = scan2.nextLine();                
                Scanner scan3 = new Scanner(System.in);     
                System.out.println("Color:");
                String Color = scan3.nextLine();
                players[i]= new Jugador(); 
                           
                // Se procedo a la asignacion del carro para cada usuario que va a tenere la cedula de cada jugador 
                
                carros[i] = new Carro();
                Scanner scan5 = new Scanner(System.in);  
                System.out.println("Cedula:");
                String cedula = scan5.nextLine();  
                int conv = Integer.parseInt(cedula); 
                players[i].Asignacion(nombre, Color, conv);     
                carros[i].asignarConductor(cedula, Color);
                conductores[i] = new Conductor();
                conductores[i].nombre(nombre);
                
                //se asignan los carros 
                
                
                System.out.println("El objeto"+ i + "tiene el siguiente nombre: "+ players[i].Nombre);
            }
            while(flag2 == false){
                System.out.println("Digite el numero 1, si quiere jugar y simular o Digite el numero 2 para terminar");
                Scanner scan6 = new Scanner(System.in);  
                int rta = scan6.nextInt(); 
                int[] arr;
                int con = 0;
                int dist=0;
                int transDist = (int) (longPista*1000);
                ArrayList<Integer> listDist = new ArrayList<Integer>(cantidadCars);
                ArrayList<Integer> distRecorrido = new ArrayList<Integer>(cantidadCars);
                if( rta == 1){
                    while(flag3 == false){
                        for(int j=0; j<=(cantidadCars-1); j++){                       
                                                       
                            dist = carros[j].avanzarEnCarril(conductores[j]);          
                            System.out.println("el conductor es: " + carros[j].entregaInfo() + "con una distancia acumulada de: " + dist);
                            if(dist >= transDist){
                                if(listDist.contains(carros[j].entregaInfo()) == true){
                                     //System.out.println("entro donnde no debe ser");
                                }
                                else{
                                    listDist.add(con, carros[j].entregaInfo());
                                    distRecorrido.add(con, dist);
                                    System.out.println("Esta es el valor que debe tener al fin cada objeto " + carros[j].distRecorrida() );
                                    con++;
                                }                              
                                                                
                            }
                            if (listDist.size() == cantidadCars ){
                                    flag3 = true;
                                    flag2 = true;
                                    flag1 = true;
                                    break; 
                            }
                            
                            
                        }
                        
                    }
                    int conta= 0;
                    Boolean bandera = false;
                    while(bandera == false){
                        for ( int k = 0; k<=(listDist.size()-1); k++){
                            if(listDist.get(conta) == players[k].Cedula ){
                                while(true){
                                    if(conta == 0){
                                       nombre1= podio.asignarPrimerLugar(players[k].Nombre);
                                      
                                      System.out.println("El primer lugar es para: "+ nombre1);
                                      break;
                                    }else if (conta == 1){
                                        nombre2= podio.asignarPrimerLugar(players[k].Nombre);
                                      
                                        System.out.println("El Segundo lugar es para: "+ nombre2);
                                        
                                        break;
                                    }else if(conta ==2){
                                         nombre3= podio.asignarPrimerLugar(players[k].Nombre);
                                        String aux =  "Primera Posicion: /"+ nombre1+ "/ Segundo Lugar: /" + nombre2 +"/ Tercer Lugar: /" + nombre3 + "/ id del juego: " + "\n";
                                       
                                        //Statement stmt = (Statement) conn.createStatement();
                                        String insert =  "insert into cargame (game_id, first_place, second_place, third_place) values(null,?,?,?)";
                                        
                                        pst = conn.prepareStatement("insert into cargame values(null,?,?,?)");
                                       
                                        pst.setString(1, nombre1);
                                        pst.setString(2, nombre2);
                                        pst.setString(3, nombre3);
                                        pst.executeUpdate();
                                        //stmt.executeUpdate(insert);
                                        
                                        fichero.write(aux);
                                            
                                        System.out.println("entre");
                                            
                                        fichero.close();
                    
                                        fichero = new FileWriter(path + nombreTXT,true);  // meto datos al text file que se encuentra en la parte del directorio del proyecto se acumulan nuevos datos
                                       
                                      
                                        bandera = true;
                                        
                                      
                                        break;
                                      
                                      
                                    }
                                    
                            }    
                           
                        
                       }
                       
                        
                    }
                        conta++;
                        if(conta == 3){
                            break;
                        }
                    }
                    
                    
                    System.out.println(listDist);
                    listDist.clear();
                    System.out.println(distRecorrido);
                    distRecorrido.clear();
                    
                    
                }
                else{
                    flag3 = true;
                    flag2 = true;
                    flag1 = true;
                    break; 
                }
                
            }
           
            
        }
        }
        else if(opcion == 2){
            List<String> records = new ArrayList<String>();
            records = readFile(abPath);
            int lrn = records.size();
            for (int i = 0; i<= (lrn-1); i++){
                System.out.println(records.get(i));
            }
            
            //System.out.println(readFile(abPath));
        }else{
            break;
        }
        
        /*String path =  new File("").getAbsolutePath();
        String nombreTXT= "cargamedb.txt";
        FileWriter fichero = new FileWriter(path + nombreTXT);
        for (int x=0; x<10; x++){
            String nombreTXT= "/cargamedb.txt";
            fichero.write("Fila numero" + x + "\n");
        }
        fichero.close();*/
        
        
    }
    }
    
    public static List<String> readFile(String filename)
    {
        List<String> records = new ArrayList<String>();
        try
        {
          BufferedReader reader = new BufferedReader(new FileReader(filename));
          String line;
          while ((line = reader.readLine()) != null)
          {
            records.add(line);
          }
          reader.close();
          return records;
        }
        catch (Exception e)
        {
          System.err.format("Exception occurred trying to read '%s'.", filename);
          e.printStackTrace();
          return null;
        }
    }
    
    public void MySql(){
        
    }
  
    
    
    /*public static void conectar(){
        FileInputStream serviceAccount =
        new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

        FirebaseApp.initializeApp(options);
    }*/

}
