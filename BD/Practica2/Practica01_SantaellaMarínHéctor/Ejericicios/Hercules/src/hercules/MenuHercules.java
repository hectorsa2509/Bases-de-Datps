/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hercules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hectorsama
 */
public class MenuHercules {
    /**
     *clase que Lee el fichero para actualizar datos , si no hay fichero, lo crea. 
     * @return El arreglo con los objetos tomados del fichero.txt
     */
    public static ArrayList<Cliente> leerFichero(String fileName) throws IOException{
	ArrayList<Cliente> res=new ArrayList<Cliente>();
	String ruta = fileName;
	File archivo = new File(ruta);
	FileReader fr = new FileReader (archivo);
	BufferedReader br;
           
	try {
	    // Apertura del fichero y creacion de BufferedReader para poder
	    // hacer una lectura comoda (disponer del metodo readLine()).
        
            br = new BufferedReader(fr);
           
            String linea;
            int id=0;
            String name="";
            String address="";
            int PNumber=0;
            while((linea=br.readLine()) !=null){
                
                if(! linea.equals("#")){
                    id=Integer.parseInt(linea);
                    name=br.readLine();
                    address=br.readLine();
                    PNumber=Integer.parseInt(br.readLine());
                    if(id >= res.size()){
			for(int i=res.size();i<=id;i++){
			    res.add(null);
			}                   
                    }
		    Cliente nwCliente= new Cliente(name,address,PNumber,id); 
		    res.set(id,nwCliente);                   
		}
	    }
	}
	catch(Exception e){
	    e.printStackTrace();
	}finally{

	    try{                    
		if( null != fr ){   
                    fr.close();     
		}                  
	    }catch (Exception e2){ 
		e2.printStackTrace();
	    }
	}
            
	return res;
            
    }
         
         
         
    /**
     *clase que Lee el fichero para actualizar datos , si no hay fichero, lo crea. 
     * @return El arreglo con los objetos tomados del fichero.txt
     */         
    public static ArrayList<Clases> leerFicheroC(String fileName) throws IOException{
	ArrayList<Clases> res=new ArrayList<Clases>();
	String ruta = fileName;
	File archivo = new File(ruta);
	FileReader fr = new FileReader (archivo);
	BufferedReader br;
           
	try {
	    // Apertura del fichero y creacion de BufferedReader para poder
	    // hacer una lectura comoda (disponer del metodo readLine()).
        
            br = new BufferedReader(fr);
            String linea;
            int id=0;
            String nombreClase="";
            String nombreProfesor="";
            int horaClase=0;
            String diaClase="";
            while((linea=br.readLine()) !=null){
                
                if(! linea.equals("#")){
                    id=Integer.parseInt(linea);
                    nombreClase=br.readLine();
                    nombreProfesor=br.readLine();
                    horaClase=Integer.parseInt(br.readLine());
                    diaClase=br.readLine();
                    if(id >= res.size()){
			for(int i=res.size();i<=id;i++){
			    res.add(null);
			}                   
                    }
		    Clases nwClase= new Clases(nombreClase,nombreProfesor,horaClase,diaClase,id); 
		    res.set(id,nwClase);
               
                    
		}
	    }
	}
	catch(Exception e){
	    e.printStackTrace();
	}finally{

	    try{                    
		if( null != fr ){   
                    fr.close();     
		}                  
	    }catch (Exception e2){ 
		e2.printStackTrace();
	    }
	}
            
	return res;
            
    }
         
         
      /**
     *clase que Lee el fichero para actualizar datos de las clases que toma cada cliente, si no hay fichero, lo crea. 
     * @return El arreglo con los objetos tomados del fichero.txt
     */         
    public static void leerFicheroCImpartidas(String fileName) throws IOException{
	
	String ruta = fileName;
	File archivo = new File(ruta);
	FileReader fr = new FileReader (archivo);
	BufferedReader br;
           
	try {
	    // Apertura del fichero y creacion de BufferedReader para poder
	    // hacer una lectura comoda (disponer del metodo readLine()).
        
            br = new BufferedReader(fr);
            String linea;
            int id=0;
            String readCl="";
            while((linea=br.readLine()) !=null){
                
                if(! linea.equals("#")){
                   id=Integer.parseInt(linea);
                   Cliente cliente=Hercules.lista.get(id);
                   while(!(readCl=br.readLine()).equals("#")){
                       cliente.getClasesTomadas().add(Integer.parseInt(readCl));
                   }
                                   
		}
	    }
	}
	catch(Exception e){
	    e.printStackTrace();
	}finally{

	    try{                    
		if( null != fr ){   
                    fr.close();     
		}                  
	    }catch (Exception e2){ 
		e2.printStackTrace();
	    }
	}
            
	
            
    }   
         
         
    /**
     * Metodo que actualza(reescribe) el archivo ClasesImpartidas.txt
     * @param c lista de los clientes
     */ 
    public static void actualizaCImpartidas(ArrayList<Cliente> c){
	try{
	    File archivo = new File("ClasesImpartidas.txt");
	    FileWriter fw=new FileWriter(archivo);
	    BufferedWriter bw=new BufferedWriter(fw);
	    String dat="";
                
	    for(Cliente k: c){ //bw.write();
		if(k!=null){
                    if(k.getClasesTomadas().size()!=0){
                        bw.write("#");
                        bw.write("\n"+k.getId());
                        for(int i:k.getClasesTomadas())
                            bw.write("\n"+i);
                            
                        bw.write("\n#\n");
                    }
		}
	    }
	    bw.close();
                
	}catch(Exception e){
	    System.err.printf("Error", e);
	}
            
    }       
         
         
         
         
    /**
     * Metodo que actualza(reescribe) el archivo Cliete.txt
     * @param c lista de los clientes
     */ 
    public static void actualizaTxt(ArrayList<Cliente> c){
	try{
	    File archivo = new File("Cliente.txt");
	    FileWriter fw=new FileWriter(archivo);
	    BufferedWriter bw=new BufferedWriter(fw);
	    String dat="";
                
	    for(Cliente k: c){ //bw.write();
		if(k!=null){
                    bw.write("#\n");
                    dat=k.getId()+"\n"+k.getNombreCompleto() +"\n"+k.getDireccion()+"\n"+k.getTelefono();
                    bw.write(dat);
                    bw.write("\n#\n");
		}
	    }
	    bw.close();
                
	}catch(Exception e){
	    System.err.printf("Error", e);
	}
            
    }       
        
