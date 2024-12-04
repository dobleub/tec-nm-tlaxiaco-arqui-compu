/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 import javax.swing.JOptionPane;
/**
 *
 * @author Jaczibeth Cruz
 */
public class CambioBase {
    public static void main(String[] args) {
        
        String[] bases = {"Binario", "Octal", "Decimal", "Hexadecimal"};
        
        // Solicitar al usuario que elija la base de entrada
        String baseEntrada = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la base de entrada:",
                "Cambio de Base",
                JOptionPane.QUESTION_MESSAGE,
                null,
                bases,
                bases[0]);

        // Validar si el usuario seleccionó una opción
        if (baseEntrada == null) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna base de entrada. Saliendo del programa.");
            return;
        }
        
        // Solicitar el número en la base seleccionada
        String numero = JOptionPane.showInputDialog(null, 
                "Ingresa el número en base " + baseEntrada + ":");
        
        // Validar si el usuario ingresó un número
        if (numero == null || numero.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ingresó ningún número. Saliendo del programa.");
            return;
        }

        // Solicitar al usuario que elija la base de salida
        String baseSalida = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la base de salida:",
                "Cambio de Base",
                JOptionPane.QUESTION_MESSAGE,
                null,
                bases,
                bases[0]);

        // Validar si el usuario seleccionó una opción
        if (baseSalida == null) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna base de salida. Saliendo del programa.");
            return;
        }

        int numeroDecimal;
        try {
            // Convertir el número de la base de entrada a decimal
            numeroDecimal = switch (baseEntrada) {
                case "Binario" -> Integer.parseInt(numero, 2);
                case "Octal" -> Integer.parseInt(numero, 8);
                case "Decimal" -> Integer.parseInt(numero, 10);
                case "Hexadecimal" -> Integer.parseInt(numero, 16);
                default -> throw new IllegalArgumentException("Base de entrada no válida.");
            };
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número ingresado no es válido para la base " + baseEntrada + ".");
            return;
        }
        
        // Convertir el número decimal a la base de salida
        String resultado = switch (baseSalida) {
            case "Binario" -> Integer.toBinaryString(numeroDecimal);
            case "Octal" -> Integer.toOctalString(numeroDecimal);
            case "Decimal" -> Integer.toString(numeroDecimal);
            case "Hexadecimal" -> Integer.toHexString(numeroDecimal).toUpperCase();
            default -> throw new IllegalArgumentException("Base de salida no válida.");
        };
        
        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, 
                "El número " + numero + " en base " + baseEntrada + 
                " es igual a " + resultado + " en base " + baseSalida);
    }
}
