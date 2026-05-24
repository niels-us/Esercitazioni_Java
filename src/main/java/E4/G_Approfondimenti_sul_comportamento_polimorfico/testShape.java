package E4.G_Approfondimenti_sul_comportamento_polimorfico;

public class testShape {
    public static void main() {
        //Polimorfismo con Shape
        Shape[] shape = new Shape[3];
        shape[0] = new Cerchio("verde", 5.22);// Introduzione di un’altra sottoclasse
        shape[1] = new Rettangolo("blanco", 5.22, 10.22);// Introduzione di un’altra sottoclasse
        shape[2] = new Triangolo("Nero", 5.22, 10.22);// Introduzione di un’altra sottoclasse
        //Metodo statico polimorfico
        stampaAree(shape);
    }

    public static void stampaAree(Shape[] shape) {
        for (Shape sha : shape) {
            System.out.println("Shapes: " + sha.getClass().getSimpleName() + "  " + sha.area());
        }

    }
}
