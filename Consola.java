package Basico_consola;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
public class Consola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BD base_de_datos =new BD();
        Escritor[] esc=new Escritor[3];
        Lector[] lector=new Lector[10];
                
		for(int i=0;i<esc.length;i++)
		{
			esc[i]=new Escritor(base_de_datos,i);
		}
		for(int i=0;i<lector.length;i++)
		{
			lector[i]=new Lector(base_de_datos,i);
		}
		for(int i=0;i<esc.length;i++)
		{
			esc[i].start();
		}
		for(int i=0;i<lector.length;i++)
		{
			lector[i].start();
		}
	}
}
