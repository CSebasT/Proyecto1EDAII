package grp7.metodosDeBusqueda;

public class Resultado implements Comparable<Resultado> {
    private double tiempoEjecucion;
    private String resumenResultado;
    private String patron;
    private String nombreAlgoritmo;

    /**
     * Constructor del Resultado.
     */
    public Resultado(String algoritmo, String resumenResultado, String patron, double tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
        this.resumenResultado = resumenResultado;
        this.patron = patron;
        this.nombreAlgoritmo = algoritmo;
    }

    public double getTiempoEjecucion() {
        return tiempoEjecucion;
    }
    
    public String getPatron(){
        return patron;
    }

    public String getAlgoritmo() {
        return nombreAlgoritmo;
    }
    
    public String getResumenResultado() {
        return resumenResultado;
    }

    @Override
    public int compareTo(Resultado resultado) {
        return (int) (this.tiempoEjecucion*1000000 - resultado.getTiempoEjecucion()*1000000);
    }
    
    /**
     * 
     * @return un String que identifica el Resultado como el mejor resultado
     * para la busqueda.
     */
    public String obtenerComoMejorResultado() {
        return "Para buscar el patrón \""+patron+"\" el mejor algoritmo fue "+nombreAlgoritmo+".";
    }

}
