
package conversor;

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class conversorn {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada desde la consola

        // Muestra el menú de opciones al usuario
        System.out.println("1. Binario a octal\n" +
                "2. Binario a decimal\n" +
                "3. Binario a hexadecimal\n" +
                "4. Octal a binario\n" +
                "5. Octal a decimal\n" +
                "6. Octal a hexadecimal\n" +
                "7. Decimal a binario\n" +
                "8. Decimal a octal\n" +
                "9. Decimal a hexadecimal\n" +
                "10. Hexadecimal a binario\n" +
                "11. Hexadecimal a octal\n" +
                "12. Hexadecimal a decimal\n" +
                "Seleccione: ");

        int eleccion = scanner.nextInt(); // Lee la opción seleccionada por el usuario
        scanner.nextLine(); // Consumir el salto de línea después de leer el entero

        // Verifica si la opción seleccionada está dentro del rango permitido
        if (eleccion < 1 || eleccion > 12) {
            System.out.println("Elección no válida");
            return; // Termina el programa si la elección no es válida
        }

        // Solicita al usuario que ingrese el número a convertir
        System.out.print("Ingrese el número: ");
        String input = scanner.nextLine(); // Lee el número ingresado como una cadena

        // Utiliza una estructura switch para realizar la conversión seleccionada
        switch (eleccion) {
            case 1 -> System.out.println("El octal es " + decimalAOctal(binarioADecimal(input)));
            // Convierte binario a decimal, luego a octal, y muestra el resultado
            case 2 -> System.out.println("El decimal es " + binarioADecimal(input));
            // Convierte binario a decimal y muestra el resultado
            case 3 -> System.out.println("El hexadecimal es " + decimalAHexadecimal(binarioADecimal(input)));
            // Convierte binario a decimal, luego a hexadecimal, y muestra el resultado
            case 4 -> System.out.println("El binario es " + decimalABinario(octalADecimal(input)));
            // Convierte octal a decimal, luego a binario, y muestra el resultado
            case 5 -> System.out.println("El decimal es " + octalADecimal(input));
            // Convierte octal a decimal y muestra el resultado
            case 6 -> System.out.println("El hexadecimal es " + decimalAHexadecimal(octalADecimal(input)));
            // Convierte octal a decimal, luego a hexadecimal, y muestra el resultado
            case 7 -> System.out.println("El binario es " + decimalABinario(Integer.parseInt(input)));
            // Convierte decimal a binario y muestra el resultado
            case 8 -> System.out.println("El octal es " + decimalAOctal(Integer.parseInt(input)));
            // Convierte decimal a octal y muestra el resultado
            case 9 -> System.out.println("El hexadecimal es " + decimalAHexadecimal(Integer.parseInt(input)));
            // Convierte decimal a hexadecimal y muestra el resultado
            case 10 -> System.out.println("El binario es " + decimalABinario(hexadecimalADecimal(input)));
            // Convierte hexadecimal a decimal, luego a binario, y muestra el resultado
            case 11 -> System.out.println("El octal es " + decimalAOctal(hexadecimalADecimal(input)));
            // Convierte hexadecimal a decimal, luego a octal, y muestra el resultado
            case 12 -> System.out.println("El decimal es " + hexadecimalADecimal(input));
            // Convierte hexadecimal a decimal y muestra el resultado
        }
    }

    // Método que valida si una cadena es un número binario válido (solo contiene 0s y 1s)
    public static boolean validarBinario(String binario) {
        return binario.matches("[01]+"); // Usa una expresión regular para comprobar que solo contiene 0s y 1s
    }

    // Método que valida si una cadena es un número octal válido (solo contiene dígitos del 0 al 7)
    public static boolean validarOctal(String octal) {
        return octal.matches("[0-7]+"); // Usa una expresión regular para comprobar que solo contiene dígitos del 0 al 7
    }

    // Método que valida si una cadena es un número hexadecimal válido (solo contiene 0-9, A-F o a-f)
    public static boolean validarHexadecimal(String hexadecimal) {
        return hexadecimal.matches("[0-9A-Fa-f]+"); // Usa una expresión regular para comprobar que solo contiene dígitos hexadecimales
    }

    // Método que convierte un número binario (en forma de cadena) a decimal
    public static int binarioADecimal(String binario) {
        if (!validarBinario(binario)) throw new IllegalArgumentException("Número binario no válido");
        // Si no es un número binario válido, lanza una excepción
        return Integer.parseInt(binario, 2); // Convierte la cadena binaria a entero en base 2 (binario)
    }

    // Método que convierte un número octal (en forma de cadena) a decimal
    public static int octalADecimal(String octal) {
        if (!validarOctal(octal)) throw new IllegalArgumentException("Número octal no válido");
        // Si no es un número octal válido, lanza una excepción
        return Integer.parseInt(octal, 8); // Convierte la cadena octal a entero en base 8 (octal)
    }

    // Método que convierte un número hexadecimal (en forma de cadena) a decimal
    public static int hexadecimalADecimal(String hexadecimal) {
        if (!validarHexadecimal(hexadecimal)) throw new IllegalArgumentException("Número hexadecimal no válido");
        // Si no es un número hexadecimal válido, lanza una excepción
        return Integer.parseInt(hexadecimal, 16); // Convierte la cadena hexadecimal a entero en base 16 (hexadecimal)
    }

    // Método que convierte un número decimal a binario (devuelve una cadena)
    public static String decimalABinario(int decimal) {
        return Integer.toBinaryString(decimal); // Convierte un número decimal a una cadena binaria
    }

    // Método que convierte un número decimal a octal (devuelve una cadena)
    public static String decimalAOctal(int decimal) {
        return Integer.toOctalString(decimal); // Convierte un número decimal a una cadena octal
    }

    // Método que convierte un número decimal a hexadecimal (devuelve una cadena en mayúsculas)
    public static String decimalAHexadecimal(int decimal) {
        return Integer.toHexString(decimal).toUpperCase(); // Convierte un número decimal a una cadena hexadecimal en mayúsculas
    }
}