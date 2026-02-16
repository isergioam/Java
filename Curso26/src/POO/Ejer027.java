package POO;

abstract class Animal3{
	public abstract void sonido();
	public void dormir() {
		System.out.println("ZZZZZZZZzzzzZzzzzzZZZZz...");
	}
	
}

class Perro extends Animal3{
	public void sonido() {
		System.out.println("GUAU GUAU GUAAAUUUU!!!");
	}
}

class Gato extends Animal3{
	public void sonido() {
		System.out.println("MIAU MIAU MIAAAUUUU!!!");
	}
}

public class Ejer027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Perro p = new Perro();
		p.sonido();
		p.dormir();
		
		Gato g = new Gato();
		g.sonido();
		g.dormir();
		
	}

}
