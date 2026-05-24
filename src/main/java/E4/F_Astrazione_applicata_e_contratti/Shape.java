package E4.F_Astrazione_applicata_e_contratti;

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
