package opoo.practica4.juego.principal;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaVisual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JpanelJuego jPjuego = null;

	private JMenuBar jMenuPrincipal = null;
	private JMenu jMenu = null;
	private JMenuItem jMIReiniciar = null;
	private JMenuItem jMISalir = null;

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
		this.setSize(490, 290);
		this.setContentPane(getJContentPane());
		this.setTitle("Juego");
		this.setJMenuBar(getJMenuPrincipal());
		this.setResizable(false);
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
					// enabledGUI1();
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
}
