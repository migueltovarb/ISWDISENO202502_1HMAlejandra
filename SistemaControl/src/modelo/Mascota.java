package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private Duenio duenio;
    private List<Control> controles;

    public Mascota() {
        this.controles = new ArrayList<>();
    }

    public Mascota(String nombre, String especie, int edad, Duenio duenio) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.duenio = duenio;
        this.controles = new ArrayList<>();
    }

    public Mascota(String nombre2, String especie2, int edad2) {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public List<Control> getControles() {
        return controles;
    }

    public void agregarControl(Control control) {
        if (control != null) {
            controles.add(control);
        }
    }

    public int getCantidadControles() {
        return controles.size();
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                ", duenio=" + (duenio != null ? duenio.getNombreCompleto() : "Sin dueño") +
                ", controles=" + controles.size() +
                '}';
    }
}

