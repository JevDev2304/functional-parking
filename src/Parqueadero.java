import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parqueadero {
    String nombre_parqueadero;
    List<String> celdas;

    Parqueadero(String nombre_parqueadero) {
        this.celdas = Arrays.asList(new String[]{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"});
    }

    private void cambiarCelda(String valor_actual ,String valor_nuevo) {
        AtomicBoolean found = new AtomicBoolean(false);
        List newCeldas = (this.celdas.stream().map(celda -> {
            if (!found.get() && celda.equals(valor_actual)) {
                found.set(true);
                return valor_nuevo;
            } else {
                return celda;
            }
        }).collect(Collectors.toList()));

        this.celdas = newCeldas;
        System.out.println(this.celdas);
    }
    public boolean estaLleno() {
        return this.celdas.stream().noneMatch(celda -> celda.equals("0"));
    }
    private int obtenerCeldaParqueadero(String placa){
       Integer indice = this.celdas.stream()
               .filter(celda -> celda.equals(placa))
               .findFirst().map(celda -> this.celdas.indexOf(celda))
               .orElse(-1);
       return indice;
    }


    public String entrar(String placa) {
        cambiarCelda("0", placa);
        Integer posicion = obtenerCeldaParqueadero(placa);
        return posicion == -1 ? "No se pudo ingresar al "+this.getNombre_parqueadero()
                : "Ingresado en la celda " + posicion + " en el  parqueadero "+ this.getNombre_parqueadero();


    }

    public String getNombre_parqueadero() {
        return nombre_parqueadero;
    }

    public String salir (String placa){
        cambiarCelda(placa, "0");
        Integer posicion = obtenerCeldaParqueadero(placa);
        return posicion == -1 ? "No se encontro la placa del carro en el parqueadero "+this.getNombre_parqueadero()
                : "Saliendo de la celda " + posicion + "en el  parqueadero "+ this.getNombre_parqueadero();
    }

    public boolean estaPlaca(String placa){
        return this.celdas.stream().anyMatch(celda -> celda.equals(placa));}
}







