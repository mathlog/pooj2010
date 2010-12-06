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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import opoo.excepciones.AllRondasCompleteException;
import opoo.practica5.juego.JuegoM;
import opoo.practica5.juego.JugadorM;
import opoo.practica5.juego.Morra;
import opoo.practica5.juego.Respuesta;
import opoo.practica5.juego.claseMorra;

/**
 * Clase visual para la pantalla del juego de la Morra
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 06.12.2010
 */
public class JPanelMorra extends JPanel {

	private Object[] totalDedos = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private Object[] tusDedos = { "1", "2", "3", "4", "5" };
	private JuegoM juego; // @jve:decl-index=0:
	private Respuesta respuesta = null; // @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JLabel jLmostrar = null;
	private JLabel jLelige = null;
	private JLabel jLresult = null;
	private JLabel jLinf = null;
	private JLabel jLtuScore = null;
	private JLabel jLhastaLim = null;
	private JLabel jLtuMano = null;
	private JLabel jLtotalDedos = null;
	private JTextArea jTAtuScores = null;
	private JScrollPane jSPtuScores = null;
	private JTextArea jTAresult = null;
	private JScrollPane jSPresult = null;
	private JTextField jTFrondaActual = null;
	private JTextField jTFhastaLimRonda = null;
	private JTextField jTFtotalDedos = null;
	private JComboBox jCBtotalDedos = null;
	private JComboBox jCBtusDedos = null;
	private JButton jBjugar = null;

	public void setJuego(JuegoM juego) {
		this.juego = juego;

	}

	/**
	 * This is the default constructor
	 */
	public JPanelMorra(JuegoM juego) {
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
		jLtotalDedos = new JLabel();
		jLtotalDedos.setBounds(new Rectangle(115, 8, 100, 14));
		jLtotalDedos.setText("¿Total de Dedos?");
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
		jLelige.setBounds(new Rectangle(13, 8, 95, 14));
		jLelige.setText("Elige tus dedos:");
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
		this.add(jLtotalDedos);

		this.add(getJSPtuScores());
		this.add(getJSPresult());

		this.add(getJTFrondaActual());
		this.add(getJTFhastaLimRonda());
		this.add(getJTFTotalDedos());

		this.add(getJBjugar());
		this.add(getJCBtotalDedos());
		this.add(getJCBtusDedos());
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
	 * This method initializes jTFtotalDedos	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTFTotalDedos() {
		if (jTFtotalDedos == null) {
			jTFtotalDedos = new JTextField();
			jTFtotalDedos.setBounds(new Rectangle(150, 25, 28, 21));
		}
		return jTFtotalDedos;
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
		}
		return jSPtuScores;
	}

	/**
	 * This method initializes jCBtotalDedos
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJCBtotalDedos() {
		if (jCBtotalDedos == null) {
			jCBtotalDedos = new JComboBox(totalDedos);
			jCBtotalDedos.setEditable(false);
			jCBtotalDedos.setBounds(new Rectangle(158, 25, 45, 21));
			jCBtotalDedos.setEnabled(false);
			jCBtotalDedos.setVisible(false);
		}
		return jCBtotalDedos;
	}

	/**
	 * This method initializes jCBtusDedos
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJCBtusDedos() {
		if (jCBtusDedos == null) {
			jCBtusDedos = new JComboBox(tusDedos);
			jCBtusDedos.setEditable(false);
			jCBtusDedos.setBounds(new Rectangle(50, 25, 45, 21));
		}
		return jCBtusDedos;
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
			if (juego.finalizarJuegoJugadoresActivos()) {
				escribirRonda(true);
				mostrarGanadorRonda(ganadores[0]);
				FINsolo1jugador();
				juego.nextRonda();
			} else if (ganadores.length == 0) {
				escribirRonda(false);
				mostrarEmpateRonda();
			} else {
				escribirRonda(true);
				mostrarGanadorRonda(ganadores[0]);
				juego.nextRonda();
			}
		} catch (AllRondasCompleteException e) {
			FINtotalRondasAlcanzadas(e);
		}
		//jBjugar.requestFocus();
	}

	/**
	 * Metodo que pasa el numero de tusDedos a la respuesta
	 */
	private boolean nDedosToResp() {
		//String totalDedos = (String) jCBtotalDedos.getSelectedItem();
		String totalDedos = (String) jTFtotalDedos.getText();
		String tusDedos = (String) jCBtusDedos.getSelectedItem();
		if ((totalDedos.equals("")) || (totalDedos == null)
				|| (tusDedos.equals("")) || (tusDedos == null)) {
			JOptionPane.showMessageDialog(this,
					"Introduce numero de dedos en el cuadro combinado",
					"¡FALTAN DATOS!", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			int nTotalDedos = Integer.parseInt(totalDedos);
			int nTusDedos = Integer.parseInt(tusDedos);
			respuesta = new claseMorra(nTusDedos, nTotalDedos);
			return true;
		}
	}

	/**
	 * Escribe los datos de la ronda en los jTA
	 */
	private void escribirRonda(boolean actual) {
		Morra morra = (Morra) juego;
		StringBuilder sb = new StringBuilder("Ronda: " + juego.getNRonda()
				+ "\n");
		sb.append("Total dedos: " + morra.getTotalDedos() + "\n");
		for (JugadorM a : juego.getJugadores()) {
			sb.append(a + "\n");
			if (a.isHumano() && !a.isMarcado())
				jTAtuScores.setText(jTAtuScores.getText() + juego.getNRonda()
						+ ". " + a.getRespuesta()
						/* + (a.isMarcado() ? " OUTGAME" : "") */+ "\n");
		}
		jTAresult.setText(jTAresult.getText() + sb.toString() + "\n");
		jTFrondaActual.setText(String.valueOf(juego.getNRonda()
				+ (actual ? 1 : 0)));
	}

	/**
	 * Muestra ganador de cada ronda
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
	 * Muestra que ha habido un empate
	 */
	private void mostrarEmpateRonda() {
		Morra morra = (Morra) juego;
		JOptionPane.showMessageDialog(this, "Se repite la ronda "
				+ juego.getNRonda() + " por que nadie acerto el total de "
				+ morra.getTotalDedos() + " dedos", "¡RONDA "
				+ juego.getNRonda() + " EMPATADA!",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Metodo que finaliza la partida
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
				+ "\nQuien no haya acertado nunca mala suerte",
				"¡FIN DE JUEGO!", JOptionPane.INFORMATION_MESSAGE);
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
