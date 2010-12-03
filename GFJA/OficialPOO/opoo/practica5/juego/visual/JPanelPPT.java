//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.visual;

import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import opoo.excepciones.AllRondasCompleteException;
import opoo.excepciones.PlayerGanadorException;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.tipoPPT;

/**
 * Clase visual para la pantalla del juego de piedra papel tijera
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 12.11.2010
 */
public class JPanelPPT extends JPanel {

	private JuegoM juego;
	private Respuesta respuesta = tipoPPT.PIEDRA;
	private static final long serialVersionUID = 1L;
	private JLabel jLmostrar = null;
	private JLabel jLelige = null;
	private JLabel jLresult = null;
	private JLabel jLinf = null;
	private JLabel jLtuScore = null;
	private JLabel jLhastaLim = null;
	private JLabel jLtuMano = null;
	private JTextArea jTAtuScores = null;
	private JScrollPane jSPtuScores = null;
	private JTextArea jTAresult = null;
	private JScrollPane jSPresult = null;
	private JTextField jTFrondaActual = null;
	private JTextField jTFhastaLimRonda = null;
	private JButton jBjugar = null;
	private JRadioButton jRBTijera = null;
	private JRadioButton jRBPiedra = null;
	private JRadioButton jRBPapel = null;
	private ButtonGroup group = null; // @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public JPanelPPT(JuegoM juego) {
		super();
		this.juego = juego;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		jLtuMano = new JLabel();
		jLtuMano.setBounds(new Rectangle(26, 159, 55, 14));
		jLtuMano.setText("Tu mano:");
		jLhastaLim = new JLabel();
		jLhastaLim.setBounds(new Rectangle(120, 129, 70, 14));
		jLhastaLim.setText("MaxRondas:");
		jLtuScore = new JLabel();
		jLtuScore.setBounds(new Rectangle(26, 129, 43, 14));
		jLtuScore.setText("Ronda:");
		jLinf = new JLabel();
		jLinf.setBounds(new Rectangle(13, 104, 160, 14));
		jLinf.setText("Información sobre jugador:");
		jLresult = new JLabel();
		jLresult.setBounds(new Rectangle(200, 8, 74, 15));
		jLresult.setText("Resultados:");
		jLelige = new JLabel();
		jLelige.setBounds(new Rectangle(13, 15, 34, 14));
		jLelige.setText("Elige:");
		jLmostrar = new JLabel();
		jLmostrar.setBounds(new Rectangle(13, 59, 96, 14));
		jLmostrar.setText("Mostrar manos:");

		this.setSize(490, 220);
		this.setLayout(null);

		this.add(jLtuMano, null);
		this.add(jLmostrar, null);
		this.add(jLelige, null);
		this.add(jLresult, null);
		this.add(jLinf, null);
		this.add(jLtuScore, null);
		this.add(jLhastaLim, null);

		this.add(getJSPlog(), null);
		this.add(getJSPresult(), null);

		this.add(getJTFrondaActual(), null);
		this.add(getJTFhastaLimRonda(), null);

