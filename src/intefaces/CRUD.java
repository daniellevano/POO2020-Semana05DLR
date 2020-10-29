package intefaces;

import java.util.List;
import modelo.Estudiante;

public interface CRUD {
    public List listarestudiante(); // Listar
    public Estudiante buscarestudiante(int idestudiante); // Buscar
    public boolean agregarestudiante(Estudiante estudiante);
    public boolean editarestudiante(Estudiante estudiante);
    public boolean eliminarestudiante(int idestudiante);
}
