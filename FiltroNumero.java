import java.util.ArrayList;
import java.util.List;

public class FiltroNumero {
    public static List<Integer> filtrarNumeros(List<Integer> numeros) {
        List<Integer> salida = new ArrayList<>();
        
        for (int numero : numeros) {
            if (numero % 5 == 0 && numero <= 600) {
                salida.add(numero);
            }
            if (numero > 1000) {
                break;
            }
        }
        
        return salida;
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> entrada = new ArrayList<>();
        entrada.add(25);
        entrada.add(550);
        entrada.add(700);
        entrada.add(950);
        entrada.add(1100);
        
        List<Integer> salida = filtrarNumeros(entrada);
        System.out.println(salida);  // Salida esperada: [25, 500]
    }
}

