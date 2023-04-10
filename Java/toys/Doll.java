package toys;

public class Doll extends Toy {

    String gender;

    public Doll(String name, int quantity, int weight_factor, String gender) {
        super(name, quantity, weight_factor);
        this.setMaterial("Пластик");
        this.gender = gender;
    }
    
}
