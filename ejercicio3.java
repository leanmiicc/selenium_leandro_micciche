import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        int resultadoFinal = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int num = input.nextInt();

        resultadoFinal = calcularDoble(num);
        System.out.println("El doble es: " + resultadoFinal);

    }

    public static int calcularDoble (int num){
        int resultado = 0;
        resultado = num * 2;
        return resultado;
    }

}
