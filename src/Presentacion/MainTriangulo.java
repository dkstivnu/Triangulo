package Presentacion;

import Negocio.Lado;
import Negocio.Punto;
import Negocio.Triangulo;

public class MainTriangulo {

    public static void main(String[] args) {
        Punto vert1 = new Punto(-3,2);
        Punto vert2 = new Punto(-5,-1);
        Punto vert3 = new Punto(2, -1);
        Triangulo t = new Triangulo(vert1,vert2,vert3);

        System.out.println(t);

        t.setPt2(new Punto(2,2));
        System.out.println(t);
    }
}
