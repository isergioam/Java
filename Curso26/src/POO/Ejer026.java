package POO;

import java.util.ArrayList;

class Animal {
	String nombre;
	int energia;

	/*public Animal(String nombre, int energia) {
		this.nombre = nombre;
		this.energia = energia;
	}*/

	public void alimentar() {
		this.energia = energia + 10;
	}

}

class Leon extends Animal {

	public void alimentar() {

		this.energia = this.energia + 25;

		if (this.energia > 80) {
			this.energia =  100;
		}

	}

}

class Panda extends Animal {
	int cont = 0;

	public void alimentar() {

		this.energia = this.energia + 15;
		cont++;
		if (cont >= 3) {
			this.energia = 20;
			cont = 0;
		}

	}

}

public class Ejer026 {

	public ArrayList<Animal> animales = new ArrayList<>();

	public void add(Animal a) {
		animales.add(a);
	}

	public void alimentarTodos() {
		for (Animal animal : animales) {
			animal.alimentar();
		}
	}

	public void listar() {
		for (Animal animal : animales) {
			System.out.println(animal.nombre +  " " + animal.energia);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejer026 e = new Ejer026();
		
		Leon l = new Leon();
		l.nombre = "Leoncito";
		l.energia = 50;
		
		Panda p = new Panda();
		p.nombre = "Pandita";
		p.energia = 50;
		
		e.add(p);
		e.add(l);
		
		e.alimentarTodos();
		e.listar();
		e.alimentarTodos();
		e.listar();
		e.alimentarTodos();
		e.listar();
		e.alimentarTodos();
		e.listar();
		e.alimentarTodos();
		e.listar();
		
	}

}
