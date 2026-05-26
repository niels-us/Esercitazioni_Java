package E4.G_Approfondimenti_sul_comportamento_polimorfico;

public class Triangolo extends Shape {
    private Double basse;
    private Double altessa;

    public Triangolo(String color, Double basse, Double altessa) {
        super(color);
        this.basse = basse;
        this.altessa = altessa;
    }

    @Override
    public Double area() {
        return (basse * altessa) / 2;
    }

    @Override
    public void descrivi(){
        System.out.println("Triangolo descrivi ");
    }
}
