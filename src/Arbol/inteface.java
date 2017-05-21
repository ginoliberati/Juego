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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;

public class inteface implements ActionListener{
	private String resp1=null;
	private String resp2=null;
	private Logica Arbol;
	private JFrame Ventanita;
	private JFrame frmAdivinador;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField Mostrador;
	private JButton BotonSi,BotonNO,BotonJugar,btnNewButton_1; 
	private JFrame Ventani;
	private JTextField Aparicion;
	private JTextField Resp1;
	private JTextField Resp2;
	private JTextField Aparicion2;
	private JButton Aceptar1;
	private JButton Aceptar2;
	private JButton ArbolA;
	private JButton Salir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inteface window = new inteface();
					window.frmAdivinador.setVisible(true);
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
		frmAdivinador = new JFrame();
		frmAdivinador.setForeground(Color.BLUE);
		frmAdivinador.setTitle("Adivinador");
		frmAdivinador.getContentPane().setForeground(Color.BLUE);
		frmAdivinador.setBounds(100, 100, 563, 603);
		frmAdivinador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BotonJugar = new JButton("Jugar");
		BotonJugar.setForeground(Color.RED);
		BotonJugar.addActionListener(this);
		BotonJugar.setActionCommand("Jugar");
		
		Salir = new JButton("Salir");
		Salir.setEnabled(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField.setToolTipText("");
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setVisible(false);

		textField.setColumns(10);
		textField.setText("Tamaño del Arbol=0");
		textField.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_1.setColumns(10);
		textField_1.setText("Cant. de Obj. Almacenados=0");
		textField_1.setEnabled(false);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setText("Cant. de Preg. Almacendas=0");
		textField_2.setVisible(false);
		
		Mostrador = new JTextField();
		Mostrador.setEnabled(false);
		Mostrador.setColumns(10);
		Mostrador.setVisible(false);
		
		BotonSi = new JButton("Si");
		BotonSi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		BotonSi.addActionListener(this);
		BotonSi.setActionCommand("Si");
		BotonSi.setEnabled(false);
		BotonSi.setVisible(false);
		
		BotonNO = new JButton("No\n");
		BotonNO.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		BotonNO.addActionListener(this);
		BotonNO.setActionCommand("No");
		BotonNO.setEnabled(false);
		BotonNO.setVisible(false);
		
		ArbolA = new JButton("Arbol Almacenado");
		ArbolA.setEnabled(false);
		ArbolA.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(frmAdivinador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addComponent(Salir)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
					.addGap(395))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addGap(63))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(ArbolA)
					.addGap(187))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Salir)
						.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addComponent(ArbolA)
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		frmAdivinador.getContentPane().setLayout(groupLayout);
		
		Ventani = new JFrame();
		Ventani.setBounds(100, 100, 450, 300);
		Ventani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventani.setEnabled(true);
		Ventani.setVisible(false);
		
		Aparicion = new JTextField();
		Aparicion.setText("¿En que pensabas?\n");
		Aparicion.setEditable(false);
		Aparicion.setColumns(10);
		
		Resp1 = new JTextField();
		Resp1.setColumns(10);
		
		Resp2 = new JTextField();
		Resp2.setText("¿Qué diferencia tiene con?");
		Resp2.setEditable(false);
		Resp2.setColumns(10);
		
		Aparicion2 = new JTextField();
		Aparicion2.setColumns(10);
		
		Aceptar1 = new JButton("Aceptar\n");
		Aceptar1.addActionListener(this);
		Aceptar1.setVisible(false);
		
		Aceptar2 = new JButton("Aceptar\n");
		Aceptar2.addActionListener(this);
		
		GroupLayout groupLayou = new GroupLayout(Ventani.getContentPane());
		groupLayou.setHorizontalGroup(
			groupLayou.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayou.createSequentialGroup()
					.addGroup(groupLayou.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayou.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayou.createParallelGroup(Alignment.LEADING)
								.addComponent(Resp1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addComponent(Aparicion, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addComponent(Resp2, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
								.addComponent(Aparicion2, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayou.createSequentialGroup()
							.addGap(167)
							.addComponent(Aceptar1))
						.addGroup(groupLayou.createSequentialGroup()
							.addGap(171)
							.addComponent(Aceptar2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayou.setVerticalGroup(
			groupLayou.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayou.createSequentialGroup()
					.addGap(36)
					.addComponent(Aparicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Resp1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Aceptar1)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(Resp2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Aparicion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Aceptar2)
					.addGap(17))
		);
		Ventani.getContentPane().setLayout(groupLayou);

	}
	public void actionPerformed(ActionEvent e){
		String evento=e.getActionCommand();
		if(e.getSource()==BotonJugar){
			 Arbol=new Logica(); 
			 textField.setEnabled(true);
			 textField.setVisible(true);
				textField_1.setEnabled(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				Mostrador.setVisible(true);
				Mostrador.setText(Arbol.getPregunta());
				BotonSi.setVisible(true);
				BotonNO.setVisible(true);
				ArbolA.setVisible(true);
				Salir.setVisible(true);
				BotonJugar.setEnabled(false);
				textField_2.setEnabled(true);
				Mostrador.setEnabled(true);
				BotonSi.setEnabled(true);
				BotonNO.setEnabled(true);
				ArbolA.setEnabled(true);
				Salir.setEnabled(true);
				Mostrador.setVisible(true);
				Actualizar();}
		
		 if(e.getSource()==BotonNO){
			if(!Arbol.Perdio()){Arbol.No();Mostrador.setText(Arbol.getPregunta());}
			else{Resp2.setText("¿Qué diferencia tiene con "+Arbol.getElement()+"?"); 
				 Ventani.setVisible(true);}
			}
		
		 if(e.getSource()==Aceptar2){
			resp2=Aparicion2.getText(); 
			resp1=Resp1.getText();
			Ventani.dispose();
			Arbol.Agregar(resp1, resp2);
			Arbol.reset();
			Aparicion2.setText("");
			Resp1.setText("");
			Mostrador.setText(Arbol.getPregunta());
			Actualizar();
			}
			
		if(e.getSource()==BotonSi){
			Arbol.Si();
			if(Arbol.Gano()){Mostrador.setText("Siempre Adivino :-)");
				textField.setVisible(true);
				textField_1.setEnabled(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				Mostrador.setVisible(true);
				BotonSi.setVisible(false);
				BotonNO.setVisible(false);
				ArbolA.setVisible(false);
				BotonJugar.setEnabled(true);
				Actualizar();
				}
			 else Mostrador.setText(Arbol.getPregunta());}
		
		if(e.getSource()==Salir){Arbol.Guardar();
								 System.exit(0);}
		
		
		
		 }
		private void Actualizar(){
			textField_2.setText("Cant. de Preg. Almacendas="+Arbol.cantPreguntas());
			textField.setText("Tamaño del Arbol=");
			textField_1.setText("Cant. de Obj. Almacenados="+Arbol.cantObjetos());
		}
	}

