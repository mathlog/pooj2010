//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Practica 5 Juego
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica5.juego.visual;

import java.awt.Dimension;
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
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.enumPPT;

/**
 * Clase visual para la pantalla del juego de piedra papel tijera
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 04.12.2010
 */
public class JPanelPPT extends JPanel {

	private JuegoM juego; // @jve:decl-index=0:
	private Respuesta respuesta = enumPPT.PIEDRA;
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

	public void setJuego(JuegoM juego) {
		this.juego = juego;

	}

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
		jLtuMano.setBounds(new Rectangle(27, 130, 55, 14));
		jLtuMano.setText("Tu mano:");
		jLhastaLim = new JLabel();
		jLhastaLim.setBounds(new Rectangle(121, 100, 70, 14));
		jLhastaLim.setText("MaxRondas:");
		jLtuScore = new JLabel();
		jLtuScore.setBounds(new Rectangle(27, 100, 43, 14));
		jLtuScore.setText("Ronda:");
		jLinf = new JLabel();
		jLinf.setBounds(new Rectangle(14, 75, 160, 14));
		jLinf.setText("Información sobre jugador:");
		jLresult = new JLabel();
		jLresult.setBounds(new Rectangle(200, 8, 74, 15));
		jLresult.setText("Resultados:");
		jLelige = new JLabel();
		jLelige.setBounds(new Rectangle(13, 8, 80, 14));
		jLelige.setText("Elige tu mano:");
		jLmostrar = new JLabel();
		jLmostrar.setBounds(new Rectangle(13, 49, 96, 14));
		jLmostrar.setText("Mostrar manos:");

		this.setLayout(null);
		this.setSize(465, 175);
		this.setPreferredSize(new Dimension(465, 175));
		this.add(jLtuMano);
		this.add(jLmostrar);
		this.add(jLelige);
		this.add(jLresult);
		this.add(jLinf);
		this.add(jLtuScore);
		this.add(jLhastaLim);

		this.add(getJSPtuScores());
		this.add(getJSPresult());

		this.add(getJTFrondaActual());
		this.add(getJTFhastaLimRonda());

