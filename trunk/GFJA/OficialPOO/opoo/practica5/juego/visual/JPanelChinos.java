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
import opoo.practica5.juego.Chinos;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.claseChinos;
import opoo.practica5.juego.enumChinos;

/**
 * Clase visual para la pantalla del juego de los chinos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 04.12.2010
 */
public class JPanelChinos extends JPanel {

	private JuegoM juego;
	private Respuesta respuesta = null;
	private static final long serialVersionUID = 1L;
	private JLabel jLmostrar = null;
	private JLabel jLelige = null;
	private JLabel jLresult = null;
	private JLabel jLinf = null;
	private JLabel jLtuScore = null;
	private JLabel jLhastaLim = null;
	private JLabel jLtuMano = null;
	private JLabel jLnCoins = null;
	private JTextArea jTAtuScores = null;
	private JScrollPane jSPtuScores = null;
	private JTextArea jTAresult = null;
	private JScrollPane jSPresult = null;
	private JTextField jTFrondaActual = null;
	private JTextField jTFhastaLimRonda = null;
	private JTextField jTFnCoins = null;
	private JButton jBjugar = null;
	private JRadioButton jRBcero = null;
	private JRadioButton jRBuna = null;
	private JRadioButton jRBdos = null;
	private JRadioButton jRBtres = null;
	private ButtonGroup group = null; // @jve:decl-index=0:

	public void setJuego(JuegoM juego) {
		this.juego = juego;
	}

