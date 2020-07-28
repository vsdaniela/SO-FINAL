package GUI;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Imagen_lector extends javax.swing.JPanel {
	 
	/**
	 * 
	 */
	
	public Imagen_lector() {
		this.setSize(550, 500); //se selecciona el tamaño del panel
	}
	 
	//Se crea un método cuyo parámetro debe ser un objeto Graphics
	 
	public void paint(Graphics grafico) {
		Dimension height = getSize();
		 
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
		 
		ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/lector.png")); 
		 
		//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
		 
		//grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		grafico.drawImage(Img.getImage(), (int)(Math.random() * 500), (int)(Math.random() * 200), 30, 50, null);
		
		setOpaque(false);
		super.paintComponent(grafico);
	}
}