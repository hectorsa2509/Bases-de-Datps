/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hercules;

/**
 *
 * @author hectorsama
 */
public class Clases {
    
    String nombreClase;
    String nombreProfesor;
    int horaClase;
    String diaClase;
    int id;
    
    
   /**
 * Constructor inicializado con los atributos de la clase con excepcion de id
 */
    public Clases(String nombreClase,String nombreProfesor , int horaClase,String diaClase){
     this.nombreClase=nombreClase;
     this.nombreProfesor=nombreProfesor;
     this.horaClase=horaClase;
     this.diaClase=diaClase;
    
    }
    
        /**
 * Constructor inicializado con los atributos de la clase
 */
     public Clases(String nombreClase,String nombreProfesor , int horaClase,String diaClase,int id){
     this.nombreClase=nombreClase;
     this.nombreProfesor=nombreProfesor;
     this.horaClase=horaClase;
     this.diaClase=diaClase;
     this.id=id;
    
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getHoraClase() {
        return horaClase;
    }

    public void setHoraClase(int horaClase) {
        this.horaClase = horaClase;
    }

    public String getDiaClase() {
        return diaClase;
    }

    public void setDiaClase(String diaClase) {
        this.diaClase = diaClase;
    }
    @Override
    public String toString() {
      
            String temp= "Nombre Clase: "+ getNombreClase()+"\nId:"+getId()
                    +"\n\tNombre del Profesor:  "+ getNombreProfesor()+"\n\tHora de Clase: "+ getHoraClase()+"\n\tDia de Clase: "+getDiaClase();     
   return temp; 
    }
    
    
}
