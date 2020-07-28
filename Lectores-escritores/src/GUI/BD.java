package GUI;
import javax.swing.JLabel;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BD {
    private int NLectores=0;
    private boolean HayEscritor=false;
    private int NEscritor=0;
    private JPanel panel;
    private JTextArea detalles;
    private JTextArea sala_espera;
    private JLabel total_lectores;
    private JLabel total_escritores;
    
    public BD (JPanel jp, JTextArea se, JTextArea d) {
    	this.panel=jp;
    	this.sala_espera=se;
    	this.detalles=d;
    }
    
    public synchronized void openL(int id)throws InterruptedException
    {
        while(HayEscritor || NEscritor>0)
        {
            sala_espera.append("Lector "+(id+1)+" está esperando"+"\n");
            wait();
        }
        sala_espera.append("Lector "+(id+1)+" ingresó a la base de datos"+"\n");
        NLectores++;
        Imagen_lector Imagen = new Imagen_lector();
		panel.add(Imagen);
		panel.repaint();
		detalles.append("Lector "+(id+1)+" está leyendo"+"\n");
        System.out.println("Lector "+(id+1)+" está leyendo");
    }
    public synchronized void closeL(int id)
    {
    	panel.remove(0);
		panel.repaint();
    	detalles.append("Lector "+(id+1)+" terminó de leer"+"\n");
    	System.out.println("Lector "+(id+1)+" terminó de leer");
        NLectores--;
        if(NLectores==0)notifyAll(); //despertar un al escritor q esta esperando
    }
    public synchronized void openE(int id) throws InterruptedException
    {
        NEscritor++;
        while(HayEscritor || NLectores>0)
        {
            sala_espera.append("Escritor "+(id+1)+" esta esperando"+"\n");
        	wait();
        }
        sala_espera.append("Escritor "+(id+1)+" ingresó a la base de datos"+"\n");
        HayEscritor=true;
        Imagen_escritor Imagen = new Imagen_escritor();
		panel.add(Imagen);
		panel.repaint();
		detalles.append("Escritor "+(id+1)+" empezó a escribir"+"\n");
        System.out.println("Escritor "+(id+1)+" empezó a escribir");
    }
    public synchronized void closeE(int id)
    {
    	NEscritor--;
    	panel.remove(0);
		panel.repaint();
		detalles.append("Escritor "+(id+1)+" terminó de escribir"+"\n");
    	System.out.println("Escritor "+(id+1)+" terminó de escribir");
        HayEscritor=false;
        notifyAll();
    }
}
