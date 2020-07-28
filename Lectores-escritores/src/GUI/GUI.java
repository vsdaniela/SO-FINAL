package GUI;
//Proyecto hecho por Daniela Vilchez y Daniel Mendiguri
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GUI {

	private JFrame frame;
	private JTextField n_escritores;
	private JTextField n_lectores;
	int nl=0;
	int ne=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1513, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 213, 482);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Problema Lectores-Escritores");
		lblNewLabel.setBounds(12, 13, 189, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de escritores");
		lblNewLabel_1.setBounds(34, 70, 139, 16);
		panel.add(lblNewLabel_1);
		
		n_escritores = new JTextField();
		n_escritores.setBounds(34, 99, 116, 22);
		panel.add(n_escritores);
		n_escritores.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de lectores");
		lblNewLabel_2.setBounds(41, 166, 116, 16);
		panel.add(lblNewLabel_2);
		
		n_lectores = new JTextField();
		n_lectores.setBounds(41, 212, 116, 22);
		panel.add(n_lectores);
		n_lectores.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(53, 286, 97, 25);
		panel.add(btnIniciar);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.setBounds(53, 383, 97, 25);
		panel.add(btnDetener);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(548, 117, 551, 291);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sala de espera");
		lblNewLabel_3.setBounds(292, 88, 93, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Base de datos");
		lblNewLabel_4.setBounds(781, 88, 86, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Detalles");
		lblNewLabel_5.setBounds(1271, 88, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 117, 277, 306);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textAreaEspera = new JTextArea();
		scrollPane.setViewportView(textAreaEspera);
		textAreaEspera.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1157, 113, 299, 295);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textAreaDetalles = new JTextArea();
		scrollPane_1.setViewportView(textAreaDetalles);
		textAreaDetalles.setEditable(false);
		
		BD base_de_datos = new BD(panel_1,textAreaEspera,textAreaDetalles);
		
	    Escritor[] esc=new Escritor[100];
	    Lector[] lector=new Lector[100];
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nl=Integer.parseInt(n_lectores.getText());
				ne=Integer.parseInt(n_escritores.getText());
				for(int i=0;i<ne;i++)
				{
					esc[i]=new Escritor(base_de_datos,i);
				}
				for(int i=0;i<nl;i++)
				{
					lector[i]=new Lector(base_de_datos,i);
				}
				for(int i=0;i<ne;i++)
				{
					esc[i].start();
				}
				for(int i=0;i<nl;i++)
				{
					lector[i].start();
				}
			}
		});
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<ne;i++)
				{
					esc[i].stop();
				}
				for(int i=0;i<nl;i++)
				{
					lector[i].stop();
				}
			}
		});
	}
}
