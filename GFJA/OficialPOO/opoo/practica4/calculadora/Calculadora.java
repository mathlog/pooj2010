package opoo.practica4.calculadora;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Calculadora extends Applet implements ActionListener {

	// Variables generales del programa
	double numero = 0, resultado = 0;
	char operacion = 'n';
	StringBuffer s = new StringBuffer();

	// Interfaz Gráfica con el Usuario
	TextField display = new TextField();

	Button b1 = new Button("1");
	Button b2 = new Button("2");
	Button b3 = new Button("3");
	Button b4 = new Button("4");
	Button b5 = new Button("5");
	Button b6 = new Button("6");
	Button b7 = new Button("7");
	Button b8 = new Button("8");
	Button b9 = new Button("9");
	Button b0 = new Button("0");

	Button bs = new Button("+");
	Button br = new Button("-");
	Button bd = new Button("/");
	Button bm = new Button("*");
	Button bp = new Button(".");
	Button bi = new Button("=");

	Button reset = new Button("Nuevo Cálculo");

	Panel superior = new Panel();
	Panel medio = new Panel();
	Panel inferior = new Panel();

	// Termina Interfaz Gráfica

	public void init() {

		// Colocar componentes
		setLayout(new BorderLayout());

		superior.setLayout(new BorderLayout());
		superior.add("Center", display);

		display.setEditable(false);

		medio.setLayout(new GridLayout(4, 4));
		medio.add(b0);
		medio.add(b1);
		medio.add(b2);
		medio.add(bs);
		medio.add(b3);
		medio.add(b4);
		medio.add(b5);
		medio.add(br);
		medio.add(b6);
		medio.add(b7);
		medio.add(b8);
		medio.add(bd);
		medio.add(b9);
		medio.add(bp);
		medio.add(bi);
		medio.add(bm);

		inferior.setLayout(new BorderLayout());
		inferior.add("Center", reset);

		add("North", superior);
		add("Center", medio);
		add("South", inferior);
		// Termina colocación de componentes

		// Permitir que los botones manejen eventos
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);

		bs.addActionListener(this);
		br.addActionListener(this);
		bd.addActionListener(this);
		bm.addActionListener(this);
		bp.addActionListener(this);
		bi.addActionListener(this);

		reset.addActionListener(this);
		// Fin del registro de Listeners
	}

	// Manejo de los eventos para cada botón
	public void actionPerformed(ActionEvent e) {

		Double digUno, digDos;

		if (e.getSource() == b1) {
			s.append('1');
		} else if (e.getSource() == b2) {
			s.append('2');
		} else if (e.getSource() == b3) {
			s.append('3');
		} else if (e.getSource() == b4) {
			s.append('4');
		} else if (e.getSource() == b5) {
			s.append('5');
		} else if (e.getSource() == b6) {
			s.append('6');
		} else if (e.getSource() == b7) {
			s.append('7');
		} else if (e.getSource() == b8) {
			s.append('8');
		} else if (e.getSource() == b9) {
			s.append('9');
		} else if (e.getSource() == b0) {
			s.append('0');
		} else if (e.getSource() == bp) {
			s.append('.');
		} else if (e.getSource() == br) { // resta
			if (display.getText() != "") {
				digUno = new Double(display.getText());
				numero = digUno.doubleValue();
			}
			s = null;
			s = new StringBuffer();
			operacion = 'r';
		} else if (e.getSource() == bd) { // division
			if (display.getText() != "") {
				digUno = new Double(display.getText());
				numero = digUno.doubleValue();
			}
			s = null;
			s = new StringBuffer();
			operacion = 'd';
		} else if (e.getSource() == bm) { // multiplicación
			if (display.getText() != "") {
				digUno = new Double(display.getText());
				numero = digUno.doubleValue();
			}
			s = null;
			s = new StringBuffer();
			operacion = 'm';
		} else if (e.getSource() == bs) { // suma
			if (display.getText() != "") {
				digUno = new Double(display.getText());
				numero = digUno.doubleValue();
			}
			s = null;
			s = new StringBuffer();
			operacion = 's';
		} else if (e.getSource() == bi) { // Realizar el cálculo

			if (display.getText() != "") {
				digDos = new Double(display.getText());

				if (operacion == 'r') {
					resultado = (numero - digDos.doubleValue());
				} else if (operacion == 'd') {
					resultado = (numero / digDos.doubleValue());
				} else if (operacion == 'm') {
					resultado = (numero * (digDos.doubleValue()));
				} else if (operacion == 's') {
					resultado = (numero + digDos.doubleValue());
				}

			}

			s = null;
			s = new StringBuffer();
			s.append(resultado);
		}
		// Exhibir el resultado
		display.setText(s.toString());

		// Resetear valores
		if (e.getSource() == reset) {
			numero = 0;
			resultado = 0;
			s = null;
			s = new StringBuffer();
			display.setText(s.toString());
		}

	}

}
