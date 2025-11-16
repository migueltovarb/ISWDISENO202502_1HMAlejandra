package modelo;


public class Main {
    public static void main(String[] args) {
        Duenio duenio1 = new Duenio("Laura Gómez", "12345678", "3104567890");

        Mascota mascota1 = new Mascota("Firulais", "Perro", 5, duenio1);
        Mascota mascota2 = new Mascota("Mishi", "Gato", 2, duenio1);

        duenio1.agregarMascota(mascota1);
        duenio1.agregarMascota(mascota2);

        Control control1 = new Control("2025-10-01", Tipo.VACUNA, "Vacuna aplicada.");
        Control control2 = new Control("2025-09-20", Tipo.CHEQUEO, "En buen estado.");

        mascota1.agregarControl(control1);
        mascota1.agregarControl(control2);

        System.out.println(duenio1);
        for (Mascota m : duenio1.getMascotas()) {
            System.out.println(m);
            for (Control c : m.getControles()) {
                System.out.println("   → " + c);
            }
        }
    }
}
