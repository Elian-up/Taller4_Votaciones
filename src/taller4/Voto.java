package taller4;

import java.util.List;

public class Voto {
    private List<Integer> preferencias;

    public Voto(List<Integer> preferencias) {
        this.preferencias = preferencias;
    }

    public boolean esValido(int n) {
        // Un voto es válido si tiene exactamente n números[cite: 1]
        if (preferencias.size() != n) return false;

        // Revisamos que estén todos los números del 1 al n[cite: 1]
        for (int i = 1; i <= n; i++) {
            boolean encontrado = false;
            for (int num : preferencias) {
                if (num == i) {
                    encontrado = true;
                    break;
                }
            }
            // Si falta un número del 1 al n, el voto es nulo[cite: 1]
            if (!encontrado) return false;
        }
        return true;
    }

    public int getPrimeraPreferencia() {
        return preferencias.get(0);
    }

    public List<Integer> getPreferencias() {
        return preferencias;
    }
}
