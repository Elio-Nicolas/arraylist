

import java.time.LocalDate;
import java.util.Scanner;
import  java.util.ArrayList ;
import  java.util.Iterator ;

public class TestTask {
    
    public static void main(String[] args){
        
        Scanner sc= new Scanner(System.in);

       ArrayList<Task> ListaTarea = new ArrayList<Task>(); // definicion de lista
       int opcion,tar,num,elimina;
       int year=0;
       int mes=1;
       int dia=1;
       int prioridad,marca=0;
       String descripcion,opc;
       Boolean estado;
       
       
       Iterator<Task> Ite = ListaTarea.iterator();// definicion de iterador para 
                                                  // trabajar con la lista
        
       do{
           System.out.println("        MENU       ");
           System.out.println(" 0- salir          ");
           System.out.println(" 1- Agregar tarea  ");
           System.out.println(" 2- mostrar tarea ");
           System.out.println(" 3- Marcar tarea   ");
           System.out.println(" 4- Eliminar tarea  ");
           opcion=sc.nextInt();
             
           
           switch(opcion){
               
               // caso 1 ingreso de datos
               
               case 1: 
                   
                   do{
                   
                  System.out.println(" Ingrese Descripcion ");
                  descripcion=sc.next();
                  do{
                  System.out.println(" Ingrese Estado  'true' or 'false' ");
                  estado=sc.nextBoolean(); 
                  }while( estado!= true && estado != false );
                  
                  System.out.println(" Ingrese numero de tarea");
                  num=sc.nextInt();
                  
                  do{
                  System.out.println(" Ingrese prioridad 'prioridad de 1 a 5 ");
                  prioridad=sc.nextInt();
                  }while(prioridad<=1 && prioridad >=5);
                  
                  // utilizacion de bloque try para excepciones
                  
                try{
                  System.out.println(" Ingrese fecha de vencimiento  aaaa/mm/dd");
                  String a??o=sc.next();
                  String Date[]=a??o.split("/");
                  year=Integer.valueOf(Date[0]);
                  mes=Integer.valueOf(Date[1]);
                  dia=Integer.valueOf(Date[2]);
                
                }catch(RuntimeException e){  // utilizacion de bloque catch para agarrar el error y continuar
                    
                    System.out.println(" No ingreso fecha correctamente");
                    System.out.println(" error : "+e);
                  //  year=0;
                  //  mes=1;     //asigno valores para poder pasar los argumentos al constructor
                  //  dia=1;     // puedo elegir los que crea conveniente por defecto
                }
                  LocalDate fecha=LocalDate.of( year,mes, dia);
                  Task Tarea= new Task(descripcion,estado,num,prioridad,fecha);
                 
                  ListaTarea.add(Tarea);
                  
                  System.out.println(" desea seguir ingresando 'si' o 'no' ");
                  opc=sc.next();
                  
                   }while( !opc.equals("no"));
               break;
                
               case 2:
                   
                   if(!ListaTarea.isEmpty()){   // compruebo si la lista esta vacia con el metodo empty
                   
                    Ite = ListaTarea.iterator();  // asigno una variable de tipo iterator
                       
                       while(Ite.hasNext()){    // while para recorrer la lista
                           
	               Task elemento = Ite.next(); // asigno el objeto al que apunta el iterator a un objeto de tipo Task
                       
                       System.out.println("tarea : "+elemento.getnumero_tarea());
	               System.out.println("Descripcion :"+elemento.getdescripcion());
                       System.out.println("Estado :"+elemento.getestado());
                       System.out.println("Prioridad :"+elemento.getprioridad());
                       System.out.println("Fecha :"+elemento.getfecha());
                      
                       }
                       
                   }else System.out.println(" Lista de tareas vacia");
                       
                break; 
                
               case 3:
                   
                   if(!ListaTarea.isEmpty()){
                      
                      Ite = ListaTarea.iterator(); 
                
                     while(Ite.hasNext()){
                         
                       Task  elemento=Ite.next();
                    
                           System.out.println("tarea :"+elemento.getnumero_tarea());
                           System.out.println(" prioridad :"+elemento.getprioridad());
                       }
                    
                   
                   
                   System.out.println("Ingrese numero de tarea que desea marcar");
                   tar= sc.nextInt();            
                   Ite = ListaTarea.iterator();
                    
                    while(Ite.hasNext() ){
                             
                        Task  elemento=Ite.next();
                        
                        if( tar==elemento.getnumero_tarea()){
                            
                            System.out.println(" Ingrese nueva prioridad");
                            prioridad= sc.nextInt();
                            elemento.setprioridad(prioridad);
                            marca=1;
                        }  
                      
                    }
                         
                     if(marca == 1)System.out.println(" Prioridad modificada");
                     
                   }else System.out.println(" Lista de tareas vacia");
                   
               break;
               
               case 4:
                   
                   if( !ListaTarea.isEmpty()){
                   
                   System.out.println(" Elija tarea que desea eliminar ");
                   Ite = ListaTarea.iterator();
                  
                  
                       while(Ite.hasNext()){
                           
                           Task  elemento =Ite.next();
                           
                             System.out.println("tarea :"+elemento.getnumero_tarea());
                          
                       }
                   
                    elimina= sc.nextInt();
                    Ite = ListaTarea.iterator();

                    while( Ite.hasNext() ){
                        
                        Task  elemento =Ite.next();
                        
                        if( elimina==elemento.getnumero_tarea()){
                                   
                           Ite.remove();
                            marca=1;
                        } 
                    }
                    
                    if(marca == 1){System.out.println(" Tarea eliminada");}
                    
                   }else System.out.println(" Lista de tareas vacia");
                   
                 break;
                 
                   }
               
               
       }while(opcion != 0);
    }
}
