package toys;

public class Constructor extends Toy {

    String age;

    public Constructor(String name, int quantity, int weight_factor, String age) {
        super(name, quantity, weight_factor);
        this.setMaterial("Пластик");
        this.age = age;
    }
    
}
