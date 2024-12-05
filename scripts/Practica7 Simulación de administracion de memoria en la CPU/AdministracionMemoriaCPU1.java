/*** Autor: Jaczibeth Cruz*/
import java.util.ArrayList; // Importa la clase ArrayList para trabajar con listas dinámicas.
import java.util.HashMap;  // Importa la clase HashMap para trabajar con mapas (diccionarios).
import java.util.List;     // Importa la interfaz List para crear listas genéricas.
import java.util.Map;      // Importa la interfaz Map para crear mapas genéricos.
public class AdministracionMemoriaCPU1 { /* Clase principal que simula la administración de memoria en la CPU.*/
    public static void main(String[] args) {
        // Paso 1: Cargar el programa en memoria.
        // Simulado con un mapa que contiene las instrucciones del programa.
        Map<Integer, String> programa = new HashMap<>(); // Declara un mapa para almacenar las instrucciones.
        programa.put(0, "cargar 1,2"); // Agrega la instrucción para cargar el valor 2 en la variable 1.
        programa.put(1, "sumar 1,2,3"); // Agrega la instrucción para sumar variables 1 y 2, y guardar el resultado en la variable 3.
        programa.put(2, "imprimir 3"); // Agrega la instrucción para imprimir el valor de la variable 3.

        // Paso 2: Asignar espacio de memoria a las variables.
        // Simulado con un mapa que contiene las variables y sus valores iniciales.
        Map<Integer, Integer> variables = new HashMap<>(); // Declara un mapa para almacenar variables y sus valores.
        variables.put(1, 0); // Inicializa la variable 1 con un valor de 0.
        variables.put(2, 0); // Inicializa la variable 2 con un valor de 0.
        variables.put(3, 0); // Inicializa la variable 3 con un valor de 0.

        // Paso 3: Asignar espacio de memoria a las instrucciones.
        // Simulado con una lista que contiene las instrucciones del programa.
        List<String> instrucciones = new ArrayList<>(programa.values()); // Crea una lista con los valores del mapa `programa`.

        // Paso 4: Ejecutar el programa.
        for (String instruccion : instrucciones) { // Itera sobre cada instrucción en la lista.
            if (instruccion.startsWith("cargar")) { // Verifica si la instrucción es del tipo "cargar".
                // Divide la instrucción para extraer la variable y el valor.
                String[] partes = instruccion.replace("cargar ", "").split(","); 
                int variable = Integer.parseInt(partes[0]); // Obtiene el índice de la variable a cargar.
                int valor = Integer.parseInt(partes[1]); // Obtiene el valor a cargar en la variable.
                variables.put(variable, valor); // Asigna el valor a la variable en el mapa `variables`.
                System.out.println("Cargando " + valor + " en la variable " + variable); // Muestra un mensaje de carga.
            } else if (instruccion.startsWith("sumar")) { // Verifica si la instrucción es del tipo "sumar".
                // Divide la instrucción para extraer las variables y el resultado.
                String[] partes = instruccion.replace("sumar ", "").split(",");
                int var1 = Integer.parseInt(partes[0]); // Obtiene el índice de la primera variable.
                int var2 = Integer.parseInt(partes[1]); // Obtiene el índice de la segunda variable.
                int varResultado = Integer.parseInt(partes[2]); // Obtiene el índice de la variable para el resultado.
                int suma = variables.get(var1) + variables.get(var2); // Realiza la suma de los valores de las dos variables.
                variables.put(varResultado, suma); // Asigna el resultado de la suma a la variable correspondiente.
                System.out.println("Sumando variables " + var1 + " y " + var2 + " en la variable " + varResultado); // Muestra un mensaje de suma.
            } else if (instruccion.startsWith("imprimir")) { // Verifica si la instrucción es del tipo "imprimir".
                // Divide la instrucción para extraer la variable a imprimir.
                String[] partes = instruccion.replace("imprimir ", "").split(",");
                int varImprimir = Integer.parseInt(partes[0]); // Obtiene el índice de la variable a imprimir.
                System.out.println("Resultado de la variable " + varImprimir + ": " + variables.get(varImprimir)); // Muestra el valor de la variable.
            }
        }

        // Paso 5: Mostrar el resultado final de las variables.
        System.out.println("\nEstado final de las variables:"); // Imprime un encabezado para los resultados finales.
        for (Map.Entry<Integer, Integer> entry : variables.entrySet()) { // Itera sobre las variables y sus valores.
            System.out.println("Variable " + entry.getKey() + ": " + entry.getValue()); // Imprime el índice y el valor de cada variable.
        }
    }
}
