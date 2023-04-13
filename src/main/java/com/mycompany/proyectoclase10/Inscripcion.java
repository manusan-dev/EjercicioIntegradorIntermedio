package com.mycompany.proyectoclase10;

import java.util.List;




public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private String resultado;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        this.resultado = "";
    }
    
    public void setMateria(Materia materia){
        this.materia = materia;
    }

    public boolean aprobada() {
        return materia.puedeCursar(alumno);
    }
    
    public Alumno getAlumno() {
    return alumno;
}

    public Materia getMateria() {
    return materia;
}

    public void agregarResultado(String resultados) {
    resultados += alumno.getNombre() + "," + materia.getNombre() + "," + (aprobada() ? "Aceptada" : "Rechazada") + "\n";
}


    public String getNombre() {
        return materia.getNombre();
    }

    public void setResultados(String resultado) {
        this.resultado = resultado;
    }

    public String getResultados() {
        return resultado;
    }
}