		this.add(getJBjugar(), null);
		this.add(getJRBTijera(), null);
		this.add(getJRBPiedra(), null);
		this.add(getJRBPapel(), null);
		getBgroup();
	}

	/**
	 * This method initializes jTFrondaActual
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFrondaActual() {
		if (jTFrondaActual == null) {
			jTFrondaActual = new JTextField();
			jTFrondaActual.setBounds(new Rectangle(75, 129, 30, 20));
			jTFrondaActual.setEditable(false);
			jTFrondaActual.setText(String.valueOf(juego.getNRonda()));
		}
		return jTFrondaActual;
	}

	/**
	 * This method initializes jTFhastaLimRonda
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFhastaLimRonda() {
		if (jTFhastaLimRonda == null) {
			jTFhastaLimRonda = new JTextField();
			jTFhastaLimRonda.setBounds(new Rectangle(195, 129, 30, 20));
			jTFhastaLimRonda.setEditable(false);
			jTFhastaLimRonda.setText(String.valueOf(juego.getNMAXrondas()));
		}
		return jTFhastaLimRonda;
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
			jSPresult.setBounds(new Rectangle(240, 30, 220, 180));
			jSPresult.setViewportView(getJTAresult());
		}
		return jSPresult;
	}

	/**
	 * This method initializes jTAtuScores
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTAtuScores() {
		if (jTAtuScores == null) {
			jTAtuScores = new JTextArea();
			jTAtuScores.setEditable(false);
		}
		return jTAtuScores;
	}

	/**
	 * This method initializes jSPtuScores
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJSPlog() {
		if (jSPtuScores == null) {
			jSPtuScores = new JScrollPane();
			jSPtuScores.setBounds(new Rectangle(85, 160, 138, 51));
			jSPtuScores.setViewportView(getJTAtuScores());
			jSPtuScores.setVisible(true);
		}
		return jSPtuScores;
	}

	/**
	 * This method initializes jBjugar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBjugar() {
		if (jBjugar == null) {
			jBjugar = new JButton();
			jBjugar.setBounds(new Rectangle(114, 59, 80, 20));
			jBjugar.setText("Mostrar");
			jBjugar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					juego.actualizarJugadores(respuesta);
					JugadorM[] ganadores;
					try {
						ganadores = juego.finalizarRonda();
						escribirRonda();
						mostrarGanadoresRonda(ganadores);
					} catch (AllRondasCompleteException e1) {
						FINtotalRondasAlcanzadas();
					} catch (PlayerGanadorException e1) {
						FINhayGanador(e1.getGanador());
					}
					// -poner valores a jugadores
					// -pal jugador humano la k ha sacao
					// -pal resto aleatorios
					// -despues de haber calculao
					// -mostrar la jugada de cada uno
					// -y decir kien se keda fuera y kien no
					// -despues seguir con las siguientes rondas
					// -hasta k solo kede 1
				}

			});
		}
		return jBjugar;
	}

	/**
	 * This method initializes jRBTijera
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBTijera() {
		if (jRBTijera == null) {
			jRBTijera = new JRadioButton();
			jRBTijera.setBounds(new Rectangle(131, 35, 60, 21));
			jRBTijera.setText("Tijera");
			jRBTijera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = tipoPPT.TIJERA;
				}
			});
		}
		return jRBTijera;
	}

	/**
	 * This method initializes jRBPiedra
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBPiedra() {
		if (group == null) {
			jRBPiedra = new JRadioButton();
			jRBPiedra.setBounds(new Rectangle(13, 35, 64, 21));
			jRBPiedra.setText("Piedra");
			jRBPiedra.setSelected(true);
			jRBPiedra.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = tipoPPT.PIEDRA;
				}
			});
		}
		return jRBPiedra;
	}

	/**
	 * This method initializes jRBPapel
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBPapel() {
		if (jRBPapel == null) {
			jRBPapel = new JRadioButton();
			jRBPapel.setBounds(new Rectangle(75, 35, 57, 21));
			jRBPapel.setText("Papel");
			jRBPapel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = tipoPPT.PAPEL;
				}
			});
		}
		return jRBPapel;
	}

	/**
	 * This method initializes group
	 * 
	 * @return javax.swing.ButtonGroup
	 */
	private ButtonGroup getBgroup() {
		if (group == null) {
			group = new ButtonGroup();
			group.add(getJRBTijera());
			group.add(getJRBPiedra());
			group.add(getJRBPapel());

		}
		return group;
	}

	/**
	 * Metodo que finaliza la partida habiendo un ganador
	 * 
	 * @param ganador
	 *            el ganador
	 */
	private void FINhayGanador(JugadorM ganador) {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, "Ha ganado: " + ganador,
				"¡HAY GANADOR!", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Metodo que finaliza la partida porque no quedan mas rondas
	 */
	private void FINtotalRondasAlcanzadas() {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, "Total de rondas alcanzado: "
				+ juego.getNMAXrondas() + " y no hay ganador",
				"¡No quedan mas rondas!", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Deshabilita botones
	 */
	private void deshabilitarBotones() {
		jBjugar.setEnabled(false);
	}

	/**
	 * Habilita botones
	 */
	private void habilitarBotones() {
		jBjugar.setEnabled(true);
	}

	/**
	 * Muestra ganadores de cada ronda
	 * 
	 * @param ganadores
	 *            los ganadores
	 */
	private void mostrarGanadoresRonda(JugadorM[] ganadores) {
		StringBuilder strWins = new StringBuilder();
		for (JugadorM a : ganadores)
			strWins.append(a + "\n");
		JOptionPane.showMessageDialog(this, "Siguen jugando: " + strWins
				+ "\n\n", "Ronda acabada", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private void escribirRonda() {
		StringBuilder sb = new StringBuilder("Ronda:" + juego.getNRonda()
				+ "\n");
		for (JugadorM a : juego.getJugadores()) {
			sb.append(a + "\n");
			if (a.isHumano())
				jTAtuScores.setText(jTAtuScores.getText() + "\n"
						+ juego.getNRonda() + ": " + a.getRespuesta());

		}
		jTAresult.setText(jTAresult.getText() + sb.toString());
		jTFrondaActual.setText(String.valueOf(juego.getNRonda()));
	}

	/**
	 * Metodo que reinicia el juego
	 */
	void reiniciarJuego() {
		juego.empezarPartida();
		jTAtuScores.setText("");
		jTAresult.setText("");

	}
} // @jve:decl-index=0:visual-constraint="10,12"
