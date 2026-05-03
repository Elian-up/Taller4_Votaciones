package taller4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eleccion {
    private int candidatos;
    private List<Voto> votos = new ArrayList<>();
    private int votosValidos = 0;
    private int votosNulos = 0;

    public void cargarArchivo(String path) {
        try {
            File f = new File(path);
            Scanner lector = new Scanner(f);

            // Primera línea: número de candidatos[cite: 1]
            if (lector.hasNextInt()) {
                candidatos = lector.nextInt();
            }

            // Leer cada voto[cite: 1]
            while (lector.hasNext()) {
                String linea = lector.next(); // Lee el voto como texto
                List<Integer> listaPref = new ArrayList<>();

                // Convertir cada letra/número en un entero
                for (int i = 0; i < linea.length(); i++) {
                    listaPref.add(Character.getNumericValue(linea.charAt(i)));
                }

                Voto v = new Voto(listaPref);
                votos.add(v);

                if (v.esValido(candidatos)) {
                    votosValidos++;
                } else {
                    votosNulos++;
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Resultado procesar(MetodoSimple metodo) {
        List<Voto> validos = new ArrayList<>();
        for (Voto v : votos) {
            if (v.esValido(candidatos)) {
                validos.add(v);
            }
        }
        return new Resultado(metodo.calcularResultado(validos, candidatos));
    }

    // Getters para el App
    public int getVotosTotales() { return votos.size(); }
    public int getVotosValidosCount() { return votosValidos; }
    public int getVotosNulosCount() { return votosNulos; }
}
