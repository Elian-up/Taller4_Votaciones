package taller4;

import java.util.List;

public class MetodoBorda implements MetodoSimple {
    @Override
    public int[] calcularResultado(List<Voto> votos, int n) {
        int[] puntajes = new int[n + 1];

        for (Voto v : votos) {
            List<Integer> pref = v.getPreferencias();
            for (int i = 0; i < n; i++) {
                int candidato = pref.get(i);
                // Si n=5, el 1ro recibe 4 puntos, el 2do recibe 3... el último 0[cite: 1]
                int puntos = (n - 1) - i;
                puntajes[candidato] += puntos;
            }
        }
        return puntajes;
    }
}
