import java.util.Scanner;

public class Gestor {
    //Declarar variables
    static int opcion; //el static permite llamar en cualquier función a la variable = Variable Global
    static String nombre;
    static double nota1;
    static double nota2;
    static double nota3;
    static double resultado;

    public static void main(String[] args){
        //Llamar funciones
        Scanner entrada = new Scanner(System.in);
        //Bucle principal para mostrar el menú
        do{
            menu(entrada);

            //Utilizar switch para manejar las opciones
            switch (opcion) {
                case 1:
                    registro(entrada);
                    
                    break;
                case 2:
                    mostrarinformacion();
                    break;
                case 3:
                    calculos();
                    if (resultado >= 50.0){
                        System.out.println(" El estudiante aprobo");
                    }
                    else{
                        System.out.println(" El estudiante reprobo");
                    }
                    break;
                case 4:
                    borrar(entrada);
                    
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while(opcion != 0);


    };

    //Función para mostrar el menú
    public static void menu(Scanner entrada){
        //Crear las opciones del menú
        System.out.println("""
            ---Registros de Estudiantes---
            1. Registrar datos de un estudiante
            2. Mostrar datos del estudiante actual
            3. Calcular promedio de notas del estudiante actual
            4. Eliminar estudiante
            0. Salir""");
            System.out.print("Digite una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
    
    }

    //Función para registrar información del estudiante
    public static void registro(Scanner entrada){
    boolean registrado = false;
    do {
        //Definir la variable para validar nombre
        boolean nombrevalido = false;
        while (!nombrevalido){
             // pedir nombre
        System.out.print("""
            
                ---Registro Estudiantes---
                Digite el nombre del estudiante: 
                """);
        nombre = entrada.nextLine();
    
        //llamar a la funcion 
        nombrevalido = validarnombre(nombre);
        if (!nombrevalido){
            System.out.println("Nombre no valido, intente nuevamente");}
        }
    // pedir notas
    
        //Con el bucle for se manejar el registro de las notas del estudiante
        for(int i = 1; i < 4; i++){
            //Validar nota
            boolean notaValida = false;
            double nota = 0;
            do{
                System.out.println("Digite la nota"+i+": ");
                nota = entrada.nextDouble();
                entrada.nextLine();
                //Llamar a la funcion
                notaValida =validarnota(nota);
                if (!notaValida){
                    System.out.println("Nota no valida, intente nuevamente");}
            }while(!notaValida);
             //Guardar el valor de las notas en la variable 
                if(i == 1) nota1 = nota;
                else if (i ==2) nota2 = nota;
                else nota3= nota;
        }
        System.out.println("Notas registradas correctamente");
    // mostrar resumen
        System.out.println("Confirmación antes de continuar");
        System.out.println("Nombre: " + nombre);
        System.out.printf("""
                Notas
                Nota1 : %.1f
                Nota2 : %.1f
                Nota3 : %.1f
                """,nota1,nota2,nota3);
    // pedir confirmación
    entrada.nextLine();
    System.out.print("Desea cambiar la información (SI/NO): ");
    String confirmacion = entrada.nextLine();
    if (confirmacion.equalsIgnoreCase("NO")) {
        registrado = true;
        System.out.println("Estudiante registrado correctamente.");
    } else {
        System.out.println("Repita el proceso de registro.");
    }

    } while (!registrado);
}
    
        //Funcion para mostrar la información del estudiante
        public static void mostrarinformacion(){
            if (nombre!= null && !nombre.isEmpty()){
            System.out.println("--Información del estudiante:\n");
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.printf("""
                Nota 1: %.1f
                Nota 2: %.1f
                Nota 3: %.1f """, nota1 , nota2 , nota3);
            }else{
                System.out.println("Estudiante Actual: N/A ");
            }
        }
        //Función para calcular promedio
        public static double calculos(){
            System.out.println("Promedio del estudiante: \n");
            resultado = (nota1 + nota2 + nota3)/3;
            System.out.printf("Promedio del estudiante: %.1f",resultado);
            return resultado;
        }
        //Función para validar nota
        public static boolean validarnota(double nota){
            return nota >= 0 && nota <= 100;
            
        }
        //Función para validar nombre
        public static boolean validarnombre(String nombre){
            return nombre != null && !nombre.isEmpty();
        }
        //Función para eliminar los datos del estudiante
        public static void borrar(Scanner entrada){
            entrada.nextLine();
            System.out.print("Digite el nombre del estudiante a eliminar: ");
            String nombreEliminar = entrada.nextLine();
            if (nombreEliminar.equalsIgnoreCase(nombre)){
                nombre = null;
                nota1 = 0.0;
                nota2 = 0.0;
                nota3 = 0.0;
                System.out.println("Estudiante eliminado correctamente");
            }
            else{
                System.out.println("Estudiante no encontrado");
            }
        }
}