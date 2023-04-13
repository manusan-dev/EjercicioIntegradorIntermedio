
package com.mycompany.proyectoclase10;


import java.util.ArrayList;
import java.util.List;

public class Alumno {
   private String nombre;
   private int legajo;
   private List<Materia> materiasAprobadas;
   
   public Alumno(String nombre) {
      this.nombre = nombre;
      this.materiasAprobadas = new ArrayList<>();
   }
   
   
   public boolean materiasAprobadas(Materia materia) {
      return materiasAprobadas.contains(materia);
   }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
    
    public String getNombre(){
        return nombre;
    }
}
