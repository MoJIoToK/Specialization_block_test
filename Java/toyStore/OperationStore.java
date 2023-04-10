package toyStore;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.Iterator;
import toys.*;

public class OperationStore {

    Scanner scanner = new Scanner(System.in);

    public static void addToy(ToyStore store, Scanner scanner) {
        int toyType = promptInt(scanner, "Выберите тип игрушки (1 - Машинки, 2 - Куклы, 3 - Конструкторы):", (n) -> {
            return n >= 1 && n <= 3;
        });
        String name = promptString(scanner, "Название игрушки: ");
        int quantity = promptInt(scanner, "Количество: ", (n) -> {
            return n >= 0;
        });
        int weight_factor = promptInt(scanner, "Вес игрушки: ", (n) -> {
            return n > 0;
        });
        String parameter = promptString(scanner, "Пол для куклы, цвет для машинки и возраст для конструктора: ");
        switch (toyType) {
            case 1:
                store.addToy(new Car(name, quantity, weight_factor, parameter));
                break;
            case 2:
                store.addToy(new Doll(name, quantity, weight_factor, parameter));
                break;
            case 3:
                store.addToy(new Constructor(name, quantity, weight_factor, parameter));
        }
    }

    public static void editWeightFactor(ToyStore store, Scanner scanner) {
        System.out.println("Изменение процента вероятности выигрыша игрушек: ");
        int factorConstructor = promptInt(scanner, "Процент выпадения конструктора: ", (n) -> {
            return n > 0;
        });
        int factorDoll = promptInt(scanner, "Процент выпадения кукол: ", (n) -> {
            return n > factorConstructor;
        });
        int factorCar = promptInt(scanner, "Процент выпадения машинки: ", (n) -> {
            return n > factorDoll;
        });
        store.setConstructorFactor(factorConstructor);
        store.setDollFactor(factorDoll);
        store.setCarFactor(factorCar);
    }

    public static void showStore(ToyStore store) {
        System.out.println("Игрушки в наличии:");
        Iterator toyIterator = store.getToys().iterator();
        while(toyIterator.hasNext()) {
            Toy toy = (Toy)toyIterator.next();
            System.out.println(toy.toString());
        }
    }

    public static void increaseToyByID(ToyStore store, Scanner scanner) {
        int id = promptInt(scanner, "Введите ID игрушки, количество которой хотите увеличить: ", (n) -> {
            return n > 0 && n <= store.getToys().size();
        });
        int quantity = promptInt(scanner, "Введите количество: ", (n) -> {
            return n >= 0;
        });
        store.increaseToyCount(id, quantity);
    }

    public static void startCasino(ToyStore store) {
        Toy toy = store.drawToy();
        if (toy != null) {
            System.out.println("Вы выиграли игрушку " + toy.getName());
            store.saveToyToFile(toy);
        } else {
            System.out.println("Ты кто такой чтобы это сделать? Где Вы таких только находите! Вы остались без штанов!");
        }
    }

    private static String promptString(Scanner scanner, String prompt) {
            System.out.print(prompt);
            return scanner.nextLine();
        }

    private static int promptInt(Scanner scanner, String prompt, Predicate<Integer> validator) {
        while(true) {
            System.out.print(prompt);

            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (validator.test(n)) {
                    return n;
                }
            } catch (NumberFormatException var4) {
            }
            System.out.println("Некорректный ввод! Попробуйте снова.");
        }
    }

}
