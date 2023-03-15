import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
/*

        int[] numeros = {25, 18, 7};
        String orden = "a"; // Descendente

        // Ordenar el arreglo según el criterio
        if (orden.equals("a")) {
            Arrays.sort(numeros);
        } else {
            Arrays.sort(numeros);
            int[] numerosDescendentes = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosDescendentes[i] = numeros[numeros.length - 1 - i];
            }
            numeros = numerosDescendentes;
        }

        // Mostrar los números ordenados
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}

*/

        /*
        Scanner scanner = new Scanner(System.in);

        // Pedir los números y el criterio por consola
        int[] numeros = new int[3];
        System.out.println("Ingrese tres números:");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Ingrese el criterio (a para ascendente, d para descendente):");
        String orden = scanner.next();

        // Ordenar el arreglo según el criterio
        if (orden.equals("a")) {
            Arrays.sort(numeros);
        } else {
            Arrays.sort(numeros);
            int[] numerosDescendentes = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosDescendentes[i] = numeros[numeros.length - 1 - i];
            }
            numeros = numerosDescendentes;
        }

        // Mostrar los números ordenados
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Cerrar el scanner
        scanner.close();
    }
}

*/
/*
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la ruta del archivo: ");
            String rutaArchivo = scanner.nextLine();

            try {
                File archivo = new File(rutaArchivo);
                Scanner scannerArchivo = new Scanner(archivo);

                int suma = 0;
                while (scannerArchivo.hasNextInt()) {
                    suma += scannerArchivo.nextInt();
                }

                System.out.println("La suma de los números del archivo es: " + suma);

            } catch (FileNotFoundException e) {
                System.out.println("Error: No se encontró el archivo.");
            }
        }
    }



 */
/*

        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese la ruta del archivo: ");
        String rutaArchivo = input.nextLine();

        File archivo = new File(rutaArchivo);

        try {
            Scanner scanner = new Scanner(archivo);

            int suma = 0;
            int multiplicacion = 1;
            int division = 1;

            while (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                suma += numero;
                multiplicacion *= numero;
                division /= numero;
            }

            System.out.println("Elija la operación que desea realizar:");
            System.out.println("a - Suma");
            System.out.println("b - Multiplicación");
            System.out.println("c - División");

            String operacion = input.nextLine();

            switch (operacion) {
                case "a":
                    System.out.println("La suma de los números es: " + suma);
                    break;
                case "b":
                    System.out.println("La multiplicación de los números es: " + multiplicacion);
                    break;
                case "c":
                    System.out.println("La división de los números es: " + division);
                    break;
                default:
                    System.out.println("Operación no válida");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        }
    }
}

*/

        String archivoEntrada = "C:\\Users\\masterpop\\IdeaProjects\\Ejercicio 5\\src\\entrada.txt";
        for (String linea : Files.readAllLines(Paths.get(archivoEntrada))){
         }

        String archivoSalida = "C:\\Users\\masterpop\\IdeaProjects\\Ejercicio 5\\src\\salida.txt";
        for (String linea : Files.readAllLines(Paths.get(archivoSalida))){
    }



        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el desplazamiento ");
        int desplazamiento = scanner.nextInt();
        scanner.nextLine();

        if (desplazamiento < 1 || desplazamiento > 3) {
            System.out.println("El valor debe ser de 1 a 3");
            return ;
        }

        boolean codificar = true;
        if (args.length >= 1) {
            codificar = args[0].equalsIgnoreCase("codificar");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            while ((linea = br.readLine()) != null) {
                String resultado = cifrarCesar(linea, desplazamiento, codificar);
                bw.write(resultado);
                bw.newLine();
            }

            br.close();
            bw.close();
            System.out.println("Finalizado");

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println("Escribalo correctamente");
        }
    }

    public static String cifrarCesar(String mensaje, int desplazamiento, boolean codificar) {
        String abecedario = "abcdefghijklmnopqrstuvwxyz ";

        if (!codificar) {
            desplazamiento *= -1;
        }

        String resultado = "";
        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            int indice = abecedario.indexOf(letra);
            if (indice == -1) {
                resultado += letra;
            } else {
                int nuevoIndice = (indice + desplazamiento + abecedario.length()) % abecedario.length();
                char nuevaLetra = abecedario.charAt(nuevoIndice);
                resultado += nuevaLetra;
            }
        }

        return resultado;
    }
}







