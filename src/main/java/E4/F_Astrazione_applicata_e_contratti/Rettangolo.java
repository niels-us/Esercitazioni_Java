package E4.F_Astrazione_applicata_e_contratti;

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
