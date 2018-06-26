/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hercules;
import java.util.*;

/**
 *Clase que administra todo el Gymnasio relacionando CLientes, Clases
 * @author hectorsama,Berna
 * @version 1.1
 *correciones en crearCliente()
 */
public class Hercules  {
    
     public static ArrayList<Cliente> lista;
     
     public static ArrayList<Clases> listac;
 
     /*
     *Constructor 
     */
     public Hercules(ArrayList<Cliente> nwCl,ArrayList<Clases> nwCl1){
     lista=nwCl;
     listac=nwCl1;
     }
     
     /*
     *Constructor 
     */

    Hercules() {
     lista= new ArrayList<Cliente>();
     listac=new ArrayList<Clases>();
    }
     /**
     * Agrega un cliente a la base de datos 
     * @param Cliente el cliente a guardar.
     */
    
    public  void crearCliente( Cliente c){
        if(hasLugarVacio()){
            int i=0;
            for(Cliente k: lista){
                if(lista.get(i)== null){
                    lista.set(i,c);
                    break;
                }else{
                    i++;
                }
                
            }
        c.setId(i);
        }
        else{
            lista.add(c);
            c.setId(lista.size()-1);
        }
        
        System.out.println("Bienvenido "+c.getNombreCompleto()+"\nId:"+c.getId()+"\nDir:"+c.getDireccion()+"\nTel:"+c.getTelefono());
            
	}
    /**
     * Metodo que revisa si en la lista existe algun lugar nulo, para asignarle ese id. 
     * [1,2,null,4,5]
     * @return res si encuentra un vacio o no
     */
    public boolean hasLugarVacio(){
        boolean res=false;
        int i=0;
        for(Cliente c:lista){
            if(lista.get(i)==null)
                   res=true;
            i++;
        }
        
        
        return res;
    }
     /**
     * Imprirmir  clientes de la base de datos 
     * 
     */       
        public void imprimirClientes(){
            if(lista.size()==0)
                System.out.println("No hay ningun cliente...aun ;D ");
             for(Cliente c: lista){
                 if(c!=null){
                  
                  System.out.println(c.toString());
                 }else
                     System.out.println("");
                     
             }
        }
   
   /**
    * Asigna un id al cliente
    *@param  ArrayList<Cliente> 
    */     
    public void idCliente(ArrayList<Cliente> lista){
        int id =0;
        for(Cliente c: lista){
        id+=1;
        System.out.println("Cliente " + id);
        System.out.println(c+ "\n");
        
        }
    }
    
    /*
    *Disponibilidad del cliente
    *@param Cliente
    */
     public  boolean verificarCliente(Cliente m){
            boolean disponibilidad = true;    
            return disponibilidad;
	}
      /**
     * Elimina un cliente a la base de datos 
     * @param cliente el cliente a guardar.
     */
     	public void eliminarCliente(int id){
            lista.set(id,null);
	}
        
