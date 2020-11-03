/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.*;
import config.bd.ConectaBd;
import intefaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

public class EstudianteDAO implements CRUD{
     ConectaBd cn = new ConectaBd();
     Connection con;
     PreparedStatement pst;
     ResultSet rs;
     Estudiante e = new Estudiante();

    @Override
    public List listarestudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        String consulta = " select * from estudiante ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Estudiante estudiante = new Estudiante();
                estudiante.setIdestudiante(rs.getInt("idestudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setCodigo(rs.getString("codigo"));
                estudiante.setEstado(rs.getString("estado"));
                estudiantes.add(estudiante);
            }
        } catch (Exception error) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(error.getMessage());
        }
        return estudiantes;
    }

    @Override
    public Estudiante buscarestudiante(int idestudiante) {
        String consulta = " select * "
                        + " from estudiante  "
                        + " where idestudiante =  " + idestudiante;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdestudiante(rs.getInt("idestudiante"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setDni(rs.getString("dni"));
                e.setCodigo(rs.getString("codigo"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception error) {
            System.out.println("Error: Problemas con la BUSQUEDA");
            System.out.println(error.getMessage());
        }
        return e;
    }

    @Override
    public boolean agregarestudiante(Estudiante estudiante) {
        String consulta = " insert into  "
                        + " estudiante (nombre, apellidos, dni, codigo, estado) "
                        + " values('"+ estudiante.getNombre() +"', "
                        + " '"+ estudiante.getApellidos() +"', "
                        + " '"+ estudiante.getDni() +"', "
                        + " '"+ estudiante.getCodigo() +"', "
                        + " '"+ estudiante.getEstado() +"')";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();            
        } catch (Exception error) {
            System.out.println("Error: Problemas con el INSERT");
            System.out.println(error.getMessage());
            return false;            
        }
        return true;
    }

    @Override
    public boolean editarestudiante(Estudiante estudiante) {
        String consulta = " update estudiante "
                        + " set "
                        + " nombre = '"+ estudiante.getNombre() +"', "
                        + " apellidos = '"+ estudiante.getApellidos() +"', "
                        + " dni = '"+ estudiante.getDni() +"', "
                        + " codigo = '"+ estudiante.getCodigo() +"', "
                        + " estado = '"+ estudiante.getEstado() +"' "
                        + " where "
                        + " idestudiante = " + estudiante.getIdestudiante();
        //System.out.println("Consulta EDITAR: " + consulta);
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();            
        } catch (Exception error) {
            System.out.println("Error: Problemas con la EDICIÓN");            
            System.out.println(error.getMessage());
            return false;            
        }
        return true;
    }

    @Override
    public boolean eliminarestudiante(int idestudiante) {
        String consulta = " delete from estudiante  "
                        + " where  "
                        + " idestudiante =  " + idestudiante;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();            
        } catch (Exception error) {
            System.out.println("Error: Problemas con el Eliminación");
            System.out.println(error.getMessage());
            return false;            
        }
        return true;
    }
    
}
