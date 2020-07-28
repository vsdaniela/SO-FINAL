package GUI;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import java.util.*;

public class Escritor extends Thread {
     private static Random r=new Random();
     private BD base_de_datos;
     private int id; //el id del escritor
     public Escritor(BD bd, int id)
    {
        this.base_de_datos=bd;
        this.id=id;
    }
    public void run()
    {
        while(true)
        {
            try {
            	base_de_datos.openE(id);
                //escribir en BD
                Thread.sleep(r.nextInt(2000));
                base_de_datos.closeE(id);
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
            
        }
    }
}
