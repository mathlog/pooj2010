//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Juego de las Nreinas
// ASIGNATURA : Programacion Orientada a Objetos
//
package poo.juegos.nReinas.visual;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import poo.juegos.nReinas.Nreinas;
import poo.juegos.nReinas.excepciones.BorradoReinaNoExisteException;

/**
 * Clase visual para el juego de las nReinass
 * 
 * @author José Ángel García Fernández
 * @version 1.0 07/10/2010
 */
public class VentanaNreinas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jCPbase = null;
	private JTextPane jTPtablero = null;
	private JTextField jTFfila = null;
	private JTextField jTFCol = null;
	private JButton jBadd = null;
	private JButton jBremove = null;
	private JPanel jPbajo = null;
	private JLabel jLX = null;
	private JLabel jLinfo = null;
	private JLabel jLnReinas = null;
	private JMenuBar jMenuPrincipal = null;
	private JMenu jMenu = null;
	private JMenuItem jMIReiniciar = null;
	private JMenuItem jMISalir = null;
	private JMenu jMAyuda = null;
	private JMenuItem jMIacerdade = null;
	private JMenuItem jMIcomoJugar = null;
	private JMenuItem jMIsolve = null;
	private JMenuItem jMInReinas = null;

	private Nreinas reinas = null; // @jve:decl-index=0:
	private int fila;
	private int col;
	private long time;
	private JDialogAcercade jdialogInfo = null;
	private JDialogComoJugar jdialogComoJugar = null;
	private Object[] posibilidades = { "4", "6", "8", "10", "12", "14", "16",
			"18", "20", "22", "24", "26" };

	/**
	 * This is the default constructor
	 */
	public VentanaNreinas() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		setResizable(false);
		setLayout(new FlowLayout());
		setContentPane(getJCPbase());
		this.setJMenuBar(getJmenuPrincipal());
		setTitle("Juego de las Nreinas");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						getClass().getResource(
								"/poo/juegos/nReinas/imgs/eldeorrr.jpg")));
		reinas = new Nreinas(8);
		refreshTablero();
		jdialogInfo = new JDialogAcercade(this, "Juego de las Nreinas", "1.0",
				"Jstyl_8", "http://jstyl8.net46.net",
				"/poo/juegos/nReinas/imgs/eldeorrr.jpg");
		jdialogComoJugar = new JDialogComoJugar(
				this,
				"El objetivo del juego es colocar n reinas en el tablero, sin que ninguna de ellas amenace a otra reina.",
				"Escribe las coordenadas en los cuadros de texto y luego añade o elimina reinas.");
		pack();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJCPbase() {
		if (jCPbase == null) {
			GridBagConstraints gridBagConstbajo = new GridBagConstraints();
			gridBagConstbajo.gridy = 1;
			gridBagConstbajo.gridx = 0;
			gridBagConstbajo.fill = GridBagConstraints.BOTH;
			GridBagConstraints gridBagConstTA = new GridBagConstraints();
			gridBagConstTA.fill = GridBagConstraints.BOTH;
			gridBagConstTA.gridx = 0;
			gridBagConstTA.gridy = 0;
			gridBagConstTA.weightx = 1.0;
			gridBagConstTA.weighty = 1.0;
			jCPbase = new JPanel();
			jCPbase.setLayout(new GridBagLayout());
			jCPbase.add(getJTAtablero(), gridBagConstTA);
			jCPbase.add(getJPbajo(), gridBagConstbajo);
		}
		return jCPbase;
	}

	/**
	 * This method initializes jTAtablero
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextPane getJTAtablero() {
		if (jTPtablero == null) {
			jTPtablero = new JTextPane();
			jTPtablero.setContentType("text/html");
			jTPtablero.setEditable(false);
		}
		return jTPtablero;
	}

	/**
	 * This method initializes jTFfilas
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFfila() {
		if (jTFfila == null) {
			jTFfila = new JTextField();
			jTFfila.setPreferredSize(new Dimension(20, 20));
		}
		return jTFfila;
	}

	/**
	 * This method initializes jTFCols
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFCol() {
		if (jTFCol == null) {
			jTFCol = new JTextField();
			jTFCol.setPreferredSize(new Dimension(20, 20));

		}
		return jTFCol;
	}

	/**
	 * This method initializes jBadd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBadd() {
		if (jBadd == null) {
			jBadd = new JButton();
			jBadd.setText("Add");
			jBadd.setPreferredSize(new Dimension(60, 20));
			jBadd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						formatearCasilla();
						if (reinas.comprobarReina(fila, col)) {
							jLinfo.setText("(" + fila + "," + col
									+ ") Casilla válida");
							reinas.addReina(fila, col);
							refreshTablero();
						} else
							jLinfo.setText("(" + fila + "," + col
									+ ") Casilla no válida");
					} catch (NumberFormatException e1) {
						jLinfo.setText("¡Rellene los 2 campos!");
					} catch (ArrayIndexOutOfBoundsException e1) {
						jLinfo.setText("(" + fila + "," + col
								+ ") Casilla no válida");
					}
				}
			});
		}
		return jBadd;
	}

	/**
	 * This method initializes jBremove
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBremove() {
		if (jBremove == null) {
			jBremove = new JButton();
			jBremove.setText("Del");
			jBremove.setPreferredSize(new Dimension(60, 20));
			jBremove.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						formatearCasilla();
						if (!reinas.comprobarReina(fila, col)) {
							jLinfo.setText("(" + fila + "," + col
									+ ") Casilla válida");
							reinas.removeReina(fila, col);
							refreshTablero();
						} else
							jLinfo.setText("No hay reina en (" + fila + ","
									+ col + ")");

					} catch (NumberFormatException e1) {
						jLinfo.setText("¡Rellene los 2 campos!");
					} catch (ArrayIndexOutOfBoundsException e1) {
						jLinfo.setText("(" + fila + "," + col
								+ ") Casilla no válida");
					} catch (BorradoReinaNoExisteException e1) {
						jLinfo.setText(e1.getMessage());
					}
				}
			});
		}
		return jBremove;
	}

	/**
	 * This method initializes jPbajo
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPbajo() {
		if (jPbajo == null) {
			jLnReinas = new JLabel();
			jLnReinas.setText("0R");
			JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
			JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
			separator1.setPreferredSize(new Dimension(1, 20));
			separator2.setPreferredSize(new Dimension(1, 20));
			jLinfo = new JLabel();
			jLinfo.setText("Zona de información/avisos");
			jLX = new JLabel();
			jLX.setText("x");
			jPbajo = new JPanel();
			jPbajo.setLayout(new FlowLayout());
			jPbajo.add(getJTFfila(), null);
			jPbajo.add(jLX, null);
			jPbajo.add(getJTFCol(), null);
			jPbajo.add(getJBadd(), null);
			jPbajo.add(getJBremove(), null);
			jPbajo.add(separator1);
			jPbajo.add(jLnReinas, null);
			jPbajo.add(separator2);
			jPbajo.add(jLinfo, null);
		}
		return jPbajo;
	}

	/**
	 * This method initializes jJMB
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJmenuPrincipal() {
		if (jMenuPrincipal == null) {
			jMenuPrincipal = new JMenuBar();
			jMenuPrincipal.add(getJMenu());
			jMenuPrincipal.add(getJMAyuda());
		}
		return jMenuPrincipal;
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
			jMenu.add(getJMIsolve());
			jMenu.add(getJMInReinas());
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

			jMIReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reiniciar();
					refreshTablero();
				}
			});
		}
		return jMIReiniciar;
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
					jdialogInfo.setLocationRelativeTo(jCPbase);
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
			jMIcomoJugar.setText("Como jugar");
			jMIcomoJugar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jdialogComoJugar.setLocationRelativeTo(jCPbase);
					jdialogComoJugar.setVisible(true);
				}
			});
		}
		return jMIcomoJugar;
	}

	/**
	 * This method initializes jMIsolve
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMIsolve() {
		if (jMIsolve == null) {
			jMIsolve = new JMenuItem();
			jMIsolve.setText("Solve");
			jMIsolve.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reiniciar();
					try {
						long start = System.nanoTime();
						reinas.solve(0);
						time = System.nanoTime() - start;
						refreshTablero();
						time = 0;
					} catch (BorradoReinaNoExisteException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return jMIsolve;
	}

	/**
	 * This method initializes jMInReinas
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMInReinas() {
		if (jMInReinas == null) {
			jMInReinas = new JMenuItem();
			jMInReinas.setText("Cambiar nReinas");
			jMInReinas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reinas = new Nreinas(eligeNumeroReinas());
					reiniciar();
					refreshTablero();
					pack();
				}
			});
		}
		return jMInReinas;
	}

	/**
	 * Metodo que reinicia el juego
	 */
	private void reiniciar() {
		reinas.reiniciar();
		getJTFCol().setText("");
		getJTFfila().setText("");
		jLinfo.setText("Zona de información/avisos");
		time = 0;
	}

	/**
	 * Metodo que formatea las casillas de coordenadas
	 * 
	 * @throws NumberFormatException
	 *             si hay problema en el formateo
	 */
	private void formatearCasilla() throws NumberFormatException {
		String colstring = getJTFCol().getText();
		String filastring = getJTFfila().getText();
		fila = Integer.parseInt(filastring);
		col = Integer.parseInt(colstring);
	}

	/**
	 * Metodo que refresca el tablero
	 */
	private void refreshTablero() {
		getJTAtablero().setText("<center>" + reinas.toStringTabla());
		jLnReinas.setText(String.valueOf(reinas.getNReinasColocadas()) + "R");
		getJTFfila().requestFocus();

		if (reinas.isSol()) {
			NumberFormat formatter = new DecimalFormat("0.#E0");
			jLinfo.setText("Terminado"
					+ (time != 0 ? " en " + formatter.format(time / 1000000)
							+ "ms" : ""));
			JOptionPane.showMessageDialog(this,
					"\n¡Se colocaron las " + reinas.getDim() + " reinas!",
					"Juego terminado", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Metodo para seleccionar el numero de reinas a colocar en el juego
	 * 
	 * @return el numero de reinas elegido por el usuario
	 */
	private int eligeNumeroReinas() {
		String s = (String) JOptionPane.showInputDialog(this,
				"Elige el número de reinas", "Numero de reinas",
				JOptionPane.QUESTION_MESSAGE, null, posibilidades, "8");
		return s != null ? Integer.parseInt(s) : 8;
	}
}
