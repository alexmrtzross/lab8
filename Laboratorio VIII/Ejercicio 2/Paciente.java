import java.util.Hashtable;
public class Paciente {
    
    public String primnombre;
    public String segnombre;
    public String primapellido;
    public String segapellido;
    public String fecha;
    public String dia;
    public String mes;
    public String anio;
    public String id;
    public int seguro;
    Hashtable tabla = new Hashtable();

    public Paciente(String primnombre, String segnombre, String primapellido, String segapellido, String fecha, String id, int seguro) {
        this.primnombre = primnombre;
        this.segnombre = segnombre;
        this.primapellido = primapellido;
        this.segapellido = segapellido;
        this.fecha = fecha;
        this.id = id;
        this.seguro = seguro;
    }
    
    public Paciente() {

    }

    public String getDia() {
        return dia;
    }


    public String getMes() {
        return mes;
    }

    public String getAnio() {
        return anio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrimnombre() {
        return primnombre;
    }

    public void setPrimnombre(String primnombre) {
        this.primnombre = primnombre;
    }

    public String getSegnombre() {
        return segnombre;
    }

    public void setSegnombre(String segnombre) {
        this.segnombre = segnombre;
    }

    public String getPrimapellido() {
        return primapellido;
    }

    public void setPrimapellido(String primapellido) {
        this.primapellido = primapellido;
    }

    public String getSegapellido() {
        return segapellido;
    }

    public void setSegapellido(String segapellido) {
        this.segapellido = segapellido;
    }

    public int getSeguro() {
        return seguro;
    }

    public void setSeguro(int seguro) {
        this.seguro = seguro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nombres: " + primnombre + " " + segnombre + "\n" + "Apellidos: " + primapellido + " " + segapellido + "\n" + "Fecha de nacimiento: " + getFecha() + "\n" + "ID: " + (String)id + "\n" + "Numero de seguro: " + seguro;
    }



}
