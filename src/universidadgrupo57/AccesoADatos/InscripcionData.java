

package universidadgrupo57.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo57.Entidades.Alumno;
import universidadgrupo57.Entidades.Inscripcion;
import universidadgrupo57.Entidades.Materia;


public class InscripcionData {
    
    private Connection con = null;
    private MateriaData md= new MateriaData();
    private AlumnoData ad= new AlumnoData();
    
    public InscripcionData(){
    
        this.con=Conexion.getConexion();
    
    }
    
    public void guardarInscripcion(Inscripcion insc){
    
        String sql="INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3,insc.getNota());
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion guardada");
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
    
        String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Nota actualizada");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar nota");
        }
    
    }
    
    public void borrarInscripcion(int idAlumno, int idMateria){
    
        String sql="DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Inscripcion borrada");
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar inscripcion");
        }
    
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        String sql="SELECT * FROM inscripcion";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inscripcion insc= new Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
                Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mate=md.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mate);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
                
            
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las inscripciones");
        }
        return cursadas;
    
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> cursadas= new ArrayList<>();
        String sql="SELECT * FROM inscripcion WHERE idAlumno = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inscripcion insc= new Inscripcion();
                insc.setIdInscripto(rs.getInt("idInscripto"));
                Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mate=md.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alu);
                insc.setMateria(mate);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
                
            
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las inscripciones");
        }
        return cursadas;
    
    }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT m.* FROM materia m " +
                     "INNER JOIN inscripcion i ON m.idMateria = i.idMateria " +
                     "WHERE i.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao encontrar inscrições");
        }

        return materias;
    }
    
    public List<Materia> obtenerMateriasNOCursadas(int idAlumno){
    
        ArrayList<Materia> materias= new ArrayList<>();
        String sql="SELECT * FROM materia WHERE estado = 1 AND idMateria not in (SELECT idMateria FROM inscripcion WHERE idAlumno = ?) ";
                
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al encontrar inscripciones");
        }
    
    return materias;
    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        ArrayList<Alumno> alumnosMateria=new ArrayList<>();
        String sql="SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
                + "FROM inscripcion i,alumno a WHERE i.idAlumno = a.idAlumno and idMateria = ? AND a.estado = 1 ";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Alumno alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
            
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar alumnos inscriptos");
        }
                
    
    return alumnosMateria;
    
    }

}
