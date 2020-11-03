package vistacontrol;

import java.util.List;
import modelo.Estudiante;
import modeloDAO.EstudianteDAO;
import utils.Leer;

public class Index {
    public static void listarEstudiantes() {
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        List<Estudiante> estudiantes = estudianteDAO.listarestudiante();
        System.out.println("Listado de Estudiantes");
        System.out.println("ID\tApellidos y Nombre\tDNI\tCódigo\tEstado");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(
                    estudiante.getIdestudiante() + "\t"
                    + estudiante.getNombreCompleto() + "\t"
                    + estudiante.getDni() + "\t"
                    + estudiante.getCodigo() + "\t"
                    + estudiante.getEstado()
            );
        }
    }
    public static void eliminarEstudiante(){
        listarEstudiantes();
        System.out.println("Ingrese el ID del estudiante a Eliminar");
        int id = Leer.entero();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.eliminarestudiante(id);
    }
    
    public static void editarEstudiante(){
        listarEstudiantes();
        System.out.println("Ingrese el ID del estudiante a editar: ");
        int id = Leer.entero();
        String nombre;
        String apellidos;
        String dni;
        String codigo;
        String estado;
        System.out.println("Editar Estudiante");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("DNI: ");
        dni = Leer.cadena();
        System.out.print("Código: ");
        codigo = Leer.cadena();
        System.out.print("Estado: ");        
        estado = Leer.cadena();
        Estudiante estudiante = new Estudiante(id, nombre, apellidos, dni, codigo, estado);
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.editarestudiante(estudiante);
    }
    
    public static void agregarEstudiante(){
        String nombre;
        String apellidos;
        String dni;
        String codigo;
        String estado;
        System.out.println("Agregar Estudiante");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos = Leer.cadena();
        System.out.print("DNI: ");
        dni = Leer.cadena();
        System.out.print("Código: ");
        codigo = Leer.cadena();
        System.out.print("Estado: ");        
        estado = Leer.cadena();
        Estudiante estudiante = new Estudiante(nombre, apellidos, dni, codigo, estado);
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        estudianteDAO.agregarestudiante(estudiante);
        
    }
    
    public static void salir(){
        System.out.println("Gracias por su visita....");
    }
    
    public static void error(int tipo){
        switch(tipo){
            case 1: 
                System.out.println("- Opcion Fuera de Rango");
                break;
            case 2:
                System.out.println("- DNI debe tener 8 Dígitos");
                break;
            case 3:
                System.out.println("- DNI debe ser compuesto por dígitos");
                break;
            case 4:
                System.out.println("- DNI repetido (Pertenece a otra persona)");
            default:
                System.out.println("Error");
        }        

    }
    
    public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Agregar Estudiantes");
        System.out.println("2. Eliminar Estudiantes");
        System.out.println("3. Editar Estudiantes");
        System.out.println("4. Listar Estudiantes");
        System.out.println("5. Salir");
        System.out.print("Escoja opción [1-5]: ");
    }
    public static void inicio(){
       int opcion;
        do {            
            menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1: 
                    agregarEstudiante();
                    break;
                case 2:
                    eliminarEstudiante();
                    break;
                case 3:
                    editarEstudiante();
                    break;
                case 4:
                    listarEstudiantes();
                    break;
                case 5:
                    salir();
                    break;
                default:
                    error(1);
                    break;
            }
        } while (opcion!=5);
    }

    public static void main(String[] args) {
        inicio();
    }
}
