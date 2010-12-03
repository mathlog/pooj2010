//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.visual;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 * Clase visual que representa el dialogo que aparece al pulsar Como usar
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 06.11.2010
 */
public class JDialogComoUsar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTabbedPane jContentPane = null;
	private JPanel jPaboutProg = null;
	private JPanel jPUsoPrograma = null;
	private JTextPane jTPaboutProg = null;
	private JScrollPane jSPaboutProg = null;
	private JTextPane jTPusoProg = null;
	private JScrollPane jSPusoProg = null;
	private String aboutProg = null;
	private String usePrograma = null;

	/**
	 * @param owner
	 */
	public JDialogComoUsar(Frame owner, String aboutProg, String useProgama) {
		super(owner);
		this.aboutProg = aboutProg;
		this.usePrograma = useProgama;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Como usar");
		this.setContentPane(getJContentPane());
		this.pack();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JTabbedPane getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JTabbedPane();
			jContentPane.addTab("Info Extra", null, getJPaboutGame(), null);
			jContentPane.addTab("Uso del programa", null, getJPUsoPrograma(),
					null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPaboutGame
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPaboutGame() {
		if (jPaboutProg == null) {
			GridLayout gridLayout = new GridLayout(1, 1);
			jPaboutProg = new JPanel();
			jPaboutProg.setLayout(gridLayout);
			jPaboutProg.add(getJSPaboutGame(), null);
		}
		return jPaboutProg;
	}

	/**
	 * This method initializes jPUsoPrograma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPUsoPrograma() {
		if (jPUsoPrograma == null) {
			GridLayout gridLayout1 = new GridLayout(1, 1);
			jPUsoPrograma = new JPanel();
			jPUsoPrograma.setLayout(gridLayout1);
			jPUsoPrograma.add(getJSPusoProg(), null);
		}
		return jPUsoPrograma;
	}

	/**
	 * This method initializes jTPaboutGame
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTPaboutGame() {
		if (jTPaboutProg == null) {
			jTPaboutProg = new JTextPane();
			jTPaboutProg.setEditable(false);
			jTPaboutProg.setContentType("text/html");
			jTPaboutProg.setText(aboutProg);
		}
		return jTPaboutProg;
	}

	/**
	 * This method initializes jSPaboutGame
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPaboutGame() {
		if (jSPaboutProg == null) {
			jSPaboutProg = new JScrollPane();
			jSPaboutProg.setViewportView(getJTPaboutGame());
		}
		return jSPaboutProg;
	}

	/**
	 * This method initializes jTPusoProg
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTPusoProg() {
		if (jTPusoProg == null) {
			jTPusoProg = new JTextPane();
			jTPusoProg.setEditable(false);
			jTPusoProg.setContentType("text/html");
			jTPusoProg.setText(usePrograma);
		}
		return jTPusoProg;
	}

	/**
	 * This method initializes jSPusoProg
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPusoProg() {
		if (jSPusoProg == null) {
			jSPusoProg = new JScrollPane();
			jSPusoProg.setViewportView(getJTPusoProg());
		}
		return jSPusoProg;
	}
}
