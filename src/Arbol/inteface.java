package Arbol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Button;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class inteface implements ActionListener{
	String resp1=null;
	String resp2=null;
	private Logica Arbol;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField Mostrador;
	private JButton BotonSi,BotonNO,BotonJugar,btnNewButton_1; 
	private JTextField Respuesta;
	private JButton AceptarResp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inteface window = new inteface();
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
	public inteface() {
		initialize();}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 563, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BotonJugar = new JButton("Jugar");
		BotonJugar.setForeground(Color.RED);
		BotonJugar.addActionListener(this);
		BotonJugar.setActionCommand("Jugar");
		
		JButton btnNewButton_1 = new JButton("Salir");
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField.setToolTipText("");
		textField.setEditable(false);
		textField.setEnabled(false);

		textField.setColumns(10);
		textField.setText("Tamaño del Arbol=0");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_1.setColumns(10);
		textField_1.setText("Cant. de Obj. Almacenados=0");
		textField_1.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setText("Cant. de Preg. Almacendas=0");
		
		Mostrador = new JTextField();
		Mostrador.setEnabled(false);
		Mostrador.setColumns(10);
		
		BotonSi = new JButton("Si");
		BotonSi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		BotonSi.addActionListener(this);
		BotonSi.setActionCommand("Si");
		BotonSi.setEnabled(false);
		
		BotonNO = new JButton("No\n");
		BotonNO.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		BotonNO.addActionListener(this);
		BotonNO.setActionCommand("No");
		BotonNO.setEnabled(false);
		
		Respuesta = new JTextField();
		Respuesta.setEnabled(false);
		Respuesta.setColumns(10);
		
		AceptarResp = new JButton("Aceptar ");
		AceptarResp.setEnabled(false);
		AceptarResp.addActionListener(this);
		AceptarResp.setActionCommand("Aceptar");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addComponent(btnNewButton_1)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Respuesta, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))))
					.addGap(63))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
					.addGap(395))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(497, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(440, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(AceptarResp)
					.addGap(217))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(Respuesta, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(AceptarResp)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void actionPerformed(ActionEvent e){
		String evento=e.getActionCommand();
		if(evento.equals("Jugar")){
			 Arbol=new Logica(); 
			 textField.setEnabled(true);
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				Mostrador.setEnabled(true);
				Mostrador.setText("¿Estas Pensando en "+Arbol.getElement()+" ?");
				BotonSi.setEnabled(true);
				BotonNO.setEnabled(true);}
		 if(evento.equals("No")){
			if(!Arbol.Perdio())Arbol.No();
			else{ 
		       Mostrador.setText("En que pensaba");
				Respuesta.setEnabled(true);
				AceptarResp.setEnabled(true);}
		if(evento.equals("Acpetar")){
			if(resp1==null){resp1=Respuesta.getText(); 
			AceptarResp.setEnabled(false);
			Mostrador.setText("Que Diferencia tiene "+Arbol.getElement()+"Con lo que pensabas");
			AceptarResp.setEnabled(true);}
			else {resp2=Respuesta.getText(); 
				  Arbol.Agregar(resp1,resp2);
				  resp1=null;
				  resp2=null;}
			}	
		 }
	
	}
}
