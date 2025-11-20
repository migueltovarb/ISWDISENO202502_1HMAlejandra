package modelo;

public class Control {
    private String fecha;
    private Tipo tipo;
    private String observaciones;

    public Control() {}

    public Control(String fecha, Tipo tipo, String observaciones) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Control{" +
                "fecha='" + fecha + '\'' +
                ", tipo=" + tipo +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}