	/**
	 * This is the default constructor
	 */
	public JPanelChinos(JuegoM juego) {
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

		jLnCoins = new JLabel();
		jLnCoins.setBounds(new Rectangle(146, 8, 73, 16));
		jLnCoins.setText("¿nMonedas?");
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
		jLresult.setBounds(new Rectangle(240, 8, 74, 15));
		jLresult.setText("Resultados:");
		jLelige = new JLabel();
		jLelige.setBounds(new Rectangle(13, 8, 110, 14));
		jLelige.setText("Elige tus monedas:");
		jLmostrar = new JLabel();
		jLmostrar.setBounds(new Rectangle(13, 49, 96, 14));
		jLmostrar.setText("Mostrar manos:");

		this.setLayout(null);
		this.setSize(465, 175);
		this.setPreferredSize(new Dimension(465, 175));
		this.add(jLtuMano, null);
		this.add(jLmostrar, null);
		this.add(jLelige, null);
		this.add(jLresult, null);
		this.add(jLinf, null);
		this.add(jLtuScore, null);
		this.add(jLhastaLim, null);

		this.add(getJStuScores(), null);
		this.add(getJSPresult(), null);

		this.add(getJTFrondaActual(), null);
		this.add(getJTFhastaLimRonda(), null);

		this.add(getJBjugar(), null);
		this.add(getJRBcero(), null);
		this.add(getJRBuna(), null);
		this.add(getJRBdos(), null);
		this.add(getJRBtres(), null);
		this.add(getJTFnCoins(), null);
		this.add(jLnCoins, null);

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
	 * This method initializes jTFnCoins
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFnCoins() {
		if (jTFnCoins == null) {
			jTFnCoins = new JTextField();
			jTFnCoins.setBounds(new Rectangle(170, 25, 26, 20));
		}
		return jTFnCoins;
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
	private JScrollPane getJStuScores() {
		if (jSPtuScores == null) {
			jSPtuScores = new JScrollPane();
			jSPtuScores.setBounds(new Rectangle(85, 128, 138, 41));
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
			group.add(getJRBcero());
			group.add(getJRBuna());
			group.add(getJRBdos());
			group.add(getJRBtres());
		}
		return group;
	}

	/**
	 * This method initializes jRBcero
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBcero() {
		if (jRBcero == null) {
			jRBcero = new JRadioButton();
			jRBcero.setBounds(new Rectangle(13, 25, 34, 21));
			jRBcero.setText("0");
			jRBcero.setSelected(true);
			respuesta = new claseChinos(enumChinos.CERO);
			jRBcero.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new claseChinos(enumChinos.CERO);
				}
			});
		}
		return jRBcero;
	}

	/**
	 * This method initializes jRBuna
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBuna() {
		if (jRBuna == null) {
			jRBuna = new JRadioButton();
			jRBuna.setBounds(new Rectangle(43, 25, 34, 21));
			jRBuna.setText("1");
			jRBuna.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new claseChinos(enumChinos.UNA);
				}
			});
		}
		return jRBuna;
	}

	/**
	 * This method initializes jRBdos
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBdos() {
		if (jRBdos == null) {
			jRBdos = new JRadioButton();
			jRBdos.setBounds(new Rectangle(73, 25, 34, 21));
			jRBdos.setText("2");
			jRBdos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new claseChinos(enumChinos.DOS);
				}
			});
		}
		return jRBdos;
	}

	/**
	 * This method initializes jRBtres
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBtres() {
		if (jRBtres == null) {
			jRBtres = new JRadioButton();
			jRBtres.setBounds(new Rectangle(103, 25, 34, 21));
			jRBtres.setText("3");
			jRBtres.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new claseChinos(enumChinos.TRES);
				}
			});
		}
		return jRBtres;
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
		if (!nMonedasToResp())
			return;
		juego.actualizarJugadores(respuesta);
		JugadorM[] ganadores;
		try {
			ganadores = juego.finalizarRonda();
			if (ganadores == null) {
				FINsolo1jugador();
				juego.nextRonda();
			} else if (ganadores.length == 0) {
				mostrarEmpateRonda();
			} else {
				mostrarGanadorRonda(ganadores);
				juego.nextRonda();
			}
		} catch (AllRondasCompleteException e1) {
			FINtotalRondasAlcanzadas();
		}
		escribirRonda();
		jBjugar.requestFocus();

	}

	/**
	 * Metodo que pasa el numero de monedas a la respuesta
	 */
	private boolean nMonedasToResp() {
		String coins = jTFnCoins.getText();
		if (coins.equals("") || (coins == null)) {
			JOptionPane.showMessageDialog(this,
					"Introduce numero de monedas en el cuadro de texto",
					"¡FALTAN DATOS!", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			int nMonedas = Integer.parseInt(jTFnCoins.getText());
			claseChinos aux = (claseChinos) respuesta;
			aux.setNMonedas(nMonedas);
			return true;
		}
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private void escribirRonda() {
		Chinos chinos = (Chinos) juego;
		StringBuilder sb = new StringBuilder("Ronda:" + chinos.getNRonda()
				+ "\n");
		sb.append("Total Monedas:" + chinos.getTotalMonedas() + "\n");
		for (JugadorM a : chinos.getJugadores()) {
			sb.append(a + "\n");
			if (a.isHumano())
				jTAtuScores.setText(jTAtuScores.getText() + chinos.getNRonda()
						+ ": " + a.getRespuesta() + "\n");

		}
		jTAresult.setText(jTAresult.getText() + sb.toString() + "\n");
		jTFrondaActual.setText(String.valueOf(chinos.getNRonda()));
	}

	/**
	 * Muestra ganadores de cada ronda
	 * 
	 * @param ganadores
	 *            los ganadores
	 */
	private void mostrarGanadorRonda(JugadorM[] ganadores) {
		StringBuilder strWins = new StringBuilder();
		for (JugadorM a : ganadores)
			strWins.append("\t" + a + "\n");
		JOptionPane.showMessageDialog(this, "Ha ganado:\n" + strWins,
				"¡RONDA ACABADA!", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra que ha habido un empate
	 */
	private void mostrarEmpateRonda() {
		Chinos chinos = (Chinos) juego;
		JOptionPane.showMessageDialog(this, "Se repite la ronda "
				+ chinos.getNRonda() + " por que nadie acerto el total de "
				+ chinos.getTotalMonedas() + " monedas", "¡RONDA EMPATADA!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Metodo que finaliza la partida habiendo un ganador
	 */
	private void FINsolo1jugador() {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, "¡Solo queda 1 jugador!",
				"¡FIN DE JUEGO!", JOptionPane.INFORMATION_MESSAGE);
		jTAresult.setText(jTAresult.getText()
				+ "Fin de juego por solo 1 jugador\n");
	}

	/**
	 * Metodo que finaliza la partida porque no quedan mas rondas
	 */
	private void FINtotalRondasAlcanzadas() {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, "Total de rondas alcanzado: "
				+ juego.getNMAXrondas() + "\nQuien no haya acertado ¡¡PAGA!!",
				"¡FIN DE JUEGO!", JOptionPane.INFORMATION_MESSAGE);
		jTAresult.setText(jTAresult.getText()
				+ "Fin de juego por maxRondas alcanzadas: "
				+ juego.getNMAXrondas() + "\n");
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
		jTFnCoins.setText(null);
		habilitarBotones();

	}

} // @jve:decl-index=0:visual-constraint="10,12"
