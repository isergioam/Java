package MVC;

public class Ej01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Ej01_Modelo m = new Ej01_Modelo("","", 0);
        Ej01_Vista vista = new Ej01_Vista();
        Ej01_Controlador c = new Ej01_Controlador(m, vista);
        
        m.setNombre("Paco");
        m.setApellidos("Palacios");
        m.setEdad(57);
        
        c.actualizarVista();

	}

}
