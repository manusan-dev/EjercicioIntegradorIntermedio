package com.mycompany.proyectoclase10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProyectoClase10 {
    public static void main(String[] args) {
        
        String archivoEntrada = "C:\\Users\\Manuel\\Documents\\NetBeansProjects\\ProyectoClase10\\src\\main\\java\\com\\mycompany\\proyectoclase10\\inscripciones.csv";
        String archivoSalida = "C:\\Users\\Manuel\\Documents\\NetBeansProjects\\ProyectoClase10\\src\\main\\java\\com\\mycompany\\proyectoclase10\\resultado.csv";
       
        
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        // Cargar inscripciones desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                String nombreAlumno = item[0];
                String nombreMateria = item[1];
                
                // Crear objeto Alumno
                Alumno alumno = new Alumno(nombreAlumno);
                
                // Crear lista de correlativas
                List<Materia> correlativas = new ArrayList<>();
                if (item.length > 2) {
                    String[] nombresCorrelativas = item[2].split(";");
                    for (String nombreCorrelativa : nombresCorrelativas) {
                        correlativas.add(new Materia(nombreCorrelativa.trim()));
                    }
                }
                
                // Crear objeto Materia
                Materia materia = new Materia(nombreMateria, correlativas);
                
                // Crear objeto Inscripcion
                Inscripcion inscripcion = new Inscripcion(alumno, materia);
                inscripciones.add(inscripcion);
            }
        } catch (IOException e) {
            System.out.println("error, no se encontró el archivo de entrada");
        }
        
        // Procesar inscripciones
        List<String> resultados = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            String resultado;
            if (inscripciones.indexOf(inscripcion) == 0) {
            resultado = inscripcion.getAlumno().getNombre() + "," + inscripcion.getMateria().getNombre() + "," + "Condicion";
            } else {
            boolean aprobada = inscripcion.aprobada();
            resultado = inscripcion.getAlumno().getNombre() + "," + inscripcion.getMateria().getNombre() + "," + (aprobada ? "Aceptada" : "Rechazada");
    }       
            inscripcion.agregarResultado(resultado);
            resultados.add(resultado); // Agregar el resultado a la lista de resultados
}
        
        
        // Escribir resultados en archivo
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoSalida))) {
            for (String resultado : resultados) {
                pw.println(resultado);
            }
        } catch (IOException e) {
            System.out.println("error, no se encontró archivo de salida");
        }
        
                System.out.println("Los resultados ya están en la nueva lista");
    }
}
