package grp7.metodosDeBusqueda;

public class Resultado implements Comparable<Resultado> {

    double tiempoEjecucion;
    String resultado;
    String patron;
    String algoritmo;

    public Resultado(){};
    
    public Resultado(String algoritmo, String resultado, String patron, double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
        this.resultado = resultado;
        this.patron = patron;
        this.algoritmo = algoritmo;
    }

    public double getTiempoEjecucion() {
        return tiempoEjecucion;
    }
    
    public String getPatron(){
        return patron;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }
    
    public String getResultado() {
        return resultado;
    }

    @Override
    public int compareTo(Resultado resultado) {
        return (int) (this.tiempoEjecucion*1000000 - resultado.getTiempoEjecucion()*1000000);
    }
    
    @Override
    public String toString() {
        return "Para buscar el patrón "+patron+" el mejor algoritmo fue "+algoritmo+".";
    }

}
