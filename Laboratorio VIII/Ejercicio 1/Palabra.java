import java.util.LinkedList;

public class Palabra {
    

    public String palabra;
    public String significado;
    public String id;


    static LinkedList[] diccionario = new LinkedList[150];

    public Palabra(String palabra, String id, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public Palabra() {
    }

    public void agregarPalabra(String palabra, String significado){
        for (int i = 0; i < diccionario.length; i++) {
            diccionario[i] = new LinkedList();
            diccionario[i].add(palabra);
            diccionario[i].add(significado);
        }
    
    }
    


    public String buscarPalabra(String palabra){
        for (int i = 0; i < diccionario.length; i++) {
            if (diccionario[i].contains(palabra)) {
                return palabra + " significa: " + diccionario[i].get(1);
            }
        }
        return "La palabra no existe";
    }

    public void mostrarPalabra() {
        System.out.println(palabra + " significa: " + significado);
    }



}
