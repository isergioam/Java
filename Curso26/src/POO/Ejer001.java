package POO;

/*class Libro {
	String titulo;
	String autor;
}
*/

/*class Saludo {
	
	public void Saludar() {
		System.out.println("Hola Mundo!!");
	}

}
*/


/*
class Calculadora{
	public void Sumar(int a,int b) {
		int result = a + b;
		System.out.println("La suma de " + a + " + " + b + " es igual a " + result);
	}
}
*/

/*class Saludo2 {
	
	public void Hola(String nombre) {
		System.out.println("Hola " + nombre + "!!");
	}
}
*/

class Rectangulo {
	public int CalcularArea(int base, int altura) {
		return base * altura;
	}
	
}

public class Ejer001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Libro c1 = new Libro();
		c1.titulo = "Dos corriendo por tres calles";
		c1.autor = "Nemesio Pérez";
		
		System.out.println("El autor de \"" + c1.titulo + "\" es " + c1.autor);
		*/
		
		/*Saludo s = new Saludo();		
		s.Saludar();
		*/
		/*
		Calculadora c1 = new Calculadora(); // Instanciar la clase (llamarla)
		c1.Sumar(12,23);*/
		
		/*
		Saludo2 s = new Saludo2();
		s.Hola("Paco");
		*/
		
		Rectangulo a = new Rectangulo();
		
		int result = a.CalcularArea(8,5);
		
		System.out.println("El Área del rectangulo es:" + result );
		
		
		
	}

}
