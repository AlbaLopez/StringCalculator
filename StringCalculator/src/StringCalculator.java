/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public StringCalculator() {

    }

    public static int Add(String cadena) {
        int sumatorio = 0;
        if (!cadena.isEmpty()) {
            int[] terminosSuma;
            terminosSuma = separarNumeros(cadena);
            for (int i = 0; i < terminosSuma.length; i++) {
                sumatorio += terminosSuma[i];
            }
        }
        return sumatorio;
    }
 
    public static int[] separarNumeros(String cadena) {

        String delimiters = "(,)|(\\s)";

        String[] subcadena = cadena.split(delimiters);
        int[] numeros = new int[subcadena.length];
        for (int i = 0; i < subcadena.length; i++) {
            numeros[i] = Integer.parseInt(subcadena[i]);

            if (numeros[i] > 999) {
                numeros[i] = 0;
            }
            if (numeros[i] < 0) {
                System.out.println("Negativos no soportados : " + numeros[i]);
                System.exit(-1);
            }
        }
        return numeros;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader leer = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(leer);
        System.out.print("Introduzca números separados por , o espacio en blanco :");
        String texto = buff.readLine();
        StringCalculator calculator = new StringCalculator();
        int suma = calculator.Add(texto);
        System.out.println(suma);

    }
}
