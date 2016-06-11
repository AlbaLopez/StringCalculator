package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringCalculator {

    public static int Add(String string) {

        int sum = 0;
        if (!string.isEmpty()) { //SOLO SE EJECUTA SI NO ES VACIO
            int[] elementsSum;
            elementsSum = divideNumSum(string);
            for (int i = 0; i < elementsSum.length; i++) {
                sum += elementsSum[i];
            }
        }
        return sum;
    }

    public static int[] divideNumSum(String string) {

        String delimiters = "\n|,"; // DELIMITADOR POR DEFECTO 

        Pattern pattern2 = Pattern.compile("\\\\(\\[.*\\])+\\n(.*)"); //PATRON QUE VAMOS A BUSCAR PARA EL DELIMITADOR

        Matcher matcher = pattern2.matcher(string); //MATCHER PARA BUSCAR

        if (matcher.find()) {//SI ENCONTRAMOS COINCIDENCIA

            String delimitersChange = matcher.group(1); //GUARDAMOS EL PRIMER GRUPO EN DELIMITADORES
            string = matcher.group(2); //GUARDAMOS EL SEGUNDO GRUPO EN LA CADENA A SUMAR
            delimiters = clearString(delimitersChange)[0]; //SE GUARDA EL PRIMER VALOR DE NUESTRO ARRAY DE 
                                                            //DELIMITADORES
            for (int i = 1; i < clearString(delimitersChange).length; i++) { //CONCATENAMOS TODOS LOS ELEMENTOS 
                //RESTANTES DEL ARRAY
                delimiters = delimiters + "|" + clearString(delimitersChange)[i];
            }
        }

        return extractNumbers(delimiters, string); //DEVOLVEMOS EL ARRAY CON LOS NUMEROS
        //SEPARADOS PARA HACER LA SUMA
    }

    public static int[] extractNumbers(String delimiters, String string) {

        Pattern pattern = Pattern.compile(delimiters); //DELIMITADORES QUE VAMOS A USAR

        String[] substring = pattern.split(string); //SEPARAMOS CADA DÍGITO
        int[] numbers = new int[substring.length]; //CREAMOS EL ARRAY NUMÉRICO PARA GUARDARLOS

        for (int i = 0; i < substring.length; i++) {
            numbers[i] = Integer.parseInt(substring[i]); //PARSEAMOS LA CADENA EN ENTEROS
            if (numbers[i] > 999) { //COMPROBAMOS SI ES MAYOR DE 1000 Y SI LO ES LE ASIGNAMOS 0
                numbers[i] = 0;
            }
            if (numbers[i] < 0) { //COMPROBAMOS SI ES NEGATIVO PARA FINALIZAR EL PROGRAMA Y PONER EL ERROR
                throw new RuntimeException("El argumento " + numbers[i] + " no puede ser negativo");
            }
        }
        return numbers; //DEVOLVEMOS EL ARRAY
    }

    public static String[] clearString(String cadena) { //ESTA FUNCIÓN LIMPIA NUESTRA CADENA DE DELIMITADORES
        cadena = cadena.replace("[", "");               //Y LA SUBDIVIDE EN UN ARRAY PARA CONCATENARLOS
        cadena = cadena.replace("]", " ");              //DESPUES CON EL | (O DE NUESTRA EXPRESIÓN REGULAR)
        String[] subdelimiters = cadena.split(" ");
        return subdelimiters;
    }

    public static void main(String[] args) {

        StringCalculator calculator = new StringCalculator();

        //RECUERDA QUE ESTAMOS CREANDO UN OBJETO CALCULADOR Y CAMBIANDO 
        //SUS DELIMITADORES AL INTRODUCIR LA CADENA DE TEXTO //[DELIMITADOR]
        //ESTA ES UNA PRUEBA ASCENDENTE EN LA QUE VAMOS AGREGANDO DELIMITADORES
        //Y PROBANDO QUE ESTÉ TODO CORRECTO.
        String prueba = "100,256,3";
        System.out.println("Prueba delimitador por defecto");
        System.out.println("Resultado esperado : 359 , Resultado obtenido : " + calculator.Add(prueba) + "\n");

        String prueba2 = "1000,256,3";
        System.out.println("Prueba delimitador por defecto con numero mayor de tres digitos");
        System.out.println("Resultado esperado : 259 , Resultado obtenido :  " + calculator.Add(prueba2) + "\n");

        String prueba3 = "\\[;]\n100;256;3";
        System.out.println("Prueba cambiando delimitador");
        System.out.println("Resultado esperado : 359 , Resultado obtenido : " + calculator.Add(prueba3) + "\n");

        String prueba4 = "\\[;][a]\n100a256;3";
        System.out.println("Prueba cambiando a dos delimitadores");
        System.out.println("Resultado esperado : 359 , Resultado obtenido :  " + calculator.Add(prueba4) + "\n");

        String prueba5 = "\\[;][a]\n-100;256;3";
        System.out.println("Error número negativo");
        calculator.Add(prueba5);

    }

}
