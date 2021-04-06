
 // clase Task donde estaran nuestros atributos y metodos
import java.time.*;

public class Task {
    
    private String descripcion=null;
    private Boolean estado=true;
    private int prioridad=0;
    private LocalDate fecha;
    private int Numero_Tarea;

     Task( String descripcion , Boolean estado,int numero,int prioridad,LocalDate fecha ){
        
       this.descripcion= descripcion;
       this.estado=estado;
       this.prioridad=prioridad;
       this.fecha=fecha;
       this.Numero_Tarea=numero;
    }
     
    Task( String descripcion , LocalDate fecha){
        
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.estado=false;
        this.Numero_Tarea=0;
        
    }

public int getnumero_tarea(){
    return Numero_Tarea;
}     
 
public void setnumerotarea(int Numero_Tarea){
    this.Numero_Tarea=Numero_Tarea;
}

public String getdescripcion (){
     return descripcion;
}

public void setdescripcion (String descripcion){
    this.descripcion = descripcion;
}     

public Boolean getestado (){
     return estado;
}

public void setestado (Boolean estado){
    this.estado = estado;
}   

public LocalDate getfecha (){
     return fecha;
}

public int getprioridad (){
     return prioridad;
}

public void setprioridad (int prioridad){
    this.prioridad = prioridad;
}   

}
