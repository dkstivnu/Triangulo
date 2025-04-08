package Negocio;

public class Lado {

    /// Atributos

    private final Punto pto1;
    private final Punto pto2;
    private final double longitud;
    private boolean esBase;

    /// Constructor parametrizado

    public Lado(Punto pto1, Punto pto2) {
        this.pto1 = pto1;
        this.pto2 = pto2;

        /// Cálculo de atributos dentro del constructor para asignación directa

        this.esBase = esLaBase();
        this.longitud = calcularLongitud();
    }

    /// Metodos getter

    public boolean getEsBase() {
        return esBase;
    }

    public String getStringEsBase() {
        if (esBase) {
            return "Es la base";
        }
        return "";
    }

    public double getLongitud() {
        return longitud;
    }

    public void setEsBase(boolean esBase) {
        this.esBase = esBase;
    }

    /// Metodos propios

    private boolean esLaBase() { //Este metodo es privado porque solo se utilizara dentro de la clase
        return this.pto1.getX() == this.pto2.getX() ||
                this.pto1.getY() == this.pto2.getY();

        /*
        Este metodo se necesita para saber si el lado es paralelo al
        eje x o eje y del plano
        Asi que se considera la base de un lado la cual esté paralela al algún eje del plano.
        */
    }

    public double calcularLongitud() { //Distancia entre dos puntos
        double dx = pto2.getX() - pto1.getX();
        double dy = pto2.getY() - pto1.getY();
        return Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) / 100.0;
        // Se redondea el valor de la longitud conservando dos numeros decimales
    }

    @Override
    public String toString() {
        return pto1.toString() + " -> " + pto2.toString();
    }

}
