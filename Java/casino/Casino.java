package casino;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import toys.Toy;

public class Casino {
    private int factorCar = 70;
    private int factorDoll = 20;
    private int factorConstructor = 10;

    public Casino() {
    }

    public Toy toyCasino(List<Toy> toys) {
        List<Toy> rightToys = new ArrayList();
        Random random = new Random();
        int totalWeight = 0;
        Iterator toyIterator = toys.iterator();

        while(toyIterator.hasNext()) {
            Toy toy = (Toy)toyIterator.next();
            if (toy.getQuantity() > 0) {
                rightToys.add(toy);
                totalWeight += this.getToyWeight(toy);
            }
        }

        if (rightToys.isEmpty()) {
            System.out.println("Игрушки закончились!");
            return null;
        } else {
            int factor = random.nextInt(totalWeight) + 1;
            Toy selectedToy = null;
            Iterator toyIterator2 = rightToys.iterator();

            while(toyIterator2.hasNext()) {
                Toy toy = (Toy)toyIterator2.next();
                int toyWeight = this.getToyWeight(toy);
                if (toyWeight >= factor) {
                    selectedToy = toy;
                    break;
                }
            }

            if (selectedToy != null) {
                selectedToy.decreaseQuantity();
            }
            return selectedToy;
        }
    }

    private int getToyWeight(Toy toy) {
        int factor = toy.getWeight_factor();
        if (factor <= this.factorCar) {
            return 65;
        } else if (factor <= this.factorDoll) {
            return 35;
        } else {
            return factor <= this.factorConstructor ? 10 : 1;
        }
    }

    public void setFactorCar(int smallToys) {
        this.factorCar = smallToys;
    }

    public void setFactorDoll(int mediumToys) {
        this.factorDoll = mediumToys;
    }

    public void setFactorConstructor(int bigToys) {
        this.factorConstructor = bigToys;
    }

}
