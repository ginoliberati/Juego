
package TDAarbolBinario;
import  TDAListaDoble.*;
import TDAPilaEnlazada.*;
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
		
		Salir = new JButton("Guardar");
		Salir.setEnabled(false);
		Salir.addActionListener(this);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 9));
		textField.setToolTipText("");
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setVisible(false);

		textField.setColumns(10);
		textField.setText("Tama\u00f1o del Arbol=0");
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
		ArbolA.setEnabled(false);;
		ArbolA.addActionListener(this);
		ArbolA.setVisible(false);
		
		MostrarNodos = new JButton("Mostrar todos Nodos");
		MostrarNodos.setEnabled(false);
		MostrarNodos.setVisible(false);
		MostrarNodos.addActionListener(this);
		
		oraciones = new JButton("Oraciones");
		oraciones.setEnabled(false);
		oraciones.addActionListener(this);
		oraciones.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(frmAdivinador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addGap(398))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
									.addGap(114)
									.addComponent(Salir))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(oraciones, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
											.addGap(207)
											.addComponent(MostrarNodos)))
									.addGap(17)))
							.addGap(76))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(130, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(213)
					.addComponent(ArbolA)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Salir)
						.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(ArbolA)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MostrarNodos))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(oraciones)))
					.addGap(15))
		);
		frmAdivinador.getContentPane().setLayout(groupLayout);
		
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
				MostrarNodos.setEnabled(true);
				MostrarNodos.setVisible(true);
				oraciones.setEnabled(true);
				oraciones.setVisible(true);
				Actualizar();}
		
	if(e.getSource()==BotonNO){
			if(!Arbol.Perdio()){Arbol.No();Mostrador.setText(Arbol.getPregunta());}
			else{Resp2.setText("\u00bfQu\u00e9 diferencia tiene con "+Arbol.getElement()+"?"); 
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
		
		if(e.getSource()==Salir){System.out.println(" hola");
									Arbol.Guardar();
								 }
	if(e.getSource()==oraciones){
			DA=new MostrarArbol();
			PositionList<String> lista= new ListaDoble<String>();
			try {	 Arbol.getInformacion(lista);
				Position<String> po=lista.first();
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
		}
	
		private void Actualizar(){
			textField_2.setText("Cant. de Preg. Almacendas="+Arbol.cantPreguntas());
			textField.setText("Altura del Arbol="+Arbol.Altura());
			textField_1.setText("Cant. de Obj. Almacenados="+Arbol.cantObjetos());}
	}


package TDAarbolBinario;
import  TDAListaDoble.*;
import TDAPilaEnlazada.*;
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
		
		Salir = new JButton("Guardar");
		Salir.setEnabled(false);
		Salir.addActionListener(this);
		
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
		ArbolA.setEnabled(false);;
		ArbolA.addActionListener(this);
		ArbolA.setVisible(false);
		
		MostrarNodos = new JButton("Mostrar todos Nodos");
		MostrarNodos.setEnabled(false);
		MostrarNodos.setVisible(false);
		MostrarNodos.addActionListener(this);
		
		oraciones = new JButton("Oraciones");
		oraciones.setEnabled(false);
		oraciones.addActionListener(this);
		oraciones.setVisible(false);
		
		Nodoborrar = new JButton("Borrar Nodo");
		Nodoborrar.setVisible(false);
		Nodoborrar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(frmAdivinador.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addGap(139)
							.addComponent(Nodoborrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(105))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
									.addGap(114)
									.addComponent(Salir))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(207)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(MostrarNodos)
										.addComponent(oraciones, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
									.addGap(17)))
							.addGap(76))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(130, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(213)
					.addComponent(ArbolA)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Salir)
						.addComponent(BotonJugar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addComponent(Mostrador, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BotonSi, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(BotonNO, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(ArbolA)
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(MostrarNodos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(oraciones)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(Nodoborrar)))
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
				MostrarNodos.setEnabled(true);
				MostrarNodos.setVisible(true);
				oraciones.setEnabled(true);
				oraciones.setVisible(true);
				Nodoborrar.setVisible(true);
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
		
		if(e.getSource()==Salir){System.out.println(" hola");
									Arbol.Guardar();
								 }
	if(e.getSource()==oraciones){
			DA=new MostrarArbol();
			PositionList<String> lista= new ListaDoble<String>();
			try {	 Arbol.getInformacion(lista);
				Position<String> po=lista.first();
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
		Borrar venta=new Borrar();
		String lei;
	try{	PositionList<String> lista=Arbol.Internos();
			
			while(!lista.isEmpty())
			{venta.mostrar(lista.first().element());
				lista.remove(lista.first());}
			}
		
	catch(InvalidPositionException| EmptyListException  |EmptyTreeException k)
	{System.out.println(k.getMessage());}
	lei=venta.leyo();
	
	venta.setVisible(true);
	lei=venta.leyo();
	System.out.println(lei);
	}
	
		
	
	}
	
		private void Actualizar(){
			textField_2.setText("Cant. de Preg. Almacendas="+Arbol.cantPreguntas());
			textField.setText("Tamaño del Arbol="+Arbol.Altura());
			textField_1.setText("Cant. de Obj. Almacenados="+Arbol.cantObjetos());}
	}

>>>>>>> Stashed changes
