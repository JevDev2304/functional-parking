import java.util.Arrays;
import java.util.Optional;
import java.util.List;

public class Universidad {
   String nombre_universidad;
   List<Parqueadero> parqueaderos;
   Universidad(String nombre_universidad){
       this.nombre_universidad = nombre_universidad;
       this.parqueaderos = Arrays.asList(new Parqueadero[]{new Parqueadero("Cafeteria"),
                       new Parqueadero("Teatro"),
                       new Parqueadero("Derecho"),
                       new Parqueadero("Ingenierías")});}

    public boolean estaPlaca(String placa){
       return this.parqueaderos.stream().anyMatch(parqueadero -> parqueadero.estaPlaca(placa));
    }

    public String entrar(String placa) {
       Optional<Parqueadero> parqueaderoEncontrado = this.parqueaderos.stream()
               .filter(parqueadero -> !parqueadero.estaLleno())
               .findFirst();
       if (parqueaderoEncontrado.isPresent()) {
           return parqueaderoEncontrado.get().entrar(placa)+ " de la "+ this.nombre_universidad+".";
       } else {
          return "No se pudo ingresar al parqueadero de la "+ this.nombre_universidad + " porque están llenos.";
       }

    }
    public String salir(String placa){
        Optional<Parqueadero> parqueaderoEncontrado = this.parqueaderos.stream()
                .filter(parqueadero -> parqueadero.estaPlaca(placa))
                .findFirst();
        if (parqueaderoEncontrado.isPresent()) {
            return parqueaderoEncontrado.get().salir(placa)+ " de la "+ this.nombre_universidad+".";
        } else {
            return "No se encuentra parqueado el carro con placa "+placa +" de la "+ this.nombre_universidad + ".";
        }

    }}





