package toyStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import casino.Casino;
import toys.*;

public class ToyStore {
    private List<Toy> toys = new ArrayList();
    private Casino casino = new Casino();

    public ToyStore() {
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public Toy drawToy() {
        return this.casino.toyCasino(this.toys);
    }

    public void setConstructorFactor(int factorConstructor) {
        this.casino.setFactorCar(factorConstructor);
    }

    public void setDollFactor(int factorDoll) {
        this.casino.setFactorDoll(factorDoll);
    }

    public void setCarFactor(int factorCar) {
        this.casino.setFactorConstructor(factorCar);
    }

    public void saveToyToFile(Toy toy) {

        try {
            FileWriter writer = new FileWriter("casino/casino.txt", true);
            writer.write(toy.toString() + "\n");
            writer.close();
        } catch (IOException var4) {
            System.out.println("Ошибка записи в файл");
        }
    }

    public List<Toy> getToys() {
        return this.toys;
    }

    public void increaseToyCount(int id, int quantityToAdd) {
        Iterator toyIterator = this.toys.iterator();

        Toy toy;
        do {
            if (!toyIterator.hasNext()) {
                System.out.println("Игрушка с таким ID не найдена в магазине.");
                return;
            }
            toy = (Toy)toyIterator.next();
        } 
        
        while(toy.getId() != id);

        toy.setQuantity(toy.getQuantity() + quantityToAdd);
    }
    
}
