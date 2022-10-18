import java.util.Scanner;
import java.util.LinkedList;
public class Diccionario {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        Palabra[] palabra = new Palabra[150];
        for (int i = 0; i < palabra.length; i++) {
            palabra[i] = new Palabra();
        }
        Palabra p = new Palabra();

        /* Creo menu para el usuario con 3 opciones  */
        int opcion = 0;
        do {

            System.out.println("1. Ingresar nueva palabra");
            System.out.println("2. Buscar significado de palabra");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){

                case 1:
                    try {
                        System.out.print("Ingrese palabra: ");
                        String palabr = sc.next();
                        /*Sacar el primer caracter de palabra */
                        String id = palabr.substring(0, 1);
                        sc.nextLine();
                        System.out.print("Ingrese significado: ");
                        String significado = sc.nextLine();
                        p.agregarPalabra(palabr, significado);
                        System.out.println("Palabra agregada al diccionario con exito");
                        System.out.println("\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error al ingresar palabra");
                    }

                
                case 2:
                    System.out.print("Ingrese palabra: ");
                    String palabraBuscar = sc.next();
                    System.out.println(p.buscarPalabra(palabraBuscar));
                    System.out.println("\n");
                
                case 3:
                    System.out.println("Gracias por usar el diccionario");
                    break;

            }

        }while(opcion != 3);


    }
}
