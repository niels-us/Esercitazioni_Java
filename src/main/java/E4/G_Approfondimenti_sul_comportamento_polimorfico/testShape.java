package E4.G_Approfondimenti_sul_comportamento_polimorfico;

import java.util.ArrayList;

public class testShape {
    public static void main() {
        //Polimorfismo con Shape
        Shape[] shape = new Shape[3];
        shape[0] = new Cerchio("verde", 5.22);// Introduzione di un’altra sottoclasse
        shape[1] = new Rettangolo("blanco", 5.22, 10.22);// Introduzione di un’altra sottoclasse
        shape[2] = new Triangolo("Nero", 5.22, 10.22);// Introduzione di un’altra sottoclasse
        //Metodo statico polimorfico
        stampaAree(shape);
        //ArrayList di superclassi
        ArrayList<Shape> listForm = new ArrayList<>();
        listForm.add(new Cerchio("Rosso", 6.0));
        listForm.add(new Rettangolo("Verde", 4.0, 5.0));
        listForm.add(new Triangolo("Nero", 5.22, 10.22));
        System.out.println(listForm.size());
        for (Shape form : listForm) {
            System.out.println("listForm: " + form.getClass().getSimpleName() + "  " + form.area());
            //Override del metodo toString()
            System.out.println(form);
        }
        //33. Metodo comune nelle sottoclassi
        Shape shaps1 = new Cerchio("Rosso", 6.0);
        Shape shaps2 = new Rettangolo("blanco", 5.22, 10.22);
        Shape shaps3 = new Triangolo("Nero", 5.22, 10.22);
        shaps1.descrivi();
        shaps2.descrivi();
        shaps3.descrivi();

    }

    public static void stampaAree(Shape[] shape) {
        for (Shape sha : shape) {
            System.out.println("Shapes: " + sha.getClass().getSimpleName() + "  " + sha.area());
            //Override del metodo toString()
            System.out.println(sha);
        }

    }
}
