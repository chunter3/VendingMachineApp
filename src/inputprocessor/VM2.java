// Input Processor for VM2 (start)
package inputprocessor;

import abstractfactory.AF_VM2;
import abstractfactory.AbstractFactory;
import datastore.DataStore;
import java.util.Scanner;
import mda.MDA;

public class VM2 {

    private MDA<Integer> mda;                 // points to MDA object 
    private DataStore<Integer> ds2;           // points to Datastore object for VM2
    private AbstractFactory<Integer> af_vm2;  // points to concrete factory for VM2
    private Scanner vm2Scan;

    public void CREATE(int p){
        af_vm2 = new AF_VM2();
        mda = new MDA<>(af_vm2);
        ds2 = af_vm2.getDataStore();
        vm2Scan = new Scanner(System.in);
        
        ds2.setTemp_p(p);
        mda.create();
        noCupsMenu();
    }

    public void COIN(int v){
        ds2.setTemp_v(v);
        if(ds2.getCf() + v >= ds2.getPrice()){
          mda.coin(1);
          System.out.println("Coins accepted. Proceeding to drink selection...");
        }
        else{
          mda.coin(0);
        }
    }

    public void SUGAR(){
        mda.additive(1);
    }

    public void CREAM(){
        mda.additive(2);
    }

    public void COFFEE(){
        mda.dispose_drink(3);
    }

    public void InsertCups(int n){
        mda.insert_cups(n);
    }

    public void SetPrice(int p){
        ds2.setTemp_p(p);
        mda.set_price();
    }

    public void CANCEL(){
        mda.cancel();
    }

    public void noCupsMenu(){
        int insertedCups = 0;
        boolean validCups = false;

        System.out.println("No cups inserted. At least one cup must be inserted to proceed.");
        do {
            System.out.print("Please insert cups: ");
            String cupInput = vm2Scan.nextLine();
            if (cupInput.matches("^[1-9][0-9]*$")) {
                insertedCups = Integer.parseInt(cupInput);
                validCups = true;
            }
            else {    
                System.out.println("Invalid input! You must enter a valid amount of cups (at least 1 cup).");       
            }
        } while (!validCups);
        InsertCups(insertedCups);
        preSelectionMenu(); 
    }