    /**
     * Metodo que actualza(reescribe) el archivo Clases.txt
     * @param c lista de los clases
     */ 
    public static void actualizaTxtC(ArrayList<Clases> c){
	try{
	    File archivo = new File("Clases.txt");
	    FileWriter fw=new FileWriter(archivo);
	    BufferedWriter bw=new BufferedWriter(fw);
	    String dat="";
                
	    for(Clases k: c){ //bw.write();
		if(k!=null){
                    bw.write("#\n");
                    dat=k.getId()+"\n"+k.getNombreClase() +"\n"+k.getNombreProfesor()+"\n"+k.getHoraClase()+"\n"+k.getDiaClase();
                    bw.write(dat);
                    bw.write("\n#\n");
		}
	    }
	    bw.close();
                
	}catch(Exception e){
	    System.err.printf("Error", e);
	}
            
    }
         
       /**
        * Menu principal del Gym
        */  
    public void menu(){
	
	Hercules h=null;
	try{
	    h=new Hercules(leerFichero("Cliente.txt"),leerFicheroC("Clases.txt") );
            leerFicheroCImpartidas("ClasesImpartidas.txt");
	}catch(Exception e){
	    System.out.println("No lo hizo  :( ");
	}
        Scanner sc = new Scanner(System.in);
        int option=0;
        int option1=0;
        int option2=0;
        String nombreCompleto="";
        String direccion="";
        int telefono=0;
        String nombreClase = "";
        String nombreProfesor = "";
        int horaClase = 0;
	String diaClase = "";
		
        System.out.println("Bienvenido Administrador");
       try{
	do{
             
            
	    System.out.println("1)Cliente"+"\n2)Clases"+"\n3)Inscribir cliente a clase"+"\n4)salir");
	    //System.out.println("2)Clases");
            
            option1= sc.nextInt();
            switch(option1){
	    case 1:
              
		do {
		    System.out.println("1.-Crear Cliente");
		    System.out.println("2.- Ver Clientes");
		    System.out.println("3.- Buscar Cliente");
		    System.out.println("4.- Eliminar Cliente");
		    System.out.println("5.- Editar Cliente");
		    System.out.println("6.- Salir");
		    option= sc.nextInt();
                
		    switch (option){ 
                  
		    case 1:
                     
			System.out.printf("Nombre: ");
			sc.nextLine();
			nombreCompleto = sc.nextLine();
			System.out.printf("Direccion: ");
			direccion=sc.nextLine();
			try {
			    System.out.printf("Telefono: ");
			    telefono=Integer.parseInt(sc.nextLine());
			} catch (InputMismatchException ime) {
			    System.out.println("\nNúmero inválido: se descartará ");
			}
			Cliente c1= new Cliente(nombreCompleto,direccion,telefono); 
			h.crearCliente(c1);
			actualizaTxt(Hercules.lista);
			break;
		    case 2:
			h.imprimirClientes();
			break;
		    case 3:
			String nombre;
			System.out.println("¿A que cliente estas buscando?");
			sc.nextLine();
			nombre=sc.nextLine();
			h.buscarCliente(nombre);
			break;
   
		    case 4:     
			h.imprimirClientes();
			System.out.println("Escribe el Id del cliente que quieres elminiar");
			int i=sc.nextInt();
			h.eliminarCliente(i);
			actualizaTxt(Hercules.lista);
			System.out.println("El cliente ha sido eliminado");
                
			break;
		    case 5:
			System.out.println("¿A quien quieres editar? ");
         
			h.imprimirClientes();
			System.out.println("Escribe el ID:  ");          
			int index=sc.nextInt();
          
			System.out.println("Que quieres editar");
			System.out.println("1)Nombre");
			System.out.println("2)Direccion");
			System.out.println("3)Telefono");
			int edit = sc.nextInt();
			switch(edit){
			case 1:
			    System.out.println("Ingresa el nuevo Nombre:");
			    sc.nextLine();       
			    String nombre1=sc.nextLine();
			    h.modificarNombreCompleto(index,nombre1, nombreCompleto);
			    System.out.println("Modificado");        
			    break;
			case 2:
			    System.out.println("Ingresa la nueva Direccion");
			    sc.nextLine();   
			    String direccion1=sc.nextLine();
			    h.modificarDireccion(index,direccion1, nombreCompleto);
			    System.out.println("Modificado");    
			    break;
			case 3:
                            
			    System.out.println("Ingresa el  nuevo Telefono");
                            int telefono1=0;
                            try{
			    sc.nextLine(); 
                             telefono1=Integer.parseInt(sc.nextLine());
                              } catch(InputMismatchException ime) {
			    System.out.println("\nNúmero inválido: se descartará ");
			} 
			    h.modificarTelefono(index,telefono1, nombreCompleto);
			    System.out.println("Modificado");
			    break;
                
			}                 
               
			break;
		    case 6:
			actualizaTxt(Hercules.lista);
                        actualizaCImpartidas(Hercules.lista);
			System.out.println("Nos Vemos!!!");
			break;
		    }  
		}while (option != 6);
		break;
	    case 2:
		
		do{
		    System.out.println("1.-Crear Clase");
		    System.out.println("2.- Ver Clases");
		    System.out.println("3.- Eliminar Clase");
		    System.out.println("4.- Buscar Clase Impartida");
		    System.out.println("5.- Editar Clase Impartida");
               
		    System.out.println("6.- Salir");
		    option2= sc.nextInt();
               
		    switch(option2){
                 
		    case 1:
			System.out.printf("Nombre de la Clase: ");
			sc.nextLine();
			nombreClase = sc.nextLine();
			System.out.printf("Profesor: ");
			nombreProfesor=sc.nextLine(); 
			System.out.printf("Hora: ");
			horaClase=sc.nextInt(); 
                        System.out.printf("Dia: ");
                        sc.nextLine();
                        diaClase=sc.nextLine(); 
			Clases cl= new Clases(nombreClase,nombreProfesor,horaClase,diaClase);
			h.crearClase(cl);
			h.imprimirClase();
                        actualizaTxtC(Hercules.listac);
                        actualizaCImpartidas(Hercules.lista);
			break;
		    case 2:
                        h.imprimirClase();
			break;
		    case 3:
			h.imprimirClase();
			System.out.println("Escribe el Id del clase que quieres elminiar");
			int i=sc.nextInt();
			h.eliminarClase(i);
                        h.ElimClaseTomadasCl(i);
			actualizaTxtC(Hercules.listac);                        
			System.out.println("La clase ha sido eliminado");
                        actualizaTxtC(Hercules.listac);
                        actualizaCImpartidas(Hercules.lista);
			break;
		    case 4: 
			String nombre;
			System.out.println("¿Qué clase estas buscando?");
			sc.nextLine();
			nombre=sc.nextLine();
			h.buscarClase(nombre);
			break;
                       
		    case 5:
                        System.out.println("¿A quien quieres editar? ");
         
			h.imprimirClase();
			System.out.println("Escribe el ID:  ");          
			int index=sc.nextInt();
        		System.out.println("Que quieres editar");
			System.out.println("1)Nombre Clase");
                        System.out.println("2)Nombre Profesor");
			System.out.println("3)Hora Clase");
			System.out.println("4)Dia Clase");
			int edit = sc.nextInt();
			switch(edit){
			case 1:
			    System.out.println("Ingresa el nuevo Nombre:");
			    sc.nextLine();       
			    String nombre1=sc.nextLine();
			    h.modificarNombreClase(index,nombre1, nombreClase);
			    System.out.println("Modificado");        
			  break;
                        case 2:
                            System.out.println("Ingresa el nuevo Nombre del profesor:");
			    sc.nextLine();       
			    String nombreprof1=sc.nextLine();
			    h.modificarNombreProfesor(index,nombreprof1, nombreProfesor);
			    System.out.println("Modificado");     
                            break;
                        case 3:
                              System.out.println("Ingresa el  nuevo Horario:");
                            int horaclase1=0;
                            try{
			    sc.nextLine(); 
                            horaclase1=Integer.parseInt(sc.nextLine());
                              } catch(InputMismatchException ime) {
			    System.out.println("\nNúmero inválido: se descartará ");
			}
                            h.modificarHoraClase(index,horaclase1, horaClase);
			    System.out.println("Modificado");
                            break;
                        case 4:
                             System.out.println("Ingresa el nuevo dia:");
			    sc.nextLine();       
			    String dia1=sc.nextLine();
			    h.modificarDiaClase(index,dia1, diaClase);
			    System.out.println("Modificado");     
                          
                
			}
                        actualizaTxtC(Hercules.listac);
                        actualizaCImpartidas(Hercules.lista);
			break;
                    case 6:
                        System.out.println("Saliendo..."); 
			break;

		    }

		}while(option2 !=6);

		break;
            case 3://inscribir clases
                System.out.println("1)Inscribir a Clase\n2)Ver lista de inscritos\n3)Salir");
                //clasesImpartidas(sc.nextInt(),h);
                int answer=sc.nextInt();
                    
                    switch(answer){
                        case 1:
                            int id=0;
                            h.imprimirClientes();
                            System.out.println("Escribe el Id del cliente a inscribir");
                            id=sc.nextInt();
                            h.imprimirClase();
                            Cliente cl=Hercules.lista.get(id);
                            System.out.println("Escribe el Id de la clase a donde se inscribira "+cl.getNombreCompleto());
                            int clas=sc.nextInt();
                            Clases nwCl=Hercules.listac.get(clas);
                            cl.getClasesTomadas().add(nwCl.getId());

                            System.out.println("Se inscribira a "+cl.getNombreCompleto()
                                    +" al curso: "+ nwCl.getNombreClase());
                            actualizaCImpartidas(Hercules.lista);

                            break;
                        case 2:
                               h.imprimirListaInscripcion();
                            break;
                        case 3:
                            System.out.println("Saliendo");
                            break;
                    }
                
                    
                break;
            case 4:
                actualizaTxt(Hercules.lista);
                actualizaTxtC(Hercules.listac);
                actualizaCImpartidas(Hercules.lista);
                System.out.println("Nos vemos!! :D ");
                break;
            }
        }while(option1!=4);
        
               }catch(InputMismatchException n){
        System.out.println("Solo numeros , vuelve a ejecutar");
        }
        
        

    }
        
    
    
}
         
         

    

         
         
         
         
         
         
         
         
         
       
         
