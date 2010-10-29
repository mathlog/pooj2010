package opoo.practica3.numeros;

class Polinomio {
	private double[] coeficientes;

	Polinomio(double[] coeficientes) {
		this.coeficientes = new double[coeficientes.length];
		System.arraycopy(coeficientes, 0, this.coeficientes, 0,
				coeficientes.length);
	}

	double evalua_1(double x) {
		double resultado = 0.0;
		for (int termino = 0; termino < coeficientes.length; termino++) {
			double xn = 1.0;
			for (int j = 0; j < termino; j++)
				xn *= x; // x elevado a n
			resultado += coeficientes[termino] * xn;
		}
		return resultado;
	}

	double evalua_2(double x) {
		double resultado = 0.0;
		for (int termino = 0; termino < coeficientes.length; termino++) {
			resultado += coeficientes[termino] * potencia(x, termino);
		}
		return resultado;
	}

	private double potencia(double x, int n) {
		if (n == 0)
			return 1.0;
		// si es potencia impar ...
		if (n % 2 == 1)
			return x * potencia(x, n - 1);
		// si es potencia par ...
		double t = potencia(x, n / 2);
		return t * t;
	}

	double evalua_3(double x) {
		double xn = 1.0;
		double resultado = coeficientes[0];
		for (int termino = 1; termino < coeficientes.length; termino++) {
			xn *= x;
			resultado += coeficientes[termino] * xn;
		}
		return resultado;
	}

	double evalua_4(double x) {
		double resultado = 0.0;
		for (int termino = coeficientes.length - 1; termino >= 0; termino--) {
			resultado = resultado * x + coeficientes[termino];
		}
		return resultado;
	}

	private static void test(int grado) {
		double[] coeficientes = new double[grado + 1];
		for (int i = 0; i < coeficientes.length; i++)
			coeficientes[i] = i;
		Polinomio p = new Polinomio(coeficientes);

		double x = 3;
		long t1, t2;

		t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			p.evalua_1(x);
		t2 = System.currentTimeMillis();
		long tiempo_1 = t2 - t1;

		t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			p.evalua_2(x);
		t2 = System.currentTimeMillis();
		long tiempo_2 = t2 - t1;

		t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			p.evalua_3(x);
		t2 = System.currentTimeMillis();
		long tiempo_3 = t2 - t1;

		t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			p.evalua_4(x);
		t2 = System.currentTimeMillis();
		long tiempo_4 = t2 - t1;

		System.out.println(grado + "," + tiempo_1 + "," + tiempo_2 + ","
				+ tiempo_3 + "," + tiempo_4);
	}

	public static void main(String[] args) {
		double[] coeficientes = new double[args.length];
		for (int i = 0; i < args.length; i++)
			coeficientes[i] = Double.parseDouble(args[i]);
		Polinomio p = new Polinomio(coeficientes);

		double x = 3;
		System.out.println(p.evalua_1(x));
		System.out.println(p.evalua_2(x));
		System.out.println(p.evalua_3(x));
		System.out.println(p.evalua_4(x));

		test(1);
		test(2);
		test(5);
		test(10);
		test(20);
		test(50);
		test(100);
		test(200);
		test(500);
		test(1000);
	}

}
