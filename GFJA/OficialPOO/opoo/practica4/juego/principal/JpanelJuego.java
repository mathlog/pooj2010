//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego del Siete y medio
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.principal;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
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
 * Clase visual para la pantalla de juego para el Siete y medio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 25.09.2010
 */
public class JpanelJuego extends JPanel {

	private Juego juego = null;
	private Object[] posibilidades = { "Siete y Medio", "Veintiuno" };
	Jugador[] jugadores = { new Jugador("Jugador"), new Jugador("BANCA") };

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
		jLtuMano = new JLabel();
		jLtuMano.setBounds(new Rectangle(209, 178, 55, 14));
		jLtuMano.setText("Tu mano:");
		jLhastaLim = new JLabel();
		jLhastaLim.setBounds(new Rectangle(350, 130, 59, 14));
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
		BarajaMostrable baraja = (BarajaMostrable) juego.getBaraja();
		jLimgPila.setIcon(baraja.getReverso());
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
		jLlog.setVisible(false);
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
			jSPlog.setBounds(new Rectangle(230, 115, 220, 95));
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
					Carta actual = null;
					try {
						actual = juego.sacarCarta();
					} catch (NoHayMasCartasException e1) {
						BarajaMostrable baraja = (BarajaMostrable) juego
								.getBaraja();
						jLimgPila.setIcon(baraja.getVacia());
						finalizarPartida(e1.getMessage());
					}
					jTFmano.setText(actual.toString());
					jTFpila.setText(String
							.valueOf((juego.getNCartasRestantes()))
							+ " cartas");
					juego.actualizarJugador(actual);
					Jugador jug = juego.getJugadorActual();
					actualizarCampos(jug, actual);

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
					Jugador actual = juego.getJugadorActual();
					actual.setPlantado(true);
					jTAresult.setText(jTAresult.getText() + actual.getNombre()
							+ " se plantó tras " + actual.getMano().size()
							+ " cartas con " + actual.getMano().get(0) + "\n");
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
			});
		}
		return jBplantarse;
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
			jSPresult.setBounds(new Rectangle(230, 30, 220, 60));
			jSPresult.setViewportView(getJTAresult());
		}
		return jSPresult;
	}

	private void finalizarPartida(String info) {
		Jugador ganador = juego.finalizarPartida();
		if (ganador == null) {
			JOptionPane
					.showMessageDialog(
							this,
							"No ha ganado nadie, inutiles!\n"
									+ info
									+ "\n¡Revisa el log para comprobar los resultados!",
							"Juego acabado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Ha ganado: " + ganador + "\n"
					+ info + "\n¡Revisa el log para comprobar los resultados!",
					"Juego acabado", JOptionPane.INFORMATION_MESSAGE);
		}
		jSPlog.setVisible(true);
		jLlog.setVisible(true);
		jTFturno.setText("nadie");
		jBpedirCarta.setEnabled(false);
		jBplantarse.setEnabled(false);
		jLtuMano.setVisible(false);
		jLtuScore.setVisible(false);
		jLhastaLim.setVisible(false);
		jLinfJugdr.setVisible(false);
		jTFhastaLim.setVisible(false);
		jTFtuMano.setVisible(false);
		jTFtuScore.setVisible(false);
	}

	void reiniciarJuego() {
		juego.reiniciarPartida();
		jTFpila.setText(String.valueOf((juego.getNCartasRestantes()))
				+ " cartas");
		jTFturno.setText((juego.getJugadorActual()).getNombre());
		jTFmano.setText("");
		jLimgMano.setIcon(null);
		jLimgPila.setIcon(new ImageIcon(getClass().getResource(
				"/com/poo/proyecto/imgs/Reverso.jpg")));
		jTAlog.setText("");
		jTAresult.setText("");
		jBpedirCarta.setEnabled(true);
		jBplantarse.setEnabled(true);
		jSPlog.setVisible(false);
		jLlog.setVisible(false);
		jLtuMano.setVisible(true);
		jLtuScore.setVisible(true);
		jLhastaLim.setVisible(true);
		jLinfJugdr.setVisible(true);
		jTFhastaLim.setVisible(true);
		jTFtuMano.setVisible(true);
		jTFtuScore.setVisible(true);
		jTFtuScore.setText(String.valueOf(0.0f));
		jTFhastaLim.setText(String.valueOf(7.5f));
		jTFtuMano.setText(null);
	}

	private void actualizarCampos(Jugador jug, Carta carta) {
		if (carta != null) {
			CartaMostrable cartaMuestra = (CartaMostrable) carta;
			jLimgMano.setIcon(cartaMuestra.getImgCarta());
			jTAlog.setText(jTAlog.getText() + jug + " sacó " + carta + "\n");
		} else
			jLimgMano.setIcon(null);
		jTFtuScore.setText(String.valueOf(jug.getPuntuacion()));
		jTFhastaLim.setText(String.valueOf(juego.getLimite()
				- jug.getPuntuacion()));
		jTFtuMano.setText(jug.getMano().toString());
	}

	private void eligeJuego() {
		// uso JOptionPane para seleccion filtrada de de
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el tipo de juego", "Numero de piezas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades,
				"Siete y Medio");
		if(s==null)
				juego = new SieteyMedioVisual(jugadores);
		else if (s.equals("Siete y Medio"))
			juego = new SieteyMedioVisual(jugadores);
		else
			juego = new VeintiunoVisual(jugadores);
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
}
