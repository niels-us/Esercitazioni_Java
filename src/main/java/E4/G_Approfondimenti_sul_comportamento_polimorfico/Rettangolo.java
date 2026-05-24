package E4.G_Approfondimenti_sul_comportamento_polimorfico;

public class Rettangolo extends Shape {
    private Double basse;
    private Double altessa;

    public Rettangolo(String color, Double basse, Double altessa) {
        super(color);
        this.basse = basse;
        this.altessa = altessa;
    }


    @Override
    public Double area() {
        return basse * altessa;
    }
}
