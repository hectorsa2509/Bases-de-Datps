
package hercules;

/**
 *
 * @author Héctor Santaella , Luis Gerardo Bernabe
 */
import java.util.ArrayList;

public class Cliente {
    String nombreCompleto;
    String direccion;
    int telefono;
    int id;
    public ArrayList<Integer> clasesTomadas=new ArrayList<Integer>();
    
/**
 * Constructor inicializado con los atributos de la clase con excepcion de id
     * @param nombreCompleto
     * @param direccion
     * @param telefono
 */
    public Cliente(String nombreCompleto,String direccion , int telefono){
        this.nombreCompleto=nombreCompleto;
        this.direccion=direccion;
        this.telefono=telefono;
        
    
    }
    /**
 * Constructor inicializado con los atributos de la clase
 */
    public Cliente(String nombreCompleto,String direccion , int telefono, int nwid){
        this.nombreCompleto=nombreCompleto;
        this.direccion=direccion;
        this.telefono=telefono;
        this.id=nwid;
        
    }
    
    /**Nos da el nombre completo del Cliente
     * @return el nombre del Cliente
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    /** Pone el Nombre Completo del Cliente.
    @param nombreCompleto
    */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
     /**Nos da la dirección  del Cliente
     * @return la dirección del Cliente
     */
    public String getDireccion() {
        return direccion;
    }
    /** Pone la direccion del Cliente.
    @param direccion 
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**Nos da el telefono del Cliente
     * @return el telefono del Cliente
     */
    public int getTelefono() {
        return telefono;
    }
    
    /** Pone el telefono del Cliente.
    @param telefono
    */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public void setId(int nwId){
    id=nwId;
    }
    
    public int getId(){
       return id;
    }
    /*
    *Método toString
    */
    @Override
    public String toString() {
      
            String temp= "Nombre:"+ getNombreCompleto()+"\nId:"+getId()
                    +"\n\tDireccion: "+ getDireccion()+"\n\tTelefono: "+ getTelefono();     
   return temp; 
    }
    /** Pone una lista con clases tomadas
     * @param nwClasesTomadas   
    */
    public void setClasesTomadas(ArrayList<Integer> nwClasesTomadas){
        clasesTomadas=nwClasesTomadas;
    }
     /**Nos las clase tomadas
     * @return clasesTomadas
     */
    public ArrayList<Integer> getClasesTomadas(){
    return clasesTomadas;
    }
}
