package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import TDAarbolBinario.*;
import  TDAListaDoble.*;
import TDAPilaEnlazada.*;
import TDAarbolBinario.BoundaryViolationException;
import TDAarbolBinario.EmptyTreeException;
import TDAarbolBinario.InvalidPositionException;
import TDAarbolBinario.Position;

import java.awt.EventQueue;
import java.awt.FlowLayout;

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
import javax.swing.border.EmptyBorder;

import GUI.Borrar.OyenteBoton;

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
	private JButton BotonSi,BotonNO,BotonJugar;
	private JFrame Ventani;
	private JTextField Aparicion;
	private JTextField Resp1;
	private JTextField Resp2;
	private JTextField Aparicion2;
	private JButton Aceptar1;
	private JButton Aceptar2;
	private JButton ArbolA;
	private JButton Salir;
	private JButton MostrarNodos;
	private MostrarArbol MA;
	private MostrarArbol DA;
	private JButton oraciones;
	private JButton Nodoborrar;
	private JButton reset;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtquDeseaNodo;
	public static String leyo;
	private JComboBox Combo;
	private JDialog borrador;
	private JButton okButton;
	private JButton cancelButton;
	/*
	 * 
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

	/*crea la aplicacion.*/
 	public inteface() {

		initialize();}

	/*
	 * Inicializa los botones y agrega las oyentes.
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
		
		Salir = new JButton("Guardar");
		Salir.setEnabled(true);
		Salir.addActionListener(this);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField.setToolTipText("");
		textField.setEditable(false);
		textField.setEnabled(true);
		textField.setVisible(false);

		textField.setColumns(10);
		textField.setText("Altura del Arbol=0");
		textField.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_1.setColumns(10);
		textField_1.setText("Cant. de Obj. Almacenados=0");
		textField_1.setEnabled(true);
		textField_1.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField_2.setEditable(false);
		textField_2.setEnabled(true);
		textField_2.setColumns(10);
		textField_2.setText("Cant. de Preg. Almacendas=0");
		textField_2.setVisible(false);
		
		Mostrador = new JTextField();
		Mostrador.setEnabled(true);
		Mostrador.setColumns(10);
		Mostrador.setVisible(false);
		
		BotonSi = new JButton("Si");
		BotonSi.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		BotonSi.addActionListener(this);
		BotonSi.setActionCommand("Si");
		BotonSi.setEnabled(true);
		BotonSi.setVisible(false);
		
		BotonNO = new JButton("No\n");
		BotonNO.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		BotonNO.addActionListener(this);
		BotonNO.setActionCommand("No");
		BotonNO.setEnabled(true);
		BotonNO.setVisible(false);
		
		ArbolA = new JButton("Arbol Almacenado");
		ArbolA.setEnabled(true);;
		ArbolA.addActionListener(this);
		ArbolA.setVisible(false);
		
		MostrarNodos = new JButton("Mostrar todos Nodos");
		MostrarNodos.setEnabled(true);
		MostrarNodos.setVisible(false);
		MostrarNodos.addActionListener(this);
		
		oraciones = new JButton("Oraciones");
		oraciones.setEnabled(true);
		oraciones.addActionListener(this);
		oraciones.setVisible(false);
		
		Nodoborrar = new JButton("Borrar Subarbol");
		Nodoborrar.setVisible(false);
		Nodoborrar.addActionListener(this);
		
		reset = new JButton("Reset");
		reset.setVisible(false);
		reset.addActionListener(this);;
		
		/*agrega los botones y textos al frame principal.*/
		
		GroupLayout groupLayout = new GroupLayout(frmAdivinador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
									.addGap(275))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(MostrarNodos)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
											.addGap(218)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(Nodoborrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(oraciones, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
									.addGap(17))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
								.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(213)
							.addComponent(ArbolA))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(reset)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(114)
							.addComponent(Salir)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Salir)
						.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(reset))
					.addGap(70)
					.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(ArbolA)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(MostrarNodos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(oraciones)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Nodoborrar)
							.addGap(17))))
		);
		frmAdivinador.getContentPane().setLayout(groupLayout);
		
	/*
	 * Nuevo frame para obtener datos.
	 */
		Ventani = new JFrame();
		Ventani.setBounds(100, 100, 450, 300);
		Ventani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ventani.setEnabled(true);
		Ventani.setVisible(false);
		
		Aparicion = new JTextField();
		Aparicion.setText("\u00bfEn qu\u00e9 pensabas?\n");
		Aparicion.setEditable(false);
		Aparicion.setColumns(10);
		
		Resp1 = new JTextField();
		Resp1.setColumns(10);
		
		Resp2 = new JTextField();
		Resp2.setText("\u00bfQu\u00e9 diferencia tiene con?");
		Resp2.setEditable(false);
		Resp2.setColumns(10);
		
		Aparicion2 = new JTextField();
		Aparicion2.setColumns(10);
		
		Aceptar1 = new JButton("Cancel");
		Aceptar1.addActionListener(this);
		Aceptar1.setVisible(true);
		
		Aceptar2 = new JButton("Aceptar");
		Aceptar2.addActionListener(this);
		
		/*Agragar los botones y los textos al frame*/
		
		GroupLayout groupLayou = new GroupLayout(Ventani.getContentPane());
		groupLayou.setHorizontalGroup(
			groupLayou.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayou.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayou.createParallelGroup(Alignment.LEADING)
						.addComponent(Resp1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addComponent(Aparicion, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addComponent(Resp2, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
						.addComponent(Aparicion2, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayou.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(Aceptar1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(Aceptar2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		groupLayou.setVerticalGroup(
			groupLayou.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayou.createSequentialGroup()
					.addGap(36)
					.addComponent(Aparicion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Resp1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addComponent(Resp2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Aparicion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayou.createParallelGroup(Alignment.BASELINE)
						.addComponent(Aceptar2)
						.addComponent(Aceptar1))
					.addGap(17))
		);
		Ventani.getContentPane().setLayout(groupLayou);

		/* Interfaz Borrar*/
		borrador=new JDialog();
		borrador.setBounds(100, 100, 450, 300);
		borrador.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		borrador.getContentPane().add(contentPanel, BorderLayout.CENTER);
		borrador.setVisible(false);
		 Combo = new JComboBox();
		
		txtquDeseaNodo = new JTextField();
		txtquDeseaNodo.setText("\u00bfQu\u00e9 nodo desea eliminar?");
		txtquDeseaNodo.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(66)
					.addComponent(Combo, 0, 292, Short.MAX_VALUE)
					.addGap(82))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(112)
					.addComponent(txtquDeseaNodo, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(txtquDeseaNodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Combo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			borrador.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				borrador.getRootPane().setDefaultButton(okButton);
			}
			{
				 cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

}
	
	
	
	
	
	
	
	/* Acciones de los botones*/
	
	public void actionPerformed(ActionEvent e){
		String evento=e.getActionCommand();
	/*Inicia la logica y pone todos los botones en visbles.*/
		if(e.getSource()==BotonJugar){
			 	Arbol=new Logica(); 
			 	textField.setVisible(true);
			 	textField_1.setVisible(true);
				textField_2.setVisible(true);
				Mostrador.setVisible(true);
				Mostrador.setText(Arbol.getPregunta());
				BotonSi.setVisible(true);
				BotonNO.setVisible(true);
				ArbolA.setVisible(true);
				Salir.setVisible(true);
				BotonJugar.setEnabled(false);
				Mostrador.setVisible(true);
				MostrarNodos.setVisible(true);
				oraciones.setVisible(true);
				Nodoborrar.setVisible(true);
				reset.setVisible(true);
				Actualizar();}
		
	
		if(e.getSource()==BotonNO){
			if(!Arbol.Perdio()){Arbol.No();Mostrador.setText(Arbol.getPregunta());}
			else{Resp2.setText("\u00bfQu\u00e9 diferencia tiene con "+Arbol.getElement()+"?"); 
				 Ventani.setVisible(true);}
			}
		
		if(e.getSource()==Aceptar1){
			Arbol.reset();
			 Mostrador.setText(Arbol.getPregunta());
			 Actualizar();
			
			Ventani.dispose();

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
			Arbol.Guardar();
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
		
		if(e.getSource()==Salir){Arbol.Guardar();}
		
		if(e.getSource()==oraciones){
			DA=new MostrarArbol();
			PositionList<String> lista= new ListaDoble<String>();
			try {	 Arbol.getInformacion(lista);
				Position<String> po=lista.first();
				//pasa todos los string de la lista al cuadro de texto de la NuevaVentana creada.
				while((po!=lista.last())){
					DA.mostrar(po.element());
					po=lista.next(po);
					}
					DA.mostrar(po.element());
				DA.setVisible(true);}
				
		
	
		catch(EmptyListException | InvalidPositionException |BoundaryViolationException h){System.out.println(h.getMessage());}
		}
		
		if(e.getSource()==MostrarNodos){
				MA=new MostrarArbol();
				TDAPilaEnlazada.Stack<String> pila= new PilaConEnlaces<String>();
				try{pila=Arbol.MostrarNodos();
					//muetra todos los nodos internos del arbol, de manera invertida.
					while(!pila.isEmpty()){
						MA.mostrar(pila.pop());
					}
					MA.setVisible(true);}
				catch(InvalidPositionException| EmptyListException | EmptyStackException |EmptyTreeException k)
			{System.out.println(k.getMessage());}
			}
		
		
		if(e.getSource()==ArbolA){Arbol.recuperar();
								 Arbol.reset();
								 Mostrador.setText(Arbol.getPregunta());
								 Actualizar();}
	
		if(e.getSource()==Nodoborrar){
			/*crea la clase borrar que es un Jdialog con un comboBox con todos los nodos internos*/
			
	
			try{	PositionList<String> lista=Arbol.Internos();
				//agrega todos los nodos internos al combo box.
				
			while(!lista.isEmpty())
					{Combo.addItem(lista.first().element());
					System.out.println(lista.first().element());	
					lista.remove(lista.first());}
				}
		
				catch(InvalidPositionException| EmptyListException  |EmptyTreeException k){
						System.out.println(k.getMessage());
						}
			borrador.setVisible(true);
				}
	
		if(e.getSource()==reset){Arbol.reset();
							Mostrador.setText(Arbol.getPregunta());
								Actualizar();}
		
		if(e.getSource()==okButton){
			
			borrar((String)Combo.getSelectedItem());
			Combo.removeAllItems();
			borrador.dispose();
			
		}
	
	}
		/*metodo invocado desde la clase borra cuando toca ok, con el string del comboBox.*/
		public void borrar(String h){System.out.println(h);
			
			Arbol.eliminarSubarbol(h);
			Actualizar();}
		/*Actualiza todos los textos con los datos de altura, cantidad de preguntas, y objetos.*/
		private void Actualizar(){
			textField_2.setText("Cant. de Preg. Almacendas="+Arbol.cantPreguntas());
			textField.setText("Altura del Arbol="+Arbol.Altura());
			textField_1.setText("Cant. de Obj. Almacenados="+Arbol.cantObjetos());}
	}


