package opoo.practica4.juego.principal;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Clase base visual para el juego
 * 
 * @author José Ángel García Fernández
 * @version 1.0 12/11/2010
 */
public class VentanaVisual extends JFrame {

	private static final long serialVersionUID = 1L;

	private JpanelJuego jPjuego = null;
	private JMenuBar jMenuPrincipal = null;
	private JMenu jMenu = null;
	private JMenuItem jMIReiniciar = null;
	private JMenuItem jMISalir = null;
	private JMenuItem jMIChangeGame = null;
	private JDialogAcercade jdialogInfo = null;
	private JMenu jMAyuda = null;
	private JMenuItem jMIAbout = null;

	/**
	 * This is the default constructor
	 */
	public VentanaVisual() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(490, 275);
		this.setContentPane(getJContentPane());
		this.setTitle("Juego de Cartas");
		this.setJMenuBar(getJMenuPrincipal());
		this.setResizable(false);
		jdialogInfo = new JDialogAcercade(this, "Juego del 7.5 y 21", "1.2",
				"Jstyl_8", "http://jstyl8.net46.net",
				"/opoo/practica4/juego/imgs/eldeorrr.jpg");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jPjuego == null) {
			jPjuego = new JpanelJuego();
		}
		return jPjuego;
	}

	/**
	 * This method initializes jMenuPrincipal
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJMenuPrincipal() {
		if (jMenuPrincipal == null) {
			jMenuPrincipal = new JMenuBar();
			jMenuPrincipal.add(getJMenu());
			jMenuPrincipal.add(getJMAyuda());
		}
		return jMenuPrincipal;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setMnemonic(KeyEvent.VK_O);
			jMenu.setText("Opciones");
			jMenu.add(getJMIChangeGame());
			jMenu.add(getJMIReiniciar());
			jMenu.add(getJMISalir());

		}
		return jMenu;
	}

	/**
	 * This method initializes jMIReiniciar
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIReiniciar() {
		if (jMIReiniciar == null) {
			jMIReiniciar = new JMenuItem();
			jMIReiniciar.setText("Reiniciar");

			jMIReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jPjuego.reiniciarJuego();
				}
			});
		}
		return jMIReiniciar;
	}

	/**
	 * This method initializes jMICerrar
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMISalir() {
		if (jMISalir == null) {
			jMISalir = new JMenuItem();
			jMISalir.setText("Salir");
			jMISalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jMISalir;
	}

	/**
	 * This method initializes jMIChangeGame
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIChangeGame() {
		if (jMIChangeGame == null) {
			jMIChangeGame = new JMenuItem();
			jMIChangeGame.setText("Cambiar Juego");
			jMIChangeGame
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							jPjuego.eligeJuego();
							jPjuego.reiniciarJuego();
						}
					});
		}
		return jMIChangeGame;
	}

	/**
	 * This method initializes jMAyuda
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMAyuda() {
		if (jMAyuda == null) {
			jMAyuda = new JMenu();
			jMAyuda.setText("Ayuda");
			jMAyuda.setMnemonic(KeyEvent.VK_A);
			jMAyuda.add(getJMIAbout());
		}
		return jMAyuda;
	}

	/**
	 * This method initializes jMIAbout
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIAbout() {
		if (jMIAbout == null) {
			jMIAbout = new JMenuItem();
			jMIAbout.setText("Acerda de");
			jMIAbout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jdialogInfo.setVisible(true);
					jdialogInfo.setLocationRelativeTo(jPjuego);
				}
			});

		}
		return jMIAbout;
	}
}
