package modelo;

import java.util.ArrayList;
import java.util.List;

public class Duenio {
    private String nombreCompleto;
    private String documento;
    private String telefono;
    private List<Mascota> mascotas;

    public Duenio() {
        this.mascotas = new ArrayList<>();
    }

    public Duenio(String nombreCompleto, String documento, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.mascotas = new ArrayList<>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        boolean existe = mascotas.stream()
                .anyMatch(m -> m.getNombre().equalsIgnoreCase(mascota.getNombre()));

        if (!existe) {
            mascotas.add(mascota);
        } else {
            System.out.println("⚠️ Ya existe una mascota con ese nombre para este dueño.");
        }
    }

    @Override
    public String toString() {
        return "Duenio{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documento='" + documento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cantidadMascotas=" + mascotas.size() +
                '}';
    }

	public Object buscarMascota(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}

