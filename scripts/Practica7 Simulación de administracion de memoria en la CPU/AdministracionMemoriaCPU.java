
/**@author Jaczibeth Cruz*/
import java.util.HashMap; // Importa la clase HashMap para usar mapas.
import java.util.Map; // Importa la interfaz Map para definir mapas.

public class AdministracionMemoriaCPU { // Clase principal del programa.

    public static void main(String[] args) { // Método principal donde comienza la ejecución del programa.
        // Paso 1: Cargar el programa en memoria
        // Simulado con un mapa que contiene las instrucciones del programa.
        Map<Integer, String> programa = new HashMap<>(); // Declara un mapa donde la clave es el número de instrucción y el valor es la instrucción en texto.
        programa.put(0, "cargar 1 5"); // Instrucción para cargar el valor 5 en la variable 1.
        programa.put(1, "cargar 2 10"); // Instrucción para cargar el valor 10 en la variable 2.
        programa.put(2, "sumar 1 2 3"); // Instrucción para sumar las variables 1 y 2 y guardar el resultado en la variable 3.
        programa.put(3, "imprimir 3"); // Instrucción para imprimir el valor de la variable 3.

        // Paso 2: Asignar espacio de memoria a las variables
        // Simulado con un mapa que contiene las variables y sus valores inicializados.
        Map<Integer, Integer> memoria = new HashMap<>(); // Declara un mapa donde la clave es el identificador de la variable y el valor es su contenido.
        memoria.put(1, 0); // Inicializa la variable 1 con valor 0.
        memoria.put(2, 0); // Inicializa la variable 2 con valor 0.
        memoria.put(3, 0); // Inicializa la variable 3 con valor 0.

        // Paso 3 y 4: Asignar espacio a las instrucciones y ejecutarlas
        for (int i = 0; i < programa.size(); i++) { // Recorre cada instrucción del programa.
            String instruccion = programa.get(i); // Obtiene la instrucción actual usando su índice.
            String[] partes = instruccion.split(" "); // Divide la instrucción en partes (separadas por espacio).

            // Evalúa el tipo de instrucción y ejecuta la acción correspondiente.
            switch (partes[0]) { 
                case "cargar": // Si la instrucción es "cargar".
                    int variable = Integer.parseInt(partes[1]); // Obtiene el identificador de la variable.
                    int valor = Integer.parseInt(partes[2]); // Obtiene el valor a cargar.
                    memoria.put(variable, valor); // Asigna el valor a la variable en memoria.
                    System.out.println("Cargando " + valor + " en la variable " + variable); // Mensaje informativo.
                    break;

                case "sumar": // Si la instrucción es "sumar".
                    int var1 = Integer.parseInt(partes[1]); // Obtiene el identificador de la primera variable.
                    int var2 = Integer.parseInt(partes[2]); // Obtiene el identificador de la segunda variable.
                    int varResultado = Integer.parseInt(partes[3]); // Obtiene el identificador de la variable donde se guardará el resultado.
                    int suma = memoria.get(var1) + memoria.get(var2); // Suma los valores de las variables especificadas.
                    memoria.put(varResultado, suma); // Asigna el resultado a la variable correspondiente en memoria.
                    System.out.println("Sumando variables " + var1 + " y " + var2 + " en la variable " + varResultado); // Mensaje informativo.
                    break;

                case "imprimir": // Si la instrucción es "imprimir".
                    int varImprimir = Integer.parseInt(partes[1]); // Obtiene el identificador de la variable a imprimir.
                    System.out.println("Resultado de la variable " + varImprimir + ": " + memoria.get(varImprimir)); // Imprime el valor de la variable.
                    break;

                default: // Si la instrucción no es reconocida.
                    System.out.println("Instrucción no reconocida: " + instruccion); // Mensaje de error para instrucciones desconocidas.
                    break;
            }
        }

        // Paso 5: Mostrar el estado final de las variables
        System.out.println("\nEstado final de las variables:"); // Mensaje inicial.
        for (Map.Entry<Integer, Integer> entry : memoria.entrySet()) { // Itera por cada entrada del mapa de memoria.
            System.out.println("Variable " + entry.getKey() + ": " + entry.getValue()); // Imprime el identificador de la variable y su valor.
        }
    }
}
