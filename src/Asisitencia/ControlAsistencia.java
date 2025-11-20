package Asisitencia;

import java.util.Scanner;

public class ControlAsistencia {
    
    private static final int DIAS_SEMANA = 5;
    private static final int NUM_ESTUDIANTES = 4;

    //SINGLETON
    private static ControlAsistencia instancia;

    // ASISTEN DAT
    private char[][] asistencia;
    private String[] nombres;

    private Scanner sc = new Scanner(System.in);

    // PRIV CONSTRAT
    private ControlAsistencia() {
        asistencia = new char[NUM_ESTUDIANTES][DIAS_SEMANA];
        nombres = new String[NUM_ESTUDIANTES];
    }

    // MET STATIC
    public static ControlAsistencia getInstancia() {
        if (instancia == null) {
            instancia = new ControlAsistencia();
        }
        return instancia;
    }

    // ADD STUDENTAND ASIS
    public void registrarAsistencia() {
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            
           System.out.println("\nRegistrando estudiante " + (i + 1));
            
           
           System.out.print("Ingrese nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.next();

      // ASIST - DAY
      for (int j = 0; j < DIAS_SEMANA; j++) {
        char valor;
            do {
            System.out.print("  Día " + (j + 1) + " (P/A): ");
            String entrada = sc.nextLine().toUpperCase();
            
               if (entrada.length() == 1 && (entrada.charAt(0) == 'P' || entrada.charAt(0) == 'A')) {
                        valor = entrada.charAt(0);
                        asistencia[i][j] = valor;
                        break;
              } else {
                System.out.println("Entrada inválida. Solo se acepta 'P' o 'A'.");
                valor = 'X'; // PROVITIONAL
          }
          } while (valor == 'X');
        }
       }
        System.out.println("Registro completado.");
       }
    

    // ASIST INDI
    public void verAsistenciaIndividual() {
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print(nombres[i] + ": ");
            for (int j = 0; j < DIAS_SEMANA; j++) {
                System.out.print(asistencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // GENERAL
    public void verResumenGeneral() {
        System.out.println("\n--- Total de asistencias por estudiante ---");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            int total = 0;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j] == 'P') total++;
            }
            System.out.println(nombres[i] + ": " + total);
        }

        System.out.println("\n--- Estudiantes que asistieron todos los días ---");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            boolean todos = true;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j] == 'A') {
                    todos = false;
                    break;
                }
            }
            if (todos) System.out.println(nombres[i]);
        }

        System.out.println("\n--- Día con mayor número de ausencias ---");
        int maxAusencias = -1;
        int diaMayor = -1;
        for (int j = 0; j < DIAS_SEMANA; j++) {
            int ausencias = 0;
            for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                if (asistencia[i][j] == 'A') ausencias++;
            }
            if (ausencias > maxAusencias) {
                maxAusencias = ausencias;
                diaMayor = j + 1;
            }
        }
        System.out.println("Día " + diaMayor + " con " + maxAusencias + " ausencias.");
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlAsistencia sistema = ControlAsistencia.getInstancia();
        boolean datosIngresados = false;
        int opcion;
    // MENU
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver asistencia individual");
            System.out.println("2. Ver resumen general");
            System.out.println("3. Registrar asistencia");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (datosIngresados) sistema.verAsistenciaIndividual();
                    else System.out.println("Primero debe registrar asistencia.");
                    break;
                case 2:
                    if (datosIngresados) sistema.verResumenGeneral();
                    else System.out.println("Primero debe registrar asistencia.");
                    break;
                case 3:
                    sistema.registrarAsistencia();
                    datosIngresados = true;
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción invalida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}



