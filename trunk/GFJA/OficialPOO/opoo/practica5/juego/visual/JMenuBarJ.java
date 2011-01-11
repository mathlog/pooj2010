package opoo.practica5.juego.visual;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class JMenuBarJ extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JFrame jOwner = null;
	private JMenu jMenu = null;
	private JMenuItem jMIReiniciar = null;
	private JMenuItem jMICambiarJugadores = null;
	private JMenuItem jMICambiarJuego = null;
	private JMenuItem jMISalir = null;
	private JMenu jMAyuda = null;
	private JMenuItem jMIacerdade = null;
	private JMenuItem jMIcomoJugar = null;
	private JDialogAcercade jdialogInfo = null;
	private JDialogComoUsar jdialogComoUsar = null;

	/**
	 * This method initializes jJMB
	 * 
	 * @return javax.swing.JMenuBar
	 */
	public JMenuBarJ(JFrame frame, JDialogAcercade jdInfo,
			JDialogComoUsar jdComoUsar) {
		jOwner = frame;
		jdialogInfo = jdInfo;
		jdialogComoUsar = jdComoUsar;
		add(getJMenu());
		add(getJMAyuda());
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
			jMenu.add(getJMCambiarJugadores());
			jMenu.add(getJMCambiarJuego());
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
			jMIReiniciar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
					ActionEvent.ALT_MASK));
			jMIReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					VentanaJuegos v = (VentanaJuegos) jOwner;
					v.reiniciar();
				}
			});
		}
		return jMIReiniciar;
	}

	/**
	 * This method initializes jMICambiarJugadores
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMCambiarJugadores() {
		if (jMICambiarJugadores == null) {
			jMICambiarJugadores = new JMenuItem();
			jMICambiarJugadores.setText("Cambiar Jugadores");
			jMICambiarJugadores.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_J, ActionEvent.ALT_MASK));
			jMICambiarJugadores
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							VentanaJuegos v = (VentanaJuegos) jOwner;
							v.eligeJugadores();
							v.actualizaJuego();
						}
					});
		}
		return jMICambiarJugadores;
	}

	/**
	 * This method initializes jMICambiarJuego
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMCambiarJuego() {
		if (jMICambiarJuego == null) {
			jMICambiarJuego = new JMenuItem();
			jMICambiarJuego.setText("Cambiar Juego");
			jMICambiarJuego.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_C, ActionEvent.ALT_MASK));
			jMICambiarJuego
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							VentanaJuegos v = (VentanaJuegos) jOwner;
							v.eligeJuego();
							v.estableceLayout();
						}
					});
		}
		return jMICambiarJuego;
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
			jMISalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					ActionEvent.ALT_MASK));
			jMISalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return jMISalir;
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
			jMAyuda.add(getJMIacerdade());
			jMAyuda.add(getJMIcomoJugar());
		}
		return jMAyuda;
	}

	/**
	 * This method initializes jMIacerdade
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIacerdade() {
		if (jMIacerdade == null) {
			jMIacerdade = new JMenuItem();
			jMIacerdade.setText("Acerca de");
			jMIacerdade.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jdialogInfo.setLocationRelativeTo(jOwner);
					jdialogInfo.setVisible(true);
				}
			});

		}
		return jMIacerdade;
	}

	/**
	 * This method initializes jMIcomoJugar
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIcomoJugar() {
		if (jMIcomoJugar == null) {
			jMIcomoJugar = new JMenuItem();
			jMIcomoJugar.setText("Como usar");
			jMIcomoJugar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jdialogComoUsar.setLocationRelativeTo(jOwner);
					jdialogComoUsar.setVisible(true);
				}
			});
		}
		return jMIcomoJugar;
	}

}
