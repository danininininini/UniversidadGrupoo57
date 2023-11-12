package universidadgrupo57;

import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JFrame;
import universidadgrupo57.AccesoADatos.*;
import universidadgrupo57.Entidades.*;
import universidadgrupo57.Vistas.Menu;


public class UniversidadGrupo57 {

    public static void main(String[] args) {
        
        JFrame frame = new Menu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        frame.setVisible(true);
        

//        Connection con = Conexion.getConexion();
//        AlumnoData ad=new AlumnoData();
//        MateriaData md= new MateriaData();
//        InscripcionData id= new InscripcionData();
//        
//        Alumno alu=ad.buscarAlumno(7);
//        Materia mate=md.buscarMateria(8);
//        
//        Inscripcion insc=new Inscripcion(alu,mate,10);
//        for(Alumno alumno:id.obtenerAlumnosXMateria(8)){
//            System.out.println("nombre: "+alumno.getNombre());
//        
//        }
//        for(Materia materia:id.obtenerMateriasNOCursadas(5)){
//            System.out.println("materias no cursadas: "+materia.getNombre());
//        
//        }
//        for (Inscripcion inscripcion : id.obtenerInscripciones()) {
//            System.out.println("id "+ inscripcion.getIdInscripto());
//            System.out.println("Apellido: "+inscripcion.getAlumno().getApellido());
//            System.out.println("Materia: "+inscripcion.getMateria().getNombre());
//        }
        //id.guardarInscripcion(insc);
        //id.actualizarNota(7, 8, 9);
        //id.borrarInscripcion(7, 8);
        
        
//        Materia mate=new Materia(6, "Italiano", 2, true);
//        MateriaData materia=new MateriaData();
//        materia.modificarMateria(mate);
        
//        for (Materia mate:materia.listarMaterias()){
//            System.out.println(mate.getNombre());
//            System.out.println(mate.getAnio());
//            System.out.println(mate.isEstado());
//        
//        }
        //materia.eliminarMateria(6);
        
//        Materia materiaE=materia.buscarMateria(3);
//        System.out.println("nombre: "+materiaE.getNombre());
//        System.out.println("año: "+materiaE.getAnio());
//        System.out.println("estado: "+materiaE.isEstado());
        //materia.guardarMateria(mate);
        
//        //Alumno alu=new Alumno(1, 12254852,"Gonzalez","Maria Laura",LocalDate.of(2000, 3, 1), true);
//        AlumnoData alum=new AlumnoData();
//       // alum.guardarAlumno(alu);
//       //alum.modificarAlumno(alu);
//        //alum.eliminarAlumno(1);
//        Alumno alumnoE=alum.buscarAlumnoPorDni(87410236);
//        if(alumnoE!=null){
//            System.out.println("dni:  "+alumnoE.getDni());
//            System.out.println("apellido:  "+alumnoE.getApellido());
//            System.out.println("nombre:  "+alumnoE.getNombre());
//            System.out.println("fecha de nacimiento:  "+alumnoE.getFechaNacimiento());
//        
//        }
//        AlumnoData alu = new AlumnoData();
//        for (Alumno alumno:alu.listarAlumnos()){
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//        
//        }

    }

}
