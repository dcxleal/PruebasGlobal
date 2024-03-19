public class SumaSerie {
    public static int sumaSerie(int numero, int terminos) {
        int sumaTotal = 0;
        int numeroActual = 0;
        
        for (int i = 0; i < terminos; i++) {
            numeroActual = numeroActual * 10 + numero;
            sumaTotal += numeroActual;
            
        }
        return sumaTotal;
    }
    
    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(sumaSerie(2, 4));  // Salida: 37035
        System.out.println(sumaSerie(4, 2));  // Salida: 615
    }
}
