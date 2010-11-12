//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 4 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.principal;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import opoo.excepciones.AllPlayersPlantadosException;
import opoo.excepciones.NoHayMasCartasException;
import opoo.practica4.juego.base.BarajaMostrable;
import opoo.practica4.juego.base.Carta;
import opoo.practica4.juego.base.CartaMostrable;
import opoo.practica4.juego.base.Juego;
import opoo.practica4.juego.base.Jugador;
import opoo.practica4.juego.sieteymedio.SieteyMedioVisual;
import opoo.practica4.juego.veintiuno.VeintiunoVisual;

/**
 * Clase visual para la pantalla de juego
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public class JpanelJuego extends JPanel {

	private Juego juego = null;
	private Object[] posibilidades = { "Siete y Medio", "Veintiuno" };
	Jugador[] jugadores = { new Jugador("Jugador"), new Jugador("BANCA") };
	private BarajaMostrable baraja;
	private boolean primerTurno;

	private static final long serialVersionUID = 1L;
	private JTextArea jTAlog = null;
	private JScrollPane jSPlog = null;
	private JScrollPane jSPresult = null;
	private JTextArea jTAresult = null;
	private JButton jBpedirCarta = null;
	private JButton jBplantarse = null;
	private JTextField jTFpila = null;
	private JLabel jLimgPila = null;
	private JLabel jLimgMano = null;
	private JTextField jTFmano = null;
	private JTextField jTFturno = null;
	private JLabel jLturno = null;
	private JLabel jLpila = null;
	private JLabel jLmano = null;
	private JLabel jLresult = null;
	private JLabel jLlog = null;
	private JLabel jLinfJugdr = null;
	private JLabel jLtuScore = null;
	private JLabel jLhastaLim = null;
	private JTextField jTFtuScore = null;
	private JTextField jTFhastaLim = null;
	private JLabel jLtuMano = null;
	private JTextField jTFtuMano = null;
	private JScrollPane jSPtuMano = null;

	/**
	 * This is the default constructor
	 */
	public JpanelJuego() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		eligeJuego();
		primerTurno = true;
		baraja = (BarajaMostrable) juego.getBaraja();
		jLtuMano = new JLabel();
		jLtuMano.setBounds(new Rectangle(209, 178, 55, 14));
		jLtuMano.setText("Tu mano:");
		jLhastaLim = new JLabel();
		jLhastaLim.setBounds(new Rectangle(350, 130, 62, 14));
		jLhastaLim.setText("hasta " + juego.getLimite() + ":");
		jLtuScore = new JLabel();
		jLtuScore.setBounds(new Rectangle(210, 130, 86, 14));
		jLtuScore.setText("Tu puntuación:");
		jLinfJugdr = new JLabel();
		jLinfJugdr.setBounds(new Rectangle(195, 100, 160, 14));
		jLinfJugdr.setText("Información sobre jugador:");
		jLlog = new JLabel();
		jLlog.setBounds(new Rectangle(195, 100, 32, 15));
		jLlog.setText("Log:");
		jLresult = new JLabel();
		jLresult.setBounds(new Rectangle(195, 8, 74, 15));
		jLresult.setText("Resultados:");
		jLmano = new JLabel();
		jLmano.setBounds(new Rectangle(105, 136, 80, 14));
		jLmano.setText("En mano:");
		jLpila = new JLabel();
		jLpila.setBounds(new Rectangle(16, 136, 80, 14));
		jLpila.setText("Quedan:");
		jLturno = new JLabel();
		jLturno.setBounds(new Rectangle(16, 176, 80, 14));
		jLturno.setText("Turno de:");
		jLimgMano = new JLabel();
		jLimgMano.setBounds(new Rectangle(105, 3, 80, 130));
		jLimgPila = new JLabel();
		jLimgPila.setBounds(new Rectangle(16, 3, 80, 130));
		jLimgPila.setIcon(baraja.getReverso());
		jLlog.setVisible(false);
		this.setSize(490, 220);
		this.setLayout(null);
		this.add(getJSPlog(), null);
		this.add(getJBpedirCarta(), null);
		this.add(getJTFresto(), null);
		this.add(jLimgPila, null);
		this.add(jLimgMano, null);
		this.add(getJTFmano(), null);
		this.add(getJTFturno(), null);
		this.add(jLturno, null);
		this.add(jLpila, null);
		this.add(jLmano, null);
		this.add(getJBplantarse(), null);
		this.add(getJSPresult(), null);
		this.add(jLresult, null);
		this.add(jLlog, null);
		this.add(jLinfJugdr, null);
		this.add(jLtuScore, null);
		this.add(jLhastaLim, null);
		this.add(getJTFtuScore(), null);
		this.add(getJTFhastaLim(), null);
		this.add(jLtuMano, null);
		this.add(getJSPtuMano(), null);
	}

	/**
	 * This method initializes jTAresults
	 * 
	 * @return javax.swing.JTextArea
	 */
	JTextArea getJTAlog() {
		if (jTAlog == null) {
			jTAlog = new JTextArea();
			jTAlog.setEditable(false);
		}
		return jTAlog;
	}

	/**
	 * This method initializes jSPresults
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPlog() {
		if (jSPlog == null) {
			jSPlog = new JScrollPane();
			jSPlog.setBounds(new Rectangle(230, 115, 220, 90));
			jSPlog.setViewportView(getJTAlog());
			jSPlog.setVisible(false);
		}
		return jSPlog;
	}

	/**
	 * This method initializes jBpedirCarta
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBpedirCarta() {
		if (jBpedirCarta == null) {
			jBpedirCarta = new JButton();
			jBpedirCarta.setBounds(new Rectangle(105, 176, 80, 20));
			jBpedirCarta.setText("Carta");
			jBpedirCarta.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					operacionesSacarCarta();
				}
			});
		}
		return jBpedirCarta;
	}

	/**
	 * This method initializes jTFturno
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFresto() {
		if (jTFpila == null) {
			jTFpila = new JTextField();
			jTFpila.setBounds(new Rectangle(16, 152, 80, 20));
			jTFpila.setEditable(false);
			jTFpila.setText(String.valueOf((juego.getNCartasRestantes()))
					+ " cartas");

		}
		return jTFpila;
	}

	/**
	 * This method initializes jTFcarta
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFmano() {
		if (jTFmano == null) {
			jTFmano = new JTextField();
			jTFmano.setBounds(new Rectangle(105, 152, 80, 20));
			jTFmano.setEditable(false);
		}
		return jTFmano;
	}

	/**
	 * This method initializes jTFturno
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFturno() {
		if (jTFturno == null) {
			jTFturno = new JTextField();
			jTFturno.setBounds(new Rectangle(16, 198, 80, 20));
			jTFturno.setEditable(false);
			jTFturno.setText((juego.getJugadorActual()).getNombre());
		}

		return jTFturno;
	}

	/**
	 * This method initializes jBplantarse
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBplantarse() {
		if (jBplantarse == null) {
			jBplantarse = new JButton();
			jBplantarse.setBounds(new Rectangle(100, 198, 90, 20));
			jBplantarse.setText("Me planto");
			jBplantarse.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					operacionesPlantarse();
				}
			});
		}
		return jBplantarse;
	}

	/**
	 * This method initializes jTFtuScore
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFtuScore() {
		if (jTFtuScore == null) {
			jTFtuScore = new JTextField();
			jTFtuScore.setBounds(new Rectangle(305, 128, 30, 20));
			jTFtuScore.setEditable(false);
			jTFtuScore.setText("0");
		}
		return jTFtuScore;
	}

	/**
	 * This method initializes jTFhastaLim
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFhastaLim() {
		if (jTFhastaLim == null) {
			jTFhastaLim = new JTextField();
			jTFhastaLim.setBounds(new Rectangle(420, 128, 30, 20));
			jTFhastaLim.setEditable(false);
			jTFhastaLim.setText(String.valueOf(juego.getLimite()));
		}
		return jTFhastaLim;
	}

	/**
	 * This method initializes jTFtuMano
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFtuMano() {
		if (jTFtuMano == null) {
			jTFtuMano = new JTextField();
			jTFtuMano.setEditable(false);
		}
		return jTFtuMano;
	}

	/**
	 * This method initializes jSPtuMano
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPtuMano() {
		if (jSPtuMano == null) {
			jSPtuMano = new JScrollPane();
			jSPtuMano.setBounds(new Rectangle(305, 162, 145, 40));
			jSPtuMano
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			jSPtuMano.setViewportView(getJTFtuMano());
		}
		return jSPtuMano;
	}

	/**
	 * This method initializes jTAresult
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTAresult() {
		if (jTAresult == null) {
			jTAresult = new JTextArea();
			jTAresult.setEditable(false);
		}
		return jTAresult;
	}

	/**
	 * This method initializes jSPresult
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPresult() {
		if (jSPresult == null) {
			jSPresult = new JScrollPane();
			jSPresult.setBounds(new Rectangle(230, 30, 220, 70));
			jSPresult.setViewportView(getJTAresult());
		}
		return jSPresult;
	}

	/**
	 * Metodo base que realiza las operaciones de sacar carta
	 */
	private void operacionesSacarCarta() {
		try {
			if (primerTurno) {
				primerTurno = false;
				Carta[] mano1 = juego.empezarTurno();
				for (int i = 0; i < mano1.length; i++)
					realizarMano(mano1[i]);
			} else {

				Carta actual = juego.sacarCarta();
				realizarMano(actual);
			}
		} catch (NoHayMasCartasException e1) {
			jLimgPila.setIcon(baraja.getVacia());
			finalizarPartida(e1.getMessage());
		}
	}

	/**
	 * Metodo que realiza las operaciones de plantarse
	 */
	private void operacionesPlantarse() {
		primerTurno = true;
		Jugador actual = juego.getJugadorActual();
		actual.setPlantado(true);
		jTAresult.setText(jTAresult.getText() + actual.getNombre()
				+ " se plantó tras " + actual.getMano().size() + " cartas con "
				+ actual.getMano().get(0) + "\n");
		if (actual.isPasado())
			JOptionPane.showMessageDialog(this, actual + " se paso",
					"Turno acabado", JOptionPane.INFORMATION_MESSAGE);
		try {
			juego.nextJugador();
			actual = juego.getJugadorActual();
			actualizarCampos(actual, null);
			jTFturno.setText(actual.getNombre());
			jTFmano.setText("");
		} catch (AllPlayersPlantadosException e1) {
			finalizarPartida(e1.getMessage());
		}
	}

	/**
	 * Metodo que opera con la carta actual de la jugada
	 * 
	 * @param actual
	 *            la carta actual
	 */
	private void realizarMano(Carta actual) {
		jTFmano.setText(actual.toString());
		jTFpila.setText(String.valueOf((juego.getNCartasRestantes()))
				+ " cartas");
		// por aki meter control de up o down
		if (true) {
			;// tapulsadoMostrarDown
			// poner bocabajo esta carta carta.flip();
			// poner boca arriba resto cartas jug.invertirCartas();
		}
		boolean pasado = juego.actualizarJugador(actual);
		Jugador jug = juego.getJugadorActual();
		actualizarCampos(jug, actual);
		if (pasado)
			operacionesPlantarse();
	}

	/**
	 * Metodo que finaliza la partida mostrando informacion
	 * 
	 * @param info
	 *            motivo de fin
	 */
	private void finalizarPartida(String info) {
		Jugador ganador = juego.finalizarPartida();
		if (ganador == null) {
			JOptionPane.showMessageDialog(this, "No ha ganado nadie!\n" + info
					+ "\n¡Revisa el log para comprobar los resultados!",
					"Juego acabado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Ha ganado: " + ganador + "\n"
					+ info + "\n¡Revisa el log para comprobar los resultados!",
					"Juego acabado", JOptionPane.INFORMATION_MESSAGE);
		}
		jLimgMano.setIcon(null);
		jTFturno.setText("nadie");
		zonaBotonesSetEnabled(false);
		zonaInfoJugSetVisible(false);
		zonaLogSetVisible(true);
	}

	/**
	 * Metodo que actualiza los campos del panel en funcion de jug y carta
	 * 
	 * @param jug
	 *            el jugador actual
	 * @param carta
	 *            la carta actual
	 */
	private void actualizarCampos(Jugador jug, Carta carta) {
		if (carta != null) {
			CartaMostrable cartaMuestra = (CartaMostrable) carta;
			if (cartaMuestra.getImgCarta() != null)
				jLimgMano.setIcon(cartaMuestra.getImgCarta());
			else
				jLimgMano.setIcon(baraja.getReverso());// estara boca abajo
			jTAlog.setText(jTAlog.getText() + jug + " sacó " + carta + "\n");
		} else
			jLimgMano.setIcon(null);
		jTFtuScore.setText(String.valueOf(jug.getPuntuacion()));
		jTFhastaLim.setText(String.valueOf(juego.getLimite()
				- jug.getPuntuacion()));
		jTFtuMano.setText(jug.getMano().toString());
	}

	private void zonaLogSetVisible(boolean b) {
		jSPlog.setVisible(b);
		jLlog.setVisible(b);
	}

	private void zonaInfoJugSetVisible(boolean b) {
		jLtuMano.setVisible(b);
		jLtuScore.setVisible(b);
		jLhastaLim.setVisible(b);
		jLinfJugdr.setVisible(b);
		jTFhastaLim.setVisible(b);
		jTFtuMano.setVisible(b);
		jTFtuScore.setVisible(b);
	}

	private void zonaBotonesSetEnabled(boolean b) {
		jBpedirCarta.setEnabled(b);
		jBplantarse.setEnabled(b);
	}

	private void resetearZonaCartas() {
		jTFpila.setText(String.valueOf((juego.getNCartasRestantes()))
				+ " cartas");
		jTFturno.setText((juego.getJugadorActual()).getNombre());
		jTFmano.setText("");
		jLimgMano.setIcon(null);
		BarajaMostrable baraja = (BarajaMostrable) juego.getBaraja();
		jLimgPila.setIcon(baraja.getReverso());
	}

	private void resetearzonaInfoJug() {
		jTFtuScore.setText(String.valueOf(0.0f));
		jTFhastaLim.setText(String.valueOf(juego.getLimite()));
		jLhastaLim.setText("hasta " + juego.getLimite() + ":");
		jTFtuMano.setText(null);
	}

	/**
	 * Metodo que reinicia el juego
	 */
	void reiniciarJuego() {
		juego.empezarPartida();
		resetearZonaCartas();
		resetearzonaInfoJug();
		zonaBotonesSetEnabled(true);
		zonaLogSetVisible(false);
		zonaInfoJugSetVisible(true);
		jTAlog.setText("");
		jTAresult.setText("");
	}

	/**
	 * Metodo para elegir juego
	 */
	void eligeJuego() {
		// uso JOptionPane para seleccion filtrada de de
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el tipo de juego", "Tipo de juego",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades,
				"Siete y Medio");

		if ((s == null) | s.equals("Siete y Medio"))
			juego = new SieteyMedioVisual(jugadores);
		else
			juego = new VeintiunoVisual(jugadores);
	}
}
