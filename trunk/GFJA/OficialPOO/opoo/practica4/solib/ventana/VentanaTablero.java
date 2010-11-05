package opoo.practica4.solib.ventana;

import java.awt.*;
import javax.swing.*;

import opoo.practica4.soli.modelo.TableroSolitario;
import opoo.practica4.soli.modelo.VistaSolitario;

import java.awt.event.*;

public class VentanaTablero extends JPanel implements VistaSolitario {

	private TableroSolitario solTab;
	private Caja cajaSelec = null;
	private Caja[][] tablero = new Caja[7][7];

	public VentanaTablero(TableroSolitario tableroSolitario) {
		this.solTab = tableroSolitario;
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		GridBagConstraints g;

		for (int i = 0; i < 2; i++) {
			for (int j = 2; j < 5; j++) {
				g = new GridBagConstraints();
				g.fill = GridBagConstraints.BOTH;
				g.anchor = GridBagConstraints.CENTER;
				g.gridwidth = 1;
				g.gridheight = 1;
				g.gridx = j;
				g.gridy = i;
				g.insets = new Insets(1, 1, 1, 1);
				Caja c = new Caja(i, j);
				c.addActionListener(c);
				tablero[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				this.add(c);
			}
		}
		for (int i = 2; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				g = new GridBagConstraints();
				g.fill = GridBagConstraints.BOTH;
				g.anchor = GridBagConstraints.CENTER;
				g.gridwidth = 1;
				g.gridheight = 1;
				g.gridx = j;
				g.gridy = i;
				g.insets = new Insets(1, 1, 1, 1);
				Caja c = new Caja(i, j);
				c.addActionListener(c);
				tablero[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				this.add(c);
			}
		}
		for (int i = 5; i < 7; i++) {
			for (int j = 2; j < 5; j++) {
				g = new GridBagConstraints();
				g.fill = GridBagConstraints.BOTH;
				g.anchor = GridBagConstraints.CENTER;
				g.gridwidth = 1;
				g.gridheight = 1;
				g.gridx = j;
				g.gridy = i;
				g.insets = new Insets(1, 1, 1, 1);
				Caja c = new Caja(i, j);
				c.addActionListener(c);
				tablero[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				this.add(c);
			}
		}
		solTab.addVista(this);
		cambio();
	}

	public void cambio() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tablero[i][j] != null) {
					if (solTab.tablero[i][j] == 1) {
						tablero[i][j].setIcon(new ImageIcon(getClass()
								.getResource("images/solitairePion.gif")));
					} else
						tablero[i][j].setIcon(new ImageIcon(getClass()
								.getResource("images/solitaireVide.gif")));
				}
			}
		}
	}

	class Caja extends JButton implements ActionListener {

		int l;
		int c;

		public Caja(int fila, int columna) {
			l = fila;
			c = columna;
			setPreferredSize(new Dimension(63, 63));
			setSize(getPreferredSize());
			setMaximumSize(getPreferredSize());
			setMinimumSize(getPreferredSize());

		}

		public void actionPerformed(ActionEvent e) {

			if (cajaSelec == null && solTab.tablero[this.l][this.c] == 1) {
				cajaSelec = this;
				this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
			} else {
				if (cajaSelec != null) {
					if (this.l == cajaSelec.l && this.c == cajaSelec.c) {
						cajaSelec.setBorder(null);
						cajaSelec = null;
					} else {
						boolean b = solTab.jugada(cajaSelec.l, cajaSelec.c,
								this.l, this.c);
						if (b) {
							cajaSelec.setBorder(null);
							cajaSelec = null;
							cambio();
						} else {
							cajaSelec.setBorder(null);
							cajaSelec = this;
							if (solTab.tablero[this.l][this.c] == 1)
								this.setBorder(BorderFactory.createLineBorder(
										Color.red, 3));
						}
					}
				}
			}
		}
	}
}