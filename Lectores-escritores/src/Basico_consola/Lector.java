package Basico_consola;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import java.util.*;

public class Lector extends Thread{

    private static Random r=new Random();
    private BD base_de_datos;
    private int id;//el id del lector
 
    public Lector(BD gestor, int id)
    {
        this.base_de_datos=gestor;
        this.id=id;
    }
    public void run()
    {
        while(true)
        {
            try {
	        	base_de_datos.openL(id);
	            //leyendo BD
	            Thread.sleep(r.nextInt(300));
	            base_de_datos.closeL(id);
	            Thread.sleep(r.nextInt(300));
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
            
        }
    }   
}
