//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//
package poo.juegos.nReinas.visual;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

/**
 * Clase visual que representa el dialogo que aparece al pulsar Como jugar
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 26.09.2010
 */
public class JDialogComoJugar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTabbedPane jContentPane = null;
	private JPanel jPaboutGame = null;
	private JPanel jPUsoPrograma = null;
	private JTextPane jTPaboutGame = null;
	private JScrollPane jSPaboutGame = null;
	private JTextPane jTPusoProg = null;
	private JScrollPane jSPusoProg = null;
	private String aboutGame=null;
	private String usePrograma=null;

	/**
	 * @param owner
	 */
	public JDialogComoJugar(Frame owner,String aboutGame,String useProgama) {
		super(owner);
		this.aboutGame=aboutGame;
		this.usePrograma=useProgama;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Como jugar");
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
			jContentPane.addTab("Sobre el juego", null, getJPaboutGame(), null);
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
		if (jPaboutGame == null) {
			GridLayout gridLayout = new GridLayout(1,1);
			jPaboutGame = new JPanel();
			jPaboutGame.setLayout(gridLayout);
			jPaboutGame.add(getJSPaboutGame(), null);
		}
		return jPaboutGame;
	}

	/**
	 * This method initializes jPUsoPrograma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPUsoPrograma() {
		if (jPUsoPrograma == null) {
			GridLayout gridLayout1 = new GridLayout(1,1);
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
		if (jTPaboutGame == null) {
			jTPaboutGame = new JTextPane();
			jTPaboutGame.setEditable(false);
			jTPaboutGame.setContentType("text/html");
			jTPaboutGame
					.setText(aboutGame);
		}
		return jTPaboutGame;
	}

	/**
	 * This method initializes jSPaboutGame
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPaboutGame() {
		if (jSPaboutGame == null) {
			jSPaboutGame = new JScrollPane();
			jSPaboutGame.setViewportView(getJTPaboutGame());
		}
		return jSPaboutGame;
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
