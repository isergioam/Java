package POO;

interface Cargable{
	public void cargar();
}

interface Grabable{
	public void grabar();
}

class Juego implements Cargable, Grabable{
	public int nivel;
	
	public void cargar() {
		System.out.println("Has cargado el juego en el nivel " + nivel);
	}
	
	public void grabar() {
		System.out.println("Has grabado el juego en el nivel " + nivel);
	}
}


public class Ejer031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Juego j = new Juego();
		j.nivel = 45;
		j.grabar();
		j.cargar();

	}

}
