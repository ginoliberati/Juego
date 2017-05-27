package TDAarbolBinario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Borrar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtquDeseaNodo;
	public static String leyo;
	private JComboBox Combo;
	private inteface gui;
		
	/**
	 * Create the dialog.
	 */
	public Borrar(inteface h) {
		gui=h;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		 Combo = new JComboBox();
		
		txtquDeseaNodo = new JTextField();
		txtquDeseaNodo.setText("¿Qué nodo desea eliminar?");
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
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				OyenteBoton c=new OyenteBoton();
				okButton.addActionListener(c);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void mostrar(String h){
		Combo.addItem(h);}
	public String leyo(){return leyo;}
	public class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			leyo=(String)Combo.getSelectedItem();
			System.out.println(leyo);
			gui.borrar(leyo);
			dispose();
		}
		}
}
