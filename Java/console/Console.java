package console;

import java.util.Scanner;
import toyStore.*;

public class Console {

    public static void name() {

        ToyStore store = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                Menu.menu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    OperationStore.addToy(store, scanner);
                } else if (choice == 2) {
                    OperationStore.editWeightFactor(store, scanner);
                } else if (choice == 3) {
                    OperationStore.showStore(store);
                } else if (choice == 4) {
                    OperationStore.increaseToyByID(store, scanner);
                } else if (choice == 5) {
                    OperationStore.startCasino(store);
                } else if (choice == 6) {
                    scanner.close();
                    return;
                }
            }
        }
    }

}
