package Negocio;

public class Triangulo {

    /// Atributos

    private Punto pt1, pt2, pt3;
    private Lado ladoA, ladoB, ladoC;
    private double area, perimetro, base, altura;

    /// Constructor parametrizado

    public Triangulo(Punto pt1, Punto pt2, Punto pt3) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.pt3 = pt3;
        actualizarTriangulo();

    }

    /// Setters and getters

    public Punto getPt1() {
        return pt1;
    }

    public void setPt1(Punto pt1) {
        this.pt1 = pt1;
        actualizarTriangulo();
    }

    public Punto getPt2() {
        return pt2;
    }

    public void setPt2(Punto pt2) {
        this.pt2 = pt2;
        actualizarTriangulo();
    }

    public Punto getPt3() {
        return pt3;
    }

    public void setPt3(Punto pt3) {
        this.pt3 = pt3;
        actualizarTriangulo();
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public Lado getLadoA() {
        return ladoA;
    }
    public Lado getLadoB() {
        return ladoB;
    }
    public Lado getLadoC() {
        return ladoC;
    }

    /// Metodos propios

    public void actualizarTriangulo() {
        // Se modulariza en bloques de codigo para asignar los atributos de forma ordenada
        calcularLados();
        calcularArea();
        calcularPerimetro();
        calcularBase();
        calcAltura();
    }

    public void calcularLados() { // Crea las clases Lado
        this.ladoA = new Lado(pt1, pt2);
        this.ladoB = new Lado(pt2, pt3);
        this.ladoC = new Lado(pt3, pt1);
    }

    public void calcularArea() {
        /* El area se calcula con el valor absoluto de la determinante:
         *           | x₁ y₁ 1 |
         *  Área = ½ | x₂ y₂ 1 |
         *           | x₃ y₃ 1 |
         */
        double area = 0.5 * Math.abs(
                (pt1.getX() * (pt2.getY() - pt3.getY())) +
                        (pt2.getX() * (pt3.getY() - pt1.getY())) +
                        (pt3.getX() * (pt1.getY() - pt2.getY())));

        // Se redondea el área con dos decimales
        area = Math.round(area * 100.0) / 100.0;
        this.area = area;
    }

    public void calcularBase() {
        // Contador para saber cuántos lados cumplen con la condición de ser base
        int posiblesBases = 0;

        // Cuenta cuántos lados tienen la propiedad esBase = true
        // Un lado es base cuando es horizontal o vertical
        if (ladoA.getEsBase()) posiblesBases++;
        if (ladoB.getEsBase()) posiblesBases++;
        if (ladoC.getEsBase()) posiblesBases++;

        // Dependiendo de cuántos lados pueden ser base, se toma una decisión diferente
        switch (posiblesBases) {
            case 1: {
                // Si solo hay un lado que puede ser base, ese lado se usa como base del triángulo
                if (ladoA.getEsBase())
                    this.base = ladoA.getLongitud();

                if (ladoB.getEsBase())
                    this.base = ladoB.getLongitud();

                if (ladoC.getEsBase())
                    this.base = ladoC.getLongitud();
            }
            break;
            case 2:
                // Si hay dos lados que pueden ser base(Como en un triangulo rectangulo),
                // se selecciona el más largo entre ellos

                elegirBaseMasGrande();

                break;
            default:
                // Si no hay lados horizontales/verticales (posiblesBases = 0)
                // se usa el lado más largo como base
                Lado ladoMax = ladoA;

                if (ladoB.getLongitud() > ladoMax.getLongitud()) /* Entonces */ ladoMax = ladoB;

                if (ladoC.getLongitud() > ladoMax.getLongitud()) /* Entonces */ ladoMax = ladoC;

                this.base = ladoMax.getLongitud();
                ladoMax.setEsBase(true);

                break;
        }
    }

    public void elegirBaseMasGrande() {
        // Reiniciar todos los lados
        ladoA.setEsBase(false);
        ladoB.setEsBase(false);
        ladoC.setEsBase(false);

        // Encontrar el lado más largo entre los que son horizontales o verticales
        Lado ladoMasLargo = null;
        double longitudMaxima = 0;

        if (ladoA.getEsBase() && ladoA.getLongitud() > longitudMaxima) {
            ladoMasLargo = ladoA;
            longitudMaxima = ladoA.getLongitud();
        }

        if (ladoB.getEsBase() && ladoB.getLongitud() > longitudMaxima) {
            ladoMasLargo = ladoB;
            longitudMaxima = ladoB.getLongitud();
        }

        if (ladoC.getEsBase() && ladoC.getLongitud() > longitudMaxima) {
            ladoMasLargo = ladoC;
        }

        // Si se encontró un lado base, establecerlo como la base
        if (ladoMasLargo != null) {
            ladoMasLargo.setEsBase(true);
            this.base = ladoMasLargo.getLongitud();
        }
    }

    public void calcularPerimetro() {
        double periAux = ladoA.getLongitud() + ladoB.getLongitud() + ladoC.getLongitud();

        //Se redondea el perímetro con dos decimales
        this.perimetro = Math.round(periAux * 100.0) / 100.0;
    }

    public void calcAltura() {
        double altura = 2 * (this.area / this.base);
        altura = Math.round(altura * 100.0) /100.0;
        this.altura = altura;
    }


    @Override
    public String toString() {
        return "\n--- TRIANGULO ---" +
                "\n1° " + pt1 +
                "\n2° " + pt2 +
                "\n3° " + pt3 +
                "\nL. lado A: " + ladoA.getLongitud() + " u" + "  | " + ladoA.getStringEsBase() +
                "\nL. lado B: " + ladoB.getLongitud() + " u" + "  | " + ladoB.getStringEsBase() +
                "\nL. lado C: " + ladoC.getLongitud() + " u" + "  | " + ladoC.getStringEsBase() +
                "\n Area: " + area + " u²" +
                "\n Perimetro: " + perimetro + " u" +
                "\n Altura: " + altura +" u"+
                "\n--- TRIANGULO ---";
    }


}


