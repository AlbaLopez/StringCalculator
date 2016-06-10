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
    
    
    
    
1
2
3
4
5
6
7
8
9
10
11
12
String patron = "([0-9]{8})([A-Z])";//Indicamos que queremos 8 numeros, seguidos de una letra (DNI)
//Con el parentesis se puede obtener solo una parte de la coincidencia
Pattern p = Pattern.compile(patron);
 
String texto = "Juan Garcia : 12345678X";
Matcher matcher = p.matcher(texto);
 
while(matcher.find()){
    System.out.printf("NIF Encontrado : %s - %s",
            matcher.group(1),//Con el group, decimos que parámetro queremos mostrar
            matcher.group(2));
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
