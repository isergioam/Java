package POO;

import java.util.ArrayList;

class Alumno {
    private String nombre;
    private int nota;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre + ", Nota: " + this.nota);
    }

}
class Curso {
    private String nombreCurso;
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void mostrarAlumnos() {
        System.out.println("Alumnos del curso " + nombreCurso + ":");
        for (Alumno alumno : alumnos) {
            alumno.mostrarInfo();
        } 


}

}

public class Ejer012 {
    public static void main(String[] args) {
        Curso c = new Curso("Matemáticas");

        Alumno alumno1 = new Alumno("Juan", 85);
        Alumno alumno2 = new Alumno("María", 92);
        Alumno alumno3 = new Alumno("Pedro", 78);

        c.agregarAlumno(alumno1);
        c.agregarAlumno(alumno2);
        c.agregarAlumno(alumno3);

        c.mostrarAlumnos();
    }   
}
