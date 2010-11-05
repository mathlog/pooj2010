package opoo.practica4.solib.ventherencia;

import java.awt.*;

import javax.swing.*;

import opoo.practica4.soli.modelo.TableroSolitario;
import opoo.practica4.soli.modelo.VistaSolitario;

import java.awt.event.*;

public class VentSolitarioHerencia extends TableroSolitario implements
		VistaSolitario {

	public JPanel panel;
	private Caja cajaSelec = null;
	private Caja[][] tab = new Caja[7][7];

	public VentSolitarioHerencia() {
		// this.solTab = tableroSolitario;
		panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);

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
				tab[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				panel.add(c);
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
				tab[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				panel.add(c);
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
				tab[i][j] = c;
				c.setBackground(Color.black);
				layout.setConstraints(c, g);
				panel.add(c);
			}
		}
		addVista(this);
		cambio();
	}

	public void cambio() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tab[i][j] != null) {
					if (tablero[i][j] == 1) {
						tab[i][j].setIcon(new ImageIcon(getClass().getResource(
								"images/solitairePion.gif")));
					} else
						tab[i][j].setIcon(new ImageIcon(getClass().getResource(
								"images/solitaireVide.gif")));
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

			if (cajaSelec == null && tablero[this.l][this.c] == 1) {
				cajaSelec = this;
				this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
			} else {
				if (cajaSelec != null) {
					if (this.l == cajaSelec.l && this.c == cajaSelec.c) {
						cajaSelec.setBorder(null);
						cajaSelec = null;
					} else {
						boolean b = jugada(cajaSelec.l, cajaSelec.c, this.l,
								this.c);
						if (b) {
							cajaSelec.setBorder(null);
							cajaSelec = null;
							cambio();
						} else {
							cajaSelec.setBorder(null);
							cajaSelec = this;
							if (tablero[this.l][this.c] == 1)
								this.setBorder(BorderFactory.createLineBorder(
										Color.red, 3));
						}
					}
				}
			}
		}
	}

}
