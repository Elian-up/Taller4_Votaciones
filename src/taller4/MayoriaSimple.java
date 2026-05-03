package taller4;

import java.util.List;

public class MayoriaSimple implements MetodoSimple {
    @Override
    public int[] calcularResultado(List<Voto> votos, int n) {
        int[] puntajes = new int[n + 1]; // Usamos n+1 para que el índice coincida con el candidato

        for (Voto v : votos) {
            int candidato = v.getPrimeraPreferencia();
            puntajes[candidato]++; // Sumamos un voto al candidato[cite: 1]
        }
        return puntajes;
    }
}
