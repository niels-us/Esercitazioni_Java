package E4.F_Astrazione_applicata_e_contratti;

public class Cerchio extends Shape {
    private Double raggio;

    public Cerchio(String color, Double raggio) {
        super(color);
        this.raggio = raggio;

    }

    @Override
    public Double area() {
        return raggio * raggio * 3.1415;
    }

}
