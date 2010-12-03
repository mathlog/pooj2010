//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.visual;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import opoo.practica5.juego.Chinos;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.PPT;

/**
 * Ventana visual para los juegos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 03/1"/2010
 */
public class VentanaJuegos extends JFrame {

	final static String PPTPANEL = "Card Piedra Papel Tijera";
	final static String CHINOSPANEL = "Card Chinos";
	final static String RUTADEO = "/opoo/practica5/juego/visual/imgs/eldeorrr.jpg";

	private JugadorM[] jugadores = null;// = { new JugadorM("JugadorM", true),
	// new JugadorM("BANCA", false) };
	private String nombreJugador;
	private int nJugadores;
	private JuegoM juego = null;
	private Object[] optionsTiposJuegos = { "Piedra, Papel, Tijera", "Chinos" };
	private Object[] optionsJugadores = { "2", "3", "4", "5", "6", "7", "8" };

	private static final long serialVersionUID = 1L;

	private JPanel jPBase = null;

	private JPanelPPT jPppt = null;

	private JPanel jPchinos = null;

	private JMenuBarJ jMBJ = null;

	private CardLayout layout = null;

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
		eligeJugadores();
		byte capa = eligeJuego();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(RUTADEO)));
		this.setContentPane(getJPbase());
		estableceLayout(capa);
		this.setJMenuBar(getJMBJ());
		this.setResizable(false);
		this.setTitle("Juegos");
		this.setSize(500,500);
	}

	/**
	 * This method initializes jPBase
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPbase() {
		if (jPBase == null) {
			layout = new CardLayout();
			jPBase = new JPanel(layout);
			jPBase.add(getJPppt(), PPTPANEL);
			jPBase.add(getJPchinos(), CHINOSPANEL);
			
		}
		return jPBase;
	}

	/**
	 * This method initializes jPppt
	 * 
	 * @return JPanelPPT
	 */
	private JPanelPPT getJPppt() {
		if (jPppt == null) {
			jPppt = new JPanelPPT(juego);
		}
		return jPppt;
	}

	/**
	 * This method initializes jPBase
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPchinos() {
		if (jPchinos == null) {
			jPchinos = new JPanel();

		}
		return jPchinos;
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
					RUTADEO), new JDialogComoUsar(this, "INFO BASE",
					"EXPLICACION JUEGOS"));
		}
		return jMBJ;
	}

	/**
	 * Metodo para configurar los jugadores
	 */
	private void eligeJugadores() {
		nombreJugador = JOptionPane.showInputDialog("Introduce tu nombre:");
		nJugadores = (Integer.parseInt((String) JOptionPane.showInputDialog(
				null, "Elige numero de jugadores", "Numero de jugadores",
				JOptionPane.QUESTION_MESSAGE, null, optionsJugadores,
				optionsJugadores[0])));
		jugadores = new JugadorM[nJugadores];
		jugadores[0] = new JugadorM(nombreJugador, true);
		for (int i = 1; i < jugadores.length; i++)
			jugadores[i] = new JugadorM("Maquina-" + i, false);
	}

	/**
	 * Metodo para elegir juego
	 */
	private byte eligeJuego() {
		// uso JOptionPane para seleccion filtrada de juego
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el tipo de juego", "Tipo de juego",
				JOptionPane.QUESTION_MESSAGE, null, optionsTiposJuegos,
				optionsTiposJuegos[0]);
		if (s == null) {
			juego = new PPT(jugadores, 3);
			return 0;
		} else if (s.equals(optionsTiposJuegos[0])) {
			juego = new PPT(jugadores, 3);
			return 0;
		} else if (s.equals(optionsTiposJuegos[1])) {
			juego = new Chinos(jugadores, 1);
			return 1;
		}
		// siwcht pal ti`po jeugo
		/*
		 * if (s == null) juego = new SieteyMedioVisual(jugadores); else if
		 * (s.equals(posibilidades[0])) juego = new
		 * SieteyMedioVisual(jugadores); else juego = new
		 * VeintiunoVisual(jugadores);
		 */
		return 0;
	}

	private void estableceLayout(byte capa) {
		switch (capa) {
		case 0:
			layout.show(jPBase, PPTPANEL);
			break;
		case 1:
			layout.show(jPBase, CHINOSPANEL);
			break;
		}

	}
}
