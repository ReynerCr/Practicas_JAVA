package ventana;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JOptionPane

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private JPanel campos;
	
	
	public Ventana () {
		this.setTitle("Iniciar sesion");
		this.setSize(700, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		iniciarCampos();
		iniciarBotones();
		
		this.pack();
	}
	
	private void iniciarCampos() {
		campos = new JPanel(new GridLayout(2, 2));

		JLabel eUsuario = new JLabel("Usuario: ");
		eUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		JTextField usuario = new JTextField();
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel eContrasena = new JLabel("Contrasena: ");
		eContrasena.setFont(new Font("Arial", Font.BOLD, 15));
		JPasswordField contrasena = new JPasswordField();
		
		campos.add(eUsuario);
		campos.add(usuario);
		campos.add(eContrasena);
		campos.add(contrasena);
		this.getContentPane().add(campos);
	}//iniciarCampos
	
	private void iniciarBotones() {
		JPanel botones = new JPanel(new FlowLayout());
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setMnemonic('\n');
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField usuario = (JTextField) campos.getComponent(1);
				JOptionPane.showMessageDialog(null, "¡Hola " + usuario.getText() + "!");
				usuario.setText("");
				
				JTextField contrasena = (JTextField) campos.getComponent(3);
				contrasena.setText("");
			}
		});
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTextField usuario = (JTextField) campos.getComponent(1);
				usuario.setText("");
				
				JTextField contrasena = (JTextField) campos.getComponent(3);
				contrasena.setText("");
			}
		});
		
		botones.add(aceptar);
		botones.add(cancelar);
		this.getContentPane().add(botones);
	}//iniciarBotones

}
