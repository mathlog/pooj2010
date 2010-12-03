package opoo.practica5.juego.visual;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana visual para los juegos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 03/1"/2010
 */
public class VentanaJuegos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jPBase = null;
	private JMenuBarJ jMBJ;

	/**
	 * This is the default constructor
	 */
	public VentanaJuegos() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 490);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/visual/imgs/eldeorrr.jpg")));
		this.setContentPane(getJPbase());
		this.setJMenuBar(getJMBJ());
		this.setResizable(false);
		this.setTitle("Juegos");
	}

	/**
	 * This method initializes jTFrutaArchivo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JMenuBarJ getJMBJ() {
		if (jMBJ == null) {
			jMBJ = new JMenuBarJ(this, new JDialogAcercade(this, "Juegos",
					"1.0 03/12/2010", "Jstyl_8", "http://jstyl8.net46.net",
					"/visual/imgs/eldeorrr.jpg"), new JDialogComoUsar(this,
					"INFO BASE", "EXPLICACION JUEGOS"));
		}
		return jMBJ;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPbase() {
		if (jPBase == null) {
			jPBase = new JPanel();
		}
		return jPBase;
	}
}
