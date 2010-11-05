package opoo.practica4.ligarej;

public class Ligaduras {
	public static void main(String[] args) {
		Uno ob1 = new Uno();
		Dos ob2 = new Dos();
		Tres ob3 = new Tres();
		Cuatro ob4 = new Cuatro();
		System.out.println("ob1.test = " + ob1.test());
		System.out.println("ob1.result1 = " + ob1.result1());
		System.out.println("ob2.test = " + ob2.test());
		System.out.println("ob2.result1 = " + ob2.result1());
		System.out.println("ob3.test = " + ob3.test());
		System.out.println("ob4.result1 = " + ob4.result1());
		System.out.println("ob3.result2 = " + ob3.result2());
		System.out.println("ob4.result2 = " + ob4.result2());
		System.out.println("ob3.result3 = " + ob3.result3());
		System.out.println("ob4.result3 = " + ob4.result3());
	}

}

class Uno {
	public int test() {
		return 1;
	}

	public int result1() {
		return this.test();
	}
}

class Dos extends Uno {
	public int test() {
		return 2;
	}
}

class Tres extends Dos {

	public int result2() {
		return this.result1();
	}

	public int result3() {
		return super.test();
	}
}

class Cuatro extends Tres {
	public int test() {
		return 4;
	}
}