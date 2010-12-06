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
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import opoo.practica5.juego.Chinos;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.Morra;
import opoo.practica5.juego.PPT;
import opoo.practica5.juego.ParesNones;

//hacer un panel que aglutine lo k tienen los panels inferiores
/**
 * Ventana visual para los juegos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 05/12/2010
 */
public class VentanaJuegos extends JFrame {
	// resources
	final static String RUTADEO = "/opoo/practica5/juego/visual/imgs/eldeorrr.jpg";
	final static String RUTAABOUT = "/opoo/practica5/juego/visual/docs/infoExtra.html"; // @jve:decl-index=0:
	final static String RUTACOMO = "/opoo/practica5/juego/visual/docs/comoUsar.html"; // @jve:decl-index=0:
	// capas
	final static String PPTPANEL = "Card Piedra Papel Tijera";
	final static String CHINOSPANEL = "Card Chinos";
	final static String PNPANEL = "Card Pares Nones";
	final static String MORRAPANEL = "Card Morra";
	// props
	private byte capaActiva;
	private JugadorM[] jugadores = null;
	private int nJugadores;
	private JuegoM juego = null;
	private Object[] optionsTiposJuegos = { "Piedra, Papel, Tijera", "Chinos",
			"Pares Nones", "Morra" };
	private Object[] optionsJugadores = { "2", "3", "4", "5", "6", "7", "8" };
	private static final long serialVersionUID = 1L;
	// componentes
	private JPanel jPBase = null;
	private JPanelPPT jPppt = null;
	private JPanelChinos jPchinos = null;
	private JPanelPN jPpn = null;
	private JPanelMorra jPmorra = null;
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
		eligeJuego();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource(RUTADEO)));
		this.setContentPane(getJPbase());
		estableceLayout();
		this.setJMenuBar(getJMBJ());
		this.setResizable(false);
		this.setTitle("Juegos de manos");
		this.pack();
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
			jPBase.add(getJPpn(), PNPANEL);
			jPBase.add(getJPmorra(), MORRAPANEL);

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
	 * This method initializes jPchinos
	 * 
	 * @return JPanelChinos
	 */
	private JPanelChinos getJPchinos() {
		if (jPchinos == null) {
			jPchinos = new JPanelChinos(juego);
		}
		return jPchinos;
	}

	/**
	 * This method initializes jPpn
	 * 
	 * @return JPanelPN
	 */
	private JPanelPN getJPpn() {
		if (jPpn == null) {
			jPpn = new JPanelPN(juego);
		}
		return jPpn;
	}

	/**
	 * This method initializes jPmorra
	 * 
	 * @return JPanelMorra
	 */
	private JPanelMorra getJPmorra() {
		if (jPmorra == null) {
			jPmorra = new JPanelMorra(juego);
		}
		return jPmorra;
	}

	/**
	 * This method initializes jTFrutaArchivo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JMenuBarJ getJMBJ() {
		if (jMBJ == null) {
			jMBJ = new JMenuBarJ(this, new JDialogAcercade(this, "Juegos de manos",
					"1.0 03/12/2010", "Jstyl_8", "http://jstyl8.net46.net",
					RUTADEO), new JDialogComoUsar(this, RUTAABOUT, RUTACOMO,
					true, true));
		}
		return jMBJ;
	}

	/**
	 * Metodo para configurar los jugadores
	 */
	void eligeJugadores() {
		String numero = (String) JOptionPane.showInputDialog(null,
				"Elige numero de jugadores", "Numero de jugadores",
				JOptionPane.QUESTION_MESSAGE, null, optionsJugadores,
				optionsJugadores[0]);
		if (numero == null)
			nJugadores = 2;
		else
			nJugadores = Integer.parseInt(numero);
		jugadores = new JugadorM[nJugadores];
		jugadores[0] = new JugadorM("Jugador", true);
		for (int i = 1; i < jugadores.length; i++)
			jugadores[i] = new JugadorM("Maquina" + i, false);
	}

	/**
	 * Metodo que actualiza el juego con los nuevos jugadores
	 */
	void actualizaJuego() {
		juego.setJugadores(jugadores);
		reiniciar();
	}

	/**
	 * Metodo para elegir juego
	 */
	void eligeJuego() {
		// uso JOptionPane para seleccion filtrada de juego
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el tipo de juego", "Tipo de juego",
				JOptionPane.QUESTION_MESSAGE, null, optionsTiposJuegos,
				optionsTiposJuegos[0]);
		if (s == null) {
			juego = new PPT(jugadores, 3);
			capaActiva = 0;
		} else if (s.equals(optionsTiposJuegos[0])) {
			juego = new PPT(jugadores, 3);
			capaActiva = 0;
		} else if (s.equals(optionsTiposJuegos[1])) {
			juego = new Chinos(jugadores, 3);
			capaActiva = 1;
		} else if (s.equals(optionsTiposJuegos[2])) {
			juego = new ParesNones(jugadores, 3);
			capaActiva = 2;
		} else if (s.equals(optionsTiposJuegos[3])) {
			juego = new Morra(jugadores, 3);
			capaActiva = 3;
		}
	}

	/**
	 * Establece la capa visible
	 */
	void estableceLayout() {
		switch (capaActiva) {
		case 0:
			layout.show(jPBase, PPTPANEL);
			jPppt.setJuego(juego);
			break;
		case 1:
			layout.show(jPBase, CHINOSPANEL);
			jPchinos.setJuego(juego);
			break;
		case 2:
			layout.show(jPBase, PNPANEL);
			jPpn.setJuego(juego);
			break;
		case 3:
			layout.show(jPBase, MORRAPANEL);
			jPmorra.setJuego(juego);
			break;
		}
	}

	/**
	 * Reinicia el juego adecuado
	 */
	void reiniciar() {
		switch (capaActiva) {
		case 0:
			jPppt.reiniciarJuego();
			break;
		case 1:
			jPchinos.reiniciarJuego();
			break;
		case 2:
			jPpn.reiniciarJuego();
			break;
		case 3:
			jPmorra.reiniciarJuego();
			break;
		}
	}
}
