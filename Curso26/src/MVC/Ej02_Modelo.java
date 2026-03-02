package MVC;
import java.util.ArrayList;

public class Ej02_Modelo {
	
	private ArrayList<Ej01_Modelo> personas = new ArrayList<>();
	
	public void add(Ej01_Modelo p) {
		
		personas.add(p);
		
	}
	
	public ArrayList<Ej01_Modelo> getPersonas() {
		return this.personas;
	}

}
