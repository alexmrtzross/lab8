import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Hashtable tabla = new Hashtable();
        Paciente paciente[] = new Paciente[100];

        // declaracion de variables
        String primnombre = "";
        String segnombre = "";
        String primapellido = "";
        String segapellido = "";
        String fecha = "";
        String id = "";
        int seguro = 0;
        String anio = "";
        String mes = "";
        String dia = "";
        char nom1 = ' ';
        char nom2 = ' ';
        char ape1 = ' ';
        char ape2 = ' ';
        int pos = 0;

        int opcion = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Gestion de pacientes" + "\n");
            System.out.println("1. Generar ID");
            System.out.println("2. Insertar datos de paciente");
            System.out.println("3. Buscar paciente por nombre e ID");
            System.out.println("4. Borrar HashTable");
            System.out.println("5. Eliminar paciente");
            System.out.println("6. Lista de pacientes");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    try {
                        System.out.println("\n");
                        System.out.print("Ingrese el primer nombre: ");
                        primnombre = sc.nextLine();
                        System.out.print("Ingrese el segundo nombre: ");
                        segnombre = sc.nextLine();
                        System.out.print("Ingrese el primer apellido: ");
                        primapellido = sc.nextLine();
                        System.out.print("Ingrese el segundo apellido: ");
                        segapellido = sc.nextLine();
                        try {
                            System.out.print("Ingrese el anio de nacimiento(Formato aaaa): ");
                            anio = sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Formato de fecha incorrecto");

                            break;
                        }
                        nom1 = HashKey(primnombre);
                        nom2 = HashKey(segnombre);
                        ape1 = HashKey(primapellido);
                        ape2 = HashKey(segapellido);
                        id = "" + nom1 + nom2 + ape1 + ape2 + anio.substring(2, 4);
                        System.out.println("El ID del paciente es: " + id);
                        // to-do hacer la posicion en base a la hashvalue
                        pos = HashValue(id);
                        System.out.println("La posicion en donde ingresar al paciente en la tabla es: " + pos);
                        System.out.println("\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas");
                        break;
                    }

                case 2:

                    System.out.println("\n");
                    try {
                        System.out.print("Ingrese el primer nombre: ");
                        primnombre = sc.nextLine();
                        System.out.print("Ingrese el segundo nombre: ");
                        segnombre = sc.nextLine();
                        System.out.print("Ingrese el primer apellido: ");
                        primapellido = sc.nextLine();
                        System.out.print("Ingrese el segundo apellido: ");
                        segapellido = sc.nextLine();
                        System.out.print("Ingrese el anio de nacimiento(Formato aaaa): ");
                        anio = sc.nextLine();
                        System.out.print("Ingrese el numero de seguro: ");
                        seguro = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas");
                        break;
                    }
                    nom1 = HashKey(primnombre);
                    nom2 = HashKey(segnombre);
                    ape1 = HashKey(primapellido);
                    ape2 = HashKey(segapellido);
                    id = "" + nom1 + nom2 + ape1 + ape2 + anio.substring(2, 4);
                    System.out.println("El ID del paciente es: " + id);
                    // to-do hacer la posicion en base a la hashvalue
                    pos = HashValue(id);
                    fecha = dia + "/" + mes + "/" + anio;
                    for (int i = 0; i < paciente.length; i++) {
                        if (paciente[i] == null) {
                            // compara el id, si ya existe no lo agrega y muestra mensaje
                            if (paciente[i].getId().equals(id)) {
                                System.out.println("El paciente ya existe");
                                break;
                            } else {
                                paciente[i] = new Paciente(primnombre, segnombre, primapellido, segapellido, fecha,
                                        id, seguro);
                                // ingresar a la tabla
                                tabla.put(pos, paciente[pos]);
                                System.out.println("Paciente ingresado con exito" + "\n");
                                break;
                            }
                        }
                    }
                    break;

                case 3:
                    try {
                        System.out.println("\n");
                        System.out.println("1.Buscar por nombre.");
                        System.out.println("2.Buscar por ID.");
                        System.out.print("Ingrese una opcion: ");
                        int op = sc.nextInt();
                        if (op == 1) {
                            sc.nextLine();
                            System.out.print("Ingrese el primer nombre: ");
                            primnombre = sc.nextLine();
                            System.out.print("Ingrese el segundo nombre: ");
                            segnombre = sc.nextLine();
                            System.out.print("Ingrese el primer apellido: ");
                            primapellido = sc.nextLine();
                            System.out.print("Ingrese el segundo apellido: ");
                            segapellido = sc.nextLine();
                            if (tabla.containsValue(primnombre) && tabla.containsValue(segnombre)
                                    && tabla.containsValue(primapellido) && tabla.containsValue(segapellido)) {
                                System.out.println("El paciente existe");
                                for (int i = 0; i < paciente.length; i++) {
                                    if (paciente[i].getPrimnombre().equals(primnombre)
                                            && paciente[i].getSegnombre().equals(segnombre)
                                            && paciente[i].getPrimapellido().equals(primapellido)
                                            && paciente[i].getSegapellido().equals(segapellido)) {
                                        System.out.println("Nombre: " + paciente[i].getPrimnombre() + " "
                                                + paciente[i].getSegnombre() + " " + paciente[i].getPrimapellido() + " "
                                                + paciente[i].getSegapellido());
                                        System.out.println("Fecha de nacimiento: " + paciente[i].getFecha());
                                        System.out.println("ID: " + paciente[i].getId());
                                        System.out.println("Numero de seguro: " + paciente[i].getSeguro());
                                    }
                                }
                            } else {
                                System.out.println("El paciente no existe" + "\n");
                            }
                        } else if (op == 2) {
                            System.out.print("Ingrese el ID del paciente: ");
                            id = sc.nextLine();
                            if (tabla.containsValue(id)) {
                                System.out.println("El paciente existe");
                                for (int i = 0; i < paciente.length; i++) {
                                    if (paciente[i].getId().equals(id)) {
                                        System.out.println("Nombre: " + paciente[i].getPrimnombre() + " "
                                                + paciente[i].getSegnombre() + " " + paciente[i].getPrimapellido() + " "
                                                + paciente[i].getSegapellido());
                                        System.out.println("Fecha de nacimiento: " + paciente[i].getFecha());
                                        System.out.println("ID: " + paciente[i].getId());
                                        System.out.println("Numero de seguro: " + paciente[i].getSeguro());
                                    }
                                }
                            } else {
                                System.out.println("El paciente no existe" + "\n");
                            }

                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas" + "\n");
                        break;
                    }

                case 4:
                    try {
                        System.out.println("\n");
                        // elimnar tabla
                        tabla.clear();
                        // eliminar pacientes
                        for (int i = 0; i < paciente.length; i++) {
                            paciente[i] = null;
                        }
                        System.out.println("Tabla y pacientes eliminados con exito" + "\n");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas" + "\n");
                        break;
                    }

                case 5:
                    try {
                        System.out.println("\n");
                        System.out.print("Ingrese el ID del paciente a eliminar: ");
                        id = sc.nextLine();
                        if (tabla.containsValue(id)) {
                            System.out.println("El paciente existe");
                            for (int i = 0; i < paciente.length; i++) {
                                if (paciente[i].getId().equals(id)) {
                                    paciente[i] = null;
                                    tabla.remove(i);
                                }
                            }
                            System.out.println("Paciente eliminado con exito" + "\n");
                        } else {
                            System.out.println("El paciente no existe" + "\n");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas");

                        break;
                    }

                case 6:
                    try {
                        System.out.println("\n");
                        for (int i = 0; i < paciente.length; i++) {
                            if (paciente[i] != null) {
                                String[] fechaa = paciente[i].getFecha().split("/");
                                int diaa = Integer.parseInt(fechaa[0]);
                                int mmes = Integer.parseInt(fechaa[1]);
                                int aanio = Integer.parseInt(fechaa[2]);
                                int edad = 2020 - aanio;
                                System.out.println("Nombre: " + paciente[i].getPrimnombre() + " "
                                        + paciente[i].getPrimapellido() + " " + paciente[i].getId());
                                System.out.println("Edad: " + edad);
                            }
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error, variables no validas" + "\n");
                        break;
                    }

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 7);

    }

    public static char HashKey(String dato) {
        return dato.toUpperCase().charAt(0);
    }

    public static int HashValue(String dato) {
        int suma = 0;
        for (int i = 0; i < dato.length(); i++) {
            suma += (int) dato.charAt(i);
        }
        int hashvalue = suma % 30;
        return hashvalue;
    }

}
