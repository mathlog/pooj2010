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
import javax.swing.JComboBox;
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
import opoo.practica5.juego.ParesNones;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.clasePN;
import opoo.practica5.juego.enumPN;

/**
 * Clase visual para la pantalla del juego de Pares Nones
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 05.12.2010
 */
public class JPanelPN extends JPanel {

	private Object[] dedos = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10" };
	private JuegoM juego;
	private Respuesta respuesta = null; // @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JLabel jLmostrar = null;
	private JLabel jLelige = null;
	private JLabel jLresult = null;
	private JLabel jLinf = null;
	private JLabel jLtuScore = null;
	private JLabel jLhastaLim = null;
	private JLabel jLtuMano = null;
	private JLabel jLdedos = null;
	private JTextArea jTAtuScores = null;
	private JScrollPane jSPtuScores = null;
	private JTextArea jTAresult = null;
	private JScrollPane jSPresult = null;
	private JTextField jTFrondaActual = null;
	private JTextField jTFhastaLimRonda = null;
	private JComboBox jCBdedos = null;
	private JButton jBjugar = null;
	private JRadioButton jRBpares = null;
	private JRadioButton jRBnones = null;
	private ButtonGroup group = null; // @jve:decl-index=0:

	public void setJuego(JuegoM juego) {
		this.juego = juego;

	}

	/**
	 * This is the default constructor
	 */
	public JPanelPN(JuegoM juego) {
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

		jLdedos = new JLabel();
		jLdedos.setBounds(new Rectangle(155, 8, 50, 14));
		jLdedos.setText("¿Dedos?");
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
		jLresult.setBounds(new Rectangle(220, 8, 74, 15));
		jLresult.setText("Resultados:");
		jLelige = new JLabel();
		jLelige.setBounds(new Rectangle(13, 8, 95, 14));
		jLelige.setText("Elige tu apuesta:");
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
		this.add(jLdedos);

		this.add(getJSPtuScores());
		this.add(getJSPresult());

		this.add(getJTFrondaActual());
		this.add(getJTFhastaLimRonda());

		this.add(getJBjugar());
		this.add(getJRBpares());
		this.add(getJRBnones());
		this.add(getJCBdedos());
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
			jTFhastaLimRonda.setBounds(new Rectangle(196, 100, 38, 20));
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
			jSPtuScores.setBounds(new Rectangle(85, 123, 150, 46));
			jSPtuScores.setViewportView(getJTAtuScores());
			jSPtuScores.setVisible(true);
		}
		return jSPtuScores;
	}

	/**
	 * This method initializes jCBdedos
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJCBdedos() {
		if (jCBdedos == null) {
			jCBdedos = new JComboBox(dedos);
			jCBdedos.setEditable(false);
			jCBdedos.setBounds(new Rectangle(158, 25, 45, 21));

		}
		return jCBdedos;
	}

	/**
	 * This method initializes group
	 * 
	 * @return javax.swing.ButtonGroup
	 */
	private ButtonGroup getBgroup() {
		if (group == null) {
			group = new ButtonGroup();
			group.add(getJRBpares());
			group.add(getJRBnones());
		}
		return group;
	}

	/**
	 * This method initializes jRBpares
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBpares() {
		if (jRBpares == null) {
			jRBpares = new JRadioButton();
			jRBpares.setBounds(new Rectangle(13, 25, 60, 21));
			jRBpares.setText("Pares");
			jRBpares.setSelected(true);
			respuesta = new clasePN(enumPN.PARES);
			jRBpares.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new clasePN(enumPN.PARES);
				}
			});
		}
		return jRBpares;
	}

	/**
	 * This method initializes jRBnones
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private JRadioButton getJRBnones() {
		if (jRBnones == null) {
			jRBnones = new JRadioButton();
			jRBnones.setBounds(new Rectangle(70, 25, 64, 21));
			jRBnones.setText("Nones");
			jRBnones.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					respuesta = new clasePN(enumPN.NONES);
				}
			});
		}
		return jRBnones;
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
		if (!nDedosToResp())
			return;
		juego.actualizarJugadores(respuesta);
		JugadorM[] ganadores;
		try {
			ganadores = juego.finalizarRonda();
			if (ganadores.length == 1) {
				escribirRonda();
				mostrarGanadorRonda(ganadores[0]);
			} else {
				escribirRonda();
				mostrarGanadoresRonda(ganadores);
			}
			if (juego.finalizarJuegoJugadoresActivos())
				FINsolo1jugador();
			juego.nextRonda();
		} catch (AllRondasCompleteException e) {
			FINtotalRondasAlcanzadas(e);
		}
		//jBjugar.requestFocus();
	}

	/**
	 * Metodo que pasa el numero de dedos a la respuesta
	 */
	private boolean nDedosToResp() {
		String dedos = (String) jCBdedos.getSelectedItem();
		if (dedos.equals("") || (dedos == null)) {
			JOptionPane.showMessageDialog(this,
					"Introduce numero de dedos en el cuadro combinado",
					"¡FALTAN DATOS!", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			int nDedos = Integer.parseInt(dedos);
			clasePN aux = (clasePN) respuesta;
			aux.setNDedos(nDedos);
			return true;
		}
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private void escribirRonda() {
		ParesNones pn = (ParesNones) juego;
		StringBuilder sb = new StringBuilder("Ronda: " + juego.getNRonda()
				+ "\n");
		sb.append("Total de dedos: " + pn.getTotalDedos() + " -> " + pn.getPn()
				+ "\n");
		for (JugadorM a : juego.getJugadores()) {
			sb.append(a + "\n");
			if (a.isHumano() && !a.isMarcado())
				jTAtuScores.setText(jTAtuScores.getText() + juego.getNRonda()
						+ ": " + a.getRespuesta() + "\n");
		}
		jTAresult.setText(jTAresult.getText() + sb.toString() + "\n");
		jTFrondaActual.setText(String.valueOf(juego.getNRonda() + 1));
	}

	/**
	 * Muestra ganador de ronda
	 * 
	 * @param ganador
	 *            el ganador
	 */
	private void mostrarGanadorRonda(JugadorM ganador) {
		JOptionPane.showMessageDialog(this, "Ha ganado:\n" + ganador, "¡RONDA "
				+ juego.getNRonda() + " ACABADA!",
				JOptionPane.INFORMATION_MESSAGE);
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
		JOptionPane.showMessageDialog(this, "Han ganado:\n" + strWins,
				"¡RONDA " + juego.getNRonda() + " ACABADA!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Metodo que finaliza la partida por 1 solo jugador restante
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
	 * 
	 * @param e1
	 *            la excepcion de rondas
	 */
	private void FINtotalRondasAlcanzadas(Exception e) {
		deshabilitarBotones();
		JOptionPane.showMessageDialog(this, e.getMessage()
				+ "\nSi nadie gano mala suerte", "¡FIN DE JUEGO!",
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
}