package taller4;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private int[] puntajes;

    public Resultado(int[] puntajes) {
        this.puntajes = puntajes;
    }

    public List<Integer> obtenerGanadores() {
        List<Integer> ganadores = new ArrayList<>();
        int max = -1;

        // 1. Encontrar el puntaje más alto
        for (int i = 1; i < puntajes.length; i++) {
            if (puntajes[i] > max) {
                max = puntajes[i];
            }
        }

        // 2. Ver quiénes tienen ese puntaje (por si hay empate)[cite: 1]
        for (int i = 1; i < puntajes.length; i++) {
            if (puntajes[i] == max) {
                ganadores.add(i);
            }
        }
        return ganadores;
    }

    public int[] getPuntajes() {
        return puntajes;
    }
}
