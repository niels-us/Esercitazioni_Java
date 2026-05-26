package E4.G_Approfondimenti_sul_comportamento_polimorfico;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public abstract Double area();

   // @Override
    public String toString() {
        // getClass().getSimpleName() prenderà dinamicamente "Cerchio" o "Rettangolo"
        return "Forma: " + getClass().getSimpleName() +
                " [Colore: " + color +
                ", Area: " + String.format("%.2f", area()) + " cm²]";
    }

    public void descrivi(){
        System.out.println("Shape descrivir");
    }
}
