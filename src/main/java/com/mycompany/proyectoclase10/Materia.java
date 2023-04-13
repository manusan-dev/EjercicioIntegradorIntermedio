
package com.mycompany.proyectoclase10;

import java.util.ArrayList;
import java.util.List;

public class Materia {
   private String nombre;
   private List<Materia> correlativas;
   
   public Materia(String nombre) {
      this.nombre = nombre;
      this.correlativas = new ArrayList<>();
   }
   
   public Materia(String nombre, List<Materia> correlativas) {
      this.nombre = nombre;
      this.correlativas = correlativas;
   }
   
   public void agregarCorrelativa(Materia correlativa) {
       this.correlativas.add(correlativa);
   }
   
   public String getNombre(){
       return nombre;
   }

    public boolean puedeCursar(Alumno alumno) {
        boolean puedeCursar = true;
        for(int i = 0; i < correlativas.size(); i++){
            if (!alumno.getMateriasAprobadas().contains(correlativas.get(i))){
                puedeCursar = false;
                break; // Si no cumple con alguna correlativa, no puede cursar la materia.
            }
        }
        return puedeCursar;
    }
}
