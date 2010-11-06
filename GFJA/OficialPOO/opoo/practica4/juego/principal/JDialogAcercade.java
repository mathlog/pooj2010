//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PROYECTO : Juego del Siete y medio
// ASIGNATURA : Programacion Orientada a Objetos
//
package opoo.practica4.juego.principal;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase visual que representa el dialogo que aparece al pulsar Acerda de
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 26.09.2010
 */
public class JDialogAcercade extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLInfo = null;
	private JLabel jLimg = null;
	private JLabel jLversion = null;
	private JLabel jLAutor = null;
	private JLabel jLWeb = null;
	private JButton jBclose = null;
	private String juego = null;
	private String version = null;
	private String autor = null;
	private String web = null;
	private String rutaImg = null;

	/**
	 * @param owner
	 */
	public JDialogAcercade(Frame owner, String juego, String version,
			String autor, String web, String rutaImg) {
		super(owner);
		this.juego = juego;
		this.version = version;
		this.autor = autor;
		this.web = web;
		this.rutaImg = rutaImg;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Acerca de");
		this.setSize(360, 200);
		this.setContentPane(getJContentPane());
		getJBclose().requestFocus();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLWeb = new JLabel();
			jLWeb.setBounds(new Rectangle(139, 110, 180, 16));
			jLWeb.setText("Web:          " + web);
			jLWeb.setToolTipText("Pincha para ir a la web");
			final Color origen = jLWeb.getForeground();
			jLWeb.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					try {
						Desktop.getDesktop().browse(new URI(web));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
					jLWeb.setForeground(Color.blue);
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
					jLWeb.setForeground(origen);
				}
			});
			jLAutor = new JLabel();
			jLAutor.setBounds(new Rectangle(139, 80, 180, 16));
			jLAutor.setText("Autor:        " + autor);
			jLversion = new JLabel();
			jLversion.setBounds(new Rectangle(139, 50, 180, 16));
			jLversion.setText("Version:    " + version);
			jLimg = new JLabel();
			jLimg.setBounds(new Rectangle(4, 16, 125, 129));
			jLimg.setIcon(new ImageIcon(getClass().getResource(rutaImg)));
			jLInfo = new JLabel();
			jLInfo.setText(juego);
			jLInfo.setFont(new Font("Dialog", Font.BOLD, 14));
			jLInfo.setBounds(new Rectangle(139, 14, 180, 24));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLInfo, null);
			jContentPane.add(jLimg, null);
			jContentPane.add(jLversion, null);
			jContentPane.add(jLAutor, null);
			jContentPane.add(jLWeb, null);
			jContentPane.add(getJBclose(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jBclose
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBclose() {
		if (jBclose == null) {
			jBclose = new JButton();
			jBclose.setBounds(new Rectangle(244, 135, 75, 21));
			jBclose.setText("Cerrar");
			jBclose.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
			jBclose.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER)
						dispose();
				}
			});
		}
		return jBclose;
	}

}
