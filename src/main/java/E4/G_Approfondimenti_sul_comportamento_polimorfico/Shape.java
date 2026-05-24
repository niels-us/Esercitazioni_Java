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
}
