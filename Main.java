package salva.potitos;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static java.util.Scanner in;

    public static boolean casoDePrueba() {

        in = new java.util.Scanner(System.in);

        int numPotitos = -1;
        Boolean rangoMuestras = false;
        do {
            int numPotitosInterno = in.nextInt();
            in.nextLine();
            if (0 < numPotitosInterno && numPotitosInterno <= 25) {
                rangoMuestras = true;
                numPotitos = numPotitosInterno;
            } else if (numPotitosInterno == 0) {
                rangoMuestras = true;
                numPotitos = numPotitosInterno;
            }
        } while (!rangoMuestras);

        if (numPotitos == 0) {
            return false;
        } else {

            Boolean finPotitos = false;
            int contador = 0;
            ArrayList<String> ingredientesSi = new ArrayList<>();
            ArrayList<String> ingredientesNo = new ArrayList<>();
            ArrayList<String> ingredientesOdiados = new ArrayList<>();
            while (!finPotitos) {

                if (contador != numPotitos) {
                    String potito = in.nextLine();
                    potito = potito.trim();
                    potito = potito.replaceAll("\\s+", " ");

                    String[] ingredientesSucio = potito.split("\\s+");
                    if (ingredientesSucio[0].equals("SI:")) {
                        for (int i = 0; i < ingredientesSucio.length; i++) {
                            if (!ingredientesSucio[i].equals("SI:") && !ingredientesSucio[i].equals("NO:") && !ingredientesSucio[i].equals("FIN")) {
                                ingredientesSi.add(ingredientesSucio[i]);
                            }
                        }
                    } else if (ingredientesSucio[0].equals("NO:")) {
                        for (int i = 0; i < ingredientesSucio.length; i++) {
                            if (!ingredientesSucio[i].equals("SI:") && !ingredientesSucio[i].equals("NO:") && !ingredientesSucio[i].equals("FIN")) {
                                ingredientesNo.add(ingredientesSucio[i]);
                            }
                        }
                    }

                    contador++;

                } else {
                    finPotitos = true;
                }

            }

            for (String ingredienteNo: ingredientesNo) {
                if (!ingredientesSi.contains(ingredienteNo)) {
                    ingredientesOdiados.add(ingredienteNo);
                }
            }

            // Ordenar alfabéticamente ArrayList
            Collections.sort(ingredientesOdiados);

            for (String ingredienteOdiado : ingredientesOdiados) {
                System.out.print(ingredienteOdiado + " ");
            }
            System.out.println();

            return true;
        }

    }

    public static void main(String args[]) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

}
