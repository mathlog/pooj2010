package poo.juegos.nReinas;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Clase visual para el juego
 * 
 * @author José Ángel García Fernández
 * @date 07/10/2010
 * @version 1.0
 */
public class VentanaNreinas extends JFrame {

	private JPanel jPbase = null;
	private Nreinas reinas = null;
	private JTextArea jTAtablero = null;
	private JButton jBadd = null;
	private JButton jBremove = null;
	private JTextField jTFfilas = null;
	private JTextField jTFcols = null;
	private JLabel jLinfo = null;

	/**
	 * Genera un objeto de tipo VentanaNreinas
	 * 
	 * @throws HeadlessException
	 */
	public VentanaNreinas() throws HeadlessException {
		super();
		inicializar();

	}

	private void inicializar() {
		setSize(500, 500);
		setTitle("Juego de las " + 8 + " reinas");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getResource(
								"/poo/juegos/nReinas/imgs/eldeorrr.jpg")));
		setContentPane(getJCPBase());
		reinas = new Nreinas(8);
		// TODO Auto-generated method stub
	}

	/**
	 * This method initializes jCPBase
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJCPBase() {
		if (jPbase == null) {
			jPbase = new JPanel();
			jPbase.setLayout(new GridLayout(2, 1));
			jLinfo = new JLabel("Introduzca Informacion");
		}
		return jPbase;
	}

}