     /**
     * Busca un cliente a la base de datos 
     * @param cliente el cliente a guardar.
     * @return string nombre del Cliente
     */
          public Cliente buscarCliente(String nombre){
           for(Cliente a : this.lista){
               if(a.getNombreCompleto().equals(nombre)){
                   System.out.println(a.toString());
                   break;
               }
           } return null;
      }
        /*
         *Modifica Nombre del Cliente
         *@param index, nombre, nombreAct
         */
        public void modificarNombreCompleto(int index,String nombre, String nombreAct){
            lista.get(index).setNombreCompleto(nombre);
        }   
         /*
         *Modifica telefono del Cliente
         *@param index, telefono, telefonoAct
         */
        public void modificarTelefono(int index,int telefono, String telefenoAct){
            lista.get(index).setTelefono(telefono);
        }
        /*
         *Modifica direccion del Cliente
         *@param index, direccion, direccionAct
         */
        public void modificarDireccion(int index,String direccion, String direccionAct){
            lista.get(index).setDireccion(direccion);
        }
        
       
     /**
     * Agrega un clase a la base de datos 
     * @param Clases la clase a guardar.
     */
        public  void crearClase( Clases c){
        if(hasLugarVacioC()){
            int i=0;
            for(Clases k: listac){
                if(listac.get(i)== null){
                    listac.set(i,c);
                    break;
                }else{
                    i++;
                }
            }
        c.setId(i);
        }
        else{
            listac.add(c);
            c.setId(listac.size()-1);
        }
        System.out.println("Clase:  "+c.getNombreClase()+"\nProfesor:"+c.nombreProfesor+"\n\tHora:"+c.horaClase+"\n\tDia:"+c.diaClase+"\niD"+c.getId());   
	}
        
        
      /**
     * Metodo que revisa si en la lista existe algun lugar nulo, para asignarle ese id. 
     * [1,2,null,4,5]
     * @return res si encuentra un vacio o no
     */
        public boolean hasLugarVacioC(){
        boolean res=false;
        int i=0;
        for(Clases c:listac){
            if(listac.get(i)==null)
                   res=true;
            i++;
        }
        
        
        return res;
    }

        /*
        *Imprime los datos de la Clase
        */
        public void imprimirClase(){
            if(listac.size()==0)
                System.out.println("No hay ningun Clase :(");
             for(Clases c: listac){
                 if(c!=null){
                  System.out.println(c.toString());
                 }else
                     System.out.println("");              
             }
        }
        
        
        public void eliminarClase(int id){
            listac.set(id,null);
	}
     /**
     * Busca una clase en la base de datos 
     * @param clase el clase a buscar.
     * @return string nombre del Cliente
     */
          public Clases buscarClase(String nombre){
           for(Clases a : this.listac){
               if(a.getNombreClase().equals(nombre)){
                   System.out.println(a.toString());
                   break;
               }
           } return null;
      }
        /*
         *Modifica Nombre de la Clase
         *@param index, nombre, nombreAct
         */
         public void modificarNombreClase(int index,String nombre, String nombreAct){
            listac.get(index).setNombreClase(nombre);
        }   
         /*
         *Modifica Nombre del Profesor
         *@param index, nombre, nombreAct
         */
        public void modificarNombreProfesor(int index,String nombre, String nombreAct){
            listac.get(index).setNombreProfesor(nombre);
        }
         /*
         *Modifica Hora de la Clase
         *@param index, hora, horaAct
         */
        public void modificarHoraClase(int index,int hora, int horaAct){
            listac.get(index).setHoraClase(hora);
        }
         /*
         *Modifica Dia de la Clase
         *@param index, dia, diaAct
         */
         public void modificarDiaClase(int index,String nombre, String nombreAct){
            listac.get(index).setDiaClase(nombre);
        }
         /*
         *Imprime la lista de Inscritos
         */
         public void imprimirListaInscripcion(){
             for(Clases cl:listac){
                 String names="";
                 if(cl !=null){
                    System.out.println(cl.getNombreClase());
                    System.out.println("\tInscritos: ");

                    for(Cliente c:lista){
                        if(c.getClasesTomadas().contains(cl.getId()))
                            names+="\t"+c.getNombreCompleto()+"\n";
                    }
                 }
                 
                 System.out.println(names+"\n");
             
             
             }             
             
         }
         /*
         *Elimina de cada cliente en el arrreglo la clase tomada el identificador de la clase que el adminitradoe decidio eliminar
         *@param id*/
         public void ElimClaseTomadasCl(int id){
             int idx=0;
             for(Cliente cliente: lista){
                 if(cliente != null)
                    if(cliente.getClasesTomadas().contains(id)){
                        idx=cliente.getClasesTomadas().indexOf(id);
                        cliente.getClasesTomadas().remove(idx);
                    }
             }
         }
           
}
        



   
