package toys;

public class Car extends Toy {

    String color;

    public Car(String name, int quantity, int weight_factor, String color) {
        super(name, quantity, weight_factor);
        this.setMaterial("Стальная");
        this.color = color;
    }
    
}