		this.add(getJBjugar());
		this.add(getJRBTijera());
		this.add(getJRBPiedra());
		this.add(getJRBPapel());
		getBgroup();
		jBjugar.requestFocus();
	}

	/**
	 * This method initializes jTFrondaActual
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFrondaActual() {
		if (jTFrondaActual == null) {
			jTFrondaActual = new JTextField();
			jTFrondaActual.setBounds(new Rectangle(76, 100, 30, 20));
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
			jTFhastaLimRonda.setBounds(new Rectangle(196, 100, 30, 20));
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
			jSPresult.setBounds(new Rectangle(240, 30, 220, 140));
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
	private JScrollPane getJSPtuScores() {
		if (jSPtuScores == null) {
			jSPtuScores = new JScrollPane();
			jSPtuScores.setBounds(new Rectangle(85, 128, 141, 41));
			jSPtuScores.setViewportView(getJTAtuScores());
			jSPtuScores.setVisible(true);
		}
		return jSPtuScores;
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
	 * This method initializes jRBTijera
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBTijera() {
		if (jRBTijera == null) {
			jRBTijera = new JRadioButton();
			jRBTijera.setBounds(new Rectangle(131, 25, 60, 21));
			jRBTijera.setText("Tijera");
			jRBTijera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = enumPPT.TIJERA;
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
		if (jRBPiedra == null) {
			jRBPiedra = new JRadioButton();
			jRBPiedra.setBounds(new Rectangle(13, 25, 64, 21));
			jRBPiedra.setText("Piedra");
			jRBPiedra.setSelected(true);
			jRBPiedra.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = enumPPT.PIEDRA;
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
			jRBPapel.setBounds(new Rectangle(75, 25, 57, 21));
			jRBPapel.setText("Papel");
			jRBPapel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = enumPPT.PAPEL;
				}
			});
		}
		return jRBPapel;
	}

	/**
	 * This method initializes jBjugar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBjugar() {
		if (jBjugar == null) {
			jBjugar = new JButton();
			jBjugar.setBounds(new Rectangle(114, 49, 80, 20));
			jBjugar.setText("Mostrar");
			jBjugar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					operacionesJugar();
				}

			});
			jBjugar.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					operacionesJugar();
				}
			});
		}
		return jBjugar;
	}

	/**
	 * Metodo que realiza las operaciones de jugar
	 */
	private void operacionesJugar() {
		juego.actualizarJugadores(respuesta);
		JugadorM[] ganadores;
		try {
			int before = juego.getNJugadoresActivos();
			ganadores = juego.finalizarRonda();
			if (ganadores.length == 0) {
				escribirRonda(false);
				mostrarEmpateRonda();
			} else if (ganadores.length == before) {
				escribirRonda(false);
				mostrarEmpateRonda();
			} else if (ganadores.length == 1) {
				escribirRonda(true);
				FINhayGanador(ganadores[0]);
				juego.nextRonda();
			} else {
				mostrarGanadoresRonda(ganadores);
				escribirRonda(true);
				juego.nextRonda();
			}
		} catch (AllRondasCompleteException e) {
			FINtotalRondasAlcanzadas(e);
		}
		//jBjugar.requestFocus();
		// -poner valores a jugadores
		// -pal jugador humano la k ha sacao
		// -pal resto aleatorios
		// -despues de haber calculao
		// -mostrar la jugada de cada uno
		// -y decir kien se keda fuera y kien no
		// -despues seguir con las siguientes rondas
		// -hasta k solo kede 1
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private void escribirRonda(boolean actual) {
		StringBuilder sb = new StringBuilder("Ronda: " + juego.getNRonda()
				+ "\n");
		for (JugadorM a : juego.getJugadores()) {
			sb.append(a + "\n");
			if (a.isHumano())
				jTAtuScores.setText(jTAtuScores.getText() + "Ronda "
						+ juego.getNRonda() + ": " + a.getRespuesta() + "\n");
		}
		jTAresult.setText(jTAresult.getText() + sb.toString() + "\n");
		jTFrondaActual.setText(String.valueOf(juego.getNRonda()
				+ (actual ? 1 : 0)));
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
			strWins.append("\t" + a + "\n");
		JOptionPane.showMessageDialog(this, "Siguen jugando:\n" + strWins,
				"¡RONDA " + juego.getNRonda() + " ACABADA!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra que ha habido un empate
	 */
	private void mostrarEmpateRonda() {
		JOptionPane.showMessageDialog(this, "Se repite la ronda "
				+ juego.getNRonda(), "¡RONDA " + juego.getNRonda()
				+ " EMPATADA!", JOptionPane.INFORMATION_MESSAGE);

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
				"¡FIN DE JUEGO!", JOptionPane.INFORMATION_MESSAGE);
		jTAresult.setText(jTAresult.getText() + "Fin de juego por ganador: "
				+ ganador.getNombre() + "\n");
	}

	/**
	 * Metodo que finaliza la partida porque no quedan mas rondas
	 * 
	 * @param e
	 *            la excepcion de rondas
	 */
	private void FINtotalRondasAlcanzadas(Exception e) {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, e.getMessage(), "¡FIN DE JUEGO!",
				JOptionPane.INFORMATION_MESSAGE);
		jTAresult.setText(jTAresult.getText() + "Fin de juego por "
				+ e.getMessage());
	}

	/**
	 * Habilita botones
	 */
	private void habilitarBotones() {
		jBjugar.setEnabled(true);
	}

	/**
	 * Deshabilita botones
	 */
	private void deshabilitarBotones() {
		jBjugar.setEnabled(false);
	}

	/**
	 * Metodo que reinicia el juego
	 */
	void reiniciarJuego() {
		juego.empezarPartida();
		jTAtuScores.setText("");
		jTAresult.setText("");
		jTFrondaActual.setText(String.valueOf(juego.getNRonda()));
		habilitarBotones();
	}
} // @jve:decl-index=0:visual-constraint="10,12"