    public void preSelectionMenu(){
        int menuOption = 0;
       
        do {
            System.out.println("Choose from the following:");
            System.out.println("1. Pay via coins");
            System.out.println("2. Insert cups");
            System.out.println("3. Set price of drinks");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            String userChoice = vm2Scan.nextLine();
            if (userChoice.matches("^[0-9]+$")) {
                menuOption = Integer.parseInt(userChoice);
                switch (menuOption) {
                    case 1 -> {
                        int insertedCoins = 0;
                        boolean validCoin = false;
                        System.out.println();
                        do {
                            System.out.print("Please insert coins: $");
                            String coinInput = vm2Scan.nextLine();

                            // The following regex ensures inputted coins is strictly non-negative whole numbers
                            if (coinInput.matches("^[0-9]+$")){
                                insertedCoins = Integer.parseInt(coinInput);
                                validCoin = true;
                            }
                            else {
                                System.out.println("Invalid amount! Please insert a valid amount of coins.");
                            }
                        } while (!validCoin);
                        COIN(insertedCoins);
                        if (mda.getCurrState().getStateId() == 3) {
                            additiveSelectionMenu();
                        }
                    }
                    case 2 -> {
                        int insertedCups = 0;
                        boolean validCups = false;
                        System.out.println();
                        do {
                            System.out.print("Please insert cups: ");
                            String cupInput = vm2Scan.nextLine();
                            if (cupInput.matches("^[1-9][0-9]*$")) {
                                insertedCups = Integer.parseInt(cupInput);
                                validCups = true;
                            }
                            else {    
                                System.out.println("Invalid input! You must enter a valid amount of cups (at least 1 cup).");       
                            }
                        } while (!validCups);
                        InsertCups(insertedCups);
                    }
                    case 3 -> {
                        int newPrice = 0;
                        boolean validPrice = false;
                        System.out.println();
                        do {
                            System.out.print("New price of drinks: $");
                            String inputPrice = vm2Scan.nextLine();
                            if (inputPrice.matches("^[1-9][0-9]*$")) {
                                newPrice = Integer.parseInt(inputPrice);
                                validPrice = true;
                            } else {
                                System.out.println("Invalid price. Please enter a valid price.");
                            }
                        } while (!validPrice);
                        SetPrice(newPrice); 
                    }
                    case 4 -> {
                        System.out.println("Thank you! Please come again.");
                        vm2Scan.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option! Please select either 1-4.");
                }
            } else {
                System.out.println("Invalid input! Please enter either 1-4.");
            }
        } while (menuOption != 4);
    }

    public void additiveSelectionMenu(){
        String additiveChoice;
        int selectedAdditive = 0;
        int change;

        System.out.println("This VM only serves coffee.");
        do {
            System.out.print("Would you like to add an additive to your coffee ('y' or 'n'): ");
            additiveChoice = vm2Scan.nextLine();
     
            switch (additiveChoice) {
                case "y" -> {
                    System.out.println("Which additive would you like:");
                    System.out.println("1. Sugar");
                    System.out.println("2. Cream");
                    System.out.println("3. Sugar and cream");
                    System.out.println("4. Cancel");
                    do {
                        System.out.print("Your choice: ");
                        String chosenAdditive = vm2Scan.nextLine();
                        if (chosenAdditive.matches("^[0-9]+$")) {
                            selectedAdditive = Integer.parseInt(chosenAdditive);
                            switch (selectedAdditive) {
                                case 1 -> {
                                    change = ds2.getCf() - ds2.getPrice();
                                    SUGAR();
                                    COFFEE();
                                    if (change > 0) {
                                        System.out.printf("Your change is $%d.", change);
                                        System.out.println("\n");
                                    }
                                    else {
                                        System.out.println();
                                    }
                                    if (mda.getCurrState().getStateId() == 2) {
                                        return;
                                    } else {
                                        noCupsMenu();
                                    }
                                }
                                case 2 -> {
                                    change = ds2.getCf() - ds2.getPrice();
                                    CREAM();
                                    COFFEE();
                                    if (change > 0) {
                                        System.out.printf("Your change is $%d.", change);
                                        System.out.println("\n");
                                    }
                                    else {
                                        System.out.println();
                                    }
                                    if (mda.getCurrState().getStateId() == 2) {
                                        return;
                                    } else {
                                        noCupsMenu();
                                    }
                                }
                                case 3 -> {
                                    change = ds2.getCf() - ds2.getPrice();
                                    SUGAR();
                                    CREAM();
                                    COFFEE();
                                    if (change > 0) {
                                        System.out.printf("Your change is $%d.", change);
                                        System.out.println("\n");
                                    }
                                    else {
                                        System.out.println();
                                    }
                                    if (mda.getCurrState().getStateId() == 2) {
                                        return;
                                    } else {
                                        noCupsMenu();
                                    }
                                }
                                case 4 -> {
                                    CANCEL();
                                    return;
                                }
                                default -> System.out.println("Invalid choice! Please select an available additive");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter either 1-4.");
                            vm2Scan.nextLine();
                        }
                    } while (selectedAdditive < 1 || selectedAdditive > 4);
                }
                case "n" -> {
                    change = ds2.getCf() - ds2.getPrice();
                    COFFEE();
                    if (change > 0) {
                        System.out.printf("Your change is $%d.", change);
                        System.out.println("\n");
                    }
                    else {
                        System.out.println();
                    }   if (mda.getCurrState().getStateId() == 2) {
                        return;
                    } else {
                        noCupsMenu();
                    }
                }
                default -> {
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");
                }
            }
        } while (!"y".equals(additiveChoice) && !"n".equals(additiveChoice));
    }
}
// Input Processor for VM2 (end)