import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Modelo {
    private List<Universidad> Universidades;
    Modelo(){
        this.Universidades= Arrays.asList(new Universidad[]{});;
        this.Universidades.add(new Universidad("EAFIT"));
        this.Universidades.add(new Universidad("Universidad de Medellín"));
        this.Universidades.add(new Universidad("Universidad de Antioquia"));
        this.Universidades.add(new Universidad("Universidad Nacional"));
    }

    public List<Universidad> getUniversidades() {
        return Universidades;
    }
    public String entrar_universidad(String placa, Universidad universidad){
        return universidad.entrar(placa);
    }

    public String salir_universidad(String placa){
        Optional<Universidad> universidad = this.Universidades.stream().filter(uni -> uni.estaPlaca(placa)).findFirst();
        if (universidad.isPresent()){
            return universidad.get().salir(placa);
        }
        else{
            return "La placa ingresada no ha sido parqueada en ninguna universidad.";
        }
    }
}
