import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Consola {

    public Scanner scan = new Scanner(System.in);
    public Modelo modelo = new Modelo();

    public void Iniciar () {

        int controlador = 3;
        while (controlador < 4){
            System.out.println("-----------------------------------------------------");
            System.out.println("------------¡Bienvenido a Mi Parqueadero!------------");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Parquear en una universidad.");
            System.out.println("2. Salir del parqueadero.");
            System.out.println("3. Salir.");
            System.out.println("-----------------------------------------------------");
            System.out.println("Digita el número de la opción: ");
            String action = scan.nextLine();
            scan.nextLine();
            if (action.equals("1")) {
                IntStream.range(1, modelo.getUniversidades().size()+1)
                        .forEachOrdered(i -> {
                            String universidad = modelo.getUniversidades().get(i - 1).nombre_universidad;
                            System.out.println("Índice: " + i + ", Universidad: " + universidad);
                        });

                Integer eleccion;
                do {
                    eleccion = scan.nextInt();
                    if (eleccion >= 1 && eleccion <= modelo.getUniversidades().size() + 1) {
                        break;
                    }
                    System.out.println("Digita una opción correcta, ingresala de nuevo.");
                } while (true);

                String placa;
                do {
                    System.out.println("Digita tu placa: ");
                    placa = scan.nextLine();
                    if (!validarPlaca(placa)) {
                        break;
                    }
                    System.out.println("La placa no es válida.");
                } while (true);

                String resultado = modelo.entrar_universidad(placa, modelo.getUniversidades().get(eleccion));
                System.out.println(resultado);

            }

            else if (action.equals("2")) {
                String placa;
                do {
                    System.out.println("Digita tu placa: ");
                    placa = scan.nextLine();
                    if (!validarPlaca(placa)) {
                        break;
                    }
                    System.out.println("La placa no es válida.");
                } while (true);
                String resultado = modelo.salir_universidad(placa);
                System.out.println(resultado);
            }
            else if (action.equals("3")) {
                System.out.println("¡Vuelva pronto!");
                System.out.println("-----------------------------------------------------");
                controlador ++;
            }
            else {
                System.out.println("Por favor digitar una opción válida.");
            }
        }
    }
public static boolean validarPlaca(String placa) {
    String patron = "^[A-Za-z]{3}\\d{3}$";

    //
    // Compilar la expresión regular en un objeto Pattern
    Pattern pattern = Pattern.compile(patron);

    // Crear un objeto Matcher para hacer coincidir la placa con el patrón
    Matcher matcher = pattern.matcher(placa);

    // Comprobar si la placa coincide con el patrón
    return matcher.matches();
    }
    }


