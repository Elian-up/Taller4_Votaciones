package taller4;

public class App {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Faltan datos");
            return;
        }

        String nombreArchivo = args[0];
        String tipoMetodo = args[1];

        Eleccion miEleccion = new Eleccion();
        miEleccion.cargarArchivo(nombreArchivo);

        MetodoSimple metodo;
        if (tipoMetodo.equalsIgnoreCase("borda")) {
            metodo = new MetodoBorda();
        } else {
            metodo = new MayoriaSimple();
        }

        Resultado res = miEleccion.procesar(metodo);


        System.out.println("METODO: " + (tipoMetodo.equalsIgnoreCase("borda") ? "Borda" : "Simple"));
        System.out.println("VOTOS TOTALES: " + miEleccion.getVotosTotales());
        System.out.println("VOTOS VALIDOS: " + miEleccion.getVotosValidosCount());
        System.out.println("VOTOS NULOS: " + miEleccion.getVotosNulosCount());

        System.out.print("RESULTADO: ");
        int[] pts = res.getPuntajes();
        for (int i = 1; i < pts.length; i++) {
            System.out.print("(" + i + "," + pts[i] + ") ");
        }
        System.out.println("\nGANADORES: " + res.obtenerGanadores());
    }
}