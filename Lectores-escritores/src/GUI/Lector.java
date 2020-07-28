package GUI;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import java.util.*;

public class Lector extends Thread{ //hilo extends thread

    private static Random r=new Random();
    private BD base_de_datos;
    private int id;//cada  lector tendra un id
 
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
            	Thread.sleep((int)(Math.random() * 9999));
            	base_de_datos.openL(id);
	            //leyendo BD
	            Thread.sleep(r.nextInt(9000));
	            base_de_datos.closeL(id);
	            Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
            
        }
    }   
}
